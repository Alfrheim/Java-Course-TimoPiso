package tablas;

public class Piso {
	private int numero;
	private String direccion;
	private String localizacion;
	private boolean piscina;
	private String nifProp;
	private double precio;
	private float comision;
	
	public Piso(){
		
	}
	
	public Piso(String direccion, String localizacion, boolean piscina,
			String nifProp, double precio, float comision) {
		super();
		this.direccion = direccion;
		this.localizacion = localizacion;
		this.piscina = piscina;
		this.nifProp = nifProp;
		this.precio = precio;
		this.comision = comision;
	}

	public Piso(int numero, String direccion, String localizacion,
			boolean piscina, String nifProp, double precio, float comision) {
		super();
		this.numero = numero;
		this.direccion = direccion;
		this.localizacion = localizacion;
		this.piscina = piscina;
		this.nifProp = nifProp;
		this.precio = precio;
		this.comision = comision;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public String getNifProp() {
		return nifProp;
	}
	public void setNifProp(String nifProp) {
		this.nifProp = nifProp;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}

	@Override
    public String toString() {
	    return localizacion+ "    -    "+ direccion;
    }
	

}
