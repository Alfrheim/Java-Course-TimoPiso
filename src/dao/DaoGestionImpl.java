package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.jdbc.Statement;

import tablas.Cliente;
import tablas.Piso;
import tablas.Propietario;

import logicaNegocio.excepciones.*;

public class DaoGestionImpl extends AbstractDao implements DaoGestion {
  /**
   * SQL
   */
  // Cliente
  
  private static final String INSERT_CLIENTE =
    "INSERT INTO cli(nif_cli, nombre, apel) VALUES (?, ?, ?)";
  private static final String CARGAR_CLIENTE =
    "SELECT nombre, apel FROM cli WHERE nif_cli = ?";
  private static final String ACTUALIZAR_CLIENTE =
    "UPDATE cli SET nombre = ?, apel = ? WHERE nif_cli = ?";
  private static final String BORRAR_CLIENTE =
    "DELETE FROM cli WHERE nif_cli = ?";
  private static final String CARGAR_CLIENTES =
    "SELECT nif_cli, nombre, apel FROM cli";

  // Piso  
  private static final String INSERT_PISO = 
    "INSERT INTO piso( dir, loc, piscina, nif_prop, precio, "+
     "comision) VALUES ( ?, ?, ?, ?, ?, ?)";
  private static final String CARGAR_PISO =
    "SELECT dir, loc, piscina, nif_prop, precio, comision "+
    "FROM piso WHERE n_piso = ?";
  private static final String ACTUALIZAR_PISO =
    "UPDATE piso SET dir = ?, loc = ?, piscina = ?, nif_prop = ?,"+
    " precio = ?, comision = ? WHERE n_piso = ?";
  private static final String BORRAR_PISO =
    "DELETE FROM piso WHERE n_piso = ?";
  private static final String CARGAR_PISOS =
    "SELECT n_piso, dir, loc, piscina, nif_prop, precio, comision "+
    "FROM piso";
  private static final String CARGAR_PISO_PROPIETARIO = 
	  "SELECT n_piso, dir, loc, piscina, precio, comision "+
  "FROM piso WHERE nif_prop = ?";

  // Propietario
  private static final String INSERT_PROPIETARIO =
    "INSERT INTO prop(nif_prop, nombre, apel, dir, loc) "+
    "VALUES (?, ?, ?, ?, ?)";
  private static final String CARGAR_PROPIETARIO =
    "SELECT nombre, apel, dir, loc FROM prop WHERE nif_prop = ?";
  private static final String ACTUALIZAR_PROPIETARIO =
    "UPDATE prop SET nombre = ?, apel = ?, dir = ?, loc = ?"+
    "WHERE nif_prop = ?";
  private static final String BORRAR_PROPIETARIO =
    "DELETE FROM prop WHERE nif_prop = ?";
  private static final String CARGAR_PROPIETARIOS =
    "SELECT nif_prop, nombre, apel, dir, loc FROM prop";
    
  // Clientes
  
  
	@Override
	public int insertCliente(Cliente c) {

      int resultado = 0;      
      try {        
        PreparedStatement ps = con.prepareStatement(INSERT_CLIENTE);
        ps.setString(1, c.getNifCli());
        ps.setString(2, c.getNombre());
        ps.setString(3, c.getApellidos());
        resultado = ps.executeUpdate();
        ps.close();
      } catch (SQLException e) {
    	  e.printStackTrace();
      } 
	return resultado;
	}
	
	
	@Override
	public Cliente getCliente(String nif_cli) {
    
      try {
       PreparedStatement ps = con.prepareStatement(CARGAR_CLIENTE);
       ps.setString(1, nif_cli);
       ResultSet rs = ps.executeQuery();
       if (rs.next()) {
         String nombre = rs.getString(1);
         String apel = rs.getString(2);
         Cliente cliente = new Cliente(nif_cli, nombre, apel);
         return cliente;
       }
       rs.close();
       ps.close();
      } catch (SQLException e) {
        for (Throwable t : e) {
          System.err.println("Errores: " + t);
        }
      }
		return null;
	}

