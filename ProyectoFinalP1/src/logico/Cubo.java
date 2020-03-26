package logico;

public class Cubo extends Figura {
	private float tamano;

	public Cubo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public float area() {
		// TODO Auto-generated method stub
		return (float) (6*Math.pow(tamano, 2));
	}

	@Override
	public float volumen() {
		// TODO Auto-generated method stub
		return (float) Math.pow(tamano, 3);
	}

	public float getTamano() {
		return tamano;
	}

	public void setTamano(float tamano) {
		this.tamano = tamano;
	}

}
