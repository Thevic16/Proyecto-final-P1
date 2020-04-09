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

public class ListaEstudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//lo que se necesita para hacer la tabla.
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	// hasta aqui.
	private int selectedRow = -1; // parte de seleccionar
	
	private static Centro centro;
	private JButton btnEliminar;
	private JButton btnModificar;
	private Profesor profesor = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListaEstudiantes(Centro centro) {
		setTitle("Mis Estudiantes");
		this.centro = centro;
		profesor = (Profesor) centro.getLoginUser();
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
				scrollPane.setBounds(6, 22, 610, 254);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					String[] columnas = {"ID","Nombre","Apellido","Cantidad de figuras"};
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
						int option = JOptionPane.showConfirmDialog(null, "Esta seguro desea eliminar al estudiante: "+profesor.getEstudiantes().get(selectedRow).getNombre()+" "+profesor.getEstudiantes().get(selectedRow).getApellido(), "Eliminar", JOptionPane.WARNING_MESSAGE);
						if(option == 0) {
						JOptionPane.showMessageDialog(null, "Operación Realizada", "Información", JOptionPane.INFORMATION_MESSAGE);
						Estudiante aux = profesor.getEstudiantes().get(selectedRow);
						profesor.removeEstudiante(aux);
						
						
						loadEstudiantes(profesor);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
						
						}
					}
				});
				
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Estudiante aux = profesor.getEstudiantes().get(selectedRow);
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
		
		loadEstudiantes(profesor);
	}
	
	
	public static void loadEstudiantes(Profesor profe) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Estudiante aux : profe.getEstudiantes()) {
			fila[0] = aux.getID();
			fila[1] = aux.getNombre();
			fila[2] = aux.getApellido();
			fila[3] = aux.getFiguras().size();
			model.addRow(fila);
		}
	}
	
}
