package logico;

public class Boleta {
	private String codigo;
	private int precio;
	private Pelicula pelicula;
	private String sala;
	private String asiento;
	private String hora;

	
	public Boleta(String codigo, int precio, Pelicula pelicula, String sala, String asiento, String hora) {
		super();
		this.codigo = codigo;
		this.precio = precio;
		this.setPelicula(pelicula);
		this.sala = sala;
		this.asiento = asiento;
		this.hora = hora;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
	

}
