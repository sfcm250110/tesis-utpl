package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ComprobanteEmpresa implements Serializable {
	
	private static final long serialVersionUID = 561428653197115872L;
	
	private String ruc;
	private Integer estado;
	private String src;
	private String claveAcceso;
	private String establecimiento;
	private Date fechaAutorizacion;
	private Date fechaEmision;
	private Date fechaRegistro;
	private String numeroAutorizacion;
	private String pdf;
	private String puntoEmision;
	private String razonSocialEmisor;
	private String rucEmisor;
	private String secuencial;
	private Integer tipo;
	private Integer tipoEmision;
	private String xml;
	private Integer fila;
	private Boolean clasificado;
	private BigDecimal baseImponible;
	private BigDecimal vivienda;
	private BigDecimal educacion;
	private BigDecimal alimentacion;
	private BigDecimal vestimenta;
	private BigDecimal salud;
	private String estadoLbl;
	private String tipoLbl;

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

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Boolean getClasificado() {
		return clasificado;
	}

	public void setClasificado(Boolean clasificado) {
		this.clasificado = clasificado;
	}

	public BigDecimal getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(BigDecimal baseImponible) {
		this.baseImponible = baseImponible;
	}

	public BigDecimal getVivienda() {
		return vivienda;
	}

	public void setVivienda(BigDecimal vivienda) {
		this.vivienda = vivienda;
	}

	public BigDecimal getEducacion() {
		return educacion;
	}

	public void setEducacion(BigDecimal educacion) {
		this.educacion = educacion;
	}

	public BigDecimal getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(BigDecimal alimentacion) {
		this.alimentacion = alimentacion;
	}

	public BigDecimal getVestimenta() {
		return vestimenta;
	}

	public void setVestimenta(BigDecimal vestimenta) {
		this.vestimenta = vestimenta;
	}

	public BigDecimal getSalud() {
		return salud;
	}

	public void setSalud(BigDecimal salud) {
		this.salud = salud;
	}

	public String getEstadoLbl() {
		if (Constantes.REGISTRADO.equals(estado)) {
			estadoLbl = Constantes.REGISTRADO_LBL;
			
		} else if (Constantes.SEND_QUEUE.equals(estado)) {
			estadoLbl = Constantes.SEND_QUEUE_LBL;
			
		} else if (Constantes.PROCESADO.equals(estado)) {
			estadoLbl = Constantes.PROCESADO_LBL;
			
		} else if (Constantes.ERROR_QUEUE.equals(estado)) {
			estadoLbl = Constantes.ERROR_QUEUE_LBL;
			
		} else if (Constantes.NO_PROCESAR.equals(estado)) {
			estadoLbl = Constantes.NO_PROCESAR_LBL;
			
		} else if (Constantes.CLASIFICADO.equals(estado)) {
			estadoLbl = Constantes.CLASIFICADO_LBL;
			
		} else if (Constantes.NO_CLASIFICADO.equals(estado)) {
			estadoLbl = Constantes.NO_CLASIFICADO_LBL;
			
		} else if (Constantes.PRE_PROCESADO.equals(estado)) {
			estadoLbl = Constantes.PRE_PROCESADO_LBL;
		}
		
		return estadoLbl;
	}

	public void setEstadoLbl(String estadoLbl) {
		this.estadoLbl = estadoLbl;
	}

	public String getTipoLbl() {
		if (Constantes.TIPO_FACTURA.equals(tipo)) {
			tipoLbl = Constantes.FACTURA_LBL;
			
		} else if (Constantes.TIPO_NOTA_CREDITO.equals(tipo)) {
			tipoLbl = Constantes.NOTA_CREDITO_LBL;
			
		} else if (Constantes.TIPO_NOTA_DEBITO.equals(tipo)) {
			tipoLbl = Constantes.NOTA_DEBITO_LBL;
			
		} else if (Constantes.TIPO_GUIA_REMISION.equals(tipo)) {
			tipoLbl = Constantes.GUIA_REMISION_LBL;
			
		} else if (Constantes.TIPO_COMPROBANTE_RETENCION.equals(tipo)) {
			tipoLbl = Constantes.COMPROBANTE_RETENCION_LBL;
		}
		
		return tipoLbl;
	}

	public void setTipoLbl(String tipoLbl) {
		this.tipoLbl = tipoLbl;
	}

}