package org.tt.sgacec.web.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.AdmEmpresaDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.util.UtplException;

@ManagedBean(name = Constantes.ADM_EMPRESA_CONTROLLER)
@ViewScoped
public class AdmEmpresaController extends CommonController {
	
	// Constantes Generales
	private static final long serialVersionUID = -7112958012726762016L;
	private static Logger log = Logger.getLogger(AdmEmpresaController.class);

	@ManagedProperty(value = Constantes.ADM_EMPRESA_DATAMANAGER_EL)
	private AdmEmpresaDataManager admEmpresaDataManager;

	@Override
	public void init() {
		try {
			admEmpresaDataManager.setMostrarEmpresas(Boolean.TRUE);
			admEmpresaDataManager.setMostrarNuevaEmpresa(Boolean.TRUE);
			admEmpresaDataManager.setMostrarCrearEmpresa(Boolean.FALSE);
			admEmpresaDataManager.setMostrarModificarEmpresa(Boolean.FALSE);
			consultar();
			
		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			admEmpresaDataManager.setEmpresas(FwUtplFactory.getIntance().getEmpresaService().obtenerEmpresas());
			
		} catch (Exception e) {
			log.info("[consultar()] Error al consultar las empresas. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al consultar las empresas. Causa --> " + e);
		}
	}
	
	public void nuevaEmpresa() {
		admEmpresaDataManager.setCrearEmpresa(new Empresa());
		
		admEmpresaDataManager.setMostrarEmpresas(Boolean.FALSE);
		admEmpresaDataManager.setMostrarCrearEmpresa(Boolean.TRUE);
		admEmpresaDataManager.setMostrarModificarEmpresa(Boolean.FALSE);
		admEmpresaDataManager.setMostrarNuevaEmpresa(Boolean.FALSE);
	}
	
	public void crearEmpresa() {
		try {
			FwUtplFactory.getIntance().getEmpresaService().crearEmpresa(admEmpresaDataManager.getCrearEmpresa());
			
			consultar();
			admEmpresaDataManager.setCrearEmpresa(null);
			admEmpresaDataManager.setMostrarEmpresas(Boolean.TRUE);
			admEmpresaDataManager.setMostrarCrearEmpresa(Boolean.FALSE);
			admEmpresaDataManager.setMostrarNuevaEmpresa(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Empresa registrada exitosamente");

		} catch (Exception e) {
			log.error("[crearEmpresa()] Error al crear la empresa. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al crear la empresa. " + e.getMessage());
		}
	}
	
	public void inicioModificarEmpresa(Empresa pEmpresa) {
		admEmpresaDataManager.setModificarEmpresa(pEmpresa);
		
		admEmpresaDataManager.setMostrarEmpresas(Boolean.FALSE);
		admEmpresaDataManager.setMostrarModificarEmpresa(Boolean.TRUE);
		admEmpresaDataManager.setMostrarCrearEmpresa(Boolean.FALSE);
		admEmpresaDataManager.setMostrarNuevaEmpresa(Boolean.FALSE);
	}
	
	public void modificarEmpresa() {
		try {
			admEmpresaDataManager.getModificarEmpresa().setFechaDownload(admEmpresaDataManager.getModificarEmpresa().getFechaInitDownload());
			FwUtplFactory.getIntance().getCrudService().update(admEmpresaDataManager.getModificarEmpresa());
			
			consultar();
			admEmpresaDataManager.setModificarEmpresa(null);
			admEmpresaDataManager.setMostrarEmpresas(Boolean.TRUE);
			admEmpresaDataManager.setMostrarModificarEmpresa(Boolean.FALSE);
			admEmpresaDataManager.setMostrarNuevaEmpresa(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Empresa actualizada exitosamente");
			
		} catch (UtplException e) {
			log.error("[modificarEmpresa()] Error al actualizar la empresa. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al actualizar la empresa. " + e.getMessage());
		}
	}
	
	public void cancelarIn() {
		init();
	}

	// Operaciones privadas

	// Getters/Setters
	public AdmEmpresaDataManager getAdmEmpresaDataManager() {
		return admEmpresaDataManager;
	}

	public void setAdmEmpresaDataManager(AdmEmpresaDataManager admEmpresaDataManager) {
		this.admEmpresaDataManager = admEmpresaDataManager;
	}
}
