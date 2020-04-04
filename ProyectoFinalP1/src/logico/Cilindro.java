package logico;

public class Cilindro extends Figura {
	protected float radio;
	protected float altura;

	public Cilindro(String codigo, float radio, float altura) {
		super(codigo);
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public float area() {
		// TODO Auto-generated method stub
		return areaLateral()+2*areaBase();
	}

	@Override
	public float volumen() {
		// TODO Auto-generated method stub
		return areaBase()*altura;
	}
	
	public float areaLateral() {
		// TODO Auto-generated method stub
		return (float) (2*Math.PI*radio*altura);
	}

	
	public float areaBase() {
		// TODO Auto-generated method stub
		return (float) (Math.PI*Math.pow(radio, 2));
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
