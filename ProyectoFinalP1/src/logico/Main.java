package logico;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertice v1 = new Vertice(12,3);
		Vertice v2 = new Vertice(6,3);
		
		Cuadrado C1 = new Cuadrado(2, v1, v2);
		
		ArrayList<Vertice>aux = C1.verticesCuadrado();
		
		for (Vertice vertice : aux) {
			System.out.println(vertice.getX()+","+vertice.getY());
			System.out.println(" ");
		}

	}

}
