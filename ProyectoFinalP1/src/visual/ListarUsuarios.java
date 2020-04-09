//
package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Centro;
import logico.Estudiante;
import logico.Profesor;
import logico.Usuario;

import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//lo que se necesita para hacer la tabla.
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	// hasta aqui.
	private int selectedRow = -1; // parte de seleccionar
	private static JComboBox cbxSeleccion;
	
	private static Centro centro;
	private JButton btnEliminar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListarUsuarios(Centro centro) {
		this.centro = centro;
		setBounds(100, 100, 662, 368);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 626, 276);
			panel.setBorder(new TitledBorder(null, "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				//tarde de la tabla
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(6, 49, 610, 227);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					String[] columnas = {"ID","Ocupación","Nombre","Apellido","Cantidad de figuras"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							selectedRow = table.getSelectedRow();
							if(selectedRow>-1) {
								btnEliminar.setEnabled(true);
								btnModificar.setEnabled(true);
							}
						}
					});
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
			
			cbxSeleccion = new JComboBox();
			cbxSeleccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indiceSeleccionado;
					
					indiceSeleccionado = cbxSeleccion.getSelectedIndex();
					
					if(indiceSeleccionado == 0) {
						loadUsuarios();
					}
					else if(indiceSeleccionado == 1) {
						loadEstudiantes();
					}
					else if(indiceSeleccionado == 2) {
						loadProfesores();
					}
				}
			});
			cbxSeleccion.setModel(new DefaultComboBoxModel(new String[] {"<Todos los usuarios>", "Estudiantes", "Profesores"}));
			cbxSeleccion.setBounds(6, 18, 165, 20);
			panel.add(cbxSeleccion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Esta seguro desea eliminar al usuario: "+centro.getUsuarios().get(selectedRow).getNombre()+" "+centro.getUsuarios().get(selectedRow).getApellido(), "Eliminar", JOptionPane.WARNING_MESSAGE);
						if(option == 0) {
						JOptionPane.showMessageDialog(null, "Operación Realizada", "Información", JOptionPane.INFORMATION_MESSAGE);
						
						Usuario aux = null;
						
						int indiceSeleccionado;
						
						indiceSeleccionado = cbxSeleccion.getSelectedIndex();
						
						if(indiceSeleccionado == 0) {
							aux = centro.getUsuarios().get(selectedRow);
							
							centro.removeUser(aux);
							centro.setCantUsuarios(centro.getCantUsuarios()-1);
						}
						else if(indiceSeleccionado == 1) {
							aux = centro.getUsuariosByTipo().get(0).get(selectedRow);
							
							centro.removeUser(aux);
							centro.setCantUsuarios(centro.getCantUsuarios()-1);
						}
						else if(indiceSeleccionado == 2) {
							aux = centro.getUsuariosByTipo().get(1).get(selectedRow);
							
							centro.removeUser(aux);
							centro.setCantUsuarios(centro.getCantUsuarios()-1);
						}
						
					
						loadUsuarios();
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
						
						}
					}
				});
				
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario aux = null;
						
						int indiceSeleccionado;
						
						indiceSeleccionado = cbxSeleccion.getSelectedIndex();
						
						if(indiceSeleccionado == 0) {
							aux = centro.getUsuarios().get(selectedRow);
						}
						else if(indiceSeleccionado == 1) {
							aux = centro.getUsuariosByTipo().get(0).get(selectedRow);
						}
						else if(indiceSeleccionado == 2) {
							aux = centro.getUsuariosByTipo().get(1).get(selectedRow);
						}
						
						if(aux != null) {
							dispose();
							ModificarUsuario modificarUsuario = new ModificarUsuario(aux);
							modificarUsuario.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Esta acción no ha podido ser realizada.", "Información", JOptionPane.ERROR_MESSAGE);
						}
	

					}
				});
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		
		loadUsuarios();
	}
	
	public static void loadUsuarios() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		cbxSeleccion.setSelectedIndex(0);
		for (Usuario user : centro.getUsuarios()) {
			fila[0] = user.getID();
			if(user instanceof Estudiante) {
				fila[1] = "Estudiante";
			}
			else {
				fila[1] = "Profesor";
			}
			fila[2] = user.getNombre();
			fila[3] = user.getApellido();
			fila[4] = user.getFiguras().size();
			model.addRow(fila);
		}
	}
	
	public static void loadEstudiantes() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		for (Usuario user : centro.getUsuarios()) {
			fila[0] = user.getID();
			if(user instanceof Estudiante) {
				fila[1] = "Estudiante";
				fila[2] = user.getNombre();
				fila[3] = user.getApellido();
				fila[4] = user.getFiguras().size();
				model.addRow(fila);
			}
		}
	}
	
	public static void loadProfesores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		for (Usuario user : centro.getUsuarios()) {
			fila[0] = user.getID();
			if(user instanceof Profesor) {
				fila[1] = "Profesor";
				fila[2] = user.getNombre();
				fila[3] = user.getApellido();
				fila[4] = user.getFiguras().size();
				model.addRow(fila);
			}
		}
	}
}