//
package logico;

import java.io.Serializable;

public abstract class Figura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String codigo;
	
	public Figura(String codigo) {
		super();
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public abstract float area();
	public abstract float volumen();


}
