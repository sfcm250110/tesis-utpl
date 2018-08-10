package org.tt.sgacec.web.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.ProcesarSriWsDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

/**
 * 
 * Controlador que maneja las opciones para procesar los errores producidos con el servicio web del SRI
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class ProcesarSriWsControlador extends CommonController {
	
	private static final long serialVersionUID = -3799960211568360733L;

	private static Logger log = Logger.getLogger(ProcesarSriWsControlador.class);

	@ManagedProperty(value = Constantes.PROCESAR_SRI_WS_DATA_MANAGER_EL)
	private ProcesarSriWsDataManager procesarSriWsDataManager;

	@Override
	public void init() {
		try {
			procesarSriWsDataManager.setMostrarProcesar(Boolean.FALSE);
			consultar();

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			List<ComprobanteEmpresa> comprobantesEmpresa = FwUtplFactory.getIntance().getComprobanteService().getComprobantes();
			
			if (comprobantesEmpresa == null || comprobantesEmpresa.isEmpty()) {
				procesarSriWsDataManager.setMostrarProcesarTodo(Boolean.FALSE);
				
			} else {
				procesarSriWsDataManager.setMostrarProcesarTodo(Boolean.TRUE);
			}
			
			procesarSriWsDataManager.setComprobantesEmpresa(comprobantesEmpresa);

		} catch (Exception e) {
			log.error("[procesar()] Error al procesar los errores producidos con el servicio web del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al procesar los errores producidos con el servicio web del SRI. Causa --> " + e);
		}
	}
	
	public void procesarTodo() {
		try {
			FwUtplFactory.getIntance().getComprobanteService().procesarTodo(procesarSriWsDataManager.getComprobantesEmpresa());
			init();
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Errores producidos con el servicio web del SRI procesados exitosamente");

		} catch (Exception e) {
			log.error("[procesar()] Error al procesar los errores producidos con el servicio web del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al procesar los errores producidos con el servicio web del SRI. Causa --> " + e);
		}
	}
	
	public void inicioProcesar(ComprobanteEmpresa pComprobanteEmpresa) {
		procesarSriWsDataManager.setComprobanteEmpresa(pComprobanteEmpresa);
		procesarSriWsDataManager.setMostrarProcesar(Boolean.TRUE);
		procesarSriWsDataManager.setMostrarProcesarTodo(Boolean.FALSE);
	}

	public void procesar() {
		try {
			FwUtplFactory.getIntance().getComprobanteService().procesar(procesarSriWsDataManager.getComprobanteEmpresa());
			init();
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Error producido con el servicio web del SRI procesado exitosamente");

		} catch (Exception e) {
			log.error("[procesar()] Error al procesar el error producido con el servicio web del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al procesar el error producido con el servicio web del SRI. Causa --> " + e);
		}
	}

	public void cancelarIn() {
		init();
	}

	// Operaciones privadas

	// Getters/Setters
	public ProcesarSriWsDataManager getProcesarSriWsDataManager() {
		return procesarSriWsDataManager;
	}

	public void setProcesarSriWsDataManager(ProcesarSriWsDataManager procesarSriWsDataManager) {
		this.procesarSriWsDataManager = procesarSriWsDataManager;
	}

}
