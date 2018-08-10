package ec.edu.utpl.sc.core.entity.xml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ec.edu.utpl.sc.core.util.Constantes;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = Constantes.SPACE_BLANK, propOrder = { "idCheckDownloadSri", "fechaDownload", "fechaProceso", "fila", "totalFilas", "totalPaginas", "paginado", "etapa", "ruc" })
@XmlRootElement(name = "CheckDownloadSriXml")
public class CheckDownloadSriXml {

	@XmlElement(name = "idCheckDownloadSri", required = true)
	protected Long idCheckDownloadSri;

	@XmlElement(name = "fechaDownload")
	protected Date fechaDownload;

	@XmlElement(name = "fechaProceso")
	protected Date fechaProceso;

	@XmlElement(name = "fila")
	protected Integer fila;

	@XmlElement(name = "totalFilas")
	protected Integer totalFilas;

	@XmlElement(name = "totalPaginas")
	protected Integer totalPaginas;

	@XmlElement(name = "paginado")
	protected Integer paginado;

	@XmlElement(name = "etapa")
	protected Integer etapa;

	@XmlElement(name = "ruc")
	protected String ruc;

	public Long getIdCheckDownloadSri() {
		return idCheckDownloadSri;
	}

	public void setIdCheckDownloadSri(Long idCheckDownloadSri) {
		this.idCheckDownloadSri = idCheckDownloadSri;
	}

	public Date getFechaDownload() {
		return fechaDownload;
	}

	public void setFechaDownload(Date fechaDownload) {
		this.fechaDownload = fechaDownload;
	}

	public Date getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public Integer getTotalFilas() {
		return totalFilas;
	}

	public void setTotalFilas(Integer totalFilas) {
		this.totalFilas = totalFilas;
	}

	public Integer getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public Integer getPaginado() {
		return paginado;
	}

	public void setPaginado(Integer paginado) {
		this.paginado = paginado;
	}
	
	public Integer getEtapa() {
		return etapa;
	}

	public void setEtapa(Integer etapa) {
		this.etapa = etapa;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

}