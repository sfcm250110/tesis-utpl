package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class Periodo implements Serializable {
	
	private static final long serialVersionUID = -2092344707197623253L;
	
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
