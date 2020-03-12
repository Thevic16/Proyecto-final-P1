package logico;

import java.util.ArrayList;

public class Reporte {
	private float altura;
	private String tipoFiguraBase;
	private float volumen;
	private float areaLateral;
	private float areaTotal;
	private ArrayList<Vertice>vertices;
	
	public Reporte(Prisma prisma) {
		super();
		this.altura = prisma.getAltura();
		this.tipoFiguraBase = determinarTipo(prisma);
		
		//falta definir estas funciones
		/*
		 this.volumen = 
		 this.areaLateral = 
		 this.areaTotal = 
		 * */
		
		this.vertices = prisma.getVertices();
		
	}

	/*
	Metodo: determinarTipo
	Argumentos: Prisma prisma
	Objetivo: determinar el tipo al que pertenece el objeto prisma.
	Retorno: String.
	*/
	private String determinarTipo(Prisma prisma) {
		String tipo="";
		
		if(prisma instanceof Cuadrado) {
			tipo ="Cuadrado";
		}
		else if(prisma instanceof Rombo) {
			tipo ="Rombo";
		}
		else if(prisma instanceof Trapecio) {
			tipo ="Trapecio";
		}
		else if(prisma instanceof Triangulo) {
			tipo ="Triangulo";
		}
		
		return tipo;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getTipoFiguraBase() {
		return tipoFiguraBase;
	}

	public void setTipoFiguraBase(String tipoFiguraBase) {
		this.tipoFiguraBase = tipoFiguraBase;
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public float getAreaLateral() {
		return areaLateral;
	}

	public void setAreaLateral(float areaLateral) {
		this.areaLateral = areaLateral;
	}

	public float getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(float areaTotal) {
		this.areaTotal = areaTotal;
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}
	
	//c

}
