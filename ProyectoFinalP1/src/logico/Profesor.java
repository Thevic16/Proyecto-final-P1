package logico;

import java.util.ArrayList;

public class Profesor extends Usuario {
	
	private ArrayList<Estudiante>estudiantes; 

	public Profesor(String nombre, String iD, String apellido, String password) {
		super(nombre, iD, apellido, password);
		// TODO Auto-generated constructor stub
		this.estudiantes = new ArrayList<Estudiante>();
	}

	
	
}
