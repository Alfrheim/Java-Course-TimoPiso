package tablas;

public class Cliente {
	private String nifCli;
	private String nombre;
	private String apellidos;
	
	
	public Cliente(String nifCli, String nombre, String apellidos) {
		super();
		this.nifCli = nifCli;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public String getNifCli() {
		return nifCli;
	}
	public void setNifCli(String nifCli) {
		this.nifCli = nifCli;
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
	
	
	
	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((nifCli == null) ? 0 : nifCli.hashCode());
	    return result;
    }
	@Override
    public boolean equals(Object obj) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    Cliente other = (Cliente) obj;
	    if (nifCli == null) {
		    if (other.nifCli != null)
			    return false;
	    } else if (!nifCli.equals(other.nifCli))
		    return false;
	    return true;
    }
	@Override
    public String toString() {
	    return nifCli+" - "+nombre+" - "+apellidos;
    }
	

}
