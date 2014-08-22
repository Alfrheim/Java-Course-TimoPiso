package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

import tablas.Caja;
import tablas.Cliente;
import tablas.Pedido;
import tablas.Piso;
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
public class PanelPagarPropietario extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel jlbPropietario;
	private JSeparator jSeparator1;
	private JButton jbtSalir;
	private JLabel jlbPisos;
	private JList jList1;
	private JComboBox jcbNifPropietario;
	private JScrollPane jScrollPane;
	private JLabel jlbMantenimiento;
	private JSeparator jSeparator2;
	private JButton jbPagar;
	private Padre padre;
	private Vector<Propietario> listaPropietarios;
	private Propietario prop;
	private Vector<Caja> listaRegistros;
	private Collection<Caja> listaRegistrosAPagar;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public PanelPagarPropietario() {
		super();
		listaPropietarios = new Vector<Propietario>(Padre.getInm().getPropietarios());
		listaRegistros = new Vector<Caja>();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(700, 315));
			this.setLayout(null);
			{
				jlbPropietario = new JLabel();
				this.add(jlbPropietario);
				jlbPropietario.setText("Propietario");
				jlbPropietario.setBounds(31, 32, 97, 19);
			}
			{
				ComboBoxModel jcbNifPropietarioModel = new DefaultComboBoxModel(listaPropietarios.toArray());
				jcbNifPropietario = new JComboBox();
				this.add(jcbNifPropietario);
				jcbNifPropietario.setModel(jcbNifPropietarioModel);
				jcbNifPropietario.setBounds(31, 54, 250, 21);
				jcbNifPropietario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jcbNifPropietarioActionPerformed(evt);
					}
				});
			}
			{
				jlbPisos = new JLabel();
				this.add(jlbPisos);
				jlbPisos.setText("Pisos");
				jlbPisos.setBounds(353, 32, 97, 19);
			}
			{
				jSeparator2 = new JSeparator();
				this.add(jSeparator2);
				jSeparator2.setBounds(31, 187, 293, 15);
			}
			{
				jlbMantenimiento = new JLabel();
				this.add(jlbMantenimiento);
				jlbMantenimiento.setText("Mantenimiento");
				jlbMantenimiento.setBounds(31, 169, 293, 15);
			}
			{
				jbPagar = new JButton();
				this.add(jbPagar);
				jbPagar.setText("Pagar");
				jbPagar.setBounds(31, 204, 140, 21);
				jbPagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbPagarActionPerformed(evt);
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
				jList1 = new JList();
				this.add(jList1);
				jList1.setListData(listaRegistros);
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
				jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				jScrollPane.setBounds(353, 54, 311, 174);				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	// metodos
	
	private void jcbNifPropietarioActionPerformed(ActionEvent evt) {
		prop = cargarPropietario();
		refrescarLista(prop);
		//listaRegistros = new Vector<Caja>(Padre.getInm().getPedidosPendientesPropietario(prop));
		//System.out.println(listaRegistros);
		//jList1.setListData(listaRegistros);
	}

	protected void jScrollPaneMouseClick() {	
	    if(jList1.getSelectedIndex()>0) {
	    	listaRegistrosAPagar = objectToCollection(jList1.getSelectedValues());
	    	//listaRegistrosAPagar = (ArrayList<Caja>) Arrays.asList((Caja[]) jList1.getSelectedValues());
	    }
    }
	private Collection<Caja> objectToCollection(Object [] obj){
		Collection<Caja> c = new ArrayList<Caja>();
		for (Object o:obj)
			c.add((Caja) o);
		return c;
	}
	private Propietario cargarPropietario() {
		return (Propietario) jcbNifPropietario.getSelectedItem();
	}
	private void refrescarLista(Propietario p) {
		listaRegistros = new Vector<Caja>(Padre.getInm().getPedidosPendientesPropietario(p));
		jList1.setListData(listaRegistros);
	}
	
	private void jbPagarActionPerformed(ActionEvent evt){
		jScrollPaneMouseClick();
		Padre.getInm().pagarPropietario(cargarPropietario(),listaRegistrosAPagar);
		refrescarLista(cargarPropietario());
	}
	
	private void jbtSalirActionPerformed(ActionEvent evt) {
		padre.salirForm();
	}
}
