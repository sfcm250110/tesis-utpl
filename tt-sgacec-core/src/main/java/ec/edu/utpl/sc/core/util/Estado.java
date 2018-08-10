package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class Estado implements Serializable {
	
	private static final long serialVersionUID = -2092344707197623253L;
	
	private String name;
	private Boolean value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

}
