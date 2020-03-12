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
	
	
	public ArrayList<Vertice> verticesCuadrado(Vertice v1, Vertice v2){
		
		ArrayList<Vertice>aux = new ArrayList<Vertice>();
		aux.add(v1);
		aux.add(v2);
		//vertices que queremos determinar. 
		Vertice v3 = null;
		Vertice v4 = null;
		
		if(isOpuesto(v1,v2)) {
			v3 = new Vertice(v1.getX(), v2.getY());
			v4 = new Vertice(v2.getX(), v1.getY());
		}
		else if (isParalelo(v1,v2) && !(areIguales(v1, v2))) {
			v3 = new Vertice(v1.getY(), v1.getX());
			v4 = new Vertice(v2.getY(), v2.getX()); 
		}
		aux.add(v3);
		aux.add(v4);
		
		return aux;
		
	}

	private boolean isParalelo(Vertice v1, Vertice v2) {
		// TODO Auto-generated method stub
		boolean paralelo = false;
		
		if(v1.getX() == v2.getX()) {
			paralelo = true;
		}
		if(v1.getY() == v2.getY()) {
			paralelo = true;
		}
		
		return paralelo;
	}

	
	private boolean isOpuesto(Vertice v1, Vertice v2) {
		boolean opuesto = false;
		
		if(v1.getX() == v2.getY() && v2.getX() == v1.getY()) {
			opuesto = true;
		}
		
		return opuesto;
	}
	
	
	public static boolean areIguales(Vertice v1, Vertice v2) {
		boolean iguales = false;
		
		if(v1.getX() == v2.getX() && v1.getY() == v2.getY()) {
			iguales = true;
		}
		
		return iguales;
	}

}
