package gui;

import tablas.Piso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

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
public class PanelPisos extends javax.swing.JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel jlbNifPropietario;
	private JList jListPisos;
	private JSeparator jSeparator1;
	private JTextField jtfComision;
	private JLabel jlbComision;
	private JTextField jtfPrecio;
	private JLabel jlbPrecio;
	private JLabel jlbPiscina;
	private JTextField jtfLocalidad;
	private JLabel jlbLocalidad;
	private ButtonGroup bgPiscina;
	private JRadioButton jrbPiscinaNo;
	private JRadioButton jrbPiscinaSi;
	private JTextField jtfDireccion;
	private JLabel jlbDireccion;
	private JComboBox jcbNifPropietario;
	private JTextField jtfPiso;
	private JLabel jlbPiso;
	private JButton jbtNuevo;
	private JButton jbtModificar;
	private JButton jbtEliminar;
	private JButton jbtGrabar;
	private JButton jbtCancelar;
	private JButton jbtSalir;
	private JLabel jlbPisos;
	private Vector<Piso> lista;
	private JScrollPane jScrollPane;
	private Object[] model;
	Padre pare;
	
	
	public PanelPisos(javax.swing.JFrame frame) {
		super();
		pare = (Padre) frame;

        lista = new Vector<Piso>(Padre.getInm().getPisos());
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(700, 315));
			this.setLayout(null);
			{
				jlbPiso = new JLabel();
				this.add(jlbPiso);
				jlbPiso.setText("Num. Piso");
				jlbPiso.setBounds(31, 31, 76, 14);
			}
			{
				jtfPiso = new JTextField();
				this.add(jtfPiso);
				jtfPiso.setBounds(130, 30, 79, 21);
			}
			{
				jlbNifPropietario = new JLabel();
				this.add(jlbNifPropietario);
				jlbNifPropietario.setText("NIF Propietario");
				jlbNifPropietario.setBounds(243, 156, 98, 14);
			}
			{	
//				model = pare.getInm().getListObject(0);
//				jcbNifPropietario = new JComboBox(model);
//				this.add(jcbNifPropietario);
				
				jcbNifPropietario.setBounds(243, 170, 125, 21);
			}
			{
				jlbDireccion = new JLabel();
				this.add(jlbDireccion);
				jlbDireccion.setText("Direcci�n");
				jlbDireccion.setBounds(31, 70, 77, 14);
			}
			{
				jtfDireccion = new JTextField();
				this.add(jtfDireccion);
				jtfDireccion.setBounds(130, 67, 238, 39);
			}
			{
				jlbLocalidad = new JLabel();
				this.add(jlbLocalidad);
				jlbLocalidad.setText("Localidad");
				jlbLocalidad.setBounds(31, 126, 72, 14);
			}
			{
				jtfLocalidad = new JTextField();
				this.add(jtfLocalidad);
				jtfLocalidad.setBounds(130, 123, 237, 21);
			}
			{
				jlbPiscina = new JLabel();
				this.add(jlbPiscina);
				jlbPiscina.setText("Piscina");
				jlbPiscina.setBounds(31, 173, 53, 14);
			}
			{
				jlbPrecio = new JLabel();
				this.add(jlbPrecio);
				jlbPrecio.setText("Precio");
				jlbPrecio.setBounds(31, 210, 72, 14);
			}
			{
				jtfPrecio = new JTextField();
				this.add(jtfPrecio);
				jtfPrecio.setBounds(80, 207, 97, 21);
			}
			{
				jlbComision = new JLabel();
				this.add(jlbComision);
				jlbComision.setText("Comisi�n (%)\r\n");
				jlbComision.setBounds(196, 210, 98, 14);
			}
			{
				jtfComision = new JTextField();
				this.add(jtfComision);
				jtfComision.setBounds(291, 207, 77, 21);
			}
			{
				jlbPisos = new JLabel();
				this.add(jlbPisos);
				jlbPisos.setText("Pisos");
				jlbPisos.setBounds(405, 32, 116, 14);
			}

			
			// menu inferior
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
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
			{
				jrbPiscinaSi = new JRadioButton();
				this.add(jrbPiscinaSi);
				jrbPiscinaSi.setText("Si");
				jrbPiscinaSi.setBounds(96, 171, 43, 18);
			}
			{
				jrbPiscinaNo = new JRadioButton();				
				jrbPiscinaNo.setText("No");
				jrbPiscinaNo.setBounds(156, 171, 48, 18);
				this.add(jrbPiscinaNo);
				jrbPiscinaNo.setSelected(true);

			}
			{
				bgPiscina = new ButtonGroup();
				bgPiscina.add(jrbPiscinaSi);
				bgPiscina.add(jrbPiscinaNo);
			{
				jListPisos = new JList();
				this.add(jListPisos);
				jListPisos.setListData(lista);
				jListPisos.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent e) { }

					@Override
					public void mousePressed(MouseEvent e) { }

					@Override
					public void mouseExited(MouseEvent e) { }
					@Override
					public void mouseEntered(MouseEvent e) { }
					@Override
					public void mouseClicked(MouseEvent e) {
						jScrollPaneMouseClick();
					}
				});
			}
			{
				jScrollPane = new JScrollPane();
				this.add(jScrollPane);
				jScrollPane.setViewportView(jListPisos);
				jListPisos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				jScrollPane.setBounds(405, 52, 242, 176);
			}
		}

		desactivarCampos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// metodos
	private void jbtNuevoActionPerformed(ActionEvent evt) {
		limpiaCampos();
		jtfPiso.setEditable(false);
		jtfDireccion.setEditable(true);
		jtfLocalidad.setEditable(true);
		jrbPiscinaSi.setEnabled(true);	
		jrbPiscinaNo.setEnabled(true);
		jtfPrecio.setEditable(true);
		jtfComision.setEditable(true);
		jcbNifPropietario.setEnabled(true);
		
	}
	
	private void jbtSalirActionPerformed(ActionEvent evt) {
		pare.salirForm();		
	}
	
	private void limpiaCampos(){
		jtfPiso.setText(null);
		jtfDireccion.setText(null);
		jtfLocalidad.setText(null);
		jtfPrecio.setText(null);
		jtfComision.setText(null);	
	}
	
	private void jbtCancelarActionPerformed(ActionEvent evt) {	
		limpiaCampos();
		desactivarCampos();		
	}

	private void jbtGrabarActionPerformed(ActionEvent evt) {
		Piso p;
		if(comprobarCampos()) {
			p = rellenarPiso();
			if (jtfPiso.isEnabled()) {
				Padre.getInm().insertPiso(p);
			} else {
				Padre.getInm().updatePiso(p);
			}
		}
		limpiaCampos();
		actualizarScrollPane();
	}
	private void actualizarScrollPane() {
		lista = new Vector<Piso>(Padre.getInm().getPisos());
		jListPisos.setListData(lista);
	}
	private boolean comprobarCampos() {	
		// TODO Cal posar jtfPiso? es autoincrementable -.-
		System.out.println("Comprobando campos");
		if(jtfDireccion.getText().isEmpty() || jtfDireccion.getText() == " ")
			return false;
		if(jtfLocalidad.getText().isEmpty() || jtfLocalidad.getText() == " ")
			return false;
		if(jtfPrecio.getText().isEmpty() || jtfPrecio.getText() == " ")
			return false;
		if(jtfComision.getText().isEmpty() || jtfComision.getText() == " ")
			return false;	
		System.out.println("Campos Comprobados");
		return true;
	}
	private Piso rellenarPiso() {
		System.out.println("Rellenando Piso");
		Piso p = new Piso();
		System.out.println("Direccion: "+ jtfDireccion.getText());
		p.setDireccion(jtfDireccion.getText());
		p.setLocalizacion(jtfLocalidad.getText());
		p.setPrecio(Double.parseDouble(jtfPrecio.getText()));
		float comision = Float.parseFloat(jtfComision.getText());
		if(comision>100){
			JOptionPane.showMessageDialog(this, "La comision no puede exceder de 100%!", "Error campo comision", JOptionPane.ERROR_MESSAGE);
		} else{ 
			p.setComision(Float.parseFloat(jtfComision.getText()));
		}
		p.setNifProp(getNifCliente());
		p.setPiscina(jrbPiscinaSi.isSelected());
		return p;
	}
	
	private void jbtEliminarActionPerformed(ActionEvent evt) {
		System.out.println("jbtEliminar.actionPerformed, event="+evt);
		//TODO add your code for jbtEliminar.actionPerformed
	}
	protected void jScrollPaneMouseClick() {
		/*
		 * Comprovamos que tengamos un elemento seleccionado
		 * si es asi cojemos el cliente seleccionado y lo
		 * mostramos
		 */		
	    Piso p;
	    if(jListPisos.getSelectedIndex()>=0) {
	    	p = lista.get(jListPisos.getSelectedIndex());
	    	mostrarPiso(p);
	    }	    
    }
	
	private void mostrarPiso(Piso p) {
		
		jtfPiso.setText(p.getNumero()+"");
		jtfDireccion.setText(p.getDireccion());
		jtfLocalidad.setText(p.getLocalizacion());
		if(p.isPiscina()){
			jrbPiscinaSi.setSelected(true);
		} else {
			jrbPiscinaNo.setSelected(true);
		}
		jtfPrecio.setText(p.getPrecio()+"");
		jtfComision.setText(p.getComision()+"");
		System.out.println(p.getNifProp());
		int i = compararCliNif(p);		
		if (i > 0) {
			jcbNifPropietario.setForeground(java.awt.Color.black);
			jcbNifPropietario.setSelectedIndex(i);
		}
		
	}

	private void desactivarCampos(){
		limpiaCampos();
		jtfPiso.setEditable(false);
		jtfDireccion.setEditable(false);
		jtfLocalidad.setEditable(false);
		jrbPiscinaSi.setEnabled(false);	
		jrbPiscinaNo.setEnabled(false);
		jtfPrecio.setEditable(false);
		jtfComision.setEditable(false);	
		jcbNifPropietario.setEnabled(false);
		jcbNifPropietario.setSelectedIndex(0);
	}
	
	private void jbtModificarActionPerformed(ActionEvent evt) {
		
		jtfPiso.setEditable(false);
		jtfDireccion.setEditable(true);
		jtfLocalidad.setEditable(true);
		jrbPiscinaSi.setEnabled(true);	
		jrbPiscinaNo.setEnabled(true);
		jtfPrecio.setEditable(true);
		jtfComision.setEditable(true);
		jcbNifPropietario.setEnabled(true);		
	}
	private String getNifCliente() {
		/*
		 * Cogemos el primer campo del toString
		 */
		String[] s = jcbNifPropietario.getSelectedItem().toString().split("\\s");
		return s[0];
	}
	private int compararCliNif(Piso p) {
		int item = 0;
		int i = 0;
		String nif = p.getNifProp();
		
		for(Object o: model) {			
			if(o != null && o.toString().length()>0 ) {
				if(p.getNifProp().equals(o.toString().split("\\s")[0])) {
					item = i;
					System.out.println("valor i = "+ i);
					break;
				}
			}
			i++;			
			System.out.println(i);
		}
		return item;
	}
}
