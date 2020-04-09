//
package logico;

public class Main {

	// para probar la parte logica
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Cilindro:");
		Cilindro cilindro = new Cilindro("1", 1, 1);
		System.out.println("Radio:"+cilindro.getRadio());
		System.out.println("Altura:"+cilindro.getAltura());
		System.out.println("Area:"+cilindro.area());
		System.out.println("Volumen:"+cilindro.volumen());
		System.out.println("Area lateral:"+cilindro.areaLateral());
		System.out.println("Area Base:"+cilindro.areaBase());

		System.out.println("Cono:");
		Cono cono = new Cono("2", 1, 3);
		System.out.println("Radio:"+cono.getRadio());
		System.out.println("Altura:"+cono.getAltura());
		System.out.println("Area:"+cono.area());
		System.out.println("Volumen:"+cono.volumen());
		System.out.println("Area lateral:"+cono.areaLateral());
		System.out.println("Area Base:"+cono.areaBase());

		System.out.println("Cubo:");		
		Cubo cubo = new Cubo("2", 1);
		System.out.println("Tamano:"+cubo.getTamano());
		System.out.println("Area:"+cubo.area());
		System.out.println("Volumen:"+cubo.volumen());
		
		System.out.println("Esfera:");
		Esfera esfera = new Esfera("2", 1);
		System.out.println("Radio:"+esfera.getRadio());
		System.out.println("Area:"+esfera.area());
		System.out.println("Volumen:"+esfera.volumen());
		
		System.out.println("Paralelepipedo:");
		Paralelepipedo paralelepipedo = new Paralelepipedo("6", 1, 1, 1);
		System.out.println("Altura:"+paralelepipedo.getAltura());
		System.out.println("Anchura:"+paralelepipedo.getAnchura());
		System.out.println("Longitud::"+paralelepipedo.getLongitud());
		System.out.println("Area:"+paralelepipedo.area());
		System.out.println("Volumen:"+paralelepipedo.volumen());

	}
}
