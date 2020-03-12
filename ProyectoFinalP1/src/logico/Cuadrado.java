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
	
	
	public ArrayList<Vertice> verticesCuadrado(){
		
		ArrayList<Vertice>aux = new ArrayList<Vertice>();
		aux.add(v1);
		aux.add(v2);
		//vertices que queremos determinar. 
		Vertice v3 = null;
		Vertice v4 = null;
		
		if(isOpuesto()) {
			v3 = new Vertice(v1.getX(), v2.getY());
			v4 = new Vertice(v2.getX(), v1.getY());
		}
		else if (isIgualY()) {
			v3 = new Vertice(v1.getX(),v1.getY()+distanciaVertices(v1, v2));
			v4 = new Vertice(v2.getX(),v2.getY()+distanciaVertices(v1, v2)); 
		}
		else if (isIgualX()) {
			v3 = new Vertice(v1.getX()+distanciaVertices(v1, v2),v1.getY());
			v4 = new Vertice(v2.getX()+distanciaVertices(v1, v2),v2.getY()); 
		}
		
		aux.add(v3);
		aux.add(v4);
		
		return aux;
		
	}

	private boolean isIgualX() {
		// TODO Auto-generated method stub
		boolean igual = false;
		
		if(v1.getX() == v2.getX()) {
			igual = true;
		}
		
		return igual;
	}
	
	private boolean isIgualY() {
		// TODO Auto-generated method stub
		boolean igual = false;
		
		if(v1.getY() == v2.getY()) {
			igual = true;
		}
		
		return igual;
	}

	
	private boolean isOpuesto() {
		boolean opuesto = false;
		
		if(v1.getX() == v2.getY() && v2.getX() == v1.getY()) {
			opuesto = true;
		}
		
		return opuesto;
	}
	
	
	


}
