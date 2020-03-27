package logico;

import java.util.ArrayList;

public class Centro {
	private ArrayList<Figura>figuras; 
	private ArrayList<Usuario>usuarios;

	public Centro() {
		// TODO Auto-generated constructor stub
		this.figuras = new ArrayList<Figura>();
		this.setUsuarios(new ArrayList<Usuario>());
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
	
	
}
