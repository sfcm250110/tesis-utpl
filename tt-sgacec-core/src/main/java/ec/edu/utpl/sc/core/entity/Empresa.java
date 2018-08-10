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
import ec.edu.utpl.sc.core.util.SecurityUtil;
import ec.edu.utpl.sc.core.util.UtplException;


/**
 * The persistent class for the utpl_empresa database table.
 * 
 */
@Entity
@Table(name="utpl_empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 7793272359908659854L;

	@Id
	@SequenceGenerator(name="UTPL_EMPRESA_IDEMPRESA_GENERATOR", sequenceName="EMPRESA_SQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTPL_EMPRESA_IDEMPRESA_GENERATOR")
	@Column(name="id_empresa")
	private Long idEmpresa;

	@Column(name="clave_sri")
	private String claveSri;

	private String nombre;

	private String ruc;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_init_download")
	private Date fechaInitDownload;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_download")
	private Date fechaDownload;
	
	private Boolean estado;
	
	@Transient
	private Long idEmpresaCrud;

	@Transient
	private String nombreCrud;

	@Transient
	private String rucCrud;
	
	@Transient
	private Date fechaInitDownloadCrud;

	@Transient
	private Date fechaDownloadCrud;
	
	@Transient
	private Boolean estadoCrud;

	public Empresa() {
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getClaveSri() {
		String claveSriDesencrypt = null;
		
		try {
			claveSriDesencrypt = SecurityUtil.desencryptMd5Base64(this.claveSri);
			
		} catch (UtplException e) {
			e.printStackTrace();
		}
		
		return claveSriDesencrypt;
	}

	public void setClaveSri(String claveSri) {
		try {
			this.claveSri = SecurityUtil.encryptMd5Base64(claveSri);
			
		} catch (UtplException e) {
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public Date getFechaInitDownload() {
		return fechaInitDownload;
	}

	public void setFechaInitDownload(Date fechaInitDownload) {
		this.fechaInitDownload = fechaInitDownload;
	}

	public Date getFechaDownload() {
		return fechaDownload;
	}

	public void setFechaDownload(Date fechaDownload) {
		this.fechaDownload = fechaDownload;
	}

	public Long getIdEmpresaCrud() {
		return idEmpresaCrud;
	}

	public void setIdEmpresaCrud(Long idEmpresaCrud) {
		this.idEmpresaCrud = idEmpresaCrud;
	}

	public String getNombreCrud() {
		return nombreCrud;
	}

	public void setNombreCrud(String nombreCrud) {
		this.nombreCrud = nombreCrud;
	}

	public String getRucCrud() {
		return rucCrud;
	}

	public void setRucCrud(String rucCrud) {
		this.rucCrud = rucCrud;
	}
	
	public Date getFechaInitDownloadCrud() {
		return fechaInitDownloadCrud;
	}

	public void setFechaInitDownloadCrud(Date fechaInitDownloadCrud) {
		this.fechaInitDownloadCrud = fechaInitDownloadCrud;
	}

	public Date getFechaDownloadCrud() {
		return fechaDownloadCrud;
	}

	public void setFechaDownloadCrud(Date fechaDownloadCrud) {
		this.fechaDownloadCrud = fechaDownloadCrud;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getEstadoCrud() {
		return estadoCrud;
	}

	public void setEstadoCrud(Boolean estadoCrud) {
		this.estadoCrud = estadoCrud;
	}

}