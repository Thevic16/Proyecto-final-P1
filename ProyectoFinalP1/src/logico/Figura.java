package logico;

public abstract class Figura {
	protected String codigo;
	
	public Figura(String codigo) {
		super();
		this.codigo = codigo;
	}
	
	public abstract float area();
	public abstract float volumen();


}
