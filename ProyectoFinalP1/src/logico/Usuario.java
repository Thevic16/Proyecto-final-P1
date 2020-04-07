package logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Usuario implements Serializable {
	protected String nombre;
	protected String ID;
	protected String apellido;
	protected String password;
	protected ArrayList<Figura>figuras;
	
	public Usuario(String nombre, String iD, String apellido, String password) {
		super();
		this.nombre = nombre;
		ID = iD;
		this.apellido = apellido;
		this.password = password;
		this.figuras = new ArrayList<Figura>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}

	public void insertFigura(Figura figura) {
		figuras.add(figura);
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
		

}
