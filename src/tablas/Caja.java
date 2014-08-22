package tablas;

import java.util.Date;

public class Caja {
	private int n_factura;
	private char operacion;
	private long n_pedido;
	private double importe;
	private boolean pagado;
	private Date dia;
	
	public Caja (){
		
	}
	
	public Caja(char operacion, long n_pedido, double importe,
			boolean pagado, Date dia) {
		super();
		this.operacion = operacion;
		this.n_pedido = n_pedido;
		this.importe = importe;
		this.pagado = pagado;
		this.dia = dia;
	}

	public Caja(int n_factura, char operacion, long n_pedido,
			double importe, boolean pagado, Date dia) {
		super();
		this.n_factura = n_factura;
		this.operacion = operacion;
		this.n_pedido = n_pedido;
		this.importe = importe;
		this.pagado = pagado;
		this.dia = dia;
	}


	public long getN_factura() {
		return n_factura;
	}

	public void setN_factura(int n_factura) {
		this.n_factura = n_factura;
	}

	public char getOperacion() {
		return operacion;
	}

	public void setOperacion(char operacion) {
		this.operacion = operacion;
	}

	public long getN_pedido() {
		return n_pedido;
	}

	public void setN_pedido(long n_pedido) {
		this.n_pedido = n_pedido;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "Caja [n_factura=" + n_factura + ", operacion=" + operacion
				+ ", n_pedido=" + n_pedido + ", importe=" + importe
				+ ", pagado=" + pagado + ", dia=" + dia + "]";
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	
	

}
