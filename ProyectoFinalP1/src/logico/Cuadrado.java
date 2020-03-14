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
	
	/*
	Metodo: verticesCuadrado.
	Argumentos: no tiene.
	Objetivo: obtener todos los vertices del cuadrado.
	Retorno: ArrayList<Vertice>
	*/
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

	/*
	Metodo: isIgualX.
	Argumentos: no tiene.
	Objetivo: determinar los vertices del cuadrados son iguales en el eje x
	Retorno: boolean
	*/
	private boolean isIgualX() {
		// TODO Auto-generated method stub
		boolean igual = false;
		
		if(v1.getX() == v2.getX()) {
			igual = true;
		}
		
		return igual;
	}
	
	/*
	Metodo: isIgualY.
	Argumentos: no tiene.
	Objetivo: determinar los vertices del cuadrados son iguales en el eje y
	Retorno: boolean
	*/
	private boolean isIgualY() {
		// TODO Auto-generated method stub
		boolean igual = false;
		
		if(v1.getY() == v2.getY()) {
			igual = true;
		}
		
		return igual;
	}

	/*
	Metodo: isOpuesto.
	Argumentos: no tiene.
	Objetivo: determinar si los vertices ingresados en el usuario son opuestos.
	Retorno: boolean
	*/
	private boolean isOpuesto() {
		boolean opuesto = false;
		
		if(v1.getX() == v2.getY() && v2.getX() == v1.getY()) {
			opuesto = true;
		}
		
		return opuesto;
	}


	@Override
	public float perimetro() {
		return distanciaVertices(v1, v2)*4;
	}


	@Override
	public float areaBase() {
		return (float) Math.pow(distanciaVertices(v1, v2), 2);
	}
	
	
	/*
	Metodo: distanciaVertices.
	Argumentos: vertice va y vertice vb.
	Objetivo: determinar la distancia entre dos vertices dados.
	Retorno: float
	
	-Esta es una funcion auxiliar que nos sirve para determinar la distancia entre dos vertices selecionardos de una clase,
	es decir te permite seleccionar entre cuales vertites deseas ver la distancia no esta predefinido.
	
	*/
	public float distanciaVertices(Vertice va,Vertice vb) {
		float distancia = super.distanciaVertices(v1, v2);
		
		if(isOpuesto()) {
			distancia = (float) (distancia/Math.sqrt(2));
		}
		
		return distancia;
	}


}
