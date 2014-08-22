package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import dao.AbstractDao;

import tablas.Cliente;

import logicaNegocio.implementacion.InmobiliariaUtilidades;
import logicaNegocio.implementacion.ServiciosInmobiliaria;


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
public class Padre extends javax.swing.JFrame {

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JPanel tabPropietarios;
	private JPanel tabPagarPropietario;
	private JPanel tabReservarPiso;
	private JPanel jPanelPisos;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private static InmobiliariaUtilidades dao;
	private static ServiciosInmobiliaria inm;
	private JPanel tabClientes;
	private JTabbedPane jTabbedPane;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		dao = new InmobiliariaUtilidades();
		inm = dao.getDao();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {				
				Padre inst = new Padre();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
		
	}
	
	public Padre() {
		super();
		
		initGUI();		
	}
	
	private void initGUI() {
		try {
			{
				this.setPreferredSize(new java.awt.Dimension(700, 400));
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						salirForm();
					}
				});
			}
			{
				jTabbedPane = new JTabbedPane();
				getContentPane().add(jTabbedPane, BorderLayout.CENTER);
				{
					tabClientes = new PanelClientes(this);
					jTabbedPane.addTab("Clientes", null, tabClientes, null);
					tabClientes.setLayout(null);
					tabClientes.setPreferredSize(new java.awt.Dimension(700, 315));
					tabClientes.setSize(700, 315);
				}
				{
					tabPropietarios = new PanelPropietarios(this);
					jTabbedPane.addTab("Propietarios", null, tabPropietarios, null);
					tabPropietarios.setLayout(null);
					tabPropietarios.setPreferredSize(new java.awt.Dimension(700, 315));
				}
				{
					jPanelPisos = new PanelPisos(this);
					jTabbedPane.addTab("Pisos", null, jPanelPisos, null);
				}
				{
					tabReservarPiso = new PanelReservaPiso();
					jTabbedPane.addTab("Reservas", null, tabReservarPiso, null);
				}
				{
					tabPagarPropietario = new PanelPagarPropietario();
					jTabbedPane.addTab("Pagos al Propietario", null, tabPagarPropietario, null);
				}
			}
			this.setSize(700, 400);
			
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ServiciosInmobiliaria getInm() {
		if (inm==null)
			inm=dao.getDao();
		return inm;
	}
	public void salirForm() {
		int respuesta = JOptionPane.showConfirmDialog(null,
				"Esta acción cerrará la aplicación, ¿desea continuar?",
				"Atención",
				JOptionPane.YES_NO_OPTION);
		if (respuesta != JOptionPane.YES_OPTION) {
			return;
		}
		AbstractDao.cerrarConexion();
		System.exit(0);
	}
	
	

}
