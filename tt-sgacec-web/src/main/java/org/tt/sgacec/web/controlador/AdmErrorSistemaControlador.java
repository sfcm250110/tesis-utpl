package org.tt.sgacec.web.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.AdmErrorSistemaDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.ErrorSistema;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

@ManagedBean
@ViewScoped
public class AdmErrorSistemaControlador extends CommonController {
	
	// Constantes Generales
	private static final long serialVersionUID = -3503503876995585583L;
		
	private static Logger log = Logger.getLogger(AdmErrorSistemaControlador.class);
	
	@ManagedProperty(value = Constantes.ADM_ERROR_SISTEMA_DATA_MANAGER_EL)
	private AdmErrorSistemaDataManager admErrorSistemaDataManager;

	@Override
	public void init() {
		try {
			setModulos();
			setNiveles();
			admErrorSistemaDataManager.setErrorSistema(new ErrorSistema());
			consultar();

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones Publicas
	public void consultar() {
		try {
			admErrorSistemaDataManager.setErroresSistema(FwUtplFactory.getIntance().getAdmService().getErroresSistemaPrint(admErrorSistemaDataManager.getErrorSistema()));
			
		} catch (Exception e) {
			String mensajeUsuario = "Error al consultar los datos de los errores del sistema";
			
			log.error("[consultar()] " + mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			FwUtplFactory.getIntance().getAdmService().registerErrorSistema(e, Constantes.MODULO_WEB, Constantes.NIVEL_ERROR, mensajeUsuario);
		}
	}
	
	public void verDetalle(Long pIdErrorSistema) {
		try {
			admErrorSistemaDataManager.setPrintTraceTrace(FwUtplFactory.getIntance().getAdmService().getErrorSistemaPrint(pIdErrorSistema).getPrintTraceTrace());

		} catch (Exception e) {
			String mensajeUsuario = "Error al ver el detalle del error del sistema";
			
			log.error("[verDetalle()] " + mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			FwUtplFactory.getIntance().getAdmService().registerErrorSistema(e, Constantes.MODULO_WEB, Constantes.NIVEL_ERROR, mensajeUsuario);
		}
	}
	
	public void cancelarIn() {
		init();
	}
	
	// Operaciones Privadas
	private void setModulos() {
		List<SelectItem> modulosSelectItem = new ArrayList<SelectItem>();
		
		modulosSelectItem.add(new SelectItem(Constantes.MODULO_CORE, Constantes.MODULO_CORE));
		modulosSelectItem.add(new SelectItem(Constantes.MODULO_LN, Constantes.MODULO_LN));
		modulosSelectItem.add(new SelectItem(Constantes.MODULO_WEB, Constantes.MODULO_WEB));
		modulosSelectItem.add(new SelectItem(Constantes.MODULO_WS, Constantes.MODULO_WS));

		admErrorSistemaDataManager.setModulosSelectItem(modulosSelectItem);
	}
	
	private void setNiveles() {
		List<SelectItem> nivelesSelectItem = new ArrayList<SelectItem>();
		
		nivelesSelectItem.add(new SelectItem(Constantes.NIVEL_ERROR, Constantes.NIVEL_ERROR));
		nivelesSelectItem.add(new SelectItem(Constantes.NIVEL_FATAL, Constantes.NIVEL_FATAL));
		nivelesSelectItem.add(new SelectItem(Constantes.NIVEL_WARN, Constantes.NIVEL_WARN));
		nivelesSelectItem.add(new SelectItem(Constantes.NIVEL_INFO, Constantes.NIVEL_INFO));

		admErrorSistemaDataManager.setNivelesSelectItem(nivelesSelectItem);
	}
	
	// Getters/Setters
	public AdmErrorSistemaDataManager getAdmErrorSistemaDataManager() {
		return admErrorSistemaDataManager;
	}

	public void setAdmErrorSistemaDataManager(AdmErrorSistemaDataManager admErrorSistemaDataManager) {
		this.admErrorSistemaDataManager = admErrorSistemaDataManager;
	}

}
