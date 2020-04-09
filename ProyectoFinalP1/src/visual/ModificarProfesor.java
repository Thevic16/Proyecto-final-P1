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

public class ModificarProfesor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtProfesor;
	private static Centro centro;

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
	public ModificarProfesor(Centro centro) {
		this.centro = centro;
		setTitle("Registrar");
		setBounds(100, 100, 510, 208);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		
		JPanel pnlInfoGeneral = new JPanel();
		pnlInfoGeneral.setBorder(new TitledBorder(null, "Infomaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfoGeneral.setBounds(10, 24, 474, 112);
		contentPanel.add(pnlInfoGeneral);
		pnlInfoGeneral.setLayout(null);
		{
			JLabel lbliD = new JLabel("Profesor Actual");
			lbliD.setBounds(10, 31, 117, 14);
			pnlInfoGeneral.add(lbliD);
		}
		{
			txtProfesor = new JTextField();
			txtProfesor.setEditable(false);
			txtProfesor.setBounds(164, 28, 266, 20);
			pnlInfoGeneral.add(txtProfesor);
			txtProfesor.setColumns(10);
		}
		{
			JLabel lblNombre = new JLabel("Profesores disponibles");
			lblNombre.setBounds(10, 67, 133, 14);
			pnlInfoGeneral.add(lblNombre);
		}
		
		JComboBox cbxProfesores = new JComboBox();
		cbxProfesores.setBounds(164, 64, 266, 20);
		pnlInfoGeneral.add(cbxProfesores);
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

							JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
							LoadUsuario(centro); 
						}
					});
					buttonPane.add(btnNewButton);
				}
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		 LoadUsuario(centro); 
	}
	
	
	public void LoadUsuario(Centro centro) {
			Profesor aux =centro.getProfesorByIDEstudiante(centro.getLoginUser().getID());
			
		if(aux != null) {
			
			txtProfesor.setText(aux.getNombre()+" "+ aux.getApellido());
		}
		else {
			txtProfesor.setText("No tiene profesor en este momento.");
		}

	}
}