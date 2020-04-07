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
	public boolean removeUser(Usuario user) {
		boolean hecho = true;
		
		Usuario aux = user;
		
		if(user instanceof Profesor) {
			if(((Profesor) user).getEstudiantes().size() !=0) {
				hecho = false; // si el profesor tiene estudiantes no se puede. 
			}
		}
		
		if(hecho) {
			usuarios.remove(aux);
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
	
	
	public int[] getCantidadFigurasByTipo() {
		int [] cantidad = new int[5];
		
		for (Figura figu : figuras) {
			if(figu instanceof Cilindro) {
				cantidad[0]++;
			}
			else if(figu instanceof Cono) {
				cantidad[1]++;
			}
			else if(figu instanceof Cubo) {
				cantidad[2]++;
			}
			else if(figu instanceof Esfera) {
				cantidad[3]++;
			}
			else if(figu instanceof Paralelepipedo) {
				cantidad[4]++;
			}
			
		}
		
		return cantidad;
	}
	
	public int promedioAreaCilindros(){
		
		float suma = 0;
		int contador = 0;
		
		for (Figura figura : figuras) {
			if(figura instanceof Cilindro) {
				suma += figura.area();
				contador++;
			}
			
		}
		
		return (int) (suma/contador);
		
	}
	
	public int promedioAreaConos(){
		
		float suma = 0;
		int contador = 0;
		
		for (Figura figura : figuras) {
			if(figura instanceof Cono) {
				suma += figura.area();
				contador++;
			}
			
		}
		
		return (int) (suma/contador);
		
	}
	
	public int promedioAreaCubos(){
		
		float suma = 0;
		int contador = 0;
		
		for (Figura figura : figuras) {
			if(figura instanceof Cubo) {
				suma += figura.area();
				contador++;
			}
			
		}
		
		return (int) (suma/contador);
		
	}
	
	public int promedioAreaEsferas(){
		
		float suma = 0;
		int contador = 0;
		
		for (Figura figura : figuras) {
			if(figura instanceof Esfera) {
				suma += figura.area();
				contador++;
			}
			
		}
		
		return (int) (suma/contador);
		
	}
	
	public int promedioAreaParalelepidedos(){
		
		float suma = 0;
		int contador = 0;
		
		for (Figura figura : figuras) {
			if(figura instanceof Paralelepipedo) {
				suma += figura.area();
				contador++;
			}
			
		}
		
		return (int) (suma/contador);
		
	}
	

		public int promedioVolumenCilindros(){
		
		float suma = 0;
		int contador = 0;
		
		for (Figura figura : figuras) {
			if(figura instanceof Cilindro) {
				suma += figura.volumen();
				contador++;
			}

		}
		
		return (int) (suma/contador);
		
	}
	
		public int promedioVolumenEsferas(){
			
			float suma = 0;
			int contador = 0;
			
			for (Figura figura : figuras) {
				if(figura instanceof Esfera) {
					suma += figura.volumen();
					contador++;
				}

			}
			
			return (int) (suma/contador);
			
		}
		
		public int promedioVolumenConos(){
			
			float suma = 0;
			int contador = 0;
			
			for (Figura figura : figuras) {
				if(figura instanceof Cono) {
					suma += figura.volumen();
					contador++;
				}

			}
			
			return (int) (suma/contador);
			
		}
	
		public int promedioVolumenCubo(){
			
			float suma = 0;
			int contador = 0;
			
			for (Figura figura : figuras) {
				if(figura instanceof Cubo) {
					suma += figura.volumen();
					contador++;
				}

			}
			
			return (int) (suma/contador);
			
		}
		
		public int promedioVolumenParalelepipedos(){
			
			float suma = 0;
			int contador = 0;
			
			for (Figura figura : figuras) {
				if(figura instanceof Paralelepipedo) {
					suma += figura.volumen();
					contador++;
				}

			}
			
			return (int) (suma/contador);
			
		}
		
		//Arreglos de arreglos 
		public ArrayList<ArrayList<Figura>> getFigurasByTipo(){
	        ArrayList<ArrayList<Figura> > FigurasByTipo =  new ArrayList<ArrayList<Figura> >(); 
	        
	        ArrayList<Figura> Cilindrico = new ArrayList<Figura>();
	        ArrayList<Figura> Cono = new ArrayList<Figura>();
	        ArrayList<Figura> Cubo = new ArrayList<Figura>();
	        ArrayList<Figura> Esferico = new ArrayList<Figura>();
	        ArrayList<Figura> Paralelepipedo = new ArrayList<Figura>();
	        
			for(Figura figu:figuras) {
				if(figu instanceof Cilindro) {
					Cilindrico.add(figu);
				}
				else if(figu instanceof Cono) {
					Cono.add(figu);
				}
				else if(figu instanceof Cubo) {
					Cubo.add(figu);
				}
				else if(figu instanceof Esfera) {
					Esferico.add(figu);
				}
				else if(figu instanceof Paralelepipedo) {
					Paralelepipedo.add(figu);
				}
				
	
			}
			FigurasByTipo.add(Cilindrico);
			FigurasByTipo.add(Cono);
			FigurasByTipo.add(Cubo);
			FigurasByTipo.add(Esferico);
			FigurasByTipo.add(Paralelepipedo);

			return FigurasByTipo;	
		}
	
		//Arreglos de arreglos 
		public ArrayList<ArrayList<Usuario>> getUsuariosByTipo(){
	        ArrayList<ArrayList<Usuario> > UsuariosByTipo =  new ArrayList<ArrayList<Usuario> >(); 
	        
	        ArrayList<Usuario> estudiantes = new ArrayList<Usuario>();
	        ArrayList<Usuario> profesores = new ArrayList<Usuario>();

	        
			for(Usuario user:usuarios) {
				if(user instanceof Estudiante) {
					estudiantes.add(user);
				}
				else if(user instanceof Profesor) {
					profesores.add(user);
				}
			}
			UsuariosByTipo.add(estudiantes);
			UsuariosByTipo.add(profesores);

			
			return UsuariosByTipo;	
		}
}
