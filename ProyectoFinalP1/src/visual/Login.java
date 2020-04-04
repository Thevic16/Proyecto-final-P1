package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.Centro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField IDtxt;
	private JTextField contrasenaTxt;
	private Centro centro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {		
				try {
					Login frame = new Login();
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
	public Login() {
		// cargar el centro y sus datos
		Centro aux = null;
		
		try {
			aux = cargarInstanceCentro();
		} catch (Exception e) {
			//System.out.println("Primera vez");
			aux = Centro.getInstance();
		}
		this.centro=aux;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("ID Usuario:");
		lblUsuario.setBounds(39, 39, 87, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(39, 98, 105, 14);
		panel.add(lblContrasea);
		
		IDtxt = new JTextField();
		IDtxt.setBounds(39, 64, 191, 20);
		panel.add(IDtxt);
		IDtxt.setColumns(10);
		
		contrasenaTxt = new JTextField();
		contrasenaTxt.setBounds(39, 128, 191, 20);
		panel.add(contrasenaTxt);
		contrasenaTxt.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(centro.confirmLogin(IDtxt.getText(), contrasenaTxt.getText())){
					Principal frame = new Principal(centro);
					dispose();
					frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error! ID o usuario no es el correcto!", "Información", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnLogin.setBounds(37, 175, 89, 23);
		panel.add(btnLogin);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegUsuario regUsuario = new RegUsuario(centro);
				regUsuario.setVisible(true);
			}
		});
		btnNewButton.setBounds(141, 175, 89, 23);
		panel.add(btnNewButton);
	}
	
	
	
	private Centro cargarInstanceCentro() throws IOException, ClassNotFoundException {
		
		Centro aux = null;
		
		FileInputStream f = new FileInputStream ("Centro.dat");
		ObjectInputStream oos = new ObjectInputStream(f);
			
		aux= (Centro) oos.readObject(); // aqui asigna el objeto
		
		f.close();
		oos.close();
		
		return aux;
	}
	//
}
