package logicaNegocio.excepciones;

public class PisoYaExisteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PisoYaExisteException() {
		super("El piso ya existe!");
	}

}
