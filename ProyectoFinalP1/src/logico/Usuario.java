package logico;

import java.util.ArrayList;

public abstract class Usuario {
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

}
