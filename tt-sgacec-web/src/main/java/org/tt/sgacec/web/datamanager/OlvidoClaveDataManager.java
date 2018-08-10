package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import ec.edu.utpl.sc.core.entity.Usuario;

@ManagedBean
@SessionScoped
public class OlvidoClaveDataManager extends CommonDataManager implements Serializable {
	
	private static final long serialVersionUID = -7503413122581554473L;
	
	private Usuario usuario;
	private String email;
	private Long idPreguntaSeguridad;
	private String respuestaSeguridad;
	private Boolean informacionEmail;
	private Boolean informacionPreguntaSeguridad;
	private Boolean informacionExitosa;
	private List<SelectItem> preguntasSeguridadSelectItem;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdPreguntaSeguridad() {
		return idPreguntaSeguridad;
	}

	public void setIdPreguntaSeguridad(Long idPreguntaSeguridad) {
		this.idPreguntaSeguridad = idPreguntaSeguridad;
	}

	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}

	public Boolean getInformacionEmail() {
		return informacionEmail;
	}

	public void setInformacionEmail(Boolean informacionEmail) {
		this.informacionEmail = informacionEmail;
	}

	public Boolean getInformacionPreguntaSeguridad() {
		return informacionPreguntaSeguridad;
	}

	public void setInformacionPreguntaSeguridad(Boolean informacionPreguntaSeguridad) {
		this.informacionPreguntaSeguridad = informacionPreguntaSeguridad;
	}

	public Boolean getInformacionExitosa() {
		return informacionExitosa;
	}

	public void setInformacionExitosa(Boolean informacionExitosa) {
		this.informacionExitosa = informacionExitosa;
	}

	public List<SelectItem> getPreguntasSeguridadSelectItem() {
		return preguntasSeguridadSelectItem;
	}

	public void setPreguntasSeguridadSelectItem(List<SelectItem> preguntasSeguridadSelectItem) {
		this.preguntasSeguridadSelectItem = preguntasSeguridadSelectItem;
	}

}
