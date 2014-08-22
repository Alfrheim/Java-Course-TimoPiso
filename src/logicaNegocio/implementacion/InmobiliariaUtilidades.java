package logicaNegocio.implementacion;

public class InmobiliariaUtilidades {
	
	private ServiciosInmobiliaria inm;
	
	public InmobiliariaUtilidades () {
		inm = ServiciosInmobiliariaFactory.getSerInm();
	}
	
	public ServiciosInmobiliaria getDao() {
		return inm;
	}
	
	
}
