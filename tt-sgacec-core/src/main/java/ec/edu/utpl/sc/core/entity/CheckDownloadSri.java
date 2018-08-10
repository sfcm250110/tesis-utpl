package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ec.edu.utpl.sc.core.base.EntityBase;
import ec.edu.utpl.sc.core.util.Constantes;


/**
 * The persistent class for the utpl_check_download_sri database table.
 * 
 */
@Entity
@Table(name="utpl_check_download_sri")
@NamedQuery(name="CheckDownloadSri.findAll", query="SELECT c FROM CheckDownloadSri c")
public class CheckDownloadSri extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = -5025529199998810337L;

	@Id
	@SequenceGenerator(name="UTPL_CHECK_DOWNLOAD_SRI_IDCHECKDOWNLOADSRI_GENERATOR", sequenceName="CHECK_DOWNLOAD_SRI_SQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTPL_CHECK_DOWNLOAD_SRI_IDCHECKDOWNLOADSRI_GENERATOR")
	@Column(name="id_check_download_sri")
	private long idCheckDownloadSri;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_download")
	private Date fechaDownload;

	@Column(name="fecha_proceso")
	private Date fechaProceso;

	private Integer fila;

	@Column(name="total_filas")
	private Integer totalFilas;

	@Column(name="total_paginas")
	private Integer totalPaginas;

	private Integer paginado;

	private Integer etapa;

	private String ruc;
	
	@Transient
	private Long idCheckDownloadSriCrud;

	@Transient
	private Date fechaDownloadCrud;

	@Transient
	private Date fechaProcesoCrud;

	@Transient
	private Integer filaCrud;

	@Transient
	private Integer totalFilasCrud;

	@Transient
	private Integer totalPaginasCrud;

	@Transient
	private Integer paginadoCrud;

	@Transient
	private Integer etapaCrud;

	@Transient
	private String rucCrud;
	
	@Transient
	private String lblEtapa;

	public long getIdCheckDownloadSri() {
		return idCheckDownloadSri;
	}

	public void setIdCheckDownloadSri(long idCheckDownloadSri) {
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

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Long getIdCheckDownloadSriCrud() {
		return idCheckDownloadSriCrud;
	}

	public void setIdCheckDownloadSriCrud(Long idCheckDownloadSriCrud) {
		this.idCheckDownloadSriCrud = idCheckDownloadSriCrud;
	}

	public Date getFechaDownloadCrud() {
		return fechaDownloadCrud;
	}

	public void setFechaDownloadCrud(Date fechaDownloadCrud) {
		this.fechaDownloadCrud = fechaDownloadCrud;
	}

	public Date getFechaProcesoCrud() {
		return fechaProcesoCrud;
	}

	public void setFechaProcesoCrud(Date fechaProcesoCrud) {
		this.fechaProcesoCrud = fechaProcesoCrud;
	}

	public Integer getFilaCrud() {
		return filaCrud;
	}

	public void setFilaCrud(Integer filaCrud) {
		this.filaCrud = filaCrud;
	}

	public Integer getTotalFilasCrud() {
		return totalFilasCrud;
	}

	public void setTotalFilasCrud(Integer totalFilasCrud) {
		this.totalFilasCrud = totalFilasCrud;
	}

	public Integer getTotalPaginasCrud() {
		return totalPaginasCrud;
	}

	public void setTotalPaginasCrud(Integer totalPaginasCrud) {
		this.totalPaginasCrud = totalPaginasCrud;
	}

	public Integer getPaginadoCrud() {
		return paginadoCrud;
	}

	public void setPaginadoCrud(Integer paginadoCrud) {
		this.paginadoCrud = paginadoCrud;
	}

	public Integer getEtapaCrud() {
		return etapaCrud;
	}

	public void setEtapaCrud(Integer etapaCrud) {
		this.etapaCrud = etapaCrud;
	}
		

	public String getRucCrud() {
		return rucCrud;
	}

	public void setRucCrud(String rucCrud) {
		this.rucCrud = rucCrud;
	}

	public Integer getEtapa() {
		return etapa;
	}

	public void setEtapa(Integer etapa) {
		this.etapa = etapa;
	}

	public String getLblEtapa() {
		switch (etapa) {
			case 1:
				lblEtapa = Constantes.REGISTRADO_LBL;
				break;
				
			case 2:
				lblEtapa = Constantes.SEND_QUEUE_LBL;
				break;
				
			case 3:
				lblEtapa = Constantes.PROCESADO_LBL;
				break;
				
			case 4:
				lblEtapa = Constantes.ERROR_QUEUE_LBL;
				break;
				
			case 5:
				lblEtapa = Constantes.NO_PROCESAR_LBL;
				break;
				
			case 6:
				lblEtapa = Constantes.CLASIFICADO_LBL;
				break;
				
			case 7:
				lblEtapa = Constantes.NO_CLASIFICADO_LBL;
				break;
				
			case 8:
				lblEtapa = Constantes.PRE_PROCESADO_LBL;
				break;
		}
		
		return lblEtapa;
	}

	public void setLblEtapa(String lblEtapa) {
		this.lblEtapa = lblEtapa;
	}

}