package logico;

import java.util.ArrayList;

public class Triangulo extends Prisma {
	private Vertice vh;

	public Triangulo(float altura, Vertice v1, Vertice v2, Vertice vh) {
		super(altura, v1, v2);
		this.vh = vh;
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
		aux.add(vh);
		return aux;
	}

	public Vertice getVh() {
		return vh;
	}

	public void setVh(Vertice vh) {
		this.vh = vh;
	}
	
	@Override
	public float perimetro() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float areaBase() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
