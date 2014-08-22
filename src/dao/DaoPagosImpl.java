package dao;

import tablas.Caja;
import tablas.Pedido;
import tablas.Piso;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DaoPagosImpl extends AbstractDao implements DaoPagos {

	private static final String FIND_ALL_FACTURAS_SQL = 
		"select * from caja";
	private static final String FIND_FACTURAS_POR_FECHAS =
		"select n_factura,operacion,importe,pagado,dia from caja "+
		"where operacion <> 'E' and dia >= ? and dia <= ?";
	private static final String CIERRE_CAJA =
		"select n_factura,operacion,importe,pagado,dia from caja "+
		"where operacion = 'E' and dia = ? ";
	private static final String ALL_FACTURAS_POR_PEDIDO =
		"select n_factura,operacion,importe,pagado,dia from caja " +
		"where n_pedido = ?";
	private static final String FIND_ALL_PEDIDOS_SQL = 
		"select * from pedido";
	private static final String ALL_PEDIDOS_POR_CLIENTE =
		"select n_pedido,n_piso,llegada,partida,pagado,cancelado from pedido " +
		"where nif_cli = ? ";
	private static final String ALL_PEDIDOS_POR_PROPIETARIO =
		"SELECT n_pedido,nif_cli,pedido.n_piso,llegada,partida, pagado, cancelado " +
		"from pedido " +
		"inner join piso on pedido.n_piso=piso.n_piso and piso.nif_prop=? ";
	private static final String INSERT_FACTURA = 
		"insert into caja (operacion,n_pedido,importe,pagado,dia) values" +
		" (?,?,?,?,?)";
	private static final String GET_FACTURA = 
		"select operacion,n_pedido,importe,pagado,dia from caja " +
		"where n_factura = ?";
	private static final String INSERT_PEDIDO =
		"insert into pedido (nif_cli,n_piso,llegada,partida," +
		"pagado,cancelado) values (?,?,?,?,?,?);";
	private static final String GET_PEDIDO =
		"select nif_cli,n_piso,llegada,partida,pagado,cancelado " +
		"from pedido where n_pedido = ?";
	private static final String UPDATE_PEDIDO =
		"update pedido set nif_cli= ?, n_piso = ?, llegada = ?, partida = ?," +
		" pagado = ?, cancelado = ? where n_pedido = ?";
	private static final String PISOS_LIBRES =
		"select piso.n_piso, dir, loc, piscina, nif_prop, precio, comision " +
		"from piso left join pedido on piso.n_piso=pedido.n_piso and pedido.partida < ?";


	private java.sql.Date cambiaFecha (Date changeFec){ 
		java.util.Date fecha = changeFec;
		java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
		return fecha2;
	}


	@Override
	public int insertFactura(Caja c) { // Insertar factura
		/*
		 * devuelve la id generada por la consulta la id tiene que ser
		 * siempre id > 0
		 */
		int idGenerada=0;	

		//java.sql.Date fechaSys= new java.sql.Date(System.currentTimeMillis());
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_FACTURA, Statement.RETURN_GENERATED_KEYS);
			char operacion=c.getOperacion();
			String operasql=String.valueOf(operacion);
			ps.setString(1, operasql);
			ps.setLong(2, c.getN_pedido());
			ps.setDouble(3,c.getImporte());
			ps.setBoolean(4,c.isPagado());
			java.sql.Date fecha1=this.cambiaFecha(c.getDia());
			ps.setDate(5,fecha1);
			ps.executeUpdate();
			idGenerada = getLastID(ps);

			ps.close();


		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error al insertar Factura: " + t);
			}
		}
		return idGenerada;
	}


	@Override
	public Caja getFactura(int n_id) { // Leer factura
		Caja caja=null;

		try {

			PreparedStatement ps = con.prepareStatement(GET_FACTURA);
			ps.setLong(1, n_id);
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				char operacion=rs.getString(1).toCharArray()[0];
				long n_pedido=rs.getLong(2);
				double importe=rs.getDouble(3);
				boolean pagado=rs.getBoolean(4);
				java.sql.Date dia=rs.getDate(5);
				caja=new Caja(n_id,operacion,n_pedido,importe,pagado,dia);
			}

		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error al leer Factura: " + t);
			}
		} 
		return caja;
	}

	@Override
	public Collection<Caja> getFacturas() { // Todas las facturas
		Collection<Caja> caja = new ArrayList<Caja>();

		try {
			PreparedStatement ps=con.prepareStatement(FIND_ALL_FACTURAS_SQL);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				int n_factura=rs.getInt(1);
				char operacion=rs.getString(2).toCharArray()[0];
				long n_pedido=rs.getLong(3);
				double importe=rs.getDouble(4);
				boolean pagado=rs.getBoolean(5);
				java.sql.Date dia=rs.getDate(6);

				caja.add(new Caja(n_factura,operacion,n_pedido,
						importe,pagado,dia));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error: " + t);
			}
		}
		return caja;
	}
	
	@Override
	public int insertPedido(Pedido p) { // Insertar pedido
		/*
		 * devuelve la id generada por la consulta la id tiene que ser
		 * siempre id > 0
		 */
		int idGenerada=0;	
		java.sql.Date fecha1=this.cambiaFecha(p.getLlegada());
		java.sql.Date fecha2=this.cambiaFecha(p.getPartida());
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_PEDIDO, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, p.getNif_cli());
			ps.setInt(2, p.getN_piso());
			ps.setDate(3,fecha1);
			ps.setDate(4,fecha2);
			ps.setBoolean(5,p.isPagado());
			ps.setBoolean(6,p.isCancelado());

			ps.executeUpdate();
			idGenerada = getLastID(ps);


			ps.close();


		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error al insertar Pedido: " + t);
			}
		}
		System.out.println("Id Generada" + idGenerada);
		return idGenerada;
	}

	@Override
	public Pedido getPedido(long n_id) { // Leer pedido
		Pedido pedido=null;

		try{
			PreparedStatement ps = con.prepareStatement(GET_PEDIDO);
			ps.setLong(1, n_id);
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {

				String nif_cli=rs.getString(1);
				int n_piso=rs.getInt(2);
				java.sql.Date llegada=rs.getDate(3);
				java.sql.Date partida=rs.getDate(4);
				boolean pagado=rs.getBoolean(5);
				boolean cancelado=rs.getBoolean(6);
				pedido=new Pedido(n_id,nif_cli,n_piso,llegada,partida,pagado,cancelado);
			}

		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error al leer Pedido: " + t);
			}
		}
		return pedido;
	}

	@Override
	public int updatePedido(Pedido p) { // Modificar pedido
		int filasMod=0;
		java.sql.Date fecha1=this.cambiaFecha(p.getLlegada());
		java.sql.Date fecha2 =this.cambiaFecha(p.getPartida());

		try {

			PreparedStatement ps = con.prepareStatement(UPDATE_PEDIDO);
			ps.setString(1, p.getNif_cli());
			ps.setInt(2, p.getN_piso());
			ps.setDate(3, fecha1);
			ps.setDate(4,fecha2);
			ps.setBoolean(5,p.isPagado());
			ps.setBoolean(6,p.isCancelado());
			ps.setInt(7,p.getN_piso());

			filasMod=ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error al modificar Pedido: " + t);
			}
		}
		return filasMod;
	}

	@Override
	public Collection<Pedido> getPedidos() { // Todos los pedidos
		Collection<Pedido> pedido = new ArrayList<Pedido>();

		try {
			PreparedStatement ps=con.prepareStatement(FIND_ALL_PEDIDOS_SQL);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				long n_id=rs.getLong(1);
				String nif_cli=rs.getString(2);
				int n_piso=rs.getInt(3);
				java.sql.Date llegada=rs.getDate(4);
				java.sql.Date partida=rs.getDate(5);
				boolean pagado=rs.getBoolean(6);
				boolean cancelado=rs.getBoolean(7);		

				pedido.add(new Pedido(n_id,nif_cli,n_piso,
						llegada,partida,pagado,cancelado));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error cargando lista de pedidos : " + t);
			}
		}
		return pedido;

	}

	@Override
	public Collection<Piso> getPisosDisponibles(Date fechaInicio, Date fechaFin) { // Pisos libres entre fechas
		Collection<Piso> piso = new ArrayList<Piso>();
		java.sql.Date fecha1=this.cambiaFecha(fechaFin);

		try {
			PreparedStatement ps=con.prepareStatement(PISOS_LIBRES);
			ps.setDate(1,fecha1);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				int numero=rs.getInt(1);
				String direccion=rs.getString(2);
				String localizacion=rs.getString(3);
				boolean piscina=rs.getBoolean(4);
				String nifProp=rs.getString(5);
				double precio=rs.getDouble(6);
				float comision=rs.getFloat(7);

				piso.add(new Piso(numero,direccion,localizacion,
						piscina,nifProp,precio,comision));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error cargando lista de pisos disponibles : " + t);
			}
		}
		return piso;
	}


	@Override
	public Collection<Caja> getFacturaPedido(long n_pedido) { // Todas las facturas de un pedido
		Collection<Caja> caja = new ArrayList<Caja>();

		try {
			PreparedStatement ps=con.prepareStatement(ALL_FACTURAS_POR_PEDIDO);
			ps.setLong(1, n_pedido);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				int n_factura=rs.getInt(1);
				char operacion=rs.getString(2).toCharArray()[0];
				double importe=rs.getDouble(3);
				boolean pagado=rs.getBoolean(4);
				java.sql.Date dia=rs.getDate(5);

				caja.add(new Caja(n_factura,operacion,n_pedido,
						importe,pagado,dia));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error buscando facturas por pedido : " + t);
			}
		}
		return caja;
	}


	@Override
	public Collection<Pedido> getPedidosCliente(String nif_cli) { // Todos los pedidos de un cliente
		Collection<Pedido> pedido = new ArrayList<Pedido>();

		try {
			PreparedStatement ps=con.prepareStatement(ALL_PEDIDOS_POR_CLIENTE);
			ps.setString(1,nif_cli);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				long n_id=rs.getLong(1);
				int n_piso=rs.getInt(2);
				java.sql.Date llegada=rs.getDate(3);
				java.sql.Date partida=rs.getDate(4);
				boolean pagado=rs.getBoolean(5);
				boolean cancelado=rs.getBoolean(6);		

				pedido.add(new Pedido(n_id,nif_cli,n_piso,
						llegada,partida,pagado,cancelado));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error buscando pedidos por cliente : " + t);
			}
		}
		return pedido;
	}
	
	@Override
	public double totalDia(Date fecha11, Date fecha12) { // Calcula total caja entre fechas (1 o mas dias)
		double totalCaja=0;
		java.sql.Date fecha1=this.cambiaFecha(fecha11);
		java.sql.Date fecha2=this.cambiaFecha(fecha12);

		try {
			PreparedStatement ps=con.prepareStatement(FIND_FACTURAS_POR_FECHAS);
			ps.setDate(1,fecha1);
			ps.setDate(2,fecha2);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				double importe=rs.getDouble(4);
				totalCaja += importe;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error calculando caja : " + t);
			}
		}
		return totalCaja;
	
	}
	
	@Override
	public Collection<Pedido> getPedidosPropietario(String nif_prop) { // Todos los pedidos por propietario
		Collection<Pedido> pedido = new ArrayList<Pedido>();

		try {
			PreparedStatement ps=con.prepareStatement(ALL_PEDIDOS_POR_PROPIETARIO);
			ps.setString(1,nif_prop);
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				long n_id=rs.getLong(1);
				String nif_cli=rs.getString(2);
				int n_piso=rs.getInt(3);
				java.sql.Date llegada=rs.getDate(4);
				java.sql.Date partida=rs.getDate(5);
				boolean pagado=rs.getBoolean(6);
				boolean cancelado=rs.getBoolean(7);		

				pedido.add(new Pedido(n_id,nif_cli,n_piso,
						llegada,partida,pagado,cancelado));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error buscando pedidos por propietario : " + t);
			}
		}
		return pedido;
	}
	@Override
	public boolean cajaCerrada(Date fecha) {
		boolean chek=false;
		java.sql.Date fecha1=this.cambiaFecha(fecha);
		
		try {
			PreparedStatement ps=con.prepareStatement(CIERRE_CAJA);
			ps.setDate(1,fecha1);
			
			ResultSet rs = ps.executeQuery();	
			while (rs.next()) {
				chek=true;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.err.println("Error buscando cierre caja : " + t);
			}
		}
		
		return chek;
	}
	
	// get y set aislamiento de la conexion para las transacciones
	public int getAislamientoCon(){
		int nivel = 0;
		try {
			nivel = con.getTransactionIsolation();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nivel;
	}
	public void setAislamientoCon(String n){
		int nivel = Integer.valueOf("Connection." + n);
		try {
			con.setTransactionIsolation(nivel);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void resetAislamientoCon(int n){
		int nivel = n;
		try {
			con.setTransactionIsolation(nivel);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void confirmaTransaccion() throws SQLException {
		con.commit();
	}
	public void anulaTransaccion() throws SQLException{
		con.rollback();
	}

}
