package ec.edu.utpl.sc.core.base;

public abstract class EntityBase {
	
	public EntityBase() {
		super();
	}
	
	/**
	 * Devuelve la clave primaria del objeto.<br>
	 * Cada objeto del modelo debe implementar su propia version de este metodo, de otra forma no funcionara con Ejb
	 *
	*/
	public Object getId() {
		return null;
	}
	
	public void setId(String pCadena) {
		
	}

}
