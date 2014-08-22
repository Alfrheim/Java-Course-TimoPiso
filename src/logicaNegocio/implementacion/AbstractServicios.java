package logicaNegocio.implementacion;

import dao.DaoInmobiliaria;
import dao.DaoInmobiliariaImpl;

public abstract class AbstractServicios {
	
	protected final DaoInmobiliaria dao = new DaoInmobiliariaImpl();
	
}
