package ec.edu.utpl.sc.core.entity.xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ec.edu.utpl.sc.core.util.Constantes;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = Constantes.SPACE_BLANK, propOrder = { "ruc", "estado", "src", "claveAcceso", "establecimiento", "fechaAutorizacion", "fechaEmision", "fechaRegistro", "numeroAutorizacion", "pdf", "puntoEmision", "razonSocialEmisor", "rucEmisor", "secuencial", "tipo", "tipoEmision", "xml", "fila" })
@XmlRootElement(name = "ComprobanteEmpresaXml")
public class ComprobanteEmpresaXml {
	
	@XmlElement(name = "ruc", required = true)
	protected String ruc;
	
	@XmlElement(name = "estado")
	protected Integer estado;
	
	@XmlElement(name = "src")
	protected String src;

	@XmlElement(name = "claveAcceso", required = true)
	protected String claveAcceso;
	
	@XmlElement(name = "establecimiento")
	protected String establecimiento;
	
	@XmlElement(name = "fechaAutorizacion")
	protected Date fechaAutorizacion;
	
	@XmlElement(name = "fechaEmision")
	protected Date fechaEmision;
	
	@XmlElement(name = "fechaRegistro")
	protected Date fechaRegistro;
	
	@XmlElement(name = "numeroAutorizacion")
	protected String numeroAutorizacion;
	
	@XmlElement(name = "pdf")
	protected String pdf;
	
	@XmlElement(name = "puntoEmision")
	protected String puntoEmision;
	
	@XmlElement(name = "razonSocialEmisor")
	protected String razonSocialEmisor;
	
	@XmlElement(name = "rucEmisor")
	protected String rucEmisor;
	
	@XmlElement(name = "secuencial")
	protected String secuencial;
	
	@XmlElement(name = "tipo")
	protected Integer tipo;
	
	@XmlElement(name = "tipoEmision")
	protected Integer tipoEmision;
	
	@XmlElement(name = "xml")
	protected String xml;
	
	@XmlElement(name = "fila")
	protected Integer fila;

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getPuntoEmision() {
		return puntoEmision;
	}

	public void setPuntoEmision(String puntoEmision) {
		this.puntoEmision = puntoEmision;
	}

	public String getRazonSocialEmisor() {
		return razonSocialEmisor;
	}

	public void setRazonSocialEmisor(String razonSocialEmisor) {
		this.razonSocialEmisor = razonSocialEmisor;
	}

	public String getRucEmisor() {
		return rucEmisor;
	}

	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}

	public String getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getTipoEmision() {
		return tipoEmision;
	}

	public void setTipoEmision(Integer tipoEmision) {
		this.tipoEmision = tipoEmision;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}