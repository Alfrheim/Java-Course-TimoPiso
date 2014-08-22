package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;


import tablas.Cliente;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class PanelClientes extends javax.swing.JPanel {
	private JList jList1;
	private JButton jbtSalir;
	private JButton jbtCancelar;
	private JButton jbtGrabar;
	private JButton jbtEliminar;
	private JButton jbtModificar;
	private JButton jbtNuevo;
	private JSeparator jSeparator1;
	private JLabel jlbNif;
	private JLabel jlbNombre;
	private JLabel jlbApellidos;
	private JTextField jtfNif;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JScrollPane jScrollPane;
	
	private JTextField[] jtfArray; 
	private Padre padre;
	private Vector<Cliente> lista;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/	
	
	public PanelClientes(javax.swing.JFrame frame) {
		super();
		this.padre = (Padre) frame;		
		
		lista = new Vector<Cliente>(Padre.getInm().getClientes());		
		System.out.println(lista);
		
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(700, 315));
			this.setLayout(null);
			this.setSize(700, 315);
			/*
			 * Añadimos evento de mouse a la lista
			 */
			{				
				jList1 = new JList();
				this.add(jList1);				
				jList1.setListData(lista);
				jList1.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						jScrollPaneMouseClick();
						
					}
				});
			}
			{
				jScrollPane = new JScrollPane();
				this.add(jScrollPane);
				jScrollPane.setViewportView(jList1);
				jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				jScrollPane.setBounds(352, 32, 297, 131);				
			}
			
			{
				jtfApellidos = new JTextField();
				this.add(jtfApellidos);
				jtfApellidos.setText(null);
				jtfApellidos.setEditable(false);
				jtfApellidos.setBounds(90, 92, 172, 21);
			}
			{
				jtfNombre = new JTextField();
				this.add(jtfNombre);
				jtfNombre.setText(null);
				jtfNombre.setEditable(false);
				jtfNombre.setBounds(90, 62, 172, 21);
			}
			{
				jtfNif = new JTextField();
				this.add(jtfNif);
				jtfNif.setText(null);
				jtfNif.setEditable(false);
				jtfNif.setBounds(90, 32, 172, 21);
			}
			{
				jlbApellidos = new JLabel();
				this.add(jlbApellidos);
				jlbApellidos.setText("Apellidos");
				jlbApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
				jlbApellidos.setBounds(30, 92, 42, 14);
			}
			{
				jlbNombre = new JLabel();
				this.add(jlbNombre);
				jlbNombre.setText("Nombre");
				jlbNombre.setHorizontalAlignment(SwingConstants.RIGHT);
				jlbNombre.setBounds(30, 62, 42, 14);
			}
			{
				jlbNif = new JLabel();
				this.add(jlbNif);
				jlbNif.setText("NIF");
				jlbNif.setHorizontalAlignment(SwingConstants.RIGHT);
				jlbNif.setBounds(30, 32, 42, 14);
			}
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setAutoscrolls(true);
				jSeparator1.setBounds(31, 242, 634, 15);
			}
			{
				jbtNuevo = new JButton();
				this.add(jbtNuevo);
				jbtNuevo.setText("Nuevo");
				jbtNuevo.setMnemonic(java.awt.event.KeyEvent.VK_N);
				jbtNuevo.setBounds(31, 252, 98, 40);
				jbtNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtNuevoActionPerformed(evt);
					}
				});
			}
			{
				jbtModificar = new JButton();
				this.add(jbtModificar);
				jbtModificar.setText("Modificar");
				jbtModificar.setMnemonic(java.awt.event.KeyEvent.VK_M);
				jbtModificar.setBounds(134, 252, 98, 40);
				jbtModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtModificarActionPerformed(evt);
					}
				});
			}
			{
				jbtEliminar = new JButton();
				this.add(jbtEliminar);
				jbtEliminar.setText("Eliminar");
				jbtEliminar.setMnemonic(java.awt.event.KeyEvent.VK_E);
				jbtEliminar.setBounds(237, 252, 98, 40);
				jbtEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtEliminarActionPerformed(evt);
					}
				});
			}
			{
				jbtGrabar = new JButton();
				this.add(jbtGrabar);
				jbtGrabar.setText("Grabar");
				jbtGrabar.setMnemonic(java.awt.event.KeyEvent.VK_G);
				jbtGrabar.setBounds(340, 252, 98, 40);
				jbtGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtGrabarActionPerformed(evt);
					}
				});
			}
			{
				jbtCancelar = new JButton();
				this.add(jbtCancelar);
				jbtCancelar.setText("Cancelar");
				jbtCancelar.setMnemonic(java.awt.event.KeyEvent.VK_C);
				jbtCancelar.setBounds(443, 252, 98, 40);
				jbtCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtCancelarActionPerformed(evt);
					}
				});
			}
			{
				jbtSalir = new JButton();
				this.add(jbtSalir);
				jbtSalir.setText("Salir");
				jbtSalir.setMnemonic(java.awt.event.KeyEvent.VK_S);
				jbtSalir.setBounds(568, 252, 98, 40);
				jbtSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtSalirActionPerformed(evt);
					}
				});
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	protected void jScrollPaneMouseClick() {
		/*
		 * Comprovamos que tengamos un elemento seleccionado
		 * si es asi cojemos el cliente seleccionado y lo
		 * mostramos
		 */		
	    Cliente c;
	    if(jList1.getSelectedIndex()>=0) {
	    	c = lista.get(jList1.getSelectedIndex());
	    	mostrarCliente(c);
	    }
	    
    }

	public void limpiaPantalla (){ // limpia la pantalla de los datos anteriores
		jtfNif.setText(null);
		jtfNombre.setText(null);
		jtfApellidos.setText(null);		
	}
	
	public void mostrarCliente(Cliente c) {
		/*
		 * Rellena los JTextField con el cliente seleccionado.
		 */
		jtfNif.setText(c.getNifCli());
		jtfNombre.setText(c.getNombre());
		jtfApellidos.setText(c.getApellidos());
	}
	private void jbtNuevoActionPerformed(ActionEvent evt) {
		/*
		 * Permite poder escribir en los jtextFields
		 * haciendolos editables.
		 */
		limpiaPantalla();
		jtfNif.setEditable(true);
		jtfApellidos.setEditable(true);
		jtfNombre.setEditable(true);
	}
	
	private void jbtSalirActionPerformed(ActionEvent evt) {
		padre.salirForm();
	}
	
	private void jbtCancelarActionPerformed(ActionEvent evt) {		
		limpiaPantalla();
		jtfNif.setEditable(false);
		jtfApellidos.setEditable(false);
		jtfNombre.setEditable(false);
	}
	
	private void jbtGrabarActionPerformed(ActionEvent evt) {
		/*
		 * Graba la accion. Mira si hay que modificar o insertar
		 * Si ja existeix, pregunta si el vol modificar.
		 */
		if(comprobarCampos()){ 
			boolean modificar = true;
			Cliente c = getCliente();
			if(jtfNif.isEditable()){
				try {
					Padre.getInm().insertCliente(c);
				} catch (Exception e) {
					// TODO: La tratamos?
				}

			} else {
				if(modificar){
					try {
						Padre.getInm().updateCliente(c);
					} catch (Exception e) {
						// TODO: La Tratamos?
					}
				}
			}
		}
		jbtCancelarActionPerformed(evt);
		refrescarLista();
	}
	
	private void jbtEliminarActionPerformed(ActionEvent evt) {
		/*
		 * Borra un cliente de la lista de clientes activos 
		 */
		//TODO Modificar para que no lo borre de la BD, simplemente
		// modifique un campo para que no aparezca como activo
		Cliente c;
		if(jList1.getSelectedIndex()>= 0) {
			c = lista.get(jList1.getSelectedIndex());
			try{
				Padre.getInm().deleteCliente(c.getNifCli());
			} catch (Exception e) {
				// TODO: handle exception
			}
			refrescarLista();		
		}
		
	}
	
	private void jbtModificarActionPerformed(ActionEvent evt) {
		/*
		 * Permite modificar, dejando editar los campos 
		 * Apellidos y Nombre Siempre y cuando un elemento
		 * de la lista este seleccionado
		 */
		if(jList1.getSelectedIndex()>=0) {
			jtfApellidos.setEditable(true);
			jtfNombre.setEditable(true);
		} else {
			JOptionPane.showMessageDialog(this, "Tienes que seleccionar antes un cliente!", "A quién quieres modificar?", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private void refrescarLista() {
		/*
		 * Refresca la lista
		 */
		lista = new Vector<Cliente>(Padre.getInm().getClientes());
		jList1.setListData(lista);		
	}
	
	private boolean comprobarCampos(){
		/*
		 * Comprueba que los campos no esten vacios, de ser asi
		 * devuelve false y salta un MessageDialog adriviertiendo de los campos
		 * incorrectos
		 */
		String campos = "";
		boolean validos = true;
		if(jtfNif.getText().isEmpty() || jtfNif.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Nif, ";
		} if(jtfNombre.getText().isEmpty() || jtfNombre.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Nombre, ";
		} if(jtfApellidos.getText().isEmpty() || jtfApellidos.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Apellidos, ";
		}
		if(!validos) {
			JOptionPane.showMessageDialog(this, "Tienes que rellenar: "+campos, "Error campos vacios", JOptionPane.WARNING_MESSAGE);
		}
		
//		
//		for(int i=0; i<jtfArray.length; i++) {
//			if(jtfArray[i].getText().compareTo("")== 0) {
//				validos = false;
//			}
//		}
				
//		for(JTextField i:jtfArray){
//			System.out.println(i.getName());
//			if(i.getText().compareTo("") == 0) {
//				validos = false;
//			}
//		}
		return validos;
	}
	
	private Cliente getCliente(){
		/*
		 * Crea un objeto cliente con los campos
		 */
		
		Cliente c;
		String nif = jtfNif.getText();
		String nombre = jtfNombre.getText();
		String apellidos = jtfApellidos.getText();
		c = new Cliente(nif, nombre, apellidos);
		return c;
	}

}
