package org.tt.sgacec.web.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.AdministrarParametrosSistemaDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.ParametroGeneral;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.vo.SessionUtil;

/**
 * 
 * Controlador que maneja las opciones de administracion de los parametros del sistema
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class AdministrarParametrosSistemaControlador extends CommonController {
	
	// Constantes Generales
	private static final long serialVersionUID = -3503503876995585583L;
	
	private static Logger log = Logger.getLogger(AdministrarParametrosSistemaControlador.class);

	@ManagedProperty(value = Constantes.ADMINISTRAR_PARAMETROS_SISTEMA_DATA_MANAGER_EL)
	private AdministrarParametrosSistemaDataManager administrarParametrosSistemaDataManager;

	@Override
	public void init() {
		try {
			administrarParametrosSistemaDataManager.setParametroGeneral(new ParametroGeneral());
			administrarParametrosSistemaDataManager.setModoEditar(Boolean.FALSE);

			consultar();

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			administrarParametrosSistemaDataManager.setParametroGeneral(new ParametroGeneral());
			administrarParametrosSistemaDataManager.setParametrosGenerales(FwUtplFactory.getIntance().getCrudService().findForCriteria(administrarParametrosSistemaDataManager.getParametroGeneral(), Boolean.FALSE));

		} catch (Exception e) {
			log.info("[consultar()] Error al consultar los datos de los parametros generales. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al consultar los datos de los parametros generales. Causa --> " + e);
		}
	}

	public void inicioModificacion(ParametroGeneral pParametroGeneral) {
		administrarParametrosSistemaDataManager.setModoEditar(Boolean.TRUE);
		administrarParametrosSistemaDataManager.setParametroGeneral(pParametroGeneral);
	}

	public void modificacion() {
		try {
			FwUtplFactory.getIntance().getFwService().modificarParametroGeneral(administrarParametrosSistemaDataManager.getParametroGeneral());

			JsfUtil.addMessage(Constantes.MSJ_INFO, "Se modifico exitosamente el parametro general");
			cancelarIn();

		} catch (Exception e) {
			log.info("[modificacion()] Error al modificar los datos del parametro generale. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al modificar los datos del parametro general. Causa --> " + e);
		}
	}

	public void cancelarIn() {
		administrarParametrosSistemaDataManager.setParametroGeneral(null);
		administrarParametrosSistemaDataManager.setModoEditar(Boolean.FALSE);
	}

	public void resetVariablesSession() {
		try {
			SessionUtil.resetObjetosSession();
			FwUtplFactory.getIntance().getGenericoService().initApplication();
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Se reseteo exitosamente las Variables de Sessi\u00f3n del sistema");
			
		} catch (Exception e) {
			String mensajeUsuario = "Error al resetear las variables de session del sistema";
			
			log.error("[resetVariablesSession()] " + mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			FwUtplFactory.getIntance().getAdmService().registerErrorSistema(e, Constantes.MODULO_WEB, Constantes.NIVEL_ERROR, mensajeUsuario);
		}
	}

	// Operaciones privadas

	// Getters/Setters
	public AdministrarParametrosSistemaDataManager getAdministrarParametrosSistemaDataManager() {
		return administrarParametrosSistemaDataManager;
	}

	public void setAdministrarParametrosSistemaDataManager(AdministrarParametrosSistemaDataManager administrarParametrosSistemaDataManager) {
		this.administrarParametrosSistemaDataManager = administrarParametrosSistemaDataManager;
	}

}
