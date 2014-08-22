package tablas;

import java.util.Date;



public class Pedido {
	private long n_pedido;
	private String nif_cli;
	private int n_piso;
	private Date llegada;
	private Date partida;
	private boolean pagado;
	private boolean cancelado;
	

	

	public Pedido(String nifCli, int nPiso, Date llegada, Date partida,
            boolean pagado, boolean cancelado) {
	    super();
	    nif_cli = nifCli;
	    n_piso = nPiso;
	    this.llegada = llegada;
	    this.partida = partida;
	    this.pagado = pagado;
	    this.cancelado = cancelado;
    }


	public Pedido(long n_pedido, String nif_cli, int n_piso, Date llegada,
			Date partida, boolean pagado, boolean cancelado) {
		super();
		this.n_pedido = n_pedido;
		this.nif_cli = nif_cli;
		this.n_piso = n_piso;
		this.llegada = llegada;
		this.partida = partida;
		this.pagado = pagado;
		this.cancelado = cancelado;
	}

	public long getN_pedido() {
		return n_pedido;
	}

	public void setN_pedido(long n_pedido) {
		this.n_pedido = n_pedido;
	}

	public String getNif_cli() {
		return nif_cli;
	}

	public void setNif_cli(String nif_cli) {
		this.nif_cli = nif_cli;
	}

	public int getN_piso() {
		return n_piso;
	}

	public void setN_piso(int n_piso) {
		this.n_piso = n_piso;
	}

	public Date getLlegada() {
		return llegada;
	}

	public void setLlegada(Date llegada) {
		this.llegada = llegada;
	}

	public Date getPartida() {
		return partida;
	}

	public void setPartida(Date partida) {
		this.partida = partida;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	@Override
	public String toString() {
		return "Pedido [n_pedido=" + n_pedido + ", nif_cli=" + nif_cli
				+ ", n_piso=" + n_piso + ", llegada=" + llegada + ", partida="
				+ partida + ", pagado=" + pagado + ", cancelado=" + cancelado
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	

}
