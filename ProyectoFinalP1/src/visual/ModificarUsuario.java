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

public class ModificarUsuario extends JDialog {

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
	public ModificarUsuario(Usuario user) {
		this.user = user;
		setTitle("Modificar cuenta");
		setBounds(100, 100, 481, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		
		JPanel pnlInfoGeneral = new JPanel();
		pnlInfoGeneral.setBorder(new TitledBorder(null, "Infomaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfoGeneral.setBounds(10, 24, 445, 193);
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
			txtApellido.setBounds(88, 100, 266, 20);
			pnlInfoGeneral.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setBounds(88, 137, 266, 20);
			pnlInfoGeneral.add(txtPassword);
			txtPassword.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton btnNewButton = new JButton("Salvar");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							user.setNombre(txtNombre.getText());
							user.setApellido(txtApellido.getText());
							user.setPassword(txtPassword.getText());
							JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							LoadUsuario(user); 
						}
					});
					buttonPane.add(btnNewButton);
				}
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