//
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
import javax.swing.table.TableColumnModel;

import logico.Centro;
import logico.Cilindro;
import logico.Cono;
import logico.Cubo;
import logico.Esfera;
import logico.Estudiante;
import logico.Figura;
import logico.Paralelepipedo;
import logico.Usuario;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FigurasCreadas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JComboBox cbxTipoFiguras;
	private JScrollPane scrollPane;
	private Centro centro;
	
	private JButton btnEliminar;
	private int selectedRow = -1; // parte de seleccionar
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Centro centro = Centro.getInstance();
			FigurasCreadas dialog = new FigurasCreadas(centro);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FigurasCreadas(Centro centro) {
		this.centro = centro;
		setBackground(new Color(176, 224, 230));
		setTitle("Figuras Creadas");
		setBounds(100, 100, 577, 421);
		setLocationRelativeTo(null);
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = table.getSelectedRow();
				if(selectedRow>-1) {
					btnEliminar.setEnabled(true);

				}
			}
		});
		table.setBackground(UIManager.getColor("Table.background"));
		tableModel = new DefaultTableModel();
		String[] columnNames0 = {"C�digo", "Tipo","�rea","Volumen"};
		tableModel.setColumnIdentifiers(columnNames0);
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
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

												
						int selection = cbxTipoFiguras.getSelectedIndex();
						
						if(centro.isLoginAdmin()) {
							JOptionPane.showMessageDialog(null, "El administrador no tiene permiso de eliminar las figuras de los usuarios", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							int option = JOptionPane.showConfirmDialog(null, "�Esta seguro desea eliminar la figura?", "Eliminar", JOptionPane.WARNING_MESSAGE);
							
							if(option == 0) {
							JOptionPane.showMessageDialog(null, "Operaci�n Realizada", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
							
							Figura aux = null;
							
							if(selection == 0) {
								aux = centro.getFiguras().get(selectedRow);
								
								centro.getLoginUser().removeFigura(aux);
								centro.removeFigura(aux);
							}
							else if(selection == 1) {
								aux = centro.getFigurasByTipo().get(0).get(selectedRow);
								
								centro.getLoginUser().removeFigura(aux);
								centro.removeFigura(aux);
							}
							else if(selection == 2) {
								aux = centro.getFigurasByTipo().get(1).get(selectedRow);

								centro.getLoginUser().removeFigura(aux);
								centro.removeFigura(aux);
							}
							else if(selection == 3) {
								aux = centro.getFigurasByTipo().get(2).get(selectedRow);
							
								centro.getLoginUser().removeFigura(aux);
								centro.removeFigura(aux);
							}
							else if(selection == 4) {
								aux = centro.getFigurasByTipo().get(3).get(selectedRow);
							
								centro.getLoginUser().removeFigura(aux);
								centro.removeFigura(aux);
							}
							else if(selection == 5) {
								aux = centro.getFigurasByTipo().get(4).get(selectedRow);
							
								centro.getLoginUser().removeFigura(aux);
								centro.removeFigura(aux);
							}
							
						}
						
						loadFiguras(selection);
						btnEliminar.setEnabled(false);
						
						}
						
						
					}
				});
				buttonPane.add(btnEliminar);
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	
	private void loadFiguras(int seleccion) {
		tableModel.setRowCount(0);
		
		if(!centro.isLoginAdmin()) {
			
			switch (seleccion) {
			case 0://Todos
				String[] columnNames0 = {"C�digo", "Tipo","�rea","Volumen"};
				tableModel.setColumnIdentifiers(columnNames0);
				fila = new Object[tableModel.getColumnCount()];//Esto hace que las filas se ajusten a 
				//la cantidad de columnas seg�n el tipo de figura a visualizar en la tabla.
				for (Figura aux : centro.getLoginUser().getFiguras()) {
					fila[0] = aux.getCodigo();
					if(aux instanceof Cilindro)
						fila[1] = "Cil�ndro";
					if(aux instanceof Cono)
						fila[1] = "Cono";
					if(aux instanceof Cubo)
						fila[1] = "Cubo";
					if(aux instanceof Esfera)
						fila[1] = "Esfera";
					if(aux instanceof Paralelepipedo)
						fila[1] = "Paralelep�pedo";
					fila[2] = aux.area();
					fila[3] = aux.volumen();
					
					tableModel.addRow(fila);
				}
				break;
				
			case 1://Cilindros
				String[] columnNames1 = {"C�digo","Radio", "Altura","�rea L.","�rea B.","�rea Total"};
				tableModel.setColumnIdentifiers(columnNames1);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getLoginUser().getFiguras()) {
					if(aux instanceof Cilindro) {
						fila[0] = ((Cilindro) aux).getCodigo();
						fila[1] = ((Cilindro) aux).getRadio();
						fila[2] = ((Cilindro) aux).getAltura();
						fila[3] = ((Cilindro) aux).areaLateral();
						fila[4] = ((Cilindro) aux).areaBase();
						fila[5] = ((Cilindro) aux).area();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 2://Conos
				String[] columnNames2 = {"C�digo","Radio", "Altura","�rea L.","�rea B.","�rea Total"};
				tableModel.setColumnIdentifiers(columnNames2);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getLoginUser().getFiguras()) {
					if(aux instanceof Cono) {
						fila[0] = ((Cono) aux).getCodigo();
						fila[1] = ((Cono) aux).getRadio();
						fila[2] = ((Cono) aux).getAltura();
						fila[3] = ((Cono) aux).areaLateral();
						fila[4] = ((Cono) aux).areaBase();
						fila[5] = ((Cono) aux).area();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 3://Cubos
				String[] columnNames3 = {"C�digo","Tama�o","�rea Total","Volumen"};
				tableModel.setColumnIdentifiers(columnNames3);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getLoginUser().getFiguras()) {
					if(aux instanceof Cubo) {
						fila[0] = ((Cubo) aux).getCodigo();
						fila[1] = ((Cubo) aux).getTamano();
						fila[2] = ((Cubo) aux).area();
						fila[3] = ((Cubo) aux).volumen();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 4://Esferas
				String[] columnNames4 = {"C�digo","Radio", "�rea Total","Volumen"};
				tableModel.setColumnIdentifiers(columnNames4);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getLoginUser().getFiguras()) {
					if(aux instanceof Esfera) {
						fila[0] = ((Esfera) aux).getCodigo();
						fila[1] = ((Esfera) aux).getRadio();
						fila[2] = ((Esfera) aux).area();
						fila[3] = ((Esfera) aux).volumen();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 5://Paralelep�pedos
				String[] columnNames5 = {"C�digo","Longitud", "Altura","Anchura","�rea L.","�rea B.","�rea Total","Volumen"};
				tableModel.setColumnIdentifiers(columnNames5);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getLoginUser().getFiguras()) {
					if(aux instanceof Paralelepipedo) {
						fila[0] = aux.getCodigo();
						fila[1] = ((Paralelepipedo) aux).getLongitud();
						fila[2] = ((Paralelepipedo) aux).getAltura();
						fila[3] = ((Paralelepipedo) aux).getAnchura();
						fila[4] = ((Paralelepipedo) aux).areaLateral();
						fila[5] = ((Paralelepipedo) aux).areaBase();
						fila[6] = ((Paralelepipedo) aux).area();
						fila[7] = ((Paralelepipedo) aux).volumen();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			default:
				break;
			}
			
		}
		else {
			
			switch (seleccion) {
			case 0://Todos
				String[] columnNames0 = {"C�digo", "Tipo","�rea","Volumen"};
				tableModel.setColumnIdentifiers(columnNames0);
				fila = new Object[tableModel.getColumnCount()];//Esto hace que las filas se ajusten a 
				//la cantidad de columnas seg�n el tipo de figura a visualizar en la tabla.
				for (Figura aux : centro.getFiguras()) {
					fila[0] = aux.getCodigo();
					if(aux instanceof Cilindro)
						fila[1] = "Cil�ndro";
					if(aux instanceof Cono)
						fila[1] = "Cono";
					if(aux instanceof Cubo)
						fila[1] = "Cubo";
					if(aux instanceof Esfera)
						fila[1] = "Esfera";
					if(aux instanceof Paralelepipedo)
						fila[1] = "Paralelep�pedo";
					fila[2] = aux.area();
					fila[3] = aux.volumen();
					
					tableModel.addRow(fila);
				}
				break;
				
			case 1://Cilindros
				String[] columnNames1 = {"C�digo","Radio", "Altura","�rea L.","�rea B.","�rea Total"};
				tableModel.setColumnIdentifiers(columnNames1);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getFiguras()) {
					if(aux instanceof Cilindro) {
						fila[0] = ((Cilindro) aux).getCodigo();
						fila[1] = ((Cilindro) aux).getRadio();
						fila[2] = ((Cilindro) aux).getAltura();
						fila[3] = ((Cilindro) aux).areaLateral();
						fila[4] = ((Cilindro) aux).areaBase();
						fila[5] = ((Cilindro) aux).area();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 2://Conos
				String[] columnNames2 = {"C�digo","Radio", "Altura","�rea L.","�rea B.","�rea Total"};
				tableModel.setColumnIdentifiers(columnNames2);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getFiguras()) {
					if(aux instanceof Cono) {
						fila[0] = ((Cono) aux).getCodigo();
						fila[1] = ((Cono) aux).getRadio();
						fila[2] = ((Cono) aux).getAltura();
						fila[3] = ((Cono) aux).areaLateral();
						fila[4] = ((Cono) aux).areaBase();
						fila[5] = ((Cono) aux).area();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 3://Cubos
				String[] columnNames3 = {"C�digo","Tama�o","�rea Total","Volumen"};
				tableModel.setColumnIdentifiers(columnNames3);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getFiguras()) {
					if(aux instanceof Cubo) {
						fila[0] = ((Cubo) aux).getCodigo();
						fila[1] = ((Cubo) aux).getTamano();
						fila[2] = ((Cubo) aux).area();
						fila[3] = ((Cubo) aux).volumen();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 4://Esferas
				String[] columnNames4 = {"C�digo","Radio", "�rea Total","Volumen"};
				tableModel.setColumnIdentifiers(columnNames4);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getFiguras()) {
					if(aux instanceof Esfera) {
						fila[0] = ((Esfera) aux).getCodigo();
						fila[1] = ((Esfera) aux).getRadio();
						fila[2] = ((Esfera) aux).area();
						fila[3] = ((Esfera) aux).volumen();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			case 5://Paralelep�pedos
				String[] columnNames5 = {"C�digo","Longitud", "Altura","Anchura","�rea L.","�rea B.","�rea Total","Volumen"};
				tableModel.setColumnIdentifiers(columnNames5);
				fila = new Object[tableModel.getColumnCount()];
				for (Figura aux : centro.getFiguras()) {
					if(aux instanceof Paralelepipedo) {
						fila[0] = aux.getCodigo();
						fila[1] = ((Paralelepipedo) aux).getLongitud();
						fila[2] = ((Paralelepipedo) aux).getAltura();
						fila[3] = ((Paralelepipedo) aux).getAnchura();
						fila[4] = ((Paralelepipedo) aux).areaLateral();
						fila[5] = ((Paralelepipedo) aux).areaBase();
						fila[6] = ((Paralelepipedo) aux).area();
						fila[7] = ((Paralelepipedo) aux).volumen();
						
						tableModel.addRow(fila);
					}
				}
				break;
				
			default:
				break;
			}
		}
		//PARA LAS OPCIONES EN TABLA
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);	
	}
}
			