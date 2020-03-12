package logico;

import java.util.ArrayList;

public class Cuadrado extends Prisma {

	public Cuadrado(float altura, Vertice v1, Vertice v2) {
		super(altura, v1, v2);
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
		
		return aux;
	}
	

}
