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

import ec.edu.utpl.sc.core.base.EntityBase;

/**
 * The persistent class for the utpl_info_ruc_sri database table.
 * 
 */
@Entity
@Table(name = "utpl_info_ruc_sri")
@NamedQuery(name = "InfoRucSri.findAll", query = "SELECT e FROM InfoRucSri e")
public class InfoRucSri extends EntityBase implements Serializable {

	private static final long serialVersionUID = 7793272359908659854L;

	@Id
	@SequenceGenerator(name = "UTPL_INFO_RUC_SRI_GENERATOR", sequenceName = "INFO_RUC_SRI_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UTPL_INFO_RUC_SRI_GENERATOR")
	@Column(name = "id_info_ruc_sri")
	private Long idInfoRucSri;

	@Column(name = "ruc")
	private String ruc;

	@Column(name = "razon_social")
	private String razonSocial;

	@Column(name = "nombre_comercial")
	private String nombreComercial;

	@Column(name = "estado_contribuyente")
	private String estadoContribuyente;

	@Column(name = "clase_contribuyente")
	private String claseContribuyente;

	@Column(name = "tipo_contribuyente")
	private String tipoContribuyente;

	@Column(name = "obligado_contabilidad")
	private String obligadoContabilidad;

	@Column(name = "actividad_economica_principal")
	private String actividadEconomicaPrincipal;

	@Temporal(TemporalType.DATE)
	@Column(name = "inicio_actividades")
	private Date inicioActividades;

	@Temporal(TemporalType.DATE)
	@Column(name = "cese_actividades")
	private Date ceseActividades;

	@Temporal(TemporalType.DATE)
	@Column(name = "reinicio_actividades")
	private Date reinicioActividades;

	@Temporal(TemporalType.DATE)
	@Column(name = "actualizacion")
	private Date actualizacion;

	@Column(name = "categoria_pymes")
	private String categoriaPymes;
	
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	public Long getIdInfoRucSri() {
		return idInfoRucSri;
	}

	public void setIdInfoRucSri(Long idInfoRucSri) {
		this.idInfoRucSri = idInfoRucSri;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getEstadoContribuyente() {
		return estadoContribuyente;
	}

	public void setEstadoContribuyente(String estadoContribuyente) {
		this.estadoContribuyente = estadoContribuyente;
	}

	public String getClaseContribuyente() {
		return claseContribuyente;
	}

	public void setClaseContribuyente(String claseContribuyente) {
		this.claseContribuyente = claseContribuyente;
	}

	public String getTipoContribuyente() {
		return tipoContribuyente;
	}

	public void setTipoContribuyente(String tipoContribuyente) {
		this.tipoContribuyente = tipoContribuyente;
	}

	public String getObligadoContabilidad() {
		return obligadoContabilidad;
	}

	public void setObligadoContabilidad(String obligadoContabilidad) {
		this.obligadoContabilidad = obligadoContabilidad;
	}

	public String getActividadEconomicaPrincipal() {
		return actividadEconomicaPrincipal;
	}

	public void setActividadEconomicaPrincipal(String actividadEconomicaPrincipal) {
		this.actividadEconomicaPrincipal = actividadEconomicaPrincipal;
	}

	public Date getInicioActividades() {
		return inicioActividades;
	}

	public void setInicioActividades(Date inicioActividades) {
		this.inicioActividades = inicioActividades;
	}

	public Date getCeseActividades() {
		return ceseActividades;
	}

	public void setCeseActividades(Date ceseActividades) {
		this.ceseActividades = ceseActividades;
	}

	public Date getReinicioActividades() {
		return reinicioActividades;
	}

	public void setReinicioActividades(Date reinicioActividades) {
		this.reinicioActividades = reinicioActividades;
	}

	public Date getActualizacion() {
		return actualizacion;
	}

	public void setActualizacion(Date actualizacion) {
		this.actualizacion = actualizacion;
	}

	public String getCategoriaPymes() {
		return categoriaPymes;
	}

	public void setCategoriaPymes(String categoriaPymes) {
		this.categoriaPymes = categoriaPymes;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}