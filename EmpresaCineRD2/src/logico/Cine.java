package logico;

public class Cine {
	private String codigo;
	private String nombre;
	private int salas;
	private String provincia;
	private int[] recauda;
	private Boleta[] bole;
	private int cantBole;
	
	public Cine(String codigo, String nombre, int salas, String provincia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.salas = salas;
		this.provincia = provincia;
		this.recauda = new int[30];
		this.bole = new Boleta [50]; // Se debe hacer para los arreglos.
		this.cantBole = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalas() {
		return salas;
	}

	public void setSalas(int salas) {
		this.salas = salas;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int[] getRecauda() {
		return recauda;
	}

	public void setRecauda(int[] recauda) {
		this.recauda = recauda;
	}

	public Boleta[] getBole() {
		return bole;
	}

	public void setBole(Boleta[] bole) {
		this.bole = bole;
	}

	public int getCantBole() {
		return cantBole;
	}

	public int diaMayRecau() {
		int mayor = 0;
		int indMayor = -1;
		
		for(int i=0;i<30;i++) {
			if(mayor>recauda[i]) {
				mayor =recauda[i];
				indMayor =i;
			}
		}
		
		return indMayor;
	}

	public int ventasMes() {
		int suma =0;
		
		for(int i=0;i<30;i++) {
			suma += recauda[i];
		}
		
		return suma;
	}
	
	public String generofav() {
		int contAcc=0;
		int contCome=0;
		int contTerr=0;
		
		for(int i=0;i<cantBole;i++) {
			if("Acción".equalsIgnoreCase(bole[i].getPelicula().getGenero())) {
				contAcc++;
			}
			else if("Comedia".equalsIgnoreCase(bole[i].getPelicula().getGenero())) {
				contCome++;
			}
			else if("Terror".equalsIgnoreCase(bole[i].getPelicula().getGenero())) {
				contTerr++;
			}
		}
		
		return mayor(contAcc,contCome,contTerr);
		
	}

	private String mayor(int contAcc, int contCome, int contTerr) {
		String favorito="";
		
		if(contAcc>contCome && contAcc>contTerr) {
			favorito ="Acción";
		}
		else if (contCome > contAcc && contCome>contTerr) {
			favorito ="Comedia";
		}
		else if (contTerr>contAcc&&contTerr>contCome) {
			favorito ="Terror";
		}
		
		
		return favorito;
	}


	public int cantProyPeli(String nombrePeli) {
		int cont=0;

		
		for(int i=0;i<cantBole;i++) {
			if(nombrePeli.equalsIgnoreCase(bole[i].getPelicula().getNombre())) {
				cont++;
			}
		}
		
		return cont;
		
	}
	

}
