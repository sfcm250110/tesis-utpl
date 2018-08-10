package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class Comprobante implements Serializable {

	private static final long serialVersionUID = 6746392755442005189L;

	private String rucEmisor;
	private String razonSocialEmisor;
	private String numeroComprobante;
	private String fechaEmision;
	private Double baseImponible;
	private Double vivienda;
	private Double educacion;
	private Double alimentacion;
	private Double vestimenta;
	private Double salud;
	private String tipo;

	public String getRucEmisor() {
		return rucEmisor;
	}

	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}

	public String getRazonSocialEmisor() {
		return razonSocialEmisor;
	}

	public void setRazonSocialEmisor(String razonSocialEmisor) {
		this.razonSocialEmisor = razonSocialEmisor;
	}

	public String getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Double getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(Double baseImponible) {
		this.baseImponible = baseImponible;
	}

	public Double getVivienda() {
		return vivienda;
	}

	public void setVivienda(Double vivienda) {
		this.vivienda = vivienda;
	}

	public Double getEducacion() {
		return educacion;
	}

	public void setEducacion(Double educacion) {
		this.educacion = educacion;
	}

	public Double getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(Double alimentacion) {
		this.alimentacion = alimentacion;
	}

	public Double getVestimenta() {
		return vestimenta;
	}

	public void setVestimenta(Double vestimenta) {
		this.vestimenta = vestimenta;
	}

	public Double getSalud() {
		return salud;
	}

	public void setSalud(Double salud) {
		this.salud = salud;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}