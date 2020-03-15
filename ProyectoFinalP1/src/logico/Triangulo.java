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
		return getBaseTriangulo() + distanciaVertices(v1, vh)*2;
	}
	@Override
	public float areaBase() {
		// TODO Auto-generated method stub
		return (getBaseTriangulo()*getAlturaTriangulo())/2;
	}
	
	
	/*
	Metodo: getAlturaTriangulo().
	Argumentos: no tiene.
	Objetivo: obtener la altura del triangulo de la base del prisma.
	Retorno: float
	*/
	public float getAlturaTriangulo() {
		return (float) (Math.sin(getAnguloTriangulo())*distanciaVertices(v1, vh));
	}
	
	/*
	Metodo: getBaseTriangulo().
	Argumentos: no tiene.
	Objetivo: obtener la base del triangulo.
	Retorno: float
	*/
	public float getBaseTriangulo() {
		return (float) (distanciaVertices(v1, v2));
	}
	
	/*
	Metodo: getAnguloTriangulo().
	Argumentos: no tiene.
	Objetivo: obtener el angulo del triangulo, pero esta funcion solo aplica si el triangulo es isósceles.
	Retorno: float
	*/
	private float getAnguloTriangulo() {
		return (float) Math.acos((getBaseTriangulo()/2)/distanciaVertices(v1, vh));
	}
}
