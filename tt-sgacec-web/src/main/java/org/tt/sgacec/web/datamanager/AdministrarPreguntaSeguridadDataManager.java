package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.entity.PreguntaSeguridad;

@ManagedBean
@SessionScoped
public class AdministrarPreguntaSeguridadDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean mostrarCrearPreguntaSeguridad;
	private Boolean mostrarNuevaPreguntaSeguridad;
	private Boolean mostrarModificarPreguntaSeguridad;
	private PreguntaSeguridad crearPreguntaSeguridad;
	private PreguntaSeguridad modificarPreguntaSeguridad;
	private PreguntaSeguridad eliminarPreguntaSeguridad;
	private List<PreguntaSeguridad> preguntasSeguridad;

	public Boolean getMostrarCrearPreguntaSeguridad() {
		return mostrarCrearPreguntaSeguridad;
	}

	public void setMostrarCrearPreguntaSeguridad(Boolean mostrarCrearPreguntaSeguridad) {
		this.mostrarCrearPreguntaSeguridad = mostrarCrearPreguntaSeguridad;
	}

	public Boolean getMostrarNuevaPreguntaSeguridad() {
		return mostrarNuevaPreguntaSeguridad;
	}

	public void setMostrarNuevaPreguntaSeguridad(Boolean mostrarNuevaPreguntaSeguridad) {
		this.mostrarNuevaPreguntaSeguridad = mostrarNuevaPreguntaSeguridad;
	}

	public Boolean getMostrarModificarPreguntaSeguridad() {
		return mostrarModificarPreguntaSeguridad;
	}

	public void setMostrarModificarPreguntaSeguridad(Boolean mostrarModificarPreguntaSeguridad) {
		this.mostrarModificarPreguntaSeguridad = mostrarModificarPreguntaSeguridad;
	}

	public PreguntaSeguridad getCrearPreguntaSeguridad() {
		return crearPreguntaSeguridad;
	}

	public void setCrearPreguntaSeguridad(PreguntaSeguridad crearPreguntaSeguridad) {
		this.crearPreguntaSeguridad = crearPreguntaSeguridad;
	}

	public PreguntaSeguridad getModificarPreguntaSeguridad() {
		return modificarPreguntaSeguridad;
	}

	public void setModificarPreguntaSeguridad(PreguntaSeguridad modificarPreguntaSeguridad) {
		this.modificarPreguntaSeguridad = modificarPreguntaSeguridad;
	}

	public PreguntaSeguridad getEliminarPreguntaSeguridad() {
		return eliminarPreguntaSeguridad;
	}

	public void setEliminarPreguntaSeguridad(PreguntaSeguridad eliminarPreguntaSeguridad) {
		this.eliminarPreguntaSeguridad = eliminarPreguntaSeguridad;
	}

	public List<PreguntaSeguridad> getPreguntasSeguridad() {
		return preguntasSeguridad;
	}

	public void setPreguntasSeguridad(List<PreguntaSeguridad> preguntasSeguridad) {
		this.preguntasSeguridad = preguntasSeguridad;
	}

}
