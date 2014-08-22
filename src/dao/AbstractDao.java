package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDao {
	
	protected static final Connection con;
	
	static {
		Conexion.setURL("jdbc:mysql://localhost:3306/inmobiliaria?user=root&password=root");
		con = Conexion.getConexion();
	}
	
	/*
	 
	 */
	protected static int getLastID(PreparedStatement pstm){
		/*
		 * Hay que pasarle un pstm que tiene un Statement.RETURN_GENERATED_KEYS como parametro
		 * Ejemplo:
		 * stmt.executeUpdate(SQL_COMAND, Statement.RETURN_GENERATED_KEYS);
		 * devuelve la id generada por la consulta la id tiene que ser
		 * siempre id > 0
		 */
		int clavePrim = 0;
		try {
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()) {
				clavePrim=rs.getInt(1);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clavePrim;
	}
	
	protected static int getLastTableID(String tabla){
		// TODO implementar
		return 0;
	}

	public static void cerrarConexion(){
		Conexion.desconecta();
	}
	
}
