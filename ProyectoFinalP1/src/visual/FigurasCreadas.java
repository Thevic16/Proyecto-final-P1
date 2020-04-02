package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigurasCreadas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JComboBox cbxTipoFiguras;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FigurasCreadas dialog = new FigurasCreadas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FigurasCreadas() {
		setBackground(new Color(176, 224, 230));
		setTitle("Figuras Creadas");
		setBounds(100, 100, 577, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Panel.background"));
		panel.setBorder(new TitledBorder(null, "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 561, 330);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 56, 541, 263);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("Table.background"));
		tableModel = new DefaultTableModel();
		String[] columnNames0 = {"Código", "Tipo","Área","Volumen"};
		tableModel.setColumnIdentifiers(columnNames0);
		//String[] columnNames = {"Código","Tipo", "Precio Base", "Precio Unitario","Volumen","Precio Total"};
		//tableModel.setColumnIdentifiers(columnNames);
		loadFiguras(0);
		scrollPane.setViewportView(table);
		
		JLabel lblTipoFigura = new JLabel("Tipo de Figura:");
		lblTipoFigura.setBounds(47, 21, 97, 14);
		panel.add(lblTipoFigura);
		
		cbxTipoFiguras = new JComboBox();
		cbxTipoFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = cbxTipoFiguras.getSelectedIndex();
				loadFiguras(selection);
			}
		});
		cbxTipoFiguras.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Cil\u00EDndros", "Conos", "Cubos", "Esferas", "Paralelep\u00EDpedos"}));
		cbxTipoFiguras.setSelectedIndex(0);
		cbxTipoFiguras.setBounds(140, 16, 176, 25);
		panel.add(cbxTipoFiguras);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(UIManager.getColor("Button.background"));
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.setBackground(UIManager.getColor("Button.background"));
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	
	private void loadFiguras(int seleccion) {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		switch (seleccion) {
		case 0://Todos
			String[] columnNames0 = {"Código", "Tipo","Área","Volumen"};
			tableModel.setColumnIdentifiers(columnNames0);
			
			break;
			
		case 1://Cilindros
			String[] columnNames1 = {"Código","Radio", "Altura","Área L.","Área B.","Área Total"};
			tableModel.setColumnIdentifiers(columnNames1);

			break;
			
		case 2://Conos
			String[] columnNames2 = {"Código","Radio", "Altura","Área L.","Área B.","Área Total"};
			tableModel.setColumnIdentifiers(columnNames2);
			
			break;
			
		case 3://Cubos
			String[] columnNames3 = {"Código","Tamaño","Área Total","Volumen"};
			tableModel.setColumnIdentifiers(columnNames3);
			
			break;
			
		case 4://Esferas
			String[] columnNames4 = {"Código","Radio", "Área Total","Volumen"};
			tableModel.setColumnIdentifiers(columnNames4);
			
			break;
			
		case 5://Paralelepípedos
			String[] columnNames5 = {"Código","Longitud", "Altura","Anchura","Área L.","Área B.","Área Total","Volumen"};
			tableModel.setColumnIdentifiers(columnNames5);
			
			break;
			
		default:
			break;
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		
		//tableModel.addRow(fila);
			
	}
	
}
