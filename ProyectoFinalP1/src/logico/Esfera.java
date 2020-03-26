package logico;

public class Esfera extends Figura {
	private float radio;

	public Esfera() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public float area() {
		// TODO Auto-generated method stub
		return (float) (4*Math.PI*Math.pow(radio, 2));
	}

	@Override
	public float volumen() {
		// TODO Auto-generated method stub
		return (float) (Math.PI*Math.pow(radio, 3)*4/3);
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

}
