package dao;

import tablas.Caja;
import tablas.Pedido;
import tablas.Piso;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public interface DaoPagos {
	
	// caja
	public int insertFactura(Caja c);
	public Caja getFactura(int n_factura);
	public Collection<Caja> getFacturas();
	//public double totalDia(Date fecha); // devuelve el importe total del dia
	public double totalDia(Date fecha, Date fecha2);
	public boolean cajaCerrada(Date fecha);
	public Collection<Caja> getFacturaPedido(long n_pedido);
	
	// pedido
	public int insertPedido(Pedido p);
	public Pedido getPedido(long n_pedido);
	public int updatePedido(Pedido p);
	public Collection<Pedido> getPedidos();
	public Collection<Pedido> getPedidosCliente(String nif_cli);
	public Collection<Piso> getPisosDisponibles(Date fechaInicio, Date fechaFin);
	public Collection<Pedido> getPedidosPropietario(String nif_prop);
	
	// transaccion
	public int getAislamientoCon();
	public void setAislamientoCon(String nivel);
	public void confirmaTransaccion() throws SQLException;
	public void anulaTransaccion() throws SQLException;
	public void resetAislamientoCon(int n);
	
	
	
	
}
