package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import tablas.Cliente;
import tablas.Pedido;
import tablas.Piso;

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
public class PanelReservaPiso extends javax.swing.JPanel {
	private JLabel jlbCliente;
	private JSeparator jSeparator1;
	private JButton jbtSalir;
	private JButton jbReservar;
	private JSeparator jSeparator2;
	private JTextField jtfSalida;
	private JTextField jtfEntrada;
	private JButton jbDisponibilidad;
	private JLabel jlbSalida;
	private JLabel jlbEntrada;
	private JLabel jlbPisos;
	private JList jList1;
	private JSeparator jSeparator5;
	private JButton jbCancelar;
	private JButton jbPagar;
	private JSeparator jSeparator4;
	private JLabel jlbMantenimiento;
	private JSeparator jSeparator3;
	private JLabel jlbReserva;
	private Vector<Piso> listaPisos;
	private Vector<Cliente> listaClientes;
	private Vector<Pedido> listaPedidos;
	private JComboBox jcbNifCliente;
	private JScrollPane jScrollPane;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	
	
	public PanelReservaPiso() {
		super();
		listaClientes = new Vector<Cliente>(Padre.getInm().getClientes());
		listaPisos = new Vector<Piso>();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(700, 315));
			this.setLayout(null);
			{
				jlbCliente = new JLabel();
				this.add(jlbCliente);
				jlbCliente.setText("Cliente");
				jlbCliente.setBounds(353, 25, 97, 19);
			}
			{
				ComboBoxModel jcbNifClienteModel = new DefaultComboBoxModel(listaClientes.toArray());
				jcbNifCliente = new JComboBox();
				this.add(jcbNifCliente);
				jcbNifCliente.setModel(jcbNifClienteModel);
				jcbNifCliente.setBounds(401, 24, 262, 21);
				jcbNifCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jcbNifClienteActionPerformed(evt);
					}
				});
			}
			{
				jlbPisos = new JLabel();
				this.add(jlbPisos);
				jlbPisos.setText("Pisos");
				jlbPisos.setBounds(353, 57, 97, 19);
			}
			{
				jlbEntrada = new JLabel();
				this.add(jlbEntrada);
				jlbEntrada.setText("Entrada");
				jlbEntrada.setBounds(32, 74, 79, 14);
			}
			{
				jlbSalida = new JLabel();
				this.add(jlbSalida);
				jlbSalida.setText("Salida");
				jlbSalida.setBounds(180, 72, 62, 19);
			}
			{
				jbDisponibilidad = new JButton();
				this.add(jbDisponibilidad);
				jbDisponibilidad.setText("Comprobar disponibilidad");
				jbDisponibilidad.setBounds(31, 118, 176, 21);
			}
			{
				jScrollPane = new JScrollPane();
				this.add(jScrollPane);
				jScrollPane.setViewportView(jList1);
				jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				jScrollPane.setBounds(353, 78, 311, 150);				
			}
			{				
				jList1 = new JList();
				this.add(jList1);
				jList1.setListData(listaPisos);
				jList1.setBounds(353, 78, 311, 150);
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
						//jScrollPaneMouseClick();
						
					}
				});
			}
			// menu inferior
			{
				jSeparator1 = new JSeparator();
				this.add(jSeparator1);
				jSeparator1.setBounds(31, 242, 634, 15);
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
				jtfEntrada = new JTextField();
				this.add(jtfEntrada);
				jtfEntrada.setBounds(79, 71, 90, 21);
			}
			{
				jtfSalida = new JTextField();
				this.add(jtfSalida);
				jtfSalida.setBounds(220, 71, 90, 21);
			}
			{
				jSeparator2 = new JSeparator();
				this.add(jSeparator2);
				jSeparator2.setBounds(32, 45, 297, 15);
			}
			{
				jlbReserva = new JLabel();
				this.add(jlbReserva);
				jlbReserva.setText("Reserva");
				jlbReserva.setBounds(31, 28, 79, 14);
			}
			{
				jSeparator3 = new JSeparator();
				this.add(jSeparator3);
				jSeparator3.setBounds(32, 45, 297, 15);
			}
			{
				jlbMantenimiento = new JLabel();
				this.add(jlbMantenimiento);
				jlbMantenimiento.setText("Mantenimiento");
				jlbMantenimiento.setBounds(32, 166, 70, 14);
			}
			{
				jSeparator4 = new JSeparator();
				this.add(jSeparator4);
				jSeparator4.setBounds(31, 45, 297, 15);
			}
			{
				jbPagar = new JButton();
				this.add(jbPagar);
				jbPagar.setText("Pagar");
				jbPagar.setBounds(31, 201, 140, 21);
			}
			{
				jbCancelar = new JButton();
				this.add(jbCancelar);
				jbCancelar.setText("Cancelar");
				jbCancelar.setBounds(189, 201, 140, 21);
			}
			{
				jSeparator5 = new JSeparator();
				this.add(jSeparator5);
				jSeparator5.setBounds(31, 184, 297, 15);
			}
			{
				jbReservar = new JButton();
				this.add(jbReservar);
				jbReservar.setText("Reservar");
				jbReservar.setBounds(226, 118, 103, 21);
			}
			desactivarCampos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	// metodos
	
		
	private void desactivarCampos(){

	}
	
	
	
	private void jbtSalirActionPerformed(ActionEvent evt) {
		System.out.println("jbtSalir.actionPerformed, event="+evt);
		//TODO add your code for jbtSalir.actionPerformed
	}
	
	private void jcbNifClienteActionPerformed(ActionEvent evt) {
		Cliente c;
		c=(Cliente) jcbNifCliente.getSelectedItem();
		listaPedidos=new Vector<Pedido>(Padre.getInm().getPedidosPendientesCliente(c));
		jList1.setListData(listaPedidos);
		
		
	}

}
