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

import ec.edu.utpl.sc.core.base.EntityBase;

/**
 * The persistent class for the utpl_valor_maximo_rubro_sri database table.
 * 
 */
@Entity
@Table(name = "utpl_valor_maximo_rubro_sri")
@NamedQuery(name = "ValorMaximoRubroSri.findAll", query = "SELECT e FROM ValorMaximoRubroSri e")
public class ValorMaximoRubroSri extends EntityBase implements Serializable {

	private static final long serialVersionUID = 7793272359908659854L;

	@Id
	@SequenceGenerator(name = "UTPL_VALORMAXIMORUBROSRI_ID_GENERATOR", sequenceName = "VALOR_MAXIMO_RUBRO_SRI_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UTPL_VALORMAXIMORUBROSRI_ID_GENERATOR")
	@Column(name = "id_valor_maximo")
	private Long idValorMaximoRubroSri;

	@Column(name = "rubro")
	private String rubro;

	@Column(name = "valor_max")
	private Double valor;

	@Column(name = "periodo")
	private String periodo;

	@Column(name = "estado")
	private Boolean estado;

	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;

	public Long getIdValorMaximoRubroSri() {
		return idValorMaximoRubroSri;
	}

	public void setIdValorMaximoRubroSri(Long idValorMaximoRubroSri) {
		this.idValorMaximoRubroSri = idValorMaximoRubroSri;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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

}