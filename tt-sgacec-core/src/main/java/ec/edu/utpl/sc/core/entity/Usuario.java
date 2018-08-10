package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.utpl.sc.core.base.EntityBase;

/**
 * The persistent class for the utpl_usuario database table.
 * 
 */
@Entity
@Table(name = "utpl_usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;
	private int hashValue = 0;

	private Long idUsuario;
	private String userName;
	private String claveUno;
	private String claveDos;
	private String claveTres;
	private String nombres;
	private String apellidos;
	private String cedulaRuc;
	private String direccion;
	private String telefonoConvencional;
	private String telefonoCelular;
	private String email;
	private String respuestaSeguridad;
	private Date fechaIngreso;
	private Boolean estado;
	private PreguntaSeguridad preguntaSeguridad;

	@Id
	@SequenceGenerator(name = "UTPL_USUARIO_IDUSUARIO_GENERATOR", sequenceName = "USUARIO_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UTPL_USUARIO_IDUSUARIO_GENERATOR")
	@Column(name = "id_usuario")
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		this.hashValue = 0;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "CLAVE_UNO")
	public String getClaveUno() {
		return this.claveUno;
	}

	public void setClaveUno(String claveUno) {
		this.claveUno = claveUno;
	}

	@Column(name = "CLAVE_DOS")
	public String getClaveDos() {
		return claveDos;
	}

	public void setClaveDos(String claveDos) {
		this.claveDos = claveDos;
	}

	@Column(name = "CLAVE_TRES")
	public String getClaveTres() {
		return claveTres;
	}

	public void setClaveTres(String claveTres) {
		this.claveTres = claveTres;
	}

	@Column(name = "NOMBRES")
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Column(name = "APELLIDOS")
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "CEDULA_RUC")
	public String getCedulaRuc() {
		return cedulaRuc;
	}

	public void setCedulaRuc(String cedulaRuc) {
		this.cedulaRuc = cedulaRuc;
	}

	@Column(name = "DIRECCION")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "TELEFONO_CONVENCIONAL")
	public String getTelefonoConvencional() {
		return telefonoConvencional;
	}

	public void setTelefonoConvencional(String telefonoConvencional) {
		this.telefonoConvencional = telefonoConvencional;
	}

	@Column(name = "TELEFONO_CELULAR")
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "RESPUESTA_SEGURIDAD")
	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}

	@Column(name = "FECHA_INGRESO")
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@ManyToOne()
	@JoinColumn(name = "ID_PREGUNTA_SEGURIDAD")
	public PreguntaSeguridad getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(PreguntaSeguridad preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public boolean equals(Object usuarioObjeto) {
		if (usuarioObjeto == null)
			return false;

		if (!(usuarioObjeto instanceof Usuario))
			return false;

		Usuario usuario = (Usuario) usuarioObjeto;

		if (this.getIdUsuario() == null || usuario.getIdUsuario() == null)
			return false;

		return (this.getIdUsuario().equals(usuario.getIdUsuario()));
	}

	public int hashCode() {
		if (this.hashValue == 0) {
			int result = 17;
			int idUsuarioValue = this.getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode();
			result = result * 37 + idUsuarioValue;

			this.hashValue = result;
		}
		return this.hashValue;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}