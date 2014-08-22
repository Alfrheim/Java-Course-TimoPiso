package dao;

import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import tablas.Caja;
import tablas.Cliente;
import tablas.Pedido;
import tablas.Piso;
import tablas.Propietario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import logicaNegocio.excepciones.ClienteYaExisteException;
import logicaNegocio.excepciones.PisoYaExisteException;
import logicaNegocio.excepciones.PropietarioYaExisteException;

public class TestDao {


public static void main(String[] args)  {
		
		DaoInmobiliaria inmobiliaria = new DaoInmobiliariaImpl();

		// operaciones CRUD mas listas clientes, propietarios y pisos
		System.out.println("inserto cliente, propietario y piso...");
		Cliente miCliente = new Cliente("1", "Juan", "Garcia");
		Propietario miPropietario = new Propietario("9657892-H", "Olivia", "Red", "Via Roma,4", "Pisa");
		Piso miPiso = new Piso("Via Bologna, 7", "Roma", true, miPropietario.getNifProp(), 50.20, 10.00f);

		Cliente miCliente1 = new Cliente("15745945-G", "Collete", "Green");
		Propietario miPropietario1 = new Propietario("7489892-Y", "Linux", "Blue", "Via Fabiola,4", "Milano");
		Piso miPiso1 = new Piso("Via Rosa, 10", "Rimini", true, miPropietario1.getNifProp(), 30.20, 5.00f);
		Piso miPiso2 = new Piso("Via Tunisi, 15", "Torino", false, miPropietario1.getNifProp(), 35.20, 12.00f);
		try{
			System.out.println(inmobiliaria.insertCliente(miCliente1));
			System.out.println(inmobiliaria.insertPropietario(miPropietario));
			System.out.println(inmobiliaria.insertPiso(miPiso));
		} catch (Exception e) {
			System.out.println("no se ha podido insertar nada :S ");
		}
		System.out.println("leo...");
		System.out.println(inmobiliaria.getCliente("15968745-G"));
		System.out.println(inmobiliaria.getPropietario("9657892-H"));
		System.out.println(inmobiliaria.getPiso(1));

		System.out.println("actualizo...");
		miCliente.setNombre("Paco");
		miPropietario.setApellidos("Perez");
		miPiso.setLocalizacion("Napoli");
		inmobiliaria.updateCliente(miCliente);
		inmobiliaria.updatePropietario(miPropietario);
		inmobiliaria.updatePiso(miPiso);
		System.out.println(miCliente);
		System.out.println(miPropietario);
		System.out.println(miPiso);

		System.out.println("recupero listas...");
		Collection<Cliente> misClientes = inmobiliaria.getClientes();
		for (Cliente c:misClientes)
			System.out.println(c);
		Collection<Propietario> misPropietarios = inmobiliaria.getPropietarios();
		for (Propietario p:misPropietarios)
			System.out.println(p);
		Collection<Piso> misPisos = inmobiliaria.getPisos();
		for (Piso p:misPisos)
			System.out.println(p);

		System.out.println("recupero pisos propietario" + miPropietario1);
		Collection<Piso> misPisosProp = inmobiliaria.getPisosPropietario(miPropietario1.getNifProp());
		for (Piso p:misPisosProp)
			System.out.println(p);

		System.out.println("borro...");
		System.out.println(inmobiliaria.deleteCliente(miCliente.getNifCli()));
		System.out.println("Numero piso a borrar: "+ miPiso.getNumero());
		System.out.println(inmobiliaria.deletePiso(miPiso.getNumero()));
		System.out.println(inmobiliaria.deletePropietario(miPropietario.getNifProp()));

		System.out.println("recupero listas...");
		Collection<Cliente> misClientes1 = inmobiliaria.getClientes();
		for (Cliente c:misClientes1)
			System.out.println(c);
		Collection<Propietario> misPropietarios1 = inmobiliaria.getPropietarios();
		for (Propietario p:misPropietarios1)
			System.out.println(p);
		Collection<Piso> misPisos1 = inmobiliaria.getPisos();
		for (Piso p:misPisos1)
			System.out.println(p);
	
		// operaciones CRUD y listas caja y pedido
        
		// operaciones CRUD y listas caja y pedido
		System.out.println("Entro en main");
	
		
		
		Calendar data = Calendar.getInstance();
		data.set(2010,01,01);
		Calendar data2 = Calendar.getInstance();
		data2.set(2010,12,01);
		
		System.out.println(data.getTime());
		System.out.println(data2.getTime());
		
		Pedido miPedido = new Pedido("1",28,data.getTime(),data2.getTime(),true, false);
	      
	      
	      Caja miCaja = new Caja('A',34, 1200.00, false,
	                            data.getTime());
	     
	     inmobiliaria.insertPedido(miPedido);
	     System.out.println("Inserto pedido");
	     
	     inmobiliaria.getPedido(1);
	     miPedido.setCancelado(true);
	     inmobiliaria.updatePedido(miPedido);
	     System.out.println("Modifico pedido");
	     Collection<Pedido> misPedidos = inmobiliaria.getPedidos();
			for (Pedido p:misPedidos)
				System.out.println(p);
	     //Collection<Piso> misPisosDisp = inmobiliaria.getPisosDisponibles(data.getTime(), data2.getTime());
		//	for (Piso p:misPisosDisp)
		//		System.out.println(p);
			 System.out.println("Comienzan facturas");
			int factura = inmobiliaria.insertFactura(miCaja);
			 System.out.println("Factura "+factura);
			miCaja=inmobiliaria.getFactura(factura);
			System.out.println(miCaja.toString());
			Collection<Caja> misCajas = inmobiliaria.getFacturas();
			for (Caja c:misCajas)
				System.out.println(c);
			
        
	}

}
