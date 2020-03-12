package logico;

import java.util.ArrayList;
//c
//Clase controladora
public class Centro {
	private ArrayList<Prisma>primas;
	private ArrayList<Reporte>reportes;
	
	public Centro() {
		super();
		this.primas = new ArrayList<Prisma>();
		this.reportes = new ArrayList<Reporte>();
	}

	public ArrayList<Prisma> getPrimas() {
		return primas;
	}

	public void setPrimas(ArrayList<Prisma> primas) {
		this.primas = primas;
	}

	public ArrayList<Reporte> getReportes() {
		return reportes;
	}

	public void setReportes(ArrayList<Reporte> reportes) {
		this.reportes = reportes;
	}
	
	

}
