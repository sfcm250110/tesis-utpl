package org.tt.sgacec.web.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.ConsultaComprobantesDataManager;
import org.tt.sgacec.web.datamanager.InicioDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

/**
 * 
 * Controlador que maneja las opciones para consultar los comprobantes descargados
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class ConsultaComprobantesControlador extends CommonController {
	
	private static final long serialVersionUID = -3799960211568360733L;

	private static Logger log = Logger.getLogger(ConsultaComprobantesControlador.class);

	@ManagedProperty(value = Constantes.CONSULTAR_COMPROBANTES_DATA_MANAGER_EL)
	private ConsultaComprobantesDataManager consultaComprobantesDataManager;
	
	@ManagedProperty(value = Constantes.INICIO_DATAMANAGER_EL)
	private InicioDataManager inicioDataManager;

	@Override
	public void init() {
		try {
			ComprobanteEmpresa comprobanteEmpresa = new ComprobanteEmpresa();
			comprobanteEmpresa.setRuc(inicioDataManager.getEmpresa().getRuc());
			consultaComprobantesDataManager.setComprobanteEmpresa(comprobanteEmpresa);
			consultaComprobantesDataManager.setFechaEmisionDesde(null);
			consultaComprobantesDataManager.setFechaEmisionHasta(null);
			consultaComprobantesDataManager.setComprobantesEmpresa(null);

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			consultaComprobantesDataManager.setComprobantesEmpresa(FwUtplFactory.getIntance().getComprobanteService().getComprobantesEmpresa(consultaComprobantesDataManager.getComprobanteEmpresa(), consultaComprobantesDataManager.getFechaEmisionDesde(), consultaComprobantesDataManager.getFechaEmisionHasta()));

		} catch (Exception e) {
			log.error("[consultar()] Error al consultar los comprobantes. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al consultar los comprobantes. Causa --> " + e);
		}
	}
	
	public void downloadXml(ComprobanteEmpresa pComprobanteEmpresa) {
		try {
			pComprobanteEmpresa.setRuc(inicioDataManager.getEmpresa().getRuc());
			
			String content = FwUtplFactory.getIntance().getComprobanteEmpresaService().generateFacturaXml(pComprobanteEmpresa);
			String nameFile = getNameFile(pComprobanteEmpresa);
			
			super.downloadXml(content, nameFile);
			
		} catch (Exception e) {
			log.error("[downloadXml()] Error al descargar el comprobante Xml. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al descargar el comprobante Xml. Causa --> " + e);
		}
	}
	
	public void downloadPdf(ComprobanteEmpresa pComprobanteEmpresa) {
		try {
			pComprobanteEmpresa.setRuc(inicioDataManager.getEmpresa().getRuc());
			
			byte[] content = FwUtplFactory.getIntance().getComprobanteEmpresaService().generateFacturaPdf(pComprobanteEmpresa);
			String nameFile = getNameFile(pComprobanteEmpresa);
			
			super.downloadPdf(content, nameFile);
			
		} catch (Exception e) {
			log.error("[downloadPdf()] Error al descargar el comprobante Pdf. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al descargar el comprobante Pdf. Causa --> " + e);
		}
	}

	public void cancelarIn() {
		cancelar();
	}

	// Operaciones privadas
	private String getNameFile(ComprobanteEmpresa pComprobanteEmpresa) {
		StringBuilder nameFile = new StringBuilder();
		nameFile.append(pComprobanteEmpresa.getEstablecimiento()).append(Constantes.GUION_MEDIO);
		nameFile.append(pComprobanteEmpresa.getPuntoEmision()).append(Constantes.GUION_MEDIO);
		nameFile.append(pComprobanteEmpresa.getSecuencial());
		
		return nameFile.toString();
	}

	// Getters/Setters
	public ConsultaComprobantesDataManager getConsultaComprobantesDataManager() {
		return consultaComprobantesDataManager;
	}

	public void setConsultaComprobantesDataManager(ConsultaComprobantesDataManager consultaComprobantesDataManager) {
		this.consultaComprobantesDataManager = consultaComprobantesDataManager;
	}
	
	public InicioDataManager getInicioDataManager() {
		return inicioDataManager;
	}

	public void setInicioDataManager(InicioDataManager inicioDataManager) {
		this.inicioDataManager = inicioDataManager;
	}

}
