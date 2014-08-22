package tablas;

public class Propietario {
	private String nifProp;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String localizacion;
	
	
	public Propietario(String nifProp, String nombre, String apellidos,
			String direccion, String localizacion) {
		super();
		this.nifProp = nifProp;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.localizacion = localizacion;
	}
	public String getNifProp() {
		return nifProp;
	}
	public void setNifProp(String nifProp) {
		this.nifProp = nifProp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	@Override
    public String toString() {
	    return nifProp;
    }
	

}
