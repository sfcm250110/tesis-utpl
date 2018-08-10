package org.tt.sgacec.web.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.ProcesarSriWebDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

/**
 * 
 * Controlador que maneja las opciones para procesar los errores producidos con el portal web del SRI
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class ProcesarSriWebControlador extends CommonController {
	
	private static final long serialVersionUID = -3799960211568360733L;

	private static Logger log = Logger.getLogger(ProcesarSriWebControlador.class);

	@ManagedProperty(value = Constantes.PROCESAR_SRI_WEB_DATA_MANAGER_EL)
	private ProcesarSriWebDataManager procesarSriWebDataManager;

	@Override
	public void init() {
		try {
			procesarSriWebDataManager.setMostrarProcesar(Boolean.FALSE);
			consultar();

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			List<CheckDownloadSri> checksDownloadSri = FwUtplFactory.getIntance().getAdmService().getChecksDownloadSri();
			
			if (checksDownloadSri == null || checksDownloadSri.isEmpty()) {
				procesarSriWebDataManager.setMostrarProcesarTodo(Boolean.FALSE);
				
			} else {
				procesarSriWebDataManager.setMostrarProcesarTodo(Boolean.TRUE);
			}
			
			procesarSriWebDataManager.setChecksDownloadSri(checksDownloadSri);

		} catch (Exception e) {
			log.error("[procesar()] Error al procesar los errores producidos con el portal web del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al procesar los errores producidos con el portal web del SRI. Causa --> " + e);
		}
	}
	
	public void procesarTodo() {
		try {
			FwUtplFactory.getIntance().getAdmService().procesarTodo(procesarSriWebDataManager.getChecksDownloadSri());
			init();
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Errores producidos con el portal web del SRI procesados exitosamente");

		} catch (Exception e) {
			log.error("[procesar()] Error al procesar los errores producidos con el portal web del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al procesar los errores producidos con el portal web del SRI. Causa --> " + e);
		}
	}
	
	public void inicioProcesar(CheckDownloadSri pCheckDownloadSri) {
		procesarSriWebDataManager.setCheckDownloadSri(pCheckDownloadSri);
		procesarSriWebDataManager.setMostrarProcesar(Boolean.TRUE);
		procesarSriWebDataManager.setMostrarProcesarTodo(Boolean.FALSE);
	}

	public void procesar() {
		try {
			FwUtplFactory.getIntance().getAdmService().procesar(procesarSriWebDataManager.getCheckDownloadSri());
			init();
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Error producido con el portal web del SRI procesado exitosamente");

		} catch (Exception e) {
			log.error("[procesar()] Error al procesar el error producido con el portal web del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al procesar el error producido con el portal web  del SRI. Causa --> " + e);
		}
	}

	public void cancelarIn() {
		init();
	}

	// Operaciones privadas

	// Getters/Setters
	public ProcesarSriWebDataManager getProcesarSriWebDataManager() {
		return procesarSriWebDataManager;
	}

	public void setProcesarSriWebDataManager(ProcesarSriWebDataManager procesarSriWebDataManager) {
		this.procesarSriWebDataManager = procesarSriWebDataManager;
	}

}
