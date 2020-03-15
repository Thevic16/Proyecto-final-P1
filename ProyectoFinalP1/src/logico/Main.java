package logico;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//La prueba del cuadrado
		/*
		// TODO Auto-generated method stub
		Vertice v1 = new Vertice(-1,2);
		Vertice v2 = new Vertice(-3,2);
		
		Cuadrado C1 = new Cuadrado(2, v1, v2);
		
		ArrayList<Vertice>aux = C1.getVertices();
		
		for (Vertice vertice : aux) {
			System.out.println(vertice.getX()+","+vertice.getY());
			System.out.println(" ");
		}
		
		System.out.println("area de la base de prisma cuadrado: "+C1.areaBase());
		System.out.println("area lateral de prisma cuadrado: "+C1.areaLateral());
		System.out.println("area total de prisma cuadrado: "+C1.areaTotal());
		System.out.println("volumen de prisma cuadrado: "+C1.volumen());
		System.out.println("Distancia entre vertices: "+C1.distanciaVertices(v1, v2));
		*/
		
		//Prueba del Rectangulo.
		/*
		Vertice v1 = new Vertice(-6,1);
		Vertice v2 = new Vertice(-1,1);
		Vertice v3 = new Vertice(-6,6);
		
		Rectangulo R1 = new Rectangulo(2, v1, v2,v3);
		
		ArrayList<Vertice>aux = R1.getVertices();
		
		for (Vertice vertice : aux) {
			System.out.println(vertice.getX()+","+vertice.getY());
			System.out.println(" ");
		}
		
		System.out.println("area de la base de prisma Rectangulo: "+R1.areaBase());
		System.out.println("area lateral de prisma Rectangulo: "+R1.areaLateral());
		System.out.println("area total de prisma Rectangulo: "+R1.areaTotal());
		System.out.println("volumen de prisma Rectangulo: "+R1.volumen());
		System.out.println(" ");
		System.out.println("Altura del area: "+R1.getAlturaRectangulo());
		System.out.println("Base del area: "+R1.getBaseRectangulo() );
		*/
		
		
		//Prueba del Triangulo.
		/*
		Vertice v1 = new Vertice(2,2);
		Vertice v2 = new Vertice(7,2);
		Vertice vh = new Vertice(7,5);
		
		Triangulo T1 = new Triangulo(2, v1, v2,vh);
		
		ArrayList<Vertice>aux = T1.getVertices();
		
		for (Vertice vertice : aux) {
			System.out.println(vertice.getX()+","+vertice.getY());
			System.out.println(" ");
		}
		
		System.out.println("area de la base de prisma con base triangular: "+T1.areaBase());
		System.out.println("area lateral de prisma con base triangular: "+T1.areaLateral());
		System.out.println("area total de prisma con base triangularo: "+T1.areaTotal());
		System.out.println("volumen de prisma con base triangular: "+T1.volumen());
		System.out.println(" ");
		System.out.println("Altura del area: "+T1.getAlturaTriangulo());
		System.out.println("Base del area: "+T1.getBaseTriangulo());
		*/
		
	}

}
