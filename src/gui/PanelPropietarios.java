package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import logicaNegocio.excepciones.PropietarioYaExisteException;

import tablas.Propietario;


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
public class PanelPropietarios extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfDireccion;
	private JList jList1;
	private JLabel jlbPropietarios;
	private JLabel jlbPisos;
	private JList jList2;
	private JScrollBar jScrollBar2;
	private JScrollBar jScrollBar1;
	private JLabel jlbApellidos;
	private JSeparator jSeparator1;
	private JTextField jtfTitulo;
	private JLabel jlbNif;
	private JLabel jlbNombre;
	private JButton jbtModificar;
	private JButton jbtNuevo;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JButton jbtEliminar;
	private JButton jbtGrabar;
	private JButton jbtCancelar;
	private JButton jbtSalir;
	private JLabel jlbDireccion;
	private JLabel jlbLocalidad;
	private JTextField jtfLocalidad;
	private JScrollPane jScrollPane;

	private Vector<Propietario> lista;
	private Padre padre;


	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */


	public PanelPropietarios(javax.swing.JFrame frame)  {
		super();
		this.padre = (Padre) frame;	
		lista = new Vector<Propietario>(Padre.getInm().getPropietarios());		
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(700, 315));
			this.setLayout(null);
			this.setSize(700, 315);
			{
				jtfLocalidad = new JTextField();
				this.add(jtfLocalidad);
				jtfLocalidad.setBounds(117, 199, 231, 20);
				jtfLocalidad.setEditable(false);
			}
			{
				jtfDireccion = new JTextField();
				this.add(jtfDireccion);
				jtfDireccion.setBounds(118, 119, 230, 62);
				jtfDireccion.setEditable(false);
			}
			{
				jlbLocalidad = new JLabel();
				this.add(jlbLocalidad);
				jlbLocalidad.setText("Localidad");
				jlbLocalidad.setBounds(20, 202, 85, 14);
				jlbLocalidad.setAutoscrolls(true);
				jlbLocalidad.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jlbDireccion = new JLabel();
				this.add(jlbDireccion);
				jlbDireccion.setText("Direccion");
				jlbDireccion.setBounds(20, 143, 85, 14);
				jlbDireccion.setAutoscrolls(true);
				jlbDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
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
				jtfApellidos = new JTextField();
				this.add(jtfApellidos);
				jtfApellidos.setBounds(117, 86, 231, 21);
				jtfApellidos.setEditable(false);
			}
			{
				jtfNombre = new JTextField();
				this.add(jtfNombre);
				jtfNombre.setBounds(117, 59, 231, 21);
				jtfNombre.setEditable(false);
			}
			{
				jtfTitulo = new JTextField();
				this.add(jtfTitulo);
				jtfTitulo.setBounds(117, 29, 144, 21);
				jtfTitulo.setEditable(false);
			}
			{
				jlbNombre = new JLabel();
				this.add(jlbNombre);
				jlbNombre.setText("Nombre");
				jlbNombre.setBounds(20, 63, 85, 14);
				jlbNombre.setAutoscrolls(true);
				jlbNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jlbNif = new JLabel();
				this.add(jlbNif);
				jlbNif.setText("NIF");
				jlbNif.setBounds(20, 33, 85, 14);
				jlbNif.setAutoscrolls(true);
				jlbNif.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(31, 242, 634, 15);
				jSeparator1.setAutoscrolls(true);
			}
			{
				jlbApellidos = new JLabel();
				this.add(jlbApellidos);
				jlbApellidos.setText("Apellidos");
				jlbApellidos.setBounds(20, 90, 85, 14);
				jlbApellidos.setAutoscrolls(true);
				jlbApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
			}
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
						System.out.println("Click en la lista");
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

				jScrollBar1 = new JScrollBar();
				this.add(jScrollBar1);
				jScrollBar1.setBounds(652, 34, 13, 78);
			}
			{
				jScrollBar2 = new JScrollBar();
				this.add(jScrollBar2);
				jScrollBar2.setBounds(652, 144, 13, 78);
			}
			{
				ListModel jList2Model = 
					new DefaultComboBoxModel();
				jList2 = new JList();
				//this.add(jList2);
				jList2.setModel(jList2Model);
				jList2.setBounds(383, 144, 269, 78);
			}
			{
				jlbPisos = new JLabel();
				this.add(jlbPisos);
				jlbPisos.setText("Pisos del Propietario");
				jlbPisos.setBounds(383, 124, 166, 14);
			}
			{
				jlbPropietarios = new JLabel();
				this.add(jlbPropietarios);
				jlbPropietarios.setText("Propietarios");
				jlbPropietarios.setBounds(383, 15, 142, 14);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbtNuevoActionPerformed(ActionEvent evt) {
		this.limpiaPantalla();
		jtfTitulo.setEditable(true);
		jtfApellidos.setEditable(true);
		jtfNombre.setEditable(true);
		jtfDireccion.setEditable(true);
		jtfLocalidad.setEditable(true);			
	}

	private void jbtSalirActionPerformed(ActionEvent evt) {
		//padre.salirForm();

	}

	private void jbtCancelarActionPerformed(ActionEvent evt) {
		this.limpiaPantalla();
		jtfTitulo.setEditable(false);
		jtfApellidos.setEditable(false);
		jtfNombre.setEditable(false);
		jtfDireccion.setEditable(false);
		jtfLocalidad.setEditable(false);
	}

	private void jbtGrabarActionPerformed(ActionEvent evt) {
		if(comprobarCampos()){ 
			boolean modificar = true;
			Propietario p = getPropietario();
			if(jtfTitulo.isEditable()){
				try {
					Padre.getInm().insertPropietario(p);
				} catch (Exception e) {
					// TODO: La tratamos?
				}

			} else {
				if(modificar){
					try {
						Padre.getInm().updatePropietario(p);
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
		
		Propietario p;
		if(jList1.getSelectedIndex()>= 0) {
			p = lista.get(jList1.getSelectedIndex());
			try{
				Padre.getInm().deletePropietario(p.getNifProp());
			} catch (Exception e) {
				// TODO: handle exception
			}
			refrescarLista();		
		}

	}

	private void jbtModificarActionPerformed(ActionEvent evt) {
		if(jList1.getSelectedIndex()>=0) {
			jtfApellidos.setEditable(true);
			jtfNombre.setEditable(true);
			jtfDireccion.setEditable(true);
			jtfLocalidad.setEditable(true);
		} else {
			JOptionPane.showMessageDialog(this, "Tienes que seleccionar antes un propietario de la lista.", "A quien quieres modificar?", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	protected void jScrollPaneMouseClick() {
		Propietario p;
		if(jList1.getSelectedIndex()>=0) {
			p = lista.get(jList1.getSelectedIndex());
			mostrarPropietario(p);
		}

	}

	public void limpiaPantalla (){ // limpia la pantalla de los datos anteriores
		jtfTitulo.setText(null);
		jtfNombre.setText(null);
		jtfApellidos.setText(null);
		jtfDireccion.setText(null);
		jtfLocalidad.setText(null);	
	}

	public void mostrarPropietario(Propietario p) {
		jtfTitulo.setText(p.getNifProp());
		jtfNombre.setText(p.getNombre());
		jtfApellidos.setText(p.getApellidos());
		jtfDireccion.setText(p.getDireccion());
		jtfLocalidad.setText(p.getLocalizacion());
	}

	private Propietario getPropietario(){
		Propietario p;
		String nif = jtfTitulo.getText();
		String nombre = jtfNombre.getText();
		String apellidos = jtfApellidos.getText();
		String direccion = jtfDireccion.getText();
		String localidad = jtfLocalidad.getText();
		p = new Propietario(nif, nombre, apellidos,direccion,localidad);
		return p;
	}

	private void refrescarLista() {
		lista = new Vector<Propietario>(Padre.getInm().getPropietarios());
		jList1.setListData(lista);		
	}
	
	private boolean comprobarCampos(){
		
		String campos = "";
		boolean validos = true;
		if(jtfTitulo.getText().isEmpty() || jtfTitulo.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Nif, ";
		} if(jtfNombre.getText().isEmpty() || jtfNombre.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Nombre, ";
		} if(jtfApellidos.getText().isEmpty() || jtfApellidos.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Apellidos, ";
		} if(jtfDireccion.getText().isEmpty() || jtfDireccion.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Direccion, ";
		} if(jtfLocalidad.getText().isEmpty() || jtfLocalidad.getText().compareTo(" ")==0) {
			validos = false;
			campos += "Localidad, ";
		}
		if(!validos) {
			JOptionPane.showMessageDialog(this, "Tienes que rellenar: "+campos, "Error campos vacios", JOptionPane.WARNING_MESSAGE);
		}
		
		return validos;
	}


}
