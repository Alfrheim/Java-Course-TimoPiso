package logicaNegocio.excepciones;

public class ClienteYaExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteYaExisteException() {
		super("El piso ya existe!");
	}

}
