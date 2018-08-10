package ec.edu.utpl.sc.core.enumerador;

import java.io.Serializable;

public enum DeducibleEnum implements Serializable {

	INOT_FOUND(0),
	IVIVIENDA(1),
	IEDUCACION(2),
	IALIMENTACION(3),
	IVESTIMENTA(4),
	ISALUD(5);

	private final Integer value;

	private DeducibleEnum(Integer pValue) {
		this.value = pValue;
	}

	public Integer getValue() {
		return value;
	}

}