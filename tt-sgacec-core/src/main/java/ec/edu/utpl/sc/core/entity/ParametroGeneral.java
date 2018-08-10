package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.utpl.sc.core.base.EntityBase;


/**
 * The persistent class for the utpl_parametros_generales database table.
 * 
 */
@Entity
@Table(name="utpl_parametro_general")
@NamedQuery(name="ParametroGeneral.findAll", query="SELECT p FROM ParametroGeneral p")
public class ParametroGeneral extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 8039429706344643547L;

	@Id
	@SequenceGenerator(name="UTPL_PARAMETRO_GENERAL_IDPARAMETROGENERAL_GENERATOR", sequenceName="PARAMETRO_GENERAL_SQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTPL_PARAMETRO_GENERAL_IDPARAMETROGENERAL_GENERATOR")
	@Column(name="id_parametro_general")
	private long idParametroGeneral;

	private String descripcion;

	private String nombre;

	private String valor;
	
	@Transient
	private Long idParametroGeneralCrud;

	@Transient
	private String descripcionCrud;

	@Transient
	private String nombreCrud;

	@Transient
	private String valorCrud;

	public ParametroGeneral() {
	}

	public long getIdParametroGeneral() {
		return this.idParametroGeneral;
	}

	public void setIdParametroGeneral(long idParametroGeneral) {
		this.idParametroGeneral = idParametroGeneral;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getIdParametroGeneralCrud() {
		return idParametroGeneralCrud;
	}

	public void setIdParametroGeneralCrud(Long idParametroGeneralCrud) {
		this.idParametroGeneralCrud = idParametroGeneralCrud;
	}

	public String getDescripcionCrud() {
		return descripcionCrud;
	}

	public void setDescripcionCrud(String descripcionCrud) {
		this.descripcionCrud = descripcionCrud;
	}

	public String getNombreCrud() {
		return nombreCrud;
	}

	public void setNombreCrud(String nombreCrud) {
		this.nombreCrud = nombreCrud;
	}

	public String getValorCrud() {
		return valorCrud;
	}

	public void setValorCrud(String valorCrud) {
		this.valorCrud = valorCrud;
	}

}