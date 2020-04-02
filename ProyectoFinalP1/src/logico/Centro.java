package logico;

import java.util.ArrayList;



public class Centro {
	private ArrayList<Figura>figuras; 
	private ArrayList<Usuario>usuarios;
	private Usuario loginUser;
	
	private static Centro centro; // primer paso singleton 

	private Centro() { //segundo paso singleton 
		// TODO Auto-generated constructor stub
		this.figuras = new ArrayList<Figura>();
		this.setUsuarios(new ArrayList<Usuario>());
	}

	public static Centro getInstance() { // tercer paso, tiene que ser estatica para que no dependa de la clase.
		if(centro  ==null) {
			centro = new Centro();
		}
		return centro;
	}
	
	public ArrayList<Figura> getFigura() {
		return figuras;
	}

	public void setFigura(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean confirmLogin(String id, String password) {
		boolean login = false;
		for (Usuario user : usuarios) {
			if(user.getID().equals(id)){
				if(user.getPassword().equals(password)) {
					login = true;
					loginUser = user;
				}
			
			}
		}
		//condicion para el administrador
		if(id.equals("Admin") && password.equals("Admin")) {
			login = true;
		}
				
		return login;
	}
	
	
}
