package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import logico.Centro;
import logico.Estudiante;
import logico.Profesor;
import logico.Usuario;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacionCuenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPassword;
	private JTextField txtID;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private static Usuario user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Centro centro = Centro.getInstance();
			RegUsuario dialog = new RegUsuario(centro);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InformacionCuenta(Usuario user) {
		this.user = user;
		setTitle("Registrar");
		setBounds(100, 100, 481, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		
		JPanel pnlInfoGeneral = new JPanel();
		pnlInfoGeneral.setBorder(new TitledBorder(null, "Infomaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfoGeneral.setBounds(10, 24, 445, 246);
		contentPanel.add(pnlInfoGeneral);
		pnlInfoGeneral.setLayout(null);
		{
			JLabel lbliD = new JLabel("ID");
			lbliD.setBounds(10, 31, 46, 14);
			pnlInfoGeneral.add(lbliD);
		}
		{
			txtID = new JTextField();
			txtID.setEditable(false);
			txtID.setBounds(88, 28, 266, 20);
			pnlInfoGeneral.add(txtID);
			txtID.setColumns(10);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(10, 67, 46, 14);
			pnlInfoGeneral.add(lblNombre);
		}
		{
			JLabel lblPassword = new JLabel("Contrase\u00F1a");
			lblPassword.setBounds(10, 140, 76, 14);
			pnlInfoGeneral.add(lblPassword);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(88, 64, 266, 20);
			pnlInfoGeneral.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblApellido = new JLabel("Apellido(s)");
			lblApellido.setBounds(10, 103, 62, 14);
			pnlInfoGeneral.add(lblApellido);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setEditable(false);
			txtApellido.setBounds(88, 100, 266, 20);
			pnlInfoGeneral.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setEditable(false);
			txtPassword.setBounds(88, 137, 266, 20);
			pnlInfoGeneral.add(txtPassword);
			txtPassword.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cerrar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		 LoadUsuario(user); 
	}
	
	
	public void LoadUsuario(Usuario user) {
		txtNombre.setText(user.getNombre());
		txtApellido.setText(user.getApellido());
		txtID.setText(user.getID());
		txtPassword.setText(user.getPassword());
	}

}