package logicaNegocio.implementacion;

import logicaNegocio.excepciones.CajaCerradaAnteriormenteException;
import logicaNegocio.excepciones.TransaccionAnuladaException;
import tablas.*;

import java.util.*;

public class ServiciosPagosImpl extends AbstractServicios implements ServiciosPagos {
	
	// metodos de conveniencia
	// recupero pisos disponibles (key=localidad value=piso)
	// usar desde el gui
	@Override
	public HashMap<String, Piso> getPisosDisponibles(Date fechaInicio, Date fechaFin){
		Collection<Piso> pisos = dao.getPisosDisponibles(fechaInicio, fechaFin);
		HashMap<String, Piso> listaPisosDisp = new HashMap<String, Piso>();
		if (!pisos.isEmpty()){
			for (Piso p:pisos){
				listaPisosDisp.put(p.getLocalizacion(),p);
			}
		}
		return listaPisosDisp;
	}
	// calculo los dias
	private int calculoDias(Date fechaInicio, Date fechaFin){
		GregorianCalendar entrada = new GregorianCalendar();
		entrada.setGregorianChange(fechaInicio);
		GregorianCalendar salida = new GregorianCalendar();
		salida.setGregorianChange(fechaFin);
		long millisegundos = salida.getTimeInMillis() - entrada.getTimeInMillis();
		int dias = (int) (millisegundos / 86400000); // 24 * 60 * 60 * 1000 -> milisegundos dia
		return dias;
	}
	// calculo el alquiler
	private double calcularAlquiler(Date fechaInicio, Date fechaFin, Piso p){
		int dias = calculoDias(fechaInicio,fechaFin);
		// recupero el precio dia y lo multiplico
		return dias*p.getPrecio();
	}
	@Override
	// recupero pedidos del cliente pendientes de pago y no cancelados
	public Collection<Pedido> getPedidosPendientesCliente(Cliente c){
		Collection<Pedido> pedidos = dao.getPedidosCliente(c.getNifCli());
		Collection<Pedido> pedidosPendientes = new ArrayList<Pedido>();
		if (!pedidos.isEmpty()){
			for (Pedido p:pedidos){
				if(p.isPagado()==false && p.isCancelado()==false){
					pedidosPendientes.add(p);
				}
			}
		}
		return pedidosPendientes;
	}
	// recupero pagos pendientes al propietario, estos no han sido cancelados o pagados
	public Collection<Caja> getPedidosPendientesPropietario(Propietario prop){
		Collection<Pedido> pedidos = dao.getPedidosPropietario(prop.getNifProp());
		Collection<Caja> pagosPendientes = new ArrayList<Caja>();
		if (!pedidos.isEmpty()){
			for (Pedido p:pedidos){
				Collection<Caja> registros = new ArrayList<Caja>();
				if(p.isCancelado()==false && p.isPagado()==true){
					registros.addAll(dao.getFacturaPedido(p.getN_pedido())); 
				}
				System.out.println(registros);
				double importeA = 0;
				double importeB = 0;
				for (Caja r:registros){
					if(r.getOperacion()=='A'){
						importeA=r.getImporte();
					} else if(r.getOperacion()=='B'){
						importeB=r.getImporte();
					} else if(r.getOperacion()=='D' || r.isPagado()==true){
						importeA = importeB = 0;
					} else {
						continue;
					}
				}
				if (importeA!=0 && importeB!=0){
					// calculo importe a pagar
					double comision = dao.getPiso(p.getN_piso()).getComision();
					double importe = (importeA+importeB)-(comision/100);
					Caja miRegistro = new Caja ('D', p.getN_pedido(), importe >= 0? importe*-1 : importe, true, new Date());
					pagosPendientes.add(miRegistro);
				}
			}
		}
		return pagosPendientes;
	}
	// metodos de pago
	@Override
	public Caja reservarPiso(Cliente c, Date fechaInicio, Date fechaFin, Piso p){
		double importe = calcularAlquiler(fechaInicio, fechaFin, p)*0.5;
		Caja miRegistro = null;
		int nivelOld=0;
		try { 
		  nivelOld=dao.getAislamientoCon();
		  dao.setAislamientoCon("TRANSACTION_READ_COMMITTED");
		  // Insertamos un pedido
		  Pedido miPedido = new Pedido (c.getNifCli(),p.getNumero(),fechaInicio, fechaFin, false, false);
		  int nroPedido = dao.insertPedido(miPedido);
		  miPedido.setN_pedido(nroPedido);
		  // Insertamos un registro en caja
		  miRegistro = new Caja ('A', miPedido.getN_pedido(), importe, false, new Date());
		  int nroRegistro = dao.insertFactura(miRegistro);
		  miRegistro.setN_factura(nroRegistro);
		  // Validamos las modificaciones y cerramos
		  dao.confirmaTransaccion();		
		} catch (Exception e1) {
		    // Anulamos y cerramos		
			try {
				dao.anulaTransaccion();	
				throw new TransaccionAnuladaException ("La transaccion ha fallado: ", e1);
				} catch (Exception e2) {
					// TODO file log
					System.out.println("Imposible anular las modificaciones!");
				} 
		} finally {
			dao.resetAislamientoCon(nivelOld);
		}
		return miRegistro;
	}

