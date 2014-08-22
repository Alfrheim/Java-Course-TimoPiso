package logicaNegocio.excepciones;

public class CajaCerradaAnteriormenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public CajaCerradaAnteriormenteException(String message) {
		super(message);
	}
}
