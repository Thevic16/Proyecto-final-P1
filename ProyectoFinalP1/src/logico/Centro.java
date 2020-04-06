package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Centro implements Serializable {
	private ArrayList<Figura>figuras; 
	private ArrayList<Usuario>usuarios;
	private int cantUsuarios;
	private Usuario loginUser;
	
	private boolean loginAdmin = false; // si es verdadero se inicio seccion el administrador. 
	
	private static int codigoFiguras = 0;
	
	private static Centro centro; // primer paso singleton 

	private Centro() { //segundo paso singleton 
		// TODO Auto-generated constructor stub
		this.figuras = new ArrayList<Figura>();
		this.setUsuarios(new ArrayList<Usuario>());
		this.cantUsuarios = 0;
		
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
	
	public void insertUsuario(Usuario user) {
		usuarios.add(user);
		cantUsuarios++;
	}
	
	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}

	public int getCantUsuarios() {
		return cantUsuarios;
	}

	public void setCantUsuarios(int cantUsuarios) {
		this.cantUsuarios = cantUsuarios;
	}

	public int getCodigoFiguras() {
		return codigoFiguras;
	}

	public void setCodigoFiguras(int codigoFiguras) {
		Centro.codigoFiguras = codigoFiguras;
	}

	public void insertFigura(Figura figura) {
		codigoFiguras++;
		figuras.add(figura);
	}
	public boolean removeUser(int indice) {
		boolean hecho = true;
		
		Usuario user = usuarios.get(indice); 
		
		if(user instanceof Profesor) {
			if(((Profesor) user).getEstudiantes().size() ==0) {
				hecho = false; // si el profesor tiene estudiantes no se puede. 
			}
		}
		
		if(hecho) {
			usuarios.remove(indice);
		}
		return hecho;
		
	}
	
	public boolean confirmLogin(String id, String password) {
		boolean login = false;
		System.out.println("Usuarios size:"+usuarios.size());
		for (Usuario user : usuarios) {
			System.out.println("Id:"+user.getID());
			System.out.println("password:"+user.getPassword());
			if(user.getID().equals(id)){
				if(user.getPassword().equals(password)) {
					login = true;
					setLoginUser(user);
				}
			
			}
		}
				
		return login;
	}

	public Usuario getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Usuario loginUser) {
		this.loginUser = loginUser;
	}

	public boolean isLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(boolean loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	
	
	
	
}
