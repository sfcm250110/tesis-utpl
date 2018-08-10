package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class Deducible implements Serializable {

	private static final long serialVersionUID = 8145687625969381299L;

	private Boolean found;
	private Integer tipoGasto;
	private Double baseImponible;

	public Boolean getFound() {
		return found;
	}

	public void setFound(Boolean found) {
		this.found = found;
	}

	public Integer getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(Integer tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public Double getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(Double baseImponible) {
		this.baseImponible = baseImponible;
	}

}