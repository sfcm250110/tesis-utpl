package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.util.List;

public class AnexoGasto implements Serializable {

	private static final long serialVersionUID = -5621167147352163343L;

	private String periodo;
	private String ruc;
	private Double vivienda;
	private Double educacion;
	private Double alimentacion;
	private Double vestimenta;
	private Double salud;
	private Double sinClasificar;
	private Double totalAnexo;
	private List<Comprobante> comprobantesClasificados;
	private List<Comprobante> comprobantesSinClasificar;

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
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

	public Double getSinClasificar() {
		return sinClasificar;
	}

	public void setSinClasificar(Double sinClasificar) {
		this.sinClasificar = sinClasificar;
	}

	public Double getTotalAnexo() {
		return totalAnexo;
	}

	public void setTotalAnexo(Double totalAnexo) {
		this.totalAnexo = totalAnexo;
	}

	public List<Comprobante> getComprobantesClasificados() {
		return comprobantesClasificados;
	}

	public void setComprobantesClasificados(List<Comprobante> comprobantesClasificados) {
		this.comprobantesClasificados = comprobantesClasificados;
	}

	public List<Comprobante> getComprobantesSinClasificar() {
		return comprobantesSinClasificar;
	}

	public void setComprobantesSinClasificar(List<Comprobante> comprobantesSinClasificar) {
		this.comprobantesSinClasificar = comprobantesSinClasificar;
	}

}