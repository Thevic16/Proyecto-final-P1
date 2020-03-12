package logico;

public class Trapecio extends Prisma {
	private Vertice v3;
	private Vertice v4;
	
	public Trapecio(float altura, Vertice v1, Vertice v2, Vertice v3, Vertice v4) {
		super(altura, v1, v2);
		this.v3 = v3;
		this.v4 = v4;
	}
	public Vertice getV3() {
		return v3;
	}
	public void setV3(Vertice v3) {
		this.v3 = v3;
	}
	public Vertice getV4() {
		return v4;
	}
	public void setV4(Vertice v4) {
		this.v4 = v4;
	}
	
	

}
