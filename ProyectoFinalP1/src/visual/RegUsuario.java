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
import javax.swing.JComboBox;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPassword;
	private JTextField txtID;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private static Centro educativo;
	private JRadioButton rdbtnEstudiante;
	private JRadioButton rdbtnProfesor;
	private JButton btnRegistrar;
	private JComboBox cbxProfesores;
	private JButton btnCancelar;

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
	public RegUsuario(Centro centro) {
		this.educativo = centro;
		setTitle("Registrar");
		setBounds(100, 100, 519, 353);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlOcupacion = new JPanel();
		pnlOcupacion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Seleccione su Ocupaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlOcupacion.setBounds(10, 28, 483, 53);
		contentPanel.add(pnlOcupacion);
		pnlOcupacion.setLayout(null);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("P-"+centro.getUsuarios().size());
				rdbtnProfesor.setSelected(true);
				rdbtnEstudiante.setSelected(false);
				btnRegistrar.setEnabled(true);
				cbxProfesores.setEnabled(false);
				cbxProfesores.setEnabled(false);
				
			}
		});
		rdbtnProfesor.setBounds(101, 17, 109, 23);
		rdbtnProfesor.setSelected(false);
		pnlOcupacion.add(rdbtnProfesor);
		
		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("E-"+centro.getUsuarios().size());
				rdbtnProfesor.setSelected(false);
				rdbtnEstudiante.setSelected(true);
				cbxProfesores.setEnabled(true);
				btnRegistrar.setEnabled(false);
				loadProfesores(educativo);
			}
		});
		rdbtnEstudiante.setBounds(227, 17, 109, 23);
		rdbtnEstudiante.setSelected(true);
		pnlOcupacion.add(rdbtnEstudiante);

		
		JPanel pnlInfoGeneral = new JPanel();
		pnlInfoGeneral.setBorder(new TitledBorder(null, "Infomaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfoGeneral.setBounds(10, 96, 483, 174);
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
			txtID.setText("E-"+centro.getUsuarios().size());
			txtID.setBounds(88, 28, 238, 20);
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
			txtNombre.setBounds(88, 64, 238, 20);
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
			txtApellido.setBounds(88, 100, 238, 20);
			pnlInfoGeneral.add(txtApellido);
			txtApellido.setColumns(10);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setBounds(88, 137, 238, 20);
			pnlInfoGeneral.add(txtPassword);
			txtPassword.setColumns(10);
		}
		
		cbxProfesores = new JComboBox();
		cbxProfesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxProfesores.getSelectedIndex()==0 && rdbtnEstudiante.isSelected()) {
					btnRegistrar.setEnabled(false);
				}
				if(cbxProfesores.getSelectedIndex()!=0 && rdbtnEstudiante.isSelected()){
					btnRegistrar.setEnabled(true);
				}
			}
		});

		cbxProfesores.setBounds(365, 28, 108, 20);
		pnlInfoGeneral.add(cbxProfesores);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setEnabled(false);
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtPassword.getText().equals("") ) {
							JOptionPane.showMessageDialog(null, "Debe llenar todas las casillas para registrarse.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else if(rdbtnProfesor.isSelected()) {
							Profesor teacher = new Profesor(txtNombre.getText(), txtID.getText(), txtApellido.getText(), txtPassword.getText());
							insertUsuario(teacher,educativo);
						}else if(rdbtnEstudiante.isSelected()) {
							int selecion = cbxProfesores.getSelectedIndex();
							Estudiante student = new Estudiante(txtNombre.getText(), txtID.getText(), txtApellido.getText(), txtPassword.getText());
							insertUsuario(student,educativo);
							
							((Profesor) educativo.getUsuariosByTipo().get(1).get(selecion-1)).insertarEstudiante(student) ;
						}

					}
					
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadProfesores(educativo);
	}
	
	
	public void insertUsuario(Usuario user,Centro centro) {
		
		if((user instanceof Profesor && !user.getID().startsWith("P"))||(user instanceof Estudiante && !user.getID().startsWith("E"))) {
			JOptionPane.showMessageDialog(null, "Identificación no válida", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			educativo.insertUsuario(user);
			JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
		    Clean(centro);
		    btnRegistrar.setEnabled(false);
		    btnCancelar.setEnabled(false);
		    cbxProfesores.setSelectedIndex(0);
		}

	}
	
	private void loadProfesores(Centro centro) {
		cbxProfesores.removeAllItems();
		for (Usuario user : centro.getUsuarios()) {
			
			if(user instanceof Profesor) {
				cbxProfesores.addItem(new String(user.getID()));
			}

		}
		cbxProfesores.insertItemAt(new String("<Seleccione>"),0);
		cbxProfesores.setSelectedIndex(0);
	}
	
	public void Clean(Centro centro) {
		txtNombre.setText("");
		txtApellido.setText("");
		if(rdbtnProfesor.isSelected()) {
			txtID.setText("P-"+centro.getUsuarios().size());
		}
		else {
			txtID.setText("P-"+centro.getUsuarios().size());
		}

		txtPassword.setText("");
	}
}
