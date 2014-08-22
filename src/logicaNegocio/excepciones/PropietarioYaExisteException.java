package logicaNegocio.excepciones;

public class PropietarioYaExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropietarioYaExisteException() {
		super("El piso ya existe!");
	}

}
