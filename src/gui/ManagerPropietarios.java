package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class ManagerPropietarios extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	private JLabel jlbNif;
	private JTextField jtfTitulo;
	private JTextField jtfDireccion;
	private JButton jbtConsulta;
	private JTextField jtfLocalidad;
	private JButton jbtNuevo;
	private JButton jbtModificar;
	private JLabel jlbLocalidad;
	private JLabel jlbDireccion;
	private JButton jbtSalir;
	private JButton jbtCancelar;
	private JButton jbtGrabar;
	private JButton jbtEliminar;
	private JTextField jtfApellidos;
	private JTextField jtfNombre;
	private JLabel jlbNombre;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
                ManagerPropietarios inst = new ManagerPropietarios();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ManagerPropietarios() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Gestion de Propietarios");
			{
				jlbNif = new JLabel();
				getContentPane().add(jlbNif);
				jlbNif.setText("NIF");
				jlbNif.setBounds(30, 32, 42, 14);
				jlbNif.setHorizontalAlignment(SwingConstants.RIGHT);
				jlbNif.setSize(45, 14);
			}
			{
				jlbNombre = new JLabel();
				getContentPane().add(jlbNombre);
				jlbNombre.setText("Nombre");
				jlbNombre.setBounds(30, 62, 42, 14);
				jlbNombre.setHorizontalAlignment(SwingConstants.RIGHT);
				jlbNombre.setSize(45, 14);
			}
			{
				jtfTitulo = new JTextField();
				getContentPane().add(jtfTitulo);
				jtfTitulo.setBounds(90, 32, 118, 21);
			}
			{
				jtfNombre = new JTextField();
				getContentPane().add(jtfNombre);
				jtfNombre.setBounds(90, 62, 172, 21);
			}
			{
				jtfApellidos = new JTextField();
				getContentPane().add(jtfApellidos);
				jtfApellidos.setBounds(268, 62, 262, 21);
			}
			{
				jbtNuevo = new JButton();
				getContentPane().add(jbtNuevo);
				jbtNuevo.setText("Nuevo");
				jbtNuevo.setBounds(30, 177, 82, 40);
				jbtNuevo.setSize(70, 40);
				jbtNuevo.setMnemonic(java.awt.event.KeyEvent.VK_N);
			}
			{
				jbtModificar = new JButton();
				getContentPane().add(jbtModificar);
				jbtModificar.setText("Modificar");
				jbtModificar.setBounds(111, 177, 70, 40);
				jbtModificar.setMnemonic(java.awt.event.KeyEvent.VK_M);
			}
			{
				jbtEliminar = new JButton();
				getContentPane().add(jbtEliminar);
				jbtEliminar.setText("Eliminar");
				jbtEliminar.setBounds(192, 177, 70, 40);
				jbtEliminar.setMnemonic(java.awt.event.KeyEvent.VK_E);
			}
			{
				jbtGrabar = new JButton();
				getContentPane().add(jbtGrabar);
				jbtGrabar.setText("Grabar");
				jbtGrabar.setBounds(273, 177, 47, 21);
				jbtGrabar.setSize(70, 40);
				jbtGrabar.setMnemonic(java.awt.event.KeyEvent.VK_G);
			}
			{
				jbtCancelar = new JButton();
				getContentPane().add(jbtCancelar);
				jbtCancelar.setText("Cancelar");
				jbtCancelar.setBounds(354, 177, 70, 40);
				jbtCancelar.setMnemonic(java.awt.event.KeyEvent.VK_C);
			}
			{
				jbtSalir = new JButton();
				getContentPane().add(jbtSalir);
				jbtSalir.setText("Salir");
				jbtSalir.setBounds(461, 177, 34, 21);
				jbtSalir.setSize(70, 40);
				jbtSalir.setMnemonic(java.awt.event.KeyEvent.VK_S);
			}
			{
				jlbDireccion = new JLabel();
				getContentPane().add(jlbDireccion);
				jlbDireccion.setText("Direccion");
				jlbDireccion.setBounds(30, 92, 43, 14);
				jlbDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jlbLocalidad = new JLabel();
				getContentPane().add(jlbLocalidad);
				jlbLocalidad.setText("Localidad");
				jlbLocalidad.setBounds(30, 122, 44, 14);
				jlbLocalidad.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jtfDireccion = new JTextField();
				getContentPane().add(jtfDireccion);
				jtfDireccion.setBounds(90, 92, 440, 21);
			}
			{
				jtfLocalidad = new JTextField();
				getContentPane().add(jtfLocalidad);
				jtfLocalidad.setBounds(90, 122, 440, 21);
			}
			{
				jbtConsulta = new JButton();
				getContentPane().add(jbtConsulta);
				jbtConsulta.setText("Pisos Propietario");
				jbtConsulta.setBounds(333, 12, 167, 38);
				jbtConsulta.setMnemonic(java.awt.event.KeyEvent.VK_P);
			}
			pack();
			this.setSize(550, 265);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
