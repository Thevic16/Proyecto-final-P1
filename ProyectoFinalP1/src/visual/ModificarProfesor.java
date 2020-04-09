//
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
	private JComboBox cbxProfesores;
	private JButton btnSalvar;
	private static int seleccion = -1;
	private static int indiceProfesorActual =-1;

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
		setTitle("Mi profesor");
		setBounds(100, 100, 510, 208);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		
		JPanel pnlInfoGeneral = new JPanel();
		pnlInfoGeneral.setBorder(new TitledBorder(null, "Infomaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfoGeneral.setBounds(10, 24, 474, 101);
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
		
		cbxProfesores = new JComboBox();
		cbxProfesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxProfesores.getSelectedIndex()==0 || cbxProfesores.getSelectedIndex() == indiceProfesorActual) {
					btnSalvar.setEnabled(false);
				}
				else {
					btnSalvar.setEnabled(true);
				}
				
			}
		});
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
					btnSalvar = new JButton("Salvar");
					btnSalvar.setEnabled(false);
					btnSalvar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							seleccion = cbxProfesores.getSelectedIndex()-1;
							Profesor aux =centro.getProfesorByIDEstudiante(centro.getLoginUser().getID());

							int option = JOptionPane.showConfirmDialog(null, "Esta seguro desea cambiar de profesor: ", "Cambio", JOptionPane.WARNING_MESSAGE);
							if(option == 0) {
							if(seleccion >=0) {
								
								if(aux == null) {
									
									((Profesor) centro.getUsuariosByTipo().get(1).get(seleccion)).insertarEstudiante((Estudiante) centro.getLoginUser());
								}
								else {
									Profesor auxProfe = centro.getProfesorByIDEstudiante(centro.getLoginUser().getID());
									auxProfe.eliminarEstudiante((Estudiante) centro.getLoginUser());
									
									((Profesor) centro.getUsuariosByTipo().get(1).get(seleccion)).insertarEstudiante((Estudiante) centro.getLoginUser());
								}
								
								
								JOptionPane.showMessageDialog(null, "La acción se ha ejecutado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE); 
							}
							}
							
							JOptionPane.showMessageDialog(null, "Ahora es parte del grupo de"+" "+((Profesor) centro.getUsuariosByTipo().get(1).get(seleccion)).getNombre(), "Información", JOptionPane.INFORMATION_MESSAGE); 
							dispose();
						}
					});
					buttonPane.add(btnSalvar);
				}
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		 LoadUsuario(centro); 
		 loadProfesores(centro);
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
	
	private void loadProfesores(Centro centro) {
		cbxProfesores.removeAllItems();
		int contador = 1;
		for (Usuario user : centro.getUsuarios()) {
			
			if(user instanceof Profesor) {
					cbxProfesores.addItem(new String(user.getID()+"-"+user.getNombre()));
					if(user ==centro.getProfesorByIDEstudiante(centro.getLoginUser().getID())) {
						indiceProfesorActual = contador;
						
					}
				contador++;
			}

		}
		cbxProfesores.insertItemAt(new String("<Profesores>"),0);
		cbxProfesores.setSelectedIndex(0);
	}
}