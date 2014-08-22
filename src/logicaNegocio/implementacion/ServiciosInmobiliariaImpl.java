package logicaNegocio.implementacion;

import tablas.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

public class ServiciosInmobiliariaImpl implements ServiciosInmobiliaria {
	ServiciosGestion gestion = new ServiciosGestionImpl();
	ServiciosPagos pagos = new ServiciosPagosImpl();

	@Override
    public int deleteCliente(String c) {
	    return gestion.deleteCliente(c);
    }

	@Override
    public int deletePiso(int p) {
	    return gestion.deletePiso(p);
    }

	@Override
    public int deletePropietario(String p) {
	    return gestion.deletePropietario(p);
    }

	@Override
    public Cliente getCliente(String nifCli) {
	    return gestion.getCliente(nifCli);
    }

	@Override
    public Collection<Cliente> getClientes() {
	    return gestion.getClientes();
    }

	@Override
    public Piso getPiso(int nPiso) {
	    return gestion.getPiso(nPiso);
    }

	@Override
    public Collection<Piso> getPisos() {
	    return gestion.getPisos();
    }

	@Override
    public Collection<Piso> getPisosPropietario(String nifProp) {
	    return gestion.getPisosPropietario(nifProp);
    }

	@Override
    public Propietario getPropietario(String nifProp) {
	    return gestion.getPropietario(nifProp);
    }

	@Override
    public Collection<Propietario> getPropietarios() {
	    return gestion.getPropietarios();
    }

	@Override
    public int insertCliente(Cliente c) {
	    return gestion.insertCliente(c);
    }

	@Override
    public int insertPiso(Piso p) {
	    return gestion.insertPiso(p);
    }

	@Override
    public int insertPropietario(Propietario p) {
	    return gestion.insertPropietario(p);
    }

	@Override
    public int updateCliente(Cliente c) {
	    return gestion.updateCliente(c);
    }

	@Override
    public int updatePiso(Piso p) {
	    return gestion.updatePiso(p);
    }

	@Override
    public int updatePropietario(Propietario p) {
	    return gestion.updatePropietario(p);
    }
	
	
	// PAGOS	
	@Override
	public Caja reservarPiso(Cliente c, Date fechaInicio, Date fechaFin, Piso p) {
		return pagos.reservarPiso(c, fechaInicio, fechaFin, p);
	}

	@Override
	public Collection<Pedido> getPedidosPendientesCliente(Cliente c) {
		return pagos.getPedidosPendientesCliente(c);
	}

	@Override
	public Caja pagarPiso(Cliente c, Pedido p) {
		return pagos.pagarPiso(c, p);
	}

	@Override
	public Collection<Caja> pagarPiso(Cliente c, Collection<Pedido> ps) {
		return pagos.pagarPiso(c, ps);
	}

	@Override
	public Caja cancelarPiso(Cliente c, Pedido p) {
		return pagos.cancelarPiso(c, p);
	}

	@Override
	public Collection<Caja> getPedidosPendientesPropietario(Propietario prop) {
		return pagos.getPedidosPendientesPropietario(prop);
	}

	@Override
	public Caja pagarPropietario(Propietario prop, Caja r) {
		return pagos.pagarPropietario(prop, r);
	}

	@Override
	public Collection<Caja> pagarPropietario(Propietario prop, Collection<Caja> rs) {
		return pagos.pagarPropietario(prop, rs);
	}

	@Override
	public Caja cierreCaja(){
		return pagos.cierreCaja();
	}

	@Override
	public HashMap<String, Piso> getPisosDisponibles(Date fechaInicio, Date fechaFin) {
		return pagos.getPisosDisponibles(fechaInicio, fechaFin);
	}



}
