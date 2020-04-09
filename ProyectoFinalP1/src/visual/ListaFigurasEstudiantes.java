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
import logico.Cilindro;
import logico.Cono;
import logico.Cubo;
import logico.Esfera;
import logico.Estudiante;
import logico.Figura;
import logico.Paralelepipedo;
import logico.Profesor;
import logico.Usuario;

import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class ListaFigurasEstudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//lo que se necesita para hacer la tabla.
	private static JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	// hasta aqui.
	private int selectedRow = -1; // parte de seleccionar
	private static JComboBox cbxEstudiantes;
	
	private static Centro centro;
	private Profesor profesor = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListaFigurasEstudiantes(Centro centro) {
		setTitle("Figuras de Estudiantes");
		this.centro = centro;
		profesor = (Profesor)centro.getLoginUser();
		setBounds(100, 100, 662, 393);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 626, 295);
			panel.setBorder(new TitledBorder(null, "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				//tarde de la tabla
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 49, 610, 235);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					String[] columnas = {"Estudiantes","Nombre","Figuras","Tipo","Área","Volumen"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					loadFiguras("<Todos>",profesor);
					scrollPane.setViewportView(table);
				}
			}
			
			cbxEstudiantes = new JComboBox();
			cbxEstudiantes.setMaximumRowCount(50);
			loadEstudiantes(profesor);
			cbxEstudiantes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int indiceSeleccionado;
					indiceSeleccionado = cbxEstudiantes.getSelectedIndex();
					String id = (String)cbxEstudiantes.getItemAt(indiceSeleccionado);
					loadFiguras(id,profesor);
				}
			});
			cbxEstudiantes.setBounds(214, 18, 165, 20);
			panel.add(cbxEstudiantes);
			{
				JLabel lblEstudiante = new JLabel("Estudiante:");
				lblEstudiante.setBounds(147, 21, 73, 14);
				panel.add(lblEstudiante);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		
		loadFiguras("<Todos>",profesor);
	}
	

	
	public static void loadFiguras(String id, Profesor profesor) {
		model.setRowCount(0);
		if(id.equalsIgnoreCase("<Todos>")) {
			String[] columnas = {"Estudiantes","Nombre","Figuras","Tipo","Área","Volumen"};
			model.setColumnIdentifiers(columnas);
			fila = new Object[model.getColumnCount()];
			for (Estudiante est : profesor.getEstudiantes()) {
				for (Figura aux : est.getFiguras()) {
					fila[0] = est.getID();
					fila[1] = est.getNombre();
					fila[2] = aux.getCodigo();
					if(aux instanceof Cilindro)
						fila[3] = "Cilíndro";
					if(aux instanceof Cono)
						fila[3] = "Cono";
					if(aux instanceof Cubo)
						fila[3] = "Cubo";
					if(aux instanceof Esfera)
						fila[3] = "Esfera";
					if(aux instanceof Paralelepipedo)
						fila[3] = "Paralelepípedo";
					fila[4] = aux.area();
					fila[5] = aux.volumen();
					model.addRow(fila);
				}
			}
			
		}else {
			Estudiante estud = profesor.buscarEstudianteByID(id);
			String[] columnas = {"Figuras","Tipo","Área","Volumen"};
			model.setColumnIdentifiers(columnas);
			fila = new Object[model.getColumnCount()];
			for (Figura aux : estud.getFiguras()) {
				fila[0] = aux.getCodigo();
				if(aux instanceof Cilindro)
					fila[1] = "Cilíndro";
				if(aux instanceof Cono)
					fila[1] = "Cono";
				if(aux instanceof Cubo)
					fila[1] = "Cubo";
				if(aux instanceof Esfera)
					fila[1] = "Esfera";
				if(aux instanceof Paralelepipedo)
					fila[1] = "Paralelepípedo";
				fila[2] = aux.area();
				fila[3] = aux.volumen();
				model.addRow(fila);
			}
		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
	}
	
	
	private void loadEstudiantes(Profesor profesor) {
        cbxEstudiantes.removeAllItems();
        cbxEstudiantes.insertItemAt(new String("<Todos>"),0);
        cbxEstudiantes.setSelectedIndex(0);
        for (Estudiante est : profesor.getEstudiantes()) {
              cbxEstudiantes.addItem(new String(est.getID()));
        }
    }
	
	////
}
