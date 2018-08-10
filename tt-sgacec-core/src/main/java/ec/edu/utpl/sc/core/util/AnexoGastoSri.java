package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AnexoGastoSri implements Serializable {
	
	private static final long serialVersionUID = 297634122918575772L;
	
	private String rucEmisor;
	private BigInteger cantidadComprobantes;
	private BigDecimal baseImponible;
	private String tipoGasto;

	public String getRucEmisor() {
		return rucEmisor;
	}

	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}

	public BigInteger getCantidadComprobantes() {
		return cantidadComprobantes;
	}

	public void setCantidadComprobantes(BigInteger cantidadComprobantes) {
		this.cantidadComprobantes = cantidadComprobantes;
	}

	public BigDecimal getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(BigDecimal baseImponible) {
		this.baseImponible = baseImponible;
	}

	public String getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

}