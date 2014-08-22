package logicaNegocio.excepciones;

public class TransaccionAnuladaException extends Exception {

	private static final long serialVersionUID = 1L;

	public TransaccionAnuladaException(String message, Throwable cause) {
		super(message, cause);
	}
}
