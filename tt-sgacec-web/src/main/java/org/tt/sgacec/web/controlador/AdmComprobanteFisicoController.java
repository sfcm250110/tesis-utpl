package org.tt.sgacec.web.controlador;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.tt.sgacec.web.datamanager.AdmComprobanteFisicoDataManager;
import org.tt.sgacec.web.datamanager.InicioDataManager;
import org.tt.sgacec.web.util.JsfUtil;
import org.tt.sgacec.web.util.Utilitarios;

import ec.edu.utpl.sc.core.entity.ComprobanteFisico;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

@ManagedBean(name = Constantes.ADM_COMPROBANTE_FISICO_CONTROLLER)
@ViewScoped
public class AdmComprobanteFisicoController extends CommonController implements Serializable {
	
	private static final long serialVersionUID = -7112958012726762016L;
	
	private static Logger log = Logger.getLogger(AdmComprobanteFisicoController.class);
	
	@ManagedProperty(value = Constantes.ADM_COMPROBANTE_FISICO_DATAMANAGER_EL)
	private AdmComprobanteFisicoDataManager admComprobanteFisicoDataManager;

	@ManagedProperty(value = Constantes.INICIO_DATAMANAGER_EL)
	private InicioDataManager inicioDataManager;

	@Override
	public void init() {
		try {
			consultar();
			
			admComprobanteFisicoDataManager.setMostrarComprobantesFisico(Boolean.TRUE);
			admComprobanteFisicoDataManager.setMostrarModificarComprobanteFisico(Boolean.FALSE);
			admComprobanteFisicoDataManager.setMostrarEliminarComprobanteFisico(Boolean.FALSE);
			admComprobanteFisicoDataManager.setMostrarNuevoComprobanteFisico(Boolean.FALSE);
			
		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			ComprobanteFisico comprobanteFisico = new ComprobanteFisico();
			comprobanteFisico.setRuc(inicioDataManager.getEmpresa().getRuc());
			admComprobanteFisicoDataManager.setComprobantesFisico(FwUtplFactory.getIntance().getComprobanteService().getComprobantesFisico(comprobanteFisico));

		} catch (Exception e) {
			log.error("[consultar()] Error al consultar los comprobantes fisicos. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al consultar los comprobantes f\u00edsicos. Causa --> " + e);
		}
	}
	
	public void loadExcelFileUploadListener(FileUploadEvent pFileUploadEvent) {
		admComprobanteFisicoDataManager.setFileExcel(pFileUploadEvent.getFile().getContents());
	}
	
	public void loadComprobanteFileUploadListener(FileUploadEvent pFileUploadEvent) {
		admComprobanteFisicoDataManager.getCrearComprobanteFisico().setNombreComprobanteImagen(pFileUploadEvent.getFile().getFileName());
		admComprobanteFisicoDataManager.getCrearComprobanteFisico().setComprobanteImagen(pFileUploadEvent.getFile().getContents());
	}
	
	public void updateComprobanteFileUploadListener(FileUploadEvent pFileUploadEvent) {
		admComprobanteFisicoDataManager.getModificarComprobanteFisico().setNombreComprobanteImagen(pFileUploadEvent.getFile().getFileName());
		admComprobanteFisicoDataManager.getModificarComprobanteFisico().setComprobanteImagen(pFileUploadEvent.getFile().getContents());
	}
	
	public void seleccionarCarga(ValueChangeEvent pValueChangeEvent) {
		
	}
	
	public void nuevoComprobante() {
		ComprobanteFisico comprobanteFisico = new ComprobanteFisico();
		comprobanteFisico.setRuc(inicioDataManager.getEmpresa().getRuc());
		admComprobanteFisicoDataManager.setCrearComprobanteFisico(comprobanteFisico);
		
		admComprobanteFisicoDataManager.setMostrarComprobantesFisico(Boolean.FALSE);
		admComprobanteFisicoDataManager.setMostrarModificarComprobanteFisico(Boolean.FALSE);
		admComprobanteFisicoDataManager.setMostrarEliminarComprobanteFisico(Boolean.FALSE);
		admComprobanteFisicoDataManager.setMostrarNuevoComprobanteFisico(Boolean.TRUE);
		admComprobanteFisicoDataManager.setCargaByFile(Constantes.CARGA_BY_ARCHIVO);
	}
	
