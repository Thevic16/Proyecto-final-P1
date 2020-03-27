package logico;

public class Paralelepipedo extends Figura {
	private float longitud;
	private float altura;
	private float anchura;


	public Paralelepipedo(String codigo, float longitud, float altura, float anchura) {
		super(codigo);
		this.longitud = longitud;
		this.altura = altura;
		this.anchura = anchura;
	}

	@Override
	public float area() {
		// TODO Auto-generated method stub
		return areaLateral()+areaBase();
	}

	@Override
	public float volumen() {
		// TODO Auto-generated method stub
		return longitud*altura*anchura;
	}
	
	public float areaLateral() {
		// TODO Auto-generated method stub
		return 2*(longitud+anchura)*altura;
	}

	
	public float areaBase() {
		// TODO Auto-generated method stub
		return 2*longitud*anchura;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getAnchura() {
		return anchura;
	}

	public void setAnchura(float anchura) {
		this.anchura = anchura;
	}

}
