package logicaNegocio.excepciones;

public class ModificacionesNoAnuladasException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModificacionesNoAnuladasException(String message, Throwable cause) {
		super(message, cause);
	}
}
