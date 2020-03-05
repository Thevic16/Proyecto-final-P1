package logico;

public class Empresa {
	private Cine[] cines;
	private Pelicula[] peliculas;
	private Boleta[] boletas;
	private int cantCine;
	private int cantPeli;
	private int cantBole;
	
	public Empresa() {
		super();
		this.cines = new Cine[30];
		this.peliculas = new Pelicula[100];
		this.boletas = new Boleta[300];
	}

	public Cine[] getCines() {
		return cines;
	}

	public void setCines(Cine[] cines) {
		this.cines = cines;
	}

	public Pelicula[] getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Pelicula[] peliculas) {
		this.peliculas = peliculas;
	}

	public Boleta[] getBoletas() {
		return boletas;
	}

	public void setBoletas(Boleta[] boletas) {
		this.boletas = boletas;
	}

	public int getCantCine() {
		return cantCine;
	}


	public int getCantPeli() {
		return cantPeli;
	}


	public int getCantBole() {
		return cantBole;
	}

	public Cine buscarCine(String codigo) {
		Cine aux = null;
		boolean encontrado = false;
		
		int i=0;
		
		while(!encontrado && i<cantCine) {
			if(codigo.equalsIgnoreCase(cines[i].getCodigo())) {
				aux = cines[i];
				encontrado = true;
			}
		}
		
		return aux;
	}
	
	public int diamayrecau(String codigo) {
		Cine aux = buscarCine(codigo);
		int dia = -1;
		
		if(aux != null) {
			dia = aux.diaMayRecau();
		}
		
		return dia;
	}
	
	public int ventasMesCines() {
		int suma =0;
		
		for(int i=0;i<cantCine;i++) {
			suma += cines[i].ventasMes();
		}
		return suma;
	}
	
	
	public String generoFavoritoCine(String codigo) {
		Cine aux = buscarCine(codigo);
		String favorito="";
		
		if(aux != null) {
			favorito = aux.generofav();
		}
		
		return favorito;
	}
	
	
	public Cine CineMayorproyeypeli(String nombrePeli) {
		int indCine = -1;
		int mayor = -1;
		
		for(int i=0;i<cantCine;i++) {
			if(mayor<cines[i].cantProyPeli(nombrePeli)) {
				mayor = cines[i].cantProyPeli(nombrePeli);
				indCine = i;
			}
		}
		
		return cines[indCine];
	}

}
