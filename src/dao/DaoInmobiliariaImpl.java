package dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.Collection;

import logicaNegocio.excepciones.ClienteYaExisteException;
import logicaNegocio.excepciones.PisoYaExisteException;
import logicaNegocio.excepciones.PropietarioYaExisteException;
import tablas.Caja;
import tablas.Cliente;
import tablas.Pedido;
import tablas.Piso;
import tablas.Propietario;

public class DaoInmobiliariaImpl implements DaoInmobiliaria {
	DaoGestion gestion = new DaoGestionImpl();
	DaoPagos pagos = new DaoPagosImpl();
	
	// Dao gestion
	@Override
	public int insertCliente(Cliente c) {
		return gestion.insertCliente(c);
	}
	@Override
	public Cliente getCliente(String nif_cli) {
		return gestion.getCliente(nif_cli);
	}
	@Override
	public int updateCliente(Cliente c) {
		return gestion.updateCliente(c);
	}
	@Override
	public int deleteCliente(String c) {
		return gestion.deleteCliente(c);
	}
	@Override
	public Collection<Cliente> getClientes() {
		return gestion.getClientes();
	}
	@Override
	public int insertPropietario(Propietario p) {
		return gestion.insertPropietario(p);
	}
	@Override
	public Propietario getPropietario(String nif_prop) {
		return gestion.getPropietario(nif_prop);
	}
	@Override
	public int updatePropietario(Propietario p) {
		return gestion.updatePropietario(p);
	}
	@Override
	public int deletePropietario(String p) {
		return gestion.deletePropietario(p);
	}
	@Override
	public Collection<Propietario> getPropietarios() {
		return gestion.getPropietarios();
	}
	@Override
	public Collection<Piso> getPisosPropietario(String nif_prop) {
		return gestion.getPisosPropietario(nif_prop);
	}
	@Override
	public int insertPiso(Piso p) {
		return gestion.insertPiso(p);
	}
	@Override
	public Piso getPiso(int n_piso) {
		return gestion.getPiso(n_piso);
	}
	@Override
	public int updatePiso(Piso p) {
		return gestion.updatePiso(p);
	}
	@Override
	public int deletePiso(int p) {
		return gestion.deletePiso(p);
	}
	@Override
	public Collection<Piso> getPisos() {
		return gestion.getPisos();
	}
	
	// Dao pagos
	@Override
	public int insertFactura(Caja c) {
		return pagos.insertFactura(c);
	}
	@Override
	public Caja getFactura(int n_factura) {
		return pagos.getFactura(n_factura);
	}
	@Override
	public Collection<Caja> getFacturas() {
		return pagos.getFacturas();
	}
	@Override
	public int insertPedido(Pedido p) {
		return pagos.insertPedido(p);
	}
	@Override
	public Pedido getPedido(long n_pedido) {
		return pagos.getPedido(n_pedido);
	}
	@Override
	public int updatePedido(Pedido p) {
		return pagos.updatePedido(p);
	}
	@Override
	public Collection<Pedido> getPedidos() {
		return pagos.getPedidos();
	}
	@Override
	public Collection<Piso> getPisosDisponibles(Date fechaInicio, Date fechaFin) {
		return pagos.getPisosDisponibles(fechaInicio, fechaFin);
	}
	@Override
	public Collection<Caja> getFacturaPedido(long n_pedido) {
		return pagos.getFacturaPedido(n_pedido);
	}
	@Override
	public Collection<Pedido> getPedidosCliente(String nif_cli) {
		return pagos.getPedidosCliente(nif_cli);
	}
	@Override
	public Collection<Pedido> getPedidosPropietario(String nif_prop) {
		return pagos.getPedidosPropietario(nif_prop);
	}
	@Override
	public int getAislamientoCon() {
		return pagos.getAislamientoCon();
	}
	@Override
	public void setAislamientoCon(String nivel) {
		pagos.setAislamientoCon(nivel);
	}
	@Override
	public void confirmaTransaccion() throws SQLException {
		pagos.confirmaTransaccion();
		
	}
	@Override
	public void anulaTransaccion() throws SQLException {
		pagos.anulaTransaccion();
		
	}
	@Override
	public void resetAislamientoCon(int n) {
		pagos.resetAislamientoCon(n);
		
	}
	@Override
	public double totalDia(Date fecha, Date fecha2) {
		return pagos.totalDia(fecha, fecha2);
	}
	@Override
	public boolean cajaCerrada(Date fecha) {
		return pagos.cajaCerrada(fecha);
	}
	

}
