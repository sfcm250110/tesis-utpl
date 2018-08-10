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
 * The persistent class for the utpl_error_sistema database table.
 * 
 */
@Entity
@Table(name="utpl_error_sistema")
@NamedQuery(name="ErrorSistema.findAll", query="SELECT e FROM ErrorSistema e")
public class ErrorSistema extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 1025185818281334807L;

	@Id
	@SequenceGenerator(name="ERROR_SISTEMA_ERRORSISTEMA_GENERATOR", sequenceName="ERROR_SISTEMA_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ERROR_SISTEMA_ERRORSISTEMA_GENERATOR")
	@Column(name="id_error_sistema")
	private Long idErrorSistema;

	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String localizacion;

	private String mensaje;

	private String modulo;

	private String nivel;
	
	@Column(name="mensaje_user")
	private String mensajeUsuario;

	@Column(name="print_trace_trace")
	private String printTraceTrace;

	public ErrorSistema() {
	}

	public Long getIdErrorSistema() {
		return this.idErrorSistema;
	}

	public void setIdErrorSistema(Long idErrorSistema) {
		this.idErrorSistema = idErrorSistema;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getLocalizacion() {
		return this.localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getPrintTraceTrace() {
		return this.printTraceTrace;
	}

	public void setPrintTraceTrace(String printTraceTrace) {
		this.printTraceTrace = printTraceTrace;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

}