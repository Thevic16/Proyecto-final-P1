package logico;

import java.util.ArrayList;

public class Profesor extends Usuario {
	
	private ArrayList<Estudiante>estudiantes; 

	public Profesor(String nombre, String iD, String usuario, String password, ArrayList<Figura> figuras) {
		super(nombre, iD, usuario, password, figuras);
		// TODO Auto-generated constructor stub
		this.estudiantes = new ArrayList<Estudiante>();
	}

	
	
}
