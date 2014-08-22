package logicaNegocio.implementacion;

import tablas.Cliente;
import tablas.Piso;
import tablas.Propietario;

import java.util.Collection;

public interface ServiciosGestion {
	
	/*
	 * interfaz dummy de DaoGestion
	 */
	// cliente
	public int insertCliente(Cliente c);
	public Cliente getCliente(String nif_cli);
	public int updateCliente(Cliente c);
	public int deleteCliente(String c);
	public Collection<Cliente> getClientes();
	
	// propietario
	public int insertPropietario(Propietario p);
	public Propietario getPropietario(String nif_prop);
	public int updatePropietario(Propietario p);
	public int deletePropietario(String p);
	public Collection<Propietario> getPropietarios();
	public Collection<Piso> getPisosPropietario(String nif_prop);

	
	// piso
	public int insertPiso(Piso p);
	public Piso getPiso(int n_piso);
	public int updatePiso(Piso p);
	public int deletePiso(int p);
	public Collection<Piso> getPisos();
	
}
