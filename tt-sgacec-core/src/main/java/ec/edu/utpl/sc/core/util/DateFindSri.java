package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class DateFindSri implements Serializable {
	
	private static final long serialVersionUID = -6821507549492413280L;
	
	private String anio;
	private String mes;
	private String dia;

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

}