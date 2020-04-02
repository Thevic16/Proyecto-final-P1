package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setTitle("Registrar");
		setBounds(100, 100, 481, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Informaci\u00F3n de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Seleccione su Ocupaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 28, 445, 53);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Profesor");
		rdbtnNewRadioButton.setBounds(101, 17, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Estudiante");
		rdbtnNewRadioButton_1.setBounds(227, 17, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Infomaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 96, 445, 174);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setBounds(10, 31, 46, 14);
			panel_1.add(lblNewLabel);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(88, 28, 266, 20);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre");
			lblNewLabel_1.setBounds(10, 67, 46, 14);
			panel_1.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
			lblNewLabel_2.setBounds(10, 140, 76, 14);
			panel_1.add(lblNewLabel_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(88, 64, 266, 20);
			panel_1.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Apellido(s)");
			lblNewLabel_3.setBounds(10, 103, 62, 14);
			panel_1.add(lblNewLabel_3);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(88, 100, 266, 20);
			panel_1.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField = new JTextField();
			textField.setBounds(88, 137, 266, 20);
			panel_1.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
