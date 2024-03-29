package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.Centro;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalEstudiante extends JFrame {

	private JPanel contentPane;
	private Centro centro;
	private Dimension dim = null; // para ajustar el tama�o de la ventana

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Centro centro = Centro.getInstance();
				try {
					PrincipalEstudiante frame = new PrincipalEstudiante(centro);
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
	public PrincipalEstudiante(Centro centroCargado) {
		this.centro = centroCargado;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					guadarInstanceCentro(centro);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		
		//tamano de la ventana.
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Figuras");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Crear figura");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearFigura crearFigura = new CrearFigura(centro);
				crearFigura.setModal(true);
				crearFigura.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		JMenu mnEstadisticas = new JMenu("Estad\u00EDstica");
		menuBar.add(mnEstadisticas);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Figuras por cantidad ");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GraficoFigurasCreadas graficoFigurasCreadas = new GraficoFigurasCreadas(centro);
				graficoFigurasCreadas.setVisible(true);
			}
		});
		mnEstadisticas.add(mntmNewMenuItem_2);
		
		JMenuItem mntmPromedioAreasFiguras = new JMenuItem("Promedio areas figuras");
		mntmPromedioAreasFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromAreaGrafica promAreaGrafica = new PromAreaGrafica(centro);
				promAreaGrafica.setVisible(true);
			}
		});
		mnEstadisticas.add(mntmPromedioAreasFiguras);
		
		JMenuItem mntmPromedioVolumenFiguras = new JMenuItem("Promedio volumen figuras");
		mntmPromedioVolumenFiguras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromVolumenGrafica promVolumenGrafica = new PromVolumenGrafica(centro);
				promVolumenGrafica.setModal(true);
				promVolumenGrafica.setVisible(true);
			}
		});
		mnEstadisticas.add(mntmPromedioVolumenFiguras);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar figuras creadas");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FigurasCreadas figurasCreadas = new FigurasCreadas(centro);
				figurasCreadas.setModal(true);
				figurasCreadas.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar Figuras");
		mntmVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarFigura visual = new VisualizarFigura(centro);
				visual.setModal(true);
				visual.setVisible(true);
			}
		});
		mnNewMenu.add(mntmVisualizar);
		
		JMenu mnNewMenu_1 = new JMenu("Cuenta");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Informaci\u00F3n cuenta");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformacionCuenta informacionCuenta = new InformacionCuenta(centro.getLoginUser());
				informacionCuenta.setModal(true);
				informacionCuenta.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Modificar cuenta");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarUsuario modificarUsuario = new ModificarUsuario(centro.getLoginUser());
				modificarUsuario.setModal(true);
				modificarUsuario.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mi profesor");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProfesor modificarProfesor = new ModificarProfesor(centro);
				modificarProfesor.setModal(true);
				modificarProfesor.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	//guardar controladora
	private void guadarInstanceCentro(Centro centro) throws IOException {
		FileOutputStream f = new FileOutputStream ("Centro.dat");
		ObjectOutputStream oos 	= new ObjectOutputStream (f);
		
		oos.writeObject(centro);
					
	    oos.close();
	}

}
