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

public class PrincipalProfesor extends JFrame {

	private JPanel contentPane;
	private Centro centro;
	private Dimension dim = null; // para ajustar el tamaño de la ventana

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
	public PrincipalProfesor(Centro centroCargado) {
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
		
		JMenu mnEstudiantes = new JMenu("Estudiantes");
		menuBar.add(mnEstudiantes);
		
		JMenuItem mntmMisEstudiantes = new JMenuItem("Mis Estudiantes");
		mntmMisEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEstudiantes listaEstudiantes = new ListaEstudiantes(centro);
				listaEstudiantes.setVisible(true);
			}
		});
		mnEstudiantes.add(mntmMisEstudiantes);
		
		JMenuItem mntmFigurasEstudiantes = new JMenuItem("Figuras de Estudiantes");
		mnEstudiantes.add(mntmFigurasEstudiantes);
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