package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import ec.edu.utpl.sc.core.base.EntityBase;

/**
 * The persistent class for the utpl_comprbante_fisico database table.
 * 
 */
/**
 * @author Kruger
 *
 */
@Entity
@Table(name = "utpl_comprobante_fisico")
@NamedQuery(name = "ComprobanteFisico.findAll", query = "SELECT e FROM ComprobanteFisico e")
public class ComprobanteFisico extends EntityBase implements Serializable {

	private static final long serialVersionUID = 7793272359908659854L;

	@Id
	@SequenceGenerator(name = "UTPL_COMPROBANTE_FISICO_IDCOMPROBANTEFISICO_GENERATOR", sequenceName = "COMPROBANTE_FISICO_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UTPL_COMPROBANTE_FISICO_IDCOMPROBANTEFISICO_GENERATOR")
	@Column(name = "id_comprobante")
	private Long idComprobante;

	@Column(name = "ruc_emisor")
	private String rucEmisor;

	@Column(name = "razon_social_emisor")
	private String razonSocialEmisor;

	@Column(name = "numero_autorizacion")
	private String numeroAutorizacion;

	@Column(name = "establecimiento")
	private String establecimiento;

	@Column(name = "punto_emision")
	private String puntoEmision;

	@Column(name = "secuencial")
	private String secuencial;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_emision")
	private Date fechaEmision;

	@Column(name = "tipo")
	private Integer tipo;
	
	@Column(name = "clasificado")
	private Boolean clasificado;

	@Column(name = "base_imponible")
	private Double baseImponible;

	@Column(name = "iva")
	private Integer iva;

	@Column(name = "total")
	private Double total;

	@Column(name = "vivienda")
	private Double vivienda;

	@Column(name = "educacion")
	private Double educacion;

	@Column(name = "alimentacion")
	private Double alimentacion;

	@Column(name = "vestimenta")
	private Double vestimenta;

	@Column(name = "salud")
	private Double salud;

	@Lob
	@Column(name = "comprobante_image")
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] comprobanteImagen;

	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "nombre_comprobante_image")
	private String nombreComprobanteImagen;
	
	@Column(name = "src")
	private String src;

	@Column(name = "estado")
	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	public Long getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(Long idComprobante) {
		this.idComprobante = idComprobante;
	}

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

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getPuntoEmision() {
		return puntoEmision;
	}

	public void setPuntoEmision(String puntoEmision) {
		this.puntoEmision = puntoEmision;
	}

	public String getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Double getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(Double baseImponible) {
		this.baseImponible = baseImponible;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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
	
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public byte[] getComprobanteImagen() {
		return comprobanteImagen;
	}

	public void setComprobanteImagen(byte[] comprobanteImagen) {
		this.comprobanteImagen = comprobanteImagen;
	}

	public String getNombreComprobanteImagen() {
		return nombreComprobanteImagen;
	}

	public void setNombreComprobanteImagen(String nombreComprobanteImagen) {
		this.nombreComprobanteImagen = nombreComprobanteImagen;
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

}