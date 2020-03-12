package logico;

public class Triangulo extends Prisma {
	private Vertice vh;

	public Triangulo(float altura, Vertice v1, Vertice v2, Vertice vh) {
		super(altura, v1, v2);
		this.vh = vh;
	}

	public Vertice getVh() {
		return vh;
	}

	public void setVh(Vertice vh) {
		this.vh = vh;
	}
	
	

}
