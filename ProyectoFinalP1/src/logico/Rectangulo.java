package logico;

import java.util.ArrayList;

public class Rectangulo extends Prisma {
	private Vertice v3;

	public Rectangulo(float altura, Vertice v1, Vertice v2,Vertice v3) {
		super(altura, v1, v2);
		// TODO Auto-generated constructor stub
		this.v3=v3;
	}

	public Vertice getV3() {
		return v3;
	}

	public void setV3(Vertice v3) {
		this.v3 = v3;
	}

	@Override
	public ArrayList<Vertice> getVertices() {
		ArrayList<Vertice>aux = new ArrayList<Vertice>();
		aux.add(v1);
		aux.add(v2);
		aux.add(v3);
		//vertices que queremos determinar. 
		Vertice v4 = new Vertice(getParejafaltante(v1.getX(),v2.getX(),v3.getX()),getParejafaltante(v1.getY(),v2.getY(),v3.getY()));
		

		aux.add(v4);
		
		return aux;
	}

	@Override
	public float perimetro() {
		// TODO Auto-generated method stub
		return getBaseArea()*2 +getAlturaArea()*2;
	}

	@Override
	public float areaBase() {
		// TODO Auto-generated method stub
		return getBaseArea()*getAlturaArea();
	}
	

	private float getParejafaltante(float a, float b, float c) {
		// TODO Auto-generated method stub
		float alone=0;
		
		if(a==b && c!=a && c!= b) {
			alone = c;
		}
		else if(a==c && b!=a && b!= c) {
			alone = b;
		}
		else if(b==c && a!=b && a!= c) {
			alone = a;
		}
		
		return alone;
	}
	
	
	public float getAlturaArea() {
		ArrayList<Vertice>aux = getVertices();
		float altura =0;
		
		if(sonIgualesEnX(aux.get(0),aux.get(1))) {
			altura = distanciaVertices(aux.get(0), aux.get(1));
		}
		else if(sonIgualesEnX(aux.get(0),aux.get(2))) {
			altura = distanciaVertices(aux.get(0), aux.get(2));
		}
		else if(sonIgualesEnX(aux.get(0),aux.get(3))) {
			altura = distanciaVertices(aux.get(0), aux.get(3));
		}
		else if(sonIgualesEnX(aux.get(1),aux.get(2))) {
			altura = distanciaVertices(aux.get(1), aux.get(2));
		}
		else if(sonIgualesEnX(aux.get(1),aux.get(3))) {
			altura = distanciaVertices(aux.get(1), aux.get(3));
		}
		else if(sonIgualesEnX(aux.get(2),aux.get(3))) {
			altura = distanciaVertices(aux.get(2), aux.get(3));
		}
		
		return altura;
		
	}

	private boolean sonIgualesEnX(Vertice vertice, Vertice vertice2) {
		// TODO Auto-generated method stub
		boolean iguales = false;
		if(vertice.getX() == vertice2.getX()) {
			iguales =true;
		}
		
		return iguales;
	}
	
	public float getBaseArea() {
		ArrayList<Vertice>aux = getVertices();
		float base =0;
		
		if(sonIgualesEnY(aux.get(0),aux.get(1))) {
			base = distanciaVertices(aux.get(0), aux.get(1));
		}
		else if(sonIgualesEnY(aux.get(0),aux.get(2))) {
			base = distanciaVertices(aux.get(0), aux.get(2));
		}
		else if(sonIgualesEnY(aux.get(0),aux.get(3))) {
			base = distanciaVertices(aux.get(0), aux.get(3));
		}
		else if(sonIgualesEnY(aux.get(1),aux.get(2))) {
			base = distanciaVertices(aux.get(1), aux.get(2));
		}
		else if(sonIgualesEnY(aux.get(1),aux.get(3))) {
			base = distanciaVertices(aux.get(1), aux.get(3));
		}
		else if(sonIgualesEnY(aux.get(2),aux.get(3))) {
			base = distanciaVertices(aux.get(2), aux.get(3));
		}
		
		return base;
		
	}

	private boolean sonIgualesEnY(Vertice vertice, Vertice vertice2) {
		// TODO Auto-generated method stub
		boolean iguales = false;
		if(vertice.getY() == vertice2.getY()) {
			iguales =true;
		}
		
		return iguales;
	}
	
	

}
