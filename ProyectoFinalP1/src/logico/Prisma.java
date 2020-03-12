package logico;

import java.util.ArrayList;

public abstract class Prisma {
	protected float altura;
	protected Vertice v1;
	protected Vertice v2;
	
	public Prisma(float altura, Vertice v1, Vertice v2) {
		super();
		this.altura = altura;
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Vertice getV1() {
		return v1;
	}
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}
	public Vertice getV2() {
		return v2;
	}
	public void setV2(Vertice v2) {
		this.v2 = v2;
	}
	
	public abstract ArrayList<Vertice> getVertices();

	/*
	Metodo: distanciaVertices.
	Argumentos: vertice va y vertice vb.
	Objetivo: determinar la distancia entre dos vertices dados.
	Retorno: float
	
	-Esta es una funcion auxiliar que nos sirve para determinar la distancia entre dos vertices selecionardos de una clase,
	es decir te permite seleccionar entre cuales vertites deseas ver la distancia no esta predefinido.
	
	*/
	public float distanciaVertices(Vertice va,Vertice vb) {
		return (float) Math.sqrt(Math.pow((vb.getX()-va.getX()), 2)+Math.pow((vb.getY()-va.getY()), 2));
	}
	
	

}