	@Override
	public Caja pagarPiso(Cliente c, Pedido p) {
		Collection<Caja> misFacturas = dao.getFacturaPedido(p.getN_pedido()); 
		Caja miRegistro = null;
		double importe = 0;
		if (!misFacturas.isEmpty()){
			for(Caja f:misFacturas){
				if(f.getOperacion()=='A')
					importe = f.getImporte();
			}
			int nivelOld=0;
			try { 
				nivelOld=dao.getAislamientoCon();
				dao.setAislamientoCon("TRANSACTION_READ_COMMITTED");
				// actualizamos el pedido
				p.setPagado(true);
				int nroPedido = dao.updatePedido(p);
				// Insertamos un registro en caja
				miRegistro = new Caja ('B', nroPedido, importe, false, new Date());
				int nroRegistro = dao.insertFactura(miRegistro);
				miRegistro.setN_factura(nroRegistro);
				// Validamos las modificaciones y cerramos
				dao.confirmaTransaccion();	
			} catch (Exception e1) {
				// Anulamos y cerramos		
				try {
					dao.anulaTransaccion();	
					throw new TransaccionAnuladaException ("La transaccion ha fallado: ", e1);
					} catch (Exception e2) {
						// TODO file log
						System.out.println("Imposible anular las modificaciones!");
					} 
				}finally {
					dao.resetAislamientoCon(nivelOld);
			}
		}
		return miRegistro;
	}
	@Override // pagamos todos los pedidos pendientes de pago
	public Collection<Caja> pagarPiso(Cliente c, Collection<Pedido> ps){
		Collection<Caja> misRegistros = new ArrayList<Caja>();
		for (Pedido p:ps){
			misRegistros.add(pagarPiso(c,p));
		}
		return misRegistros;
	}

	@Override
	public Caja cancelarPiso(Cliente c, Pedido p) {
		// calculo porcentaje segun la politica de devolucion
		int dias = calculoDias(new Date(), p.getLlegada());
		double porcentaje = 0;
		if (dias>30)
			porcentaje = 0.40;
		if (dias>20 && dias<=30)
			porcentaje = 0.20;
		if (dias>10 && dias<=20)
			porcentaje = 0.10;
		else 
			porcentaje = 0;
		
		Collection<Caja> misFacturas = dao.getFacturaPedido(p.getN_pedido()); 
		Caja miRegistro = null;
		double importe = 0;
		if (!misFacturas.isEmpty()){
			for(Caja f:misFacturas){
				if(f.getOperacion()=='A')
					importe = f.getImporte()*porcentaje;
			}
			int nivelOld=0;
			try { 
				nivelOld=dao.getAislamientoCon();
				dao.setAislamientoCon("TRANSACTION_READ_COMMITTED");
				// actualizamos el pedido
				p.setCancelado(true);
				int nroPedido = dao.updatePedido(p);
				// Insertamos un registro en caja
				miRegistro = new Caja ('C', nroPedido, importe >= 0? importe*-1 : importe, false, new Date());
				int nroRegistro = dao.insertFactura(miRegistro);
				miRegistro.setN_factura(nroRegistro);
				// Validamos las modificaciones y cerramos
				dao.confirmaTransaccion();	
			} catch (Exception e1) {
				// Anulamos y cerramos		
				try {
					dao.anulaTransaccion();	
					throw new TransaccionAnuladaException ("La transacci�n ha fallado: ", e1);
					} catch (Exception e2) {
						// TODO file log
						System.out.println("Imposible anular las modificaciones!");
					} 
				}finally {
					dao.resetAislamientoCon(nivelOld);
			}
		}
		return miRegistro;
	}

	@Override
	public Caja pagarPropietario(Propietario prop, Caja r) {
		// Insertamos un registro en caja
		int nroRegistro = dao.insertFactura(r);
	 	r.setN_factura(nroRegistro);
		return r;
	}
	@Override // pagamos todos los pedidos pendientes de pago
	public Collection<Caja> pagarPropietario(Propietario prop, Collection<Caja> rs){
		Collection<Caja> misRegistros = new ArrayList<Caja>();
		for (Caja r:rs){
			misRegistros.add(pagarPropietario(prop,r));
		}
		return misRegistros;
	}

	@Override
	public Caja cierreCaja(){
		Date fecha = new Date();
		Caja miRegistro = null;
		if(!dao.cajaCerrada(fecha)){
			double importeTotal = dao.totalDia(fecha,fecha);
			// Insertamos un registro en caja
			miRegistro = new Caja ();
			miRegistro.setOperacion('E');
			miRegistro.setImporte(importeTotal);
			miRegistro.setDia(new Date());
			int nroRegistro = dao.insertFactura(miRegistro);
			miRegistro.setN_factura(nroRegistro);
		} else {
			try {
				throw new CajaCerradaAnteriormenteException("No es posible volver a cerrar la caja!");
			} catch (CajaCerradaAnteriormenteException e) {
				System.out.println("No es posible volver a cerrar la caja!");
			}
		}
		return miRegistro;
	}

}
