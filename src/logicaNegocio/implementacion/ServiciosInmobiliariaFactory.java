package logicaNegocio.implementacion;

public class ServiciosInmobiliariaFactory {
	
	protected static ServiciosInmobiliaria SERVICIOS_INMOBILIARIA;
	
	public static ServiciosInmobiliaria getSerInm() {
		if (SERVICIOS_INMOBILIARIA == null) {
			SERVICIOS_INMOBILIARIA = new ServiciosInmobiliariaImpl(); 
		}
		return SERVICIOS_INMOBILIARIA;
	}
	
}
