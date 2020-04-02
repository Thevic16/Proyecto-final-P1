package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearFigura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFiguraID;
	private JRadioButton rdbtnCilindro;
	private JRadioButton rdbtnCono;
	private JRadioButton rdbtnCubo;
	private JRadioButton rdbtnEsfera;
	private JRadioButton rdbtnParalelepipedo;
	private JPanel panelCilindroCono;
	private JPanel panelCubo;
	private JPanel panelEsfera;
	private JPanel panelParalelepipedo;

	/**
	 * Launch the application.as
	 */
	public static void main(String[] args) {
		try {
			CrearFigura dialog = new CrearFigura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearFigura() {
		setResizable(false);
		setTitle("Crear Figuras");
		setBounds(100, 100, 633, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelTipoFigura = new JPanel();
		panelTipoFigura.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Tipo de Figura", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTipoFigura.setBounds(10, 11, 427, 251);
		contentPanel.add(panelTipoFigura);
		panelTipoFigura.setLayout(null);
		
		JLabel lblfiguraID = new JLabel("Figura ID:");
		lblfiguraID.setBounds(10, 20, 65, 14);
		panelTipoFigura.add(lblfiguraID);
		
		txtFiguraID = new JTextField();
		txtFiguraID.setEditable(false);
		txtFiguraID.setBounds(66, 17, 82, 20);
		panelTipoFigura.add(txtFiguraID);
		txtFiguraID.setColumns(10);
		
		rdbtnCilindro = new JRadioButton("Cil\u00EDndro");
		rdbtnCilindro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apgagar los demas rbdtn
				rdbtnCilindro.setSelected(true);
				rdbtnCono.setSelected(false);
				rdbtnCubo.setSelected(false);
				rdbtnEsfera.setSelected(false);
				rdbtnParalelepipedo.setSelected(false);
				
				panelCilindroCono.setVisible(true);
				panelCubo.setVisible(false);
				panelEsfera.setVisible(false);
				panelParalelepipedo.setVisible(false);
			}
		});
		rdbtnCilindro.setSelected(true);
		rdbtnCilindro.setBounds(10, 41, 82, 23);
		panelTipoFigura.add(rdbtnCilindro);
		
		rdbtnCono = new JRadioButton("Cono");
		rdbtnCono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apgagar los demas rbdtn
				rdbtnCono.setSelected(true);
				rdbtnCilindro.setSelected(false);
				rdbtnCubo.setSelected(false);
				rdbtnEsfera.setSelected(false);
				rdbtnParalelepipedo.setSelected(false);
				
				panelCilindroCono.setVisible(true);
				panelCubo.setVisible(false);
				panelEsfera.setVisible(false);
				panelParalelepipedo.setVisible(false);
			}
		});
		rdbtnCono.setBounds(10, 81, 76, 23);
		panelTipoFigura.add(rdbtnCono);
		
		rdbtnCubo = new JRadioButton("Cubo");
		rdbtnCubo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apgagar los demas rbdtn
				rdbtnCono.setSelected(false);
				rdbtnCilindro.setSelected(false);
				rdbtnCubo.setSelected(true);
				rdbtnEsfera.setSelected(false);
				rdbtnParalelepipedo.setSelected(false);
				
				panelCilindroCono.setVisible(false);
				panelCubo.setVisible(true);
				panelEsfera.setVisible(false);
				panelParalelepipedo.setVisible(false);
			}
		});
		rdbtnCubo.setBounds(10, 125, 76, 23);
		panelTipoFigura.add(rdbtnCubo);
		
		rdbtnEsfera = new JRadioButton("Esfera");
		rdbtnEsfera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apgagar los demas rbdtn
				rdbtnCono.setSelected(false);
				rdbtnCilindro.setSelected(false);
				rdbtnCubo.setSelected(false);
				rdbtnEsfera.setSelected(true);
				rdbtnParalelepipedo.setSelected(false);
				
				panelCilindroCono.setVisible(false);
				panelCubo.setVisible(false);
				panelEsfera.setVisible(true);
				panelParalelepipedo.setVisible(false);
			}
		});
		rdbtnEsfera.setBounds(10, 169, 82, 23);
		panelTipoFigura.add(rdbtnEsfera);
		
		rdbtnParalelepipedo = new JRadioButton("Paralelep\u00EDpedo");
		rdbtnParalelepipedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apgagar los demas rbdtn
				rdbtnCono.setSelected(false);
				rdbtnCilindro.setSelected(false);
				rdbtnCubo.setSelected(false);
				rdbtnEsfera.setSelected(false);
				rdbtnParalelepipedo.setSelected(true);
				
				panelCilindroCono.setVisible(false);
				panelCubo.setVisible(false);
				panelEsfera.setVisible(false);
				panelParalelepipedo.setVisible(true);
			}
		});
		rdbtnParalelepipedo.setBounds(10, 210, 113, 23);
		panelTipoFigura.add(rdbtnParalelepipedo);
		
		JLabel lblFotoFigura = new JLabel("Imagen Figura");
		lblFotoFigura.setBounds(193, 42, 207, 188);
		panelTipoFigura.add(lblFotoFigura);
		
		panelCilindroCono = new JPanel();
		panelCilindroCono.setBounds(437, 11, 175, 251);
		contentPanel.add(panelCilindroCono);
		panelCilindroCono.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Par\u00E1metros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCilindroCono.setLayout(null);
		
		JLabel lblRadio = new JLabel("Radio:");
		lblRadio.setBounds(74, 62, 48, 14);
		panelCilindroCono.add(lblRadio);
		
		JSpinner spnRadio = new JSpinner();
		spnRadio.setBounds(59, 87, 73, 20);
		panelCilindroCono.add(spnRadio);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(74, 137, 48, 14);
		panelCilindroCono.add(lblAltura);
		
		JSpinner spnAltura = new JSpinner();
		spnAltura.setBounds(59, 162, 73, 20);
		panelCilindroCono.add(spnAltura);
		
		panelCubo = new JPanel();
		panelCubo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Par\u00E1metros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCubo.setBounds(437, 11, 175, 251);
		contentPanel.add(panelCubo);
		panelCubo.setLayout(null);
		
		JLabel lblTamanoCubo = new JLabel("Tama\u00F1o:");
		lblTamanoCubo.setBounds(68, 96, 60, 14);
		panelCubo.add(lblTamanoCubo);
		
		JSpinner spnTamanoCubo = new JSpinner();
		spnTamanoCubo.setBounds(52, 115, 71, 20);
		panelCubo.add(spnTamanoCubo);
		
		panelEsfera = new JPanel();
		panelEsfera.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Par\u00E1metros", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEsfera.setBounds(437, 11, 175, 251);
		contentPanel.add(panelEsfera);
		panelEsfera.setLayout(null);
		
		JLabel lblRadioEsfera = new JLabel("Radio:");
		lblRadioEsfera.setBounds(66, 90, 48, 14);
		panelEsfera.add(lblRadioEsfera);
		
		JSpinner spnRadioEsfera = new JSpinner();
		spnRadioEsfera.setBounds(55, 115, 64, 20);
		panelEsfera.add(spnRadioEsfera);
		
		panelParalelepipedo = new JPanel();
		panelParalelepipedo.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Par\u00E1metros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelParalelepipedo.setBounds(437, 11, 175, 251);
		contentPanel.add(panelParalelepipedo);
		panelParalelepipedo.setLayout(null);
		
		JLabel lblLongitudPp = new JLabel("Longitud:");
		lblLongitudPp.setBounds(62, 31, 61, 14);
		panelParalelepipedo.add(lblLongitudPp);
		
		JSpinner spnLongitudPp = new JSpinner();
		spnLongitudPp.setBounds(48, 51, 78, 20);
		panelParalelepipedo.add(spnLongitudPp);
		
		JLabel lblAlturaPp = new JLabel("Altura:");
		lblAlturaPp.setBounds(70, 93, 53, 14);
		panelParalelepipedo.add(lblAlturaPp);
		
		JSpinner spnAlturaPp = new JSpinner();
		spnAlturaPp.setBounds(48, 110, 78, 20);
		panelParalelepipedo.add(spnAlturaPp);
		
		JLabel lblAnchuraPp = new JLabel("Anchura:");
		lblAnchuraPp.setBounds(65, 158, 58, 14);
		panelParalelepipedo.add(lblAnchuraPp);
		
		JSpinner spnAnchuraPp = new JSpinner();
		spnAnchuraPp.setBounds(48, 175, 78, 20);
		panelParalelepipedo.add(spnAnchuraPp);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnCrear = new JButton("Crear");
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		//configuracion inicial paneles
		panelCilindroCono.setVisible(true);
		panelCubo.setVisible(false);
		panelEsfera.setVisible(false);
		panelParalelepipedo.setVisible(false);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
