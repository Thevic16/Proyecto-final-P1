package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtCodigoCliente;
	private JTextField txtCodigoCuenta;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCliente() {
		setTitle("Registrar cliente");
		setBounds(100, 100, 434, 460);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panelInfCliente = new JPanel();
				panelInfCliente.setBorder(new TitledBorder(null, "Informaci\u00F3n cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelInfCliente.setBounds(10, 9, 391, 178);
				panel.add(panelInfCliente);
				panelInfCliente.setLayout(null);
				
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setBounds(10, 26, 59, 14);
				panelInfCliente.add(lblNombre);
				
				txtNombre = new JTextField();
				txtNombre.setBounds(10, 40, 138, 20);
				panelInfCliente.add(txtNombre);
				txtNombre.setColumns(10);
				
				JLabel lblApellido = new JLabel("Apellido");
				lblApellido.setBounds(10, 78, 92, 14);
				panelInfCliente.add(lblApellido);
				
				txtApellido = new JTextField();
				txtApellido.setBounds(10, 90, 138, 20);
				panelInfCliente.add(txtApellido);
				txtApellido.setColumns(10);
				
				JLabel lblDireccion = new JLabel("Direcci\u00F3n ");
				lblDireccion.setBounds(10, 121, 112, 14);
				panelInfCliente.add(lblDireccion);
				
				txtDireccion = new JTextField();
				txtDireccion.setBounds(10, 136, 138, 20);
				panelInfCliente.add(txtDireccion);
				txtDireccion.setColumns(10);
				
				JLabel lblCedula = new JLabel("C\u00E9dula de identidad");
				lblCedula.setBounds(225, 26, 138, 14);
				panelInfCliente.add(lblCedula);
				
				txtCedula = new JTextField();
				txtCedula.setBounds(225, 40, 138, 20);
				panelInfCliente.add(txtCedula);
				txtCedula.setColumns(10);
				
				JLabel lblTelefono = new JLabel("Tel\u00E9fono");
				lblTelefono.setBounds(225, 78, 86, 14);
				panelInfCliente.add(lblTelefono);
				
				txtTelefono = new JTextField();
				txtTelefono.setBounds(225, 90, 138, 20);
				panelInfCliente.add(txtTelefono);
				txtTelefono.setColumns(10);
				
				JLabel lblCodCliente = new JLabel("C\u00F3digo cliente");
				lblCodCliente.setBounds(225, 121, 125, 14);
				panelInfCliente.add(lblCodCliente);
				
				txtCodigoCliente = new JTextField();
				txtCodigoCliente.setEnabled(false);
				txtCodigoCliente.setBounds(225, 136, 138, 20);
				panelInfCliente.add(txtCodigoCliente);
				txtCodigoCliente.setColumns(10);
			}
			{
				JPanel panelInforCuenta = new JPanel();
				panelInforCuenta.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n cuenta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelInforCuenta.setBounds(10, 196, 391, 178);
				panel.add(panelInforCuenta);
				panelInforCuenta.setLayout(null);
				
				JLabel lblTipo = new JLabel("Tipo");
				lblTipo.setBounds(10, 26, 46, 14);
				panelInforCuenta.add(lblTipo);
				
				JComboBox cbxTipo = new JComboBox();
				cbxTipo.setBounds(10, 43, 138, 20);
				panelInforCuenta.add(cbxTipo);
				
				JLabel lblEstado = new JLabel("Estado cuenta");
				lblEstado.setBounds(10, 71, 138, 14);
				panelInforCuenta.add(lblEstado);
				
				JComboBox cbxEstado = new JComboBox();
				cbxEstado.setBounds(10, 84, 138, 20);
				panelInforCuenta.add(cbxEstado);
				
				JLabel lblSaldoIniciar = new JLabel("Saldo iniciar");
				lblSaldoIniciar.setBounds(10, 110, 87, 14);
				panelInforCuenta.add(lblSaldoIniciar);
				
				JSpinner spnSaldo = new JSpinner();
				spnSaldo.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnSaldo.setBounds(9, 123, 138, 20);
				panelInforCuenta.add(spnSaldo);
				
				JLabel lblDiaCorte = new JLabel("D\u00EDa de corte");
				lblDiaCorte.setBounds(225, 26, 74, 14);
				panelInforCuenta.add(lblDiaCorte);
				
				JSpinner spnDiaCorte = new JSpinner();
				spnDiaCorte.setModel(new SpinnerNumberModel(1, 1, 31, 1));
				spnDiaCorte.setBounds(225, 43, 138, 20);
				panelInforCuenta.add(spnDiaCorte);
				
				JLabel lblMesesApertura = new JLabel("Meses apertura");
				lblMesesApertura.setBounds(225, 71, 96, 14);
				panelInforCuenta.add(lblMesesApertura);
				
				JSpinner spnMesesApertura = new JSpinner();
				spnMesesApertura.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnMesesApertura.setBounds(225, 84, 138, 20);
				panelInforCuenta.add(spnMesesApertura);
				
				JLabel lblCodigoCuenta = new JLabel("C\u00F3digo cuenta");
				lblCodigoCuenta.setBounds(225, 110, 138, 14);
				panelInforCuenta.add(lblCodigoCuenta);
				
				txtCodigoCuenta = new JTextField();
				txtCodigoCuenta.setEditable(false);
				txtCodigoCuenta.setBounds(225, 123, 138, 20);
				panelInforCuenta.add(txtCodigoCuenta);
				txtCodigoCuenta.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
