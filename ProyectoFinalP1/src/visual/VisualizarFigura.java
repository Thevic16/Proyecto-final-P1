//
package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import Figuras3D.Cilindro3D;
import Figuras3D.Cono3D;
import Figuras3D.Cubo3D;
import Figuras3D.Esfera3D;
import Figuras3D.Paralelepipedo3D;
import logico.Centro;
import logico.Cilindro;
import logico.Cono;
import logico.Cubo;
import logico.Esfera;
import logico.Figura;
import logico.Paralelepipedo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class VisualizarFigura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList<String> listFigura;
	private DefaultListModel<String> listFiguraModel;
	private Centro educativo;
	private JComboBox cbxFiguras;
	private JComboBox cbxColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Centro educativo = Centro.getInstance();
			VisualizarFigura dialog = new VisualizarFigura(educativo);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualizarFigura(Centro educativo) {
		this.educativo = educativo;
		setTitle("Visualizar Figura");
		setBounds(100, 100, 466, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel pnlInfoFigura = new JPanel();
		pnlInfoFigura.setBorder(new TitledBorder(null, "Informaci\u00F3n de Figura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInfoFigura.setBounds(10, 63, 231, 134);
		contentPanel.add(pnlInfoFigura);
		pnlInfoFigura.setLayout(null);
		
		cbxFiguras = new JComboBox();
		cbxFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listFiguraModel.removeAllElements();

				switch(cbxFiguras.getSelectedIndex()){
				
				case 0:
					loadFiguras(educativo);
					break;
				
				case 1:
					loadCilindros(educativo);
					break;
				
				case 2:
					loadConos(educativo);
					break;
				
				case 3:
					loadCubos(educativo);
					break;
				
				case 4:
					loadEsferas(educativo);
					break;
				
				case 5:
					loadParalelepipedos(educativo);
					break;				
				}
			}
				
		});
		cbxFiguras.setModel(new DefaultComboBoxModel(new String[] {"<Todas las Figuras>", "Cil\u00EDndro", "Cubo", "Cono", "Esfera", "Paralelep\u00EDpedo"}));
		cbxFiguras.setBounds(10, 22, 204, 22);
		pnlInfoFigura.add(cbxFiguras);
		
		JLabel lblNewLabel = new JLabel("Color de Figura\r\n");
		lblNewLabel.setBounds(10, 73, 96, 14);
		pnlInfoFigura.add(lblNewLabel);
		
		cbxColor = new JComboBox();
		cbxColor.setModel(new DefaultComboBoxModel(new String[] {"<Lista de Colores>", "Amarillo", "Azul", "Blanco", "Cian", "Gris", "Gris claro", "Magenta", "Naranja", "Rojo", "Rosa", "Verde"}));
		cbxColor.setBounds(10, 98, 204, 22);
		pnlInfoFigura.add(cbxColor);
		
		JPanel pnlListFiguras = new JPanel();
		pnlListFiguras.setBorder(new TitledBorder(null, "Lista de Figuras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlListFiguras.setBounds(251, 11, 189, 240);
		contentPanel.add(pnlListFiguras);
		pnlListFiguras.setLayout(null);
		
		listFigura = new JList();
		listFigura.setBounds(10, 21, 169, 208);
		//loadFiguras(educativo);
		
		pnlListFiguras.add(listFigura);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnVisualizar = new JButton("Visualizar");
				btnVisualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!(listFigura.isSelectionEmpty())){
							String codeFigura = listFigura.getSelectedValue();
							Figura figure = educativo.findFiguraByCode(codeFigura);
							
							if(!(figure == null)) {
								visualizar(figure);
								Clean();
							}
						}						
					}
				});
				btnVisualizar.setActionCommand("OK");
				buttonPane.add(btnVisualizar);
				getRootPane().setDefaultButton(btnVisualizar);
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
	}
	
	public void visualizar(Figura figure) {
		
		if(figure instanceof Cilindro) {
			Cilindro3D.VisualizarFigura("Cilindro", (((Cilindro) figure).getRadio())/100, (((Cilindro) figure).getAltura())/100, colorFigura());
		}
		if(figure instanceof Cono) {
			Cono3D.VisualizarFigura("Cono", (((Cilindro) figure).getRadio())/100, (((Cilindro) figure).getAltura())/100, colorFigura());
		}
		if(figure instanceof Cubo) {
			Cubo3D.VisualizarFigura("Cubo", (((Cilindro) figure).getRadio())/100, colorFigura());
		}
		if(figure instanceof Esfera) {
			Esfera3D.VisualizarFigura("Esfera", (((Cilindro) figure).getRadio())/100, colorFigura());
		}
		if(figure instanceof Paralelepipedo) {
			Paralelepipedo3D.VisualizarFigura("Paralelepipedo", (((Paralelepipedo) figure).getLongitud())/100, (((Paralelepipedo) figure).getAltura())/100, (((Paralelepipedo) figure).getAnchura())/100, colorFigura());
		}		
	}
	
	public String colorFigura() {
		String color = null;
		
		switch(cbxColor.getSelectedIndex()) {
		case 0:
			color = null;
			break;
		case 1:
			color = "Amarillo";
			break;
		case 2:
			color = "Azul";
			break;
		
		case 3:
			color = "Blanco";
			break;
		
		case 4:
			color = "Cian";
			break;
		
		case 5:
			color = "Gris";
			break;
		
		case 6:
			color = "Gris claro";
			break;
			
		case 7: 
			color = "Magenta";
			break;
			
		case 8:
			color = "Naranja";
			break;
		
		case 9:
			color = "Rojo";
			break;
			
		case 10:
			color = "Rosa";
			break;
			
		case 11:
			color = "Verde";
			break;	
		}
		
		return color;
	}
	
	public void loadFiguras(Centro educativo){
		listFiguraModel.removeAllElements();
		
		if(!(educativo.getFiguras().isEmpty())) {	
			for (Figura figure : educativo.getFiguras()) {
				listFiguraModel.addElement(figure.getCodigo());
				listFigura.setModel(listFiguraModel);
			}
		}
	}
	
	public void loadCilindros(Centro educativo){
		listFiguraModel.removeAllElements();
		
		for (Figura figure : educativo.getFiguras()) {
			if(figure instanceof Cilindro) {
				listFiguraModel.addElement(figure.getCodigo());
				listFigura.setModel(listFiguraModel);
			}
		}
	}
	
	public void loadConos(Centro educativo){
		listFiguraModel.removeAllElements();
		
		for (Figura figure : educativo.getFiguras()) {
			if(figure instanceof Cono) {
				listFiguraModel.addElement(figure.getCodigo());
				listFigura.setModel(listFiguraModel);
			}
		}
	}
	
	public void loadCubos(Centro educativo){
		listFiguraModel.removeAllElements();
		
		for (Figura figure : educativo.getFiguras()) {
			if(figure instanceof Cubo) {
				listFiguraModel.addElement(figure.getCodigo());
				listFigura.setModel(listFiguraModel);
			}
		}
	}
	
	public void loadEsferas(Centro educativo){
		listFiguraModel.removeAllElements();
		
		for (Figura figure : educativo.getFiguras()) {
			if(figure instanceof Esfera) {
				listFiguraModel.addElement(figure.getCodigo());
				listFigura.setModel(listFiguraModel);
			}
		}
	}
	public void loadParalelepipedos(Centro educativo){
		listFiguraModel.removeAllElements();
		
		for (Figura figure : educativo.getFiguras()) {
			if(figure instanceof Paralelepipedo) {
				listFiguraModel.addElement(figure.getCodigo());
				listFigura.setModel(listFiguraModel);
			}
		}
	}
	
	public void Clean() {
		cbxColor.setSelectedIndex(0);
		cbxFiguras.setSelectedIndex(0);
	}
}
