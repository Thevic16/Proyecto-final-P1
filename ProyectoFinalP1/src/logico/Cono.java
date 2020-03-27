package logico;

public class Cono extends Figura {
	private float radio;
	private float altura;

	
	public Cono(String codigo, float radio, float altura) {
		super(codigo);
		this.radio = radio;
		this.altura = altura;
	}
	
	@Override
	public float area() {
		// TODO Auto-generated method stub
		return areaLateral()+areaBase();
	}

	@Override
	public float volumen() {
		// TODO Auto-generated method stub
		return (float) ((Math.PI*Math.pow(radio, 2)*altura)/3);
	}
	
	public float areaLateral() {
		// TODO Auto-generated method stub
		return (float) (Math.PI*radio*getG());
	}

	
	public float areaBase() {
		// TODO Auto-generated method stub
		return (float) (Math.PI*Math.pow(radio, 2));
	}
	
	private float getG() {
		return (float) Math.sqrt(Math.pow(radio, 2)+Math.pow(altura, 2));
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

}
