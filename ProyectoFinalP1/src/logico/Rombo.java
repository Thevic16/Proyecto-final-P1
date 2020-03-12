package logico;

import java.util.ArrayList;

public class Rombo extends Prisma {
	private Vertice v3;
	private Vertice v4;
	
	public Rombo(float altura, Vertice v1, Vertice v2, Vertice v3, Vertice v4) {
		super(altura, v1, v2);
		this.v3 = v3;
		this.v4 = v4;
	}
	/*
	Metodo: getVertices.
	Argumentos: no tiene.
	Objetivo: obtener los vertices de un objeto prisma.
	Retorno: ArrayList<Vertice>
	*/
	@Override
	public ArrayList<Vertice> getVertices() {
		// TODO Auto-generated method stub
		ArrayList<Vertice>aux = new ArrayList<Vertice>();
		aux.add(v1);
		aux.add(v2);
		aux.add(v3);
		aux.add(v4);
		
		return aux;
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