	@Override
	public int updateCliente(Cliente c) {

      int resultado = 0;
      try {
        PreparedStatement ps = con.prepareStatement(ACTUALIZAR_CLIENTE);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellidos());
        ps.setString(3, c.getNifCli());
        resultado = ps.executeUpdate();
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      } 
	return resultado;
	}

	@Override
	public int deleteCliente(String c) {

      int resultado = 0;
      try {
        PreparedStatement ps = con.prepareStatement(BORRAR_CLIENTE);
        ps.setString(1, c);
        ps.execute();
        resultado = ps.getUpdateCount();
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
	return resultado;
	}

	@Override
	public Collection<Cliente> getClientes() {

      Collection<Cliente> cliente = new ArrayList<Cliente>();
      try {

        PreparedStatement ps = con.prepareStatement(CARGAR_CLIENTES);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          String nif = rs.getString(1);
          String nombre = rs.getString(2);
          String apel = rs.getString(3);
          cliente.add(new Cliente(nif, nombre, apel));
        }
        ps.close();
        rs.close();

      } catch (SQLException e) {
        e.printStackTrace();
      } 
	return cliente;
	}

  // Propietarios
	@Override
	public int insertPropietario(Propietario p) {
		/*
		 * No devuelve la id generada ya que String prop.nif es la id
		 * i no se genera.
		 * Devuelve 1 si se ha insertado, 0 si algo ha fallado
		 */
		
      int resultado = 0;
      try {
        PreparedStatement ps = con.prepareStatement(INSERT_PROPIETARIO);
        ps.setString(1, p.getNifProp());
        ps.setString(2, p.getNombre());
        ps.setString(3, p.getApellidos());
        ps.setString(4, p.getDireccion());
        ps.setString(5, p.getLocalizacion());        
        resultado = ps.executeUpdate();
        ps.close();
      } catch (SQLException e) {
    	  e.printStackTrace();
      }
      return resultado;
	}

	@Override
	public Propietario getPropietario(String nif_prop) {

      try {
        PreparedStatement ps = con.prepareStatement(CARGAR_PROPIETARIO);
        ps.setString(1, nif_prop);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
          String nombre = rs.getString(1);
          String apel = rs.getString(2);
          String dir = rs.getString(3);
          String loc = rs.getString(4);
          Propietario p = new Propietario(nif_prop, nombre, apel,
                                          dir, loc);
          return p;
        }

      } catch (SQLException e) {
        e.printStackTrace();
      }
		return null;
	}

	@Override
	public int updatePropietario(Propietario p) {
	
		 int resultado = 0;
      try {
        PreparedStatement ps = con.prepareStatement
          (ACTUALIZAR_PROPIETARIO);        
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getApellidos());
        ps.setString(3, p.getDireccion());
        ps.setString(4, p.getLocalizacion());
        ps.setString(5, p.getNifProp());
        resultado = ps.executeUpdate();
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return resultado;
	}
	
	@Override
	public int deletePropietario(String p) {

	  int resultado = 0;
      try {
        PreparedStatement ps = con.prepareStatement
          (BORRAR_PROPIETARIO);        
        ps.setString(1, p);
        resultado = ps.executeUpdate();
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return resultado;
	}

	@Override
	public Collection<Propietario> getPropietarios() {
	
		Collection<Propietario> propietario =
          new ArrayList<Propietario>();
      try {

        PreparedStatement ps = con.prepareStatement(CARGAR_PROPIETARIOS);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          String nif = rs.getString(1);
          String nombre = rs.getString(2);
          String apel = rs.getString(3);
          String dir = rs.getString(4);
          String loc = rs.getString(5);
          propietario.add(new Propietario(nif, nombre, apel, dir, loc));
        }
        ps.close();
        rs.close();

      } catch (SQLException e) {
        e.printStackTrace();
      } 
	return propietario;
	}

  // Piso
	@Override
	public Collection<Piso> getPisosPropietario(String nif_prop) {
		
		Collection<Piso> piso =
          new ArrayList<Piso>();
      try {

        PreparedStatement ps = con.prepareStatement(CARGAR_PISO_PROPIETARIO);
        ps.setString(1, nif_prop);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          int n_piso = rs.getInt(1);
          String dir = rs.getString(2);
          String loc = rs.getString(3);
          boolean piscina = rs.getBoolean(4);
          Double precio = rs.getDouble(5);
          float comision = rs.getFloat(6);
          piso.add(new Piso(n_piso, dir, loc, piscina, nif_prop,
                            precio, comision));
        }
        ps.close();
        rs.close();

      } catch (SQLException e) {
        e.printStackTrace();
      } 
	return piso;
	}

	@Override
	public int insertPiso(Piso p) {
		/*
		 * Devuelve la id generada al insertar un piso, devuelve 0 si
		 * no se ha podido insertar.
		 */
		
		int idGenerada = 0;
	      try {
	        PreparedStatement ps = con.prepareStatement(INSERT_PISO, Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, p.getDireccion());
	        ps.setString(2, p.getLocalizacion());
	        ps.setBoolean(3, p.isPiscina());
	        ps.setString(4, p.getNifProp());
	        ps.setDouble(5, p.getPrecio());
	        ps.setDouble(6, p.getComision());
	        idGenerada = ps.executeUpdate();
	        ps.close();
	      } catch (SQLException e) {	        
	    	  e.printStackTrace();
	      } 
	      return idGenerada;

	}

	@Override
	public Piso getPiso(int n_piso) {
      try {

       PreparedStatement ps = con.prepareStatement(CARGAR_PISO);
       ps.setInt(1, n_piso);
       ResultSet rs = ps.executeQuery();
       if (rs.next()) {
          String dir = rs.getString(1);
          String loc = rs.getString(2);
          boolean piscina = rs.getBoolean(3);
          String nif_prop = rs.getString(4);
          Double precio = rs.getDouble(5);
          float comision = rs.getFloat(6);
          Piso piso = new Piso(n_piso, dir, loc, piscina, nif_prop,
                               precio, comision);
         return piso;
       }
       rs.close();
       ps.close();
      } catch (SQLException e) {
    	  for (Throwable t : e) {
    		  System.err.println("Errores: " + t);
    	  }
      }
      return null;
	}

	@Override
	public int updatePiso(Piso p) {
		int resultado = 0;
		try {

			PreparedStatement ps = con.prepareStatement(ACTUALIZAR_PISO);
			ps.setString(1, p.getDireccion());
			ps.setString(2, p.getLocalizacion());
			ps.setBoolean(3, p.isPiscina());
			ps.setString(4, p.getNifProp());
			ps.setDouble(5, p.getPrecio());
			ps.setDouble(6, p.getComision());
			ps.setInt(7, p.getNumero());
			resultado = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Errores: " + t);
			}
		}
		return resultado;

	}

	@Override
	public int deletePiso(int p) {
		int resultado = 0;
		try {
			PreparedStatement ps = con.prepareStatement(BORRAR_PISO);
			ps.setInt(1, p);
			resultado = ps.executeUpdate();
			ps.close();

		}  catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Errores: " + t);
			}
		}
		return resultado;
	}

	@Override
	public Collection<Piso> getPisos() {
		Collection<Piso> piso =
	          new ArrayList<Piso>();
	      try {

	        PreparedStatement ps = con.prepareStatement(CARGAR_PISOS);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	          int n_piso = rs.getInt(1);
	          String dir = rs.getString(2);
	          String loc = rs.getString(3);
	          boolean piscina = rs.getBoolean(4);
	          String nif_prop = rs.getString(5);
	          Double precio = rs.getDouble(6);
	          float comision = rs.getFloat(7);
	          piso.add(new Piso(n_piso, dir, loc, piscina, nif_prop,
	                            precio, comision));
	        }
	        ps.close();
	        rs.close();

	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
		return piso;
	}
	

	

}
