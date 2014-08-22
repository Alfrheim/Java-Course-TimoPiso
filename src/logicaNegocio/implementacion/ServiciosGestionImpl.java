package logicaNegocio.implementacion;

import tablas.Cliente;
import tablas.Piso;
import tablas.Propietario;

import java.util.Collection;

public class ServiciosGestionImpl extends AbstractServicios implements ServiciosGestion {
	
	/*
	 * Dummy de la Gestion
	 */
	
	// Gestion del Cliente

	@Override
	public int insertCliente(Cliente c) {
		return dao.insertCliente(c);
	}
	
	@Override
	public Cliente getCliente(String nif_cli) {
		return dao.getCliente(nif_cli);
	}

	@Override
	public int updateCliente(Cliente c) {
		return dao.updateCliente(c);
	}

	@Override
	public int deleteCliente(String c) {
		return dao.deleteCliente(c);
	}

	@Override
	public Collection<Cliente> getClientes() {
		return dao.getClientes();
	}
	
	// Gestion del Propietario

	@Override
	public int insertPropietario(Propietario p) {
		return dao.insertPropietario(p);
	}

	@Override
	public Propietario getPropietario(String nif_prop) {
		return dao.getPropietario(nif_prop);
	}

	@Override
	public int updatePropietario(Propietario p) {
		return dao.updatePropietario(p);
	}

	@Override
	public int deletePropietario(String p) {
		return dao.deletePropietario(p);
	}

	@Override
	public Collection<Propietario> getPropietarios() {
		return dao.getPropietarios();
	}

	@Override
	public Collection<Piso> getPisosPropietario(String nif_prop) {
		return dao.getPisosPropietario(nif_prop);
	}
	
	// Gestion Pisos

	@Override
	public int insertPiso(Piso p) {		
		return dao.insertPiso(p);
	}

	@Override
	public Piso getPiso(int n_piso) {
		return dao.getPiso(n_piso);
	}

	@Override
	public int updatePiso(Piso p) {
		return dao.updatePiso(p);
	}

	@Override
	public int deletePiso(int p) {
		return dao.deletePiso(p);
	}

	@Override
	public Collection<Piso> getPisos() {
		return dao.getPisos();
	}
}
