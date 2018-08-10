package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;

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
 * The persistent class for the utpl_roles_tbl database table.
 * 
 */
@Entity
@Table(name="utpl_rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int hashValue = 0;

	private Long idRol;
	private String nombreRol;
	private String descripcionRol;

	@Id
	@SequenceGenerator(name="UTPL_ROL_IDROL_GENERATOR", sequenceName="ROL_SQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTPL_ROL_IDROL_GENERATOR")
	@Column(name="id_rol")
	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
		this.hashValue = 0;
	}

	@Column(name = "NOMBRE_ROL")
	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Column(name = "DESCRIPCION_ROL")
	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public boolean equals(Object rolObjeto) {
		if (rolObjeto == null)
			return false;

		if (!(rolObjeto instanceof Rol))
			return false;

		Rol rol = (Rol) rolObjeto;

		if (this.getIdRol() == null || rol.getIdRol() == null)
			return false;

		return (this.getIdRol().equals(rol.getIdRol()));
	}

	public int hashCode() {
		if (this.hashValue == 0) {
			int result = 17;
			int idRolValue = this.getIdRol() == null ? 0 : this.getIdRol().hashCode();
			result = result * 37 + idRolValue;

			this.hashValue = result;
		}
		return this.hashValue;
	}

}
