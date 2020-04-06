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
import logico.Usuario;

import javax.swing.ListSelectionModel;

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//lo que se necesita para hacer la tabla.
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	// hasta aqui.
	private int selectedRow = -1; // parte de seleccionar
	
	private static Centro centro;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListarUsuarios(Centro centro) {
		this.centro = centro;
		setBounds(100, 100, 540, 368);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				//tarde de la tabla
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					String[] columnas = {"ID","Tipo","Nombre","Apellido","Cantidad de figuras creadas"};
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
						int option = JOptionPane.showConfirmDialog(null, "Esta seguro desea eliminar al usuario: "+centro.getUsuarios().get(selectedRow).getNombre()+" "+centro.getUsuarios().get(selectedRow).getApellido(), "Eliminar", JOptionPane.WARNING_MESSAGE);
						if(option == 0) {
						JOptionPane.showMessageDialog(null, "Operación Realizada", "Información", JOptionPane.INFORMATION_MESSAGE);
						centro.removeUser(selectedRow);
						centro.setCantUsuarios(centro.getCantUsuarios()-1);
						loadSuministradores();
						btnEliminar.setEnabled(false);
						
						}
					}
				});
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
		
		loadSuministradores();
	}
	
	public static void loadSuministradores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
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

}