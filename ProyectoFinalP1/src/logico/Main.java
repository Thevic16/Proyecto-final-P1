package logico;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertice v1 = new Vertice(-1,2);
		Vertice v2 = new Vertice(-3,2);
		
		Cuadrado C1 = new Cuadrado(2, v1, v2);
		
		ArrayList<Vertice>aux = C1.verticesCuadrado();
		
		for (Vertice vertice : aux) {
			System.out.println(vertice.getX()+","+vertice.getY());
			System.out.println(" ");
		}
		
		System.out.println("area de la base de prisma cuadrado: "+C1.areaBase());
		System.out.println("area lateral de prisma cuadrado: "+C1.areaLateral());
		System.out.println("area total de prisma cuadrado: "+C1.areaTotal());
		System.out.println("volumen de prisma cuadrado: "+C1.volumen());
		
		System.out.println("Distancia entre vertices: "+C1.distanciaVertices(v1, v2));
	}

}
