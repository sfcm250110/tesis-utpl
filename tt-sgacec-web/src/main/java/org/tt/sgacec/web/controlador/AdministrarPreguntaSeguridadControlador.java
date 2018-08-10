package org.tt.sgacec.web.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.AdministrarPreguntaSeguridadDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.PreguntaSeguridad;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

/**
 * 
 * Controlador que maneja las opciones de administracion de las preguntas de seguridad del usuario
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class AdministrarPreguntaSeguridadControlador extends CommonController {
	
	private static final long serialVersionUID = -3799960211568360733L;

	private static Logger log = Logger.getLogger(AdministrarPreguntaSeguridadControlador.class);

	@ManagedProperty(value = Constantes.ADMINISTRAR_PREGUNTAS_SEGURIDAD_DATA_MANAGER_EL)
	private AdministrarPreguntaSeguridadDataManager administrarPreguntasSeguridadDataManager;

	@Override
	public void init() {
		try {
			administrarPreguntasSeguridadDataManager.setMostrarNuevaPreguntaSeguridad(Boolean.TRUE);
			administrarPreguntasSeguridadDataManager.setMostrarCrearPreguntaSeguridad(Boolean.FALSE);
			administrarPreguntasSeguridadDataManager.setMostrarModificarPreguntaSeguridad(Boolean.FALSE);
			administrarPreguntasSeguridadDataManager.setPreguntasSeguridad(FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE));

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void nuevaPreguntaSeguridad() {
		administrarPreguntasSeguridadDataManager.setMostrarCrearPreguntaSeguridad(Boolean.TRUE);
		administrarPreguntasSeguridadDataManager.setMostrarModificarPreguntaSeguridad(Boolean.FALSE);
		administrarPreguntasSeguridadDataManager.setMostrarNuevaPreguntaSeguridad(Boolean.FALSE);
		administrarPreguntasSeguridadDataManager.setCrearPreguntaSeguridad(new PreguntaSeguridad());
	}

	public void crearPreguntaSeguridad() {
		try {
			// Crear la Pregunta de Seguridad 
			FwUtplFactory.getIntance().getCrudService().update(administrarPreguntasSeguridadDataManager.getCrearPreguntaSeguridad());

			administrarPreguntasSeguridadDataManager.setPreguntasSeguridad(FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE));
			administrarPreguntasSeguridadDataManager.setCrearPreguntaSeguridad(null);
			administrarPreguntasSeguridadDataManager.setMostrarCrearPreguntaSeguridad(Boolean.FALSE);
			administrarPreguntasSeguridadDataManager.setMostrarNuevaPreguntaSeguridad(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Pregunta de Seguridad registrada exitosamente");

		} catch (Exception e) {
			log.error("[crearModelo()] Error al crear la pregunta seguridad en el sistema. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al crear la pregunta seguridad en el sistema. Causa --> " + e);
		}
	}

	public void inicioModificarPreguntaSeguridad(PreguntaSeguridad pPreguntaSeguridad) {
		administrarPreguntasSeguridadDataManager.setModificarPreguntaSeguridad(pPreguntaSeguridad);
		administrarPreguntasSeguridadDataManager.setMostrarModificarPreguntaSeguridad(Boolean.TRUE);
		administrarPreguntasSeguridadDataManager.setMostrarCrearPreguntaSeguridad(Boolean.FALSE);
		administrarPreguntasSeguridadDataManager.setMostrarNuevaPreguntaSeguridad(Boolean.FALSE);
	}

	public void modificarPreguntaSeguridad() {
		try {
			// Modificar la Pregunta de Seguridad
			FwUtplFactory.getIntance().getCrudService().update(administrarPreguntasSeguridadDataManager.getModificarPreguntaSeguridad());

			administrarPreguntasSeguridadDataManager.setPreguntasSeguridad(FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE));
			administrarPreguntasSeguridadDataManager.setModificarPreguntaSeguridad(null);
			administrarPreguntasSeguridadDataManager.setMostrarModificarPreguntaSeguridad(Boolean.FALSE);
			administrarPreguntasSeguridadDataManager.setMostrarNuevaPreguntaSeguridad(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Pregunta de Seguridad modificada exitosamente");

		} catch (Exception e) {
			log.error("[modificarPreguntaSeguridad()] Error al modificar la pregunta seguridad en el sistema. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al modificar la pregunta seguridad en el sistema. Causa --> " + e);
		}
	}

	public void inicioEliminarPreguntaSeguridad(PreguntaSeguridad pPreguntaSeguridad) {
		administrarPreguntasSeguridadDataManager.setEliminarPreguntaSeguridad(pPreguntaSeguridad);
	}

	public void eliminarPreguntaSeguridad() {
		try {
			FwUtplFactory.getIntance().getCrudService().delete(administrarPreguntasSeguridadDataManager.getEliminarPreguntaSeguridad());

			administrarPreguntasSeguridadDataManager.setPreguntasSeguridad(FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE));
			administrarPreguntasSeguridadDataManager.setEliminarPreguntaSeguridad(null);
			administrarPreguntasSeguridadDataManager.setMostrarCrearPreguntaSeguridad(Boolean.FALSE);
			administrarPreguntasSeguridadDataManager.setMostrarModificarPreguntaSeguridad(Boolean.FALSE);
			administrarPreguntasSeguridadDataManager.setMostrarNuevaPreguntaSeguridad(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Pregunta de Seguridad eliminada exitosamente");

		} catch (Exception e) {
			log.error("[eliminarPreguntaSeguridad] Error al eliminar la pregunta seguridad. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al eliminar la pregunta seguridad. Causa --> " + e);
		}
	}

	public void cancelarIn() {
		init();
	}

	// Operaciones privadas

	// Getters/Setters
	public AdministrarPreguntaSeguridadDataManager getAdministrarPreguntasSeguridadDataManager() {
		return administrarPreguntasSeguridadDataManager;
	}

	public void setAdministrarPreguntasSeguridadDataManager(AdministrarPreguntaSeguridadDataManager administrarPreguntasSeguridadDataManager) {
		this.administrarPreguntasSeguridadDataManager = administrarPreguntasSeguridadDataManager;
	}

}