	public void crearComprobante() {
		try {
			List<ComprobanteFisico> comprobanteFisicos = Utilitarios.getComprobantesFisicos(admComprobanteFisicoDataManager.getCrearComprobanteFisico(), admComprobanteFisicoDataManager.getFileExcel());
			FwUtplFactory.getIntance().getComprobanteService().crearComprobantesFisicos(comprobanteFisicos);
			init();
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Los comprobantes f\u00edsicos se cargaron exitosamente");

		} catch (Exception e) {
			init();
			log.error("[crearComprobante()] Error al cargar los comprobantes fisicos. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al cargar los comprobantes f\u00edsicos. " + e.getMessage());
		}
	}
	
	public void inicioModificarComprobante(ComprobanteFisico pComprobanteFisico) {
		pComprobanteFisico.setFechaModificacion(new Date());
		admComprobanteFisicoDataManager.setModificarComprobanteFisico(pComprobanteFisico);
		
		admComprobanteFisicoDataManager.setMostrarComprobantesFisico(Boolean.FALSE);
		admComprobanteFisicoDataManager.setMostrarModificarComprobanteFisico(Boolean.TRUE);
		admComprobanteFisicoDataManager.setMostrarEliminarComprobanteFisico(Boolean.FALSE);
		admComprobanteFisicoDataManager.setMostrarNuevoComprobanteFisico(Boolean.FALSE);
	}
	
	public void modificarComprobante() {
		try {
			FwUtplFactory.getIntance().getComprobanteService().modificarComprobanteFisico(admComprobanteFisicoDataManager.getModificarComprobanteFisico());
			
			init();
			JsfUtil.addMessage(Constantes.MSJ_INFO, "El comprobante f\u00edsico se modifico exitosamente");

		} catch (Exception e) {
			log.error("[modificarComprobanteFisico()] Error al modificar el comprobante fisico. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al modificar el comprobante f\u00edsico. " + e.getMessage());
		}
	}
	
	public void inicioEliminarComprobante(ComprobanteFisico pComprobanteFisico) {
		admComprobanteFisicoDataManager.setEliminarComprobanteFisico(pComprobanteFisico);
		
		admComprobanteFisicoDataManager.setMostrarComprobantesFisico(Boolean.FALSE);
		admComprobanteFisicoDataManager.setMostrarModificarComprobanteFisico(Boolean.FALSE);
		admComprobanteFisicoDataManager.setMostrarEliminarComprobanteFisico(Boolean.TRUE);
		admComprobanteFisicoDataManager.setMostrarNuevoComprobanteFisico(Boolean.FALSE);
	}
	
	public void eliminarComprobante() {
		try {
			FwUtplFactory.getIntance().getCrudService().delete(admComprobanteFisicoDataManager.getEliminarComprobanteFisico());
			
			init();
			JsfUtil.addMessage(Constantes.MSJ_INFO, "El comprobante f\u00edsico se elimino exitosamente");

		} catch (Exception e) {
			log.error("[modificarComprobanteFisico()] Error al eliminar el comprobante fisico. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al eliminar el comprobante f\u00edsico. " + e.getMessage());
		}
	}
	
	public void cancelarIn() {
		init();
	}
	
	// Operaciones privadas
	
	// Getters/Setters
	public AdmComprobanteFisicoDataManager getAdmComprobanteFisicoDataManager() {
		return admComprobanteFisicoDataManager;
	}

	public void setAdmComprobanteFisicoDataManager(AdmComprobanteFisicoDataManager admComprobanteFisicoDataManager) {
		this.admComprobanteFisicoDataManager = admComprobanteFisicoDataManager;
	}

	public InicioDataManager getInicioDataManager() {
		return inicioDataManager;
	}

	public void setInicioDataManager(InicioDataManager inicioDataManager) {
		this.inicioDataManager = inicioDataManager;
	}
}
