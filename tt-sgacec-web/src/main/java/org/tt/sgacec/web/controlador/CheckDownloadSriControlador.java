package org.tt.sgacec.web.controlador;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.CheckDownloadSriDataManager;
import org.tt.sgacec.web.datamanager.InicioDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

/**
 * 
 * Controlador que maneja las opciones para procesar la descarga de los comprobantes del portal web del SRI
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class CheckDownloadSriControlador extends CommonController {
	
	private static final long serialVersionUID = -7868898709805507575L;

	private static Logger log = Logger.getLogger(CheckDownloadSriControlador.class);

	@ManagedProperty(value = Constantes.CHECK_DOWNLOAD_SRI_DATA_MANAGER_EL)
	private CheckDownloadSriDataManager checkDownloadSriDataManager;
	
	@ManagedProperty(value = Constantes.INICIO_DATAMANAGER_EL)
	private InicioDataManager inicioDataManager;

	@Override
	public void init() {
		try {
			CheckDownloadSri checkDownloadSri = new CheckDownloadSri();
			checkDownloadSri.setRuc(inicioDataManager.getEmpresa().getRuc());
			checkDownloadSri.setFechaDownload(new Date());
			checkDownloadSriDataManager.setCheckDownloadSri(checkDownloadSri);
			
			consultar();

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			checkDownloadSriDataManager.setChecksDownloadSri(FwUtplFactory.getIntance().getCrudService().findForCriteria(checkDownloadSriDataManager.getCheckDownloadSri(), Constantes.TYPE_ORDER_DESC, Constantes.FIELD_FECHA_DOWNLOAD, Boolean.FALSE));

		} catch (Exception e) {
			log.error("[consultar()] Error al consultar los registros check download del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al consultar los registros check download del SRI. Causa --> " + e);
		}
	}
	
	public void checkDownloadSri() {
		try {
			FwUtplFactory.getIntance().getAdmService().checkDownloadSri(inicioDataManager.getEmpresa(), checkDownloadSriDataManager.getFechaCheckDownloadSri());
			init();
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "La verificaci\u00f3n (check) de la descarga del portal web del SRI se proceso exitosamente");

		} catch (Exception e) {
			log.error("[checkDownloadSri()] Error al check download del portal web del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al check download del portal web del SRI. Causa --> " + e);
		}
	}

	public void cancelarIn() {
		init();
	}

	// Operaciones privadas

	// Getters/Setters
	public CheckDownloadSriDataManager getCheckDownloadSriDataManager() {
		return checkDownloadSriDataManager;
	}

	public void setCheckDownloadSriDataManager(CheckDownloadSriDataManager checkDownloadSriDataManager) {
		this.checkDownloadSriDataManager = checkDownloadSriDataManager;
	}
	
	public InicioDataManager getInicioDataManager() {
		return inicioDataManager;
	}

	public void setInicioDataManager(InicioDataManager inicioDataManager) {
		this.inicioDataManager = inicioDataManager;
	}

}
