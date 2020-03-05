package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Banco Popular");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 600, 450);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegCliente = new JMenu("Registrar cliente");
		mnRegCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCliente regCliente = new RegCliente(); 
				regCliente.setModal(true);
				regCliente.setVisible(true);
			}
		});

		
		menuBar.add(mnRegCliente);
		
		JMenu mnCrearCuenta = new JMenu("Crear cuenta");
		menuBar.add(mnCrearCuenta);
		
		JMenu mnOperaciones = new JMenu("Operaciones");
		menuBar.add(mnOperaciones);
		
		JMenu mnIngresar = new JMenu("Ingresar");
		mnOperaciones.add(mnIngresar);
		
		JMenu mnRetirar = new JMenu("Retirar");
		mnOperaciones.add(mnRetirar);
		
		JMenu mnConsultSaldo = new JMenu("Consultar saldo");
		mnOperaciones.add(mnConsultSaldo);
		
		JMenu mnRevisionMensual = new JMenu("Revisi\u00F3n mensual");
		mnOperaciones.add(mnRevisionMensual);
		
		JMenu mnConsultPuntos = new JMenu("Consultar puntos");
		mnOperaciones.add(mnConsultPuntos);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.SOUTH);

	}

}

