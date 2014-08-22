package logicaNegocio.implementacion;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import tablas.Caja;
import tablas.Cliente;
import tablas.Pedido;
import tablas.Piso;
import tablas.Propietario;

public interface ServiciosPagos {
	// reserva piso
	public HashMap<String, Piso> getPisosDisponibles(Date fechaInicio, Date fechaFin);
	public Caja reservarPiso(Cliente c, Date fechaInicio, Date fechaFin, Piso p);
	
	// pago piso y cancelacion piso
	public Collection<Pedido> getPedidosPendientesCliente(Cliente c);
	public Caja pagarPiso(Cliente c, Pedido p);
	public Collection<Caja> pagarPiso(Cliente c, Collection<Pedido> ps);
	public Caja cancelarPiso(Cliente c, Pedido p);
	
	// pago propietario
	public Collection<Caja> getPedidosPendientesPropietario(Propietario prop);
	public Caja pagarPropietario(Propietario prop, Caja r);
	public Collection<Caja> pagarPropietario(Propietario prop, Collection<Caja> rs);
	
	// cierre caja
	public Caja cierreCaja();
	

}
