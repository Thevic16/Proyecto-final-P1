package logico;

import java.util.ArrayList;

public class Profesor extends Usuario {
	
	private ArrayList<Estudiante>estudiantes; 

	public Profesor(String nombre, String iD, String apellido, String password) {
		super(nombre, iD, apellido, password);
		// TODO Auto-generated constructor stub
		this.setEstudiantes(new ArrayList<Estudiante>());
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public void insertarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
	public void eliminarEstudiante(Estudiante estudiante) {
		estudiantes.remove(estudiante);
	}
	
	
	public Estudiante buscarEstudianteByID(String ID) {
		Estudiante est = null;
		boolean find = false;
		int i = 0;
		while (i < estudiantes.size() && !find) {
			if(estudiantes.get(i).getID().equalsIgnoreCase(ID)){
				est = estudiantes.get(i);
				find = true;
			}
			i++;
		}
		return est;
	}
	
	public void removeEstudiante(Estudiante aux) {
		estudiantes.remove(aux);
	}
	
	
}
