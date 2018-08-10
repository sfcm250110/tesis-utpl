package org.tt.sgacec.web.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.OlvidoClaveDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.PreguntaSeguridad;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.util.UtplException;

/**
 * 
 * Controlador que maneja las opciones de recuperacion de la clave del usuario
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class OlvidoClaveControlador extends CommonController {
	
	private static final long serialVersionUID = -7547783208151883917L;

	private static Logger log = Logger.getLogger(OlvidoClaveControlador.class);

	@ManagedProperty(value = Constantes.OLVIDO_CLAVE_DATA_MANAGER_EL)
	private OlvidoClaveDataManager olvidoClaveDataManager;

	@Override
	public void init() {
		try {
			olvidoClaveDataManager.setEmail(null);
			olvidoClaveDataManager.setIdPreguntaSeguridad(null);
			olvidoClaveDataManager.setRespuestaSeguridad(null);
			olvidoClaveDataManager.setUsuario(null);
			
			olvidoClaveDataManager.setTituloOpcionUsuario(Constantes.MSJ_VERIFICAR_EMAIL_OLVIDO_CLAVE);
			olvidoClaveDataManager.setInformacionEmail(Boolean.TRUE);
			olvidoClaveDataManager.setInformacionPreguntaSeguridad(Boolean.FALSE);
			olvidoClaveDataManager.setInformacionExitosa(Boolean.FALSE);

			establecerPreguntasSeguridad();

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void verificarEmail() {
		try {
			Usuario usuario = new Usuario();
			usuario.setUserName(olvidoClaveDataManager.getEmail());
			usuario = FwUtplFactory.getIntance().getCrudService().findOneRow(usuario, Boolean.FALSE);

			if (usuario == null) {
				JsfUtil.addMessage(Constantes.MSJ_ERROR, "Usuario no Registrado");
				return;

			} else {
				olvidoClaveDataManager.setUsuario(usuario);
				olvidoClaveDataManager.setInformacionEmail(Boolean.FALSE);
				olvidoClaveDataManager.setInformacionPreguntaSeguridad(Boolean.TRUE);
				olvidoClaveDataManager.setInformacionExitosa(Boolean.FALSE);
				olvidoClaveDataManager.setTituloOpcionUsuario(Constantes.MSJ_PREGUNTA_SECRETA_OLVIDO_CLAVE);
			}

		} catch (Exception e) {
			log.error("[verificarEmail()] Error al recuperar la clave del usuario. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al recuperar la clave del usuario. Causa --> " + e);
		}
	}

	public void verificarPreguntaSeguridad() {
		try {
			if (!olvidoClaveDataManager.getIdPreguntaSeguridad().equals(olvidoClaveDataManager.getUsuario().getPreguntaSeguridad().getIdPreguntaSeguridad())) {
				JsfUtil.addMessage(Constantes.MSJ_ERROR, "Pregunta Incorrecta");
				return;
			}

			if (!olvidoClaveDataManager.getRespuestaSeguridad().equals(olvidoClaveDataManager.getUsuario().getRespuestaSeguridad())) {
				JsfUtil.addMessage(Constantes.MSJ_ERROR, "Respuesta Incorrecta");
				return;
			}
			
			FwUtplFactory.getIntance().getAdmService().recoveryKey(olvidoClaveDataManager.getUsuario());

			olvidoClaveDataManager.setInformacionEmail(Boolean.FALSE);
			olvidoClaveDataManager.setInformacionPreguntaSeguridad(Boolean.FALSE);
			olvidoClaveDataManager.setInformacionExitosa(Boolean.TRUE);
			olvidoClaveDataManager.setTituloOpcionUsuario(Constantes.MSJ_RECUPERACION_EXITOSA_OLVIDO_CLAVE);

		} catch (Exception e) {
			log.error("[verificarEmail()] Error al recuperar la clave del usuario. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al recuperar la clave del usuario. Causa --> " + e);
		}
	}

	public void atrasVerificarEmail() {
		olvidoClaveDataManager.setTituloOpcionUsuario(Constantes.MSJ_VERIFICAR_EMAIL_OLVIDO_CLAVE);
		olvidoClaveDataManager.setInformacionEmail(Boolean.TRUE);
		olvidoClaveDataManager.setInformacionPreguntaSeguridad(Boolean.FALSE);
		olvidoClaveDataManager.setInformacionExitosa(Boolean.FALSE);
	}

	// Operaciones Privadas
	private void establecerPreguntasSeguridad() throws UtplException {
		List<PreguntaSeguridad> preguntasSeguridad = FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE);
		List<SelectItem> preguntasSeguridadSelectItem = new ArrayList<SelectItem>();

		for (PreguntaSeguridad preguntaSeguridad : preguntasSeguridad) {
			preguntasSeguridadSelectItem.add(new SelectItem(preguntaSeguridad.getIdPreguntaSeguridad(), preguntaSeguridad.getPreguntaSeguridad()));
		}

		olvidoClaveDataManager.setPreguntasSeguridadSelectItem(preguntasSeguridadSelectItem);
	}

	// Getters/Setters
	public OlvidoClaveDataManager getOlvidoClaveDataManager() {
		return olvidoClaveDataManager;
	}

	public void setOlvidoClaveDataManager(OlvidoClaveDataManager olvidoClaveDataManager) {
		this.olvidoClaveDataManager = olvidoClaveDataManager;
	}
}
