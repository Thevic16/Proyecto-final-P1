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

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPassword;
	private JTextField txtID;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private static Centro educativo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setTitle("Registrar");
		setBounds(100, 100, 481, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlOcupacion = new JPanel();
		pnlOcupacion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Seleccione su Ocupaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlOcupacion.setBounds(10, 28, 445, 53);
		contentPanel.add(pnlOcupacion);
		pnlOcupacion.setLayout(null);
		
		JRadioButton rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setBounds(101, 17, 109, 23);
		pnlOcupacion.add(rdbtnProfesor);
		
		JRadioButton rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setBounds(227, 17, 109, 23);
		pnlOcupacion.add(rdbtnEstudiante);
		
		JPanel pnlInfoGeneral = new JPanel();
		pnlInfoGeneral.setBorder(new TitledBorder(null, "Infomaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfoGeneral.setBounds(10, 96, 445, 174);
		contentPanel.add(pnlInfoGeneral);
		pnlInfoGeneral.setLayout(null);
		{
			JLabel lbliD = new JLabel("ID");
			lbliD.setBounds(10, 31, 46, 14);
			pnlInfoGeneral.add(lbliD);
		}
		{
			txtID = new JTextField();
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
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnProfesor.isSelected()) {
							Profesor teacher = new Profesor(txtNombre.getText(), txtID.getText(), txtApellido.getText(), txtPassword.getText());
							insertUsuario(teacher);
						}else if(rdbtnEstudiante.isSelected()) {
							Estudiante student = new Estudiante(txtNombre.getText(), txtID.getText(), txtApellido.getText(), txtPassword.getText());
							insertUsuario(student);						
						}
					}
					
				});
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
	
	
	public void insertUsuario(Usuario user) {
		
		if((user instanceof Profesor && !user.getID().startsWith("P"))||(user instanceof Estudiante && !user.getID().startsWith("E"))) {
			JOptionPane.showMessageDialog(null, "Identificación no válida", "Error", JOptionPane.ERROR_MESSAGE);
			Clean();
			return;
		}		
		educativo.insertUsuario(user);
		JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
	    Clean();
	}
	
	public void Clean() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtID.setText("");
		txtPassword.setText("");
	}
	
}
