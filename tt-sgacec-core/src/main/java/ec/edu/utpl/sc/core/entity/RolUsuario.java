package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.utpl.sc.core.base.EntityBase;

/**
 * The persistent class for the utpl_roles_usuario_tbl database table.
 * 
 */
@Entity
@Table(name = "utpl_rol_usuario")
@NamedQuery(name = "RolUsuario.findAll", query = "SELECT r FROM RolUsuario r")
public class RolUsuario extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;
	private int hashValue = 0;

	private Long idRolUsuario;
	private String userName;
	private String nombreRol;
	private Rol rol;
	private Usuario usuario;

	@Id
	@SequenceGenerator(name = "UTPL_ROL_USUARIO_IDROLUSUARIO_GENERATOR", sequenceName = "ROL_USUARIO_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UTPL_ROL_USUARIO_IDROLUSUARIO_GENERATOR")
	@Column(name = "id_rol_usuario")
	public Long getIdRolUsuario() {
		return idRolUsuario;
	}

	public void setIdRolUsuario(Long idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
		this.hashValue = 0;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "NOMBRE_ROL")
	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@OneToOne()
	@JoinColumn(name = "ID_ROL")
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@ManyToOne()
	@JoinColumn(name = "ID_USUARIO")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean equals(Object rolUsuarioObjeto) {
		if (rolUsuarioObjeto == null)
			return false;

		if (!(rolUsuarioObjeto instanceof RolUsuario))
			return false;

		RolUsuario rolUsuario = (RolUsuario) rolUsuarioObjeto;

		if (this.getIdRolUsuario() == null || rolUsuario.getIdRolUsuario() == null)
			return false;

		return (this.getIdRolUsuario().equals(rolUsuario.getIdRolUsuario()));
	}

	public int hashCode() {
		if (this.hashValue == 0) {
			int result = 17;
			int idRolUsuarioValue = this.getIdRolUsuario() == null ? 0 : this.getIdRolUsuario().hashCode();
			result = result * 37 + idRolUsuarioValue;

			this.hashValue = result;
		}
		return this.hashValue;
	}

}