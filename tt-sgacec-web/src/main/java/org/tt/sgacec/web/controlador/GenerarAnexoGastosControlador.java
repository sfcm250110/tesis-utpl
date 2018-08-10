package org.tt.sgacec.web.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.tt.sgacec.web.datamanager.GenerarAnexoGastosDataManager;
import org.tt.sgacec.web.datamanager.InicioDataManager;
import org.tt.sgacec.web.util.GraphicsUtil;
import org.tt.sgacec.web.util.JsfUtil;
import org.tt.sgacec.web.util.Utilitarios;

import ec.edu.utpl.sc.core.entity.ValorMaximoRubroSri;
import ec.edu.utpl.sc.core.util.AnexoGasto;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ExcelUtil;
import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.util.UtplException;

/**
 * 
 * Controlador que maneja las opciones para generar el anexo de gastos
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class GenerarAnexoGastosControlador extends CommonController {
	
	private static final long serialVersionUID = -3799960211568360733L;

	private static Logger log = Logger.getLogger(GenerarAnexoGastosControlador.class);

	@ManagedProperty(value = Constantes.GENERAR_ANEXO_GASTOS_DATAMANAGER_EL)
	private GenerarAnexoGastosDataManager generarAnexoGastosDataManager;

	@ManagedProperty(value = Constantes.INICIO_DATAMANAGER_EL)
	private InicioDataManager inicioDataManager;

	@Override
	public void init() {
		try {
			generarAnexoGastosDataManager.setPeriodos(FwUtplFactory.getIntance().getConsultasService().getPeriodos());
			AnexoGasto anexoGasto = new AnexoGasto();
			anexoGasto.setRuc(inicioDataManager.getEmpresa().getRuc());
			generarAnexoGastosDataManager.setAnexoGasto(anexoGasto);
			generarAnexoGastosDataManager.setMostrarAnexoExel(Boolean.FALSE);

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void generarAnexoGastos() {
		try {
			AnexoGasto anexoGasto = FwUtplFactory.getIntance().getAnexoGastoService().generateAnexoGastos(generarAnexoGastosDataManager.getAnexoGasto());
			
			if (anexoGasto == null) {
				generarAnexoGastosDataManager.setMostrarAnexoExel(Boolean.FALSE);
				
			} else {
				generarAnexoGastosDataManager.setAnexoGasto(anexoGasto);
				generarAnexoGastosDataManager.setValoresMaximosRubroSri(getValoresMaximoRubroSri());
				generarAnexoGastosDataManager.setSaludPieChartModel(GraphicsUtil.getIntance().generatePieChartModel(Constantes.LBL_SALUD, Constantes.LBL_UTILIZADO, Constantes.LBL_DISPONIBLE, anexoGasto.getSalud(), generarAnexoGastosDataManager.getValoresMaximosRubroSri().get(Constantes.SALUD).getValor()));
				generarAnexoGastosDataManager.setEducacionPieChartModel(GraphicsUtil.getIntance().generatePieChartModel(Constantes.LBL_EDUCACION, Constantes.LBL_UTILIZADO, Constantes.LBL_DISPONIBLE, anexoGasto.getEducacion(), generarAnexoGastosDataManager.getValoresMaximosRubroSri().get(Constantes.EDUCACION).getValor()));
				generarAnexoGastosDataManager.setAlimentacionPieChartModel(GraphicsUtil.getIntance().generatePieChartModel(Constantes.LBL_ALIMENTACION, Constantes.LBL_UTILIZADO, Constantes.LBL_DISPONIBLE, anexoGasto.getAlimentacion(), generarAnexoGastosDataManager.getValoresMaximosRubroSri().get(Constantes.ALIMENTACION).getValor()));
				generarAnexoGastosDataManager.setVestimentaPieChartModel(GraphicsUtil.getIntance().generatePieChartModel(Constantes.LBL_VESTIMENTA, Constantes.LBL_UTILIZADO, Constantes.LBL_DISPONIBLE, anexoGasto.getVestimenta(), generarAnexoGastosDataManager.getValoresMaximosRubroSri().get(Constantes.VESTIMENTA).getValor()));
				generarAnexoGastosDataManager.setViviendaPieChartModel(GraphicsUtil.getIntance().generatePieChartModel(Constantes.LBL_VIVIENDA, Constantes.LBL_UTILIZADO, Constantes.LBL_DISPONIBLE, anexoGasto.getVivienda(), generarAnexoGastosDataManager.getValoresMaximosRubroSri().get(Constantes.VIVIENDA).getValor()));
				generarAnexoGastosDataManager.setAnexoGastosPieChartModel(GraphicsUtil.getIntance().generateAnexoGastoPieChartModel(anexoGasto));
				generarAnexoGastosDataManager.setConsolidadoPieChartModel(GraphicsUtil.getIntance().generatePieChartModel(Constantes.LBL_CONSOLIDADO, Constantes.LBL_UTILIZADO, Constantes.LBL_DISPONIBLE, anexoGasto.getTotalAnexo(), generarAnexoGastosDataManager.getValoresMaximosRubroSri().get(Constantes.SALUD).getValor()));
				generarAnexoGastosDataManager.setTotalBaseImponiblePieChartModel(GraphicsUtil.getIntance().generatePieChartModel(Constantes.LBL_TOTAL_BASE_IMPONIBLE, Constantes.LBL_SIN_CLASIFICAR, Constantes.LBL_CLASIFICADO, anexoGasto.getSinClasificar(), anexoGasto.getTotalAnexo()));
				generarAnexoGastosDataManager.setMostrarAnexoExel(Boolean.TRUE);
			}

		} catch (Exception e) {
			String mensajeUsuario = "Error al generar el anexo de gastos";
			
			log.error("[generar()] " + mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, mensajeUsuario + ". " + e.getMessage() + " para este per\u00edodo");
			FwUtplFactory.getIntance().getAdmService().registerErrorSistema(e, Constantes.MODULO_WEB, Constantes.NIVEL_ERROR, mensajeUsuario);
		}
	}
	
	public void generarAnexoGastosSri() {
		try {
			List<AnexoGastoSri> anexosGastosSri = FwUtplFactory.getIntance().getAnexoGastoService().generateAnexoGastosSri(generarAnexoGastosDataManager.getAnexoGasto().getPeriodo(), generarAnexoGastosDataManager.getAnexoGasto().getRuc());
			byte[] content = ExcelUtil.generateAnexoGastoSri(anexosGastosSri);
			String nameFile = getNameFileSri(generarAnexoGastosDataManager.getAnexoGasto());
			
			super.downloadExcel(content, nameFile);
			
		} catch (Exception e) {
			log.error("[generarAnexoGastosSri()] Error al descargar el anexo de gastos del SRI. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al descargar el anexo de gastos del SRI. Causa --> " + e);
		}
	}
	
	public void downloadExcel() {
		try {
			byte[] content = ExcelUtil.generateAnexoGasto(generarAnexoGastosDataManager.getAnexoGasto());
			String nameFile = getNameFile(generarAnexoGastosDataManager.getAnexoGasto());
			
			super.downloadExcel(content, nameFile);
			
		} catch (Exception e) {
			log.error("[downloadExcel()] Error al descargar el archivo Excel. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al descargar el archivo Excel. Causa --> " + e);
		}
	}
	
	public void uploadConsolidarAnexoGastoUploadListener(FileUploadEvent pFileUploadEvent) {
		generarAnexoGastosDataManager.setConsolidarAnexoGastoExcel(pFileUploadEvent.getFile().getContents());
	}
	
	public void uploadConsolidarAnexoGasto() {
		try {
			AnexoGasto anexoGasto = Utilitarios.getConsolidarAnexoGasto(generarAnexoGastosDataManager.getConsolidarAnexoGastoExcel());
			FwUtplFactory.getIntance().getAnexoGastoService().consolidarAnexoGastos(anexoGasto);
			init();
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Se consolido la informaci\u00f3n del Anexo de Gastos exitosamente");

		} catch (Exception e) {
			init();
			log.error("[crearComprobante()] Error al cargar los comprobantes fisicos. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al cargar los comprobantes f\u00edsicos. " + e.getMessage());
		}
	}

	public void cancelarIn() {
		cancelar();
	}

	// Operaciones privadas
	private String getNameFile(AnexoGasto pAnexoGasto) {
		StringBuilder nameFile = new StringBuilder();
		nameFile.append(pAnexoGasto.getPeriodo()).append(Constantes.GUION_MEDIO);
		nameFile.append(pAnexoGasto.getRuc());
		
		return nameFile.toString();
	}
	
	private String getNameFileSri(AnexoGasto pAnexoGasto) {
		StringBuilder nameFile = new StringBuilder();
		nameFile.append(Constantes.NAME_FILE_XLS_ANEXO_GATOS_SRI);
		nameFile.append(pAnexoGasto.getPeriodo()).append(Constantes.GUION_MEDIO);
		nameFile.append(pAnexoGasto.getRuc());
		
		return nameFile.toString();
	}
	
	private Map<String, ValorMaximoRubroSri> getValoresMaximoRubroSri() throws UtplException {
		Map<String, ValorMaximoRubroSri> valoresMaximoRubroSriMap = generarAnexoGastosDataManager.getValoresMaximosRubroSri();
		
		ValorMaximoRubroSri valorMaximoRubroSri = new ValorMaximoRubroSri();
		valorMaximoRubroSri.setEstado(Boolean.TRUE);
		valorMaximoRubroSri.setPeriodo(generarAnexoGastosDataManager.getAnexoGasto().getPeriodo());
		List<ValorMaximoRubroSri> valoresMaximoRubroSri = FwUtplFactory.getIntance().getCrudService().findForCriteria(valorMaximoRubroSri, Boolean.FALSE);
		
		if (valoresMaximoRubroSri == null || valoresMaximoRubroSri.isEmpty()) {
			init();
			throw new UtplException("No se ha configurado los valores m\u00e1ximos del Sri");
			
		} else {
			valoresMaximoRubroSriMap = new HashMap<String, ValorMaximoRubroSri>();
			
			for (ValorMaximoRubroSri valorMaximoRubroSriTmp : valoresMaximoRubroSri) {
				if (Constantes.VIVIENDA.equals(valorMaximoRubroSriTmp.getRubro())) {
					valoresMaximoRubroSriMap.put(Constantes.VIVIENDA, valorMaximoRubroSriTmp);
					
				} else if (Constantes.SALUD.equals(valorMaximoRubroSriTmp.getRubro())) {
					valoresMaximoRubroSriMap.put(Constantes.SALUD, valorMaximoRubroSriTmp);
					
				} else if (Constantes.VESTIMENTA.equals(valorMaximoRubroSriTmp.getRubro())) {
					valoresMaximoRubroSriMap.put(Constantes.VESTIMENTA, valorMaximoRubroSriTmp);
					
				} else if (Constantes.ALIMENTACION.equals(valorMaximoRubroSriTmp.getRubro())) {
					valoresMaximoRubroSriMap.put(Constantes.ALIMENTACION, valorMaximoRubroSriTmp);
					
				} else if (Constantes.EDUCACION.equals(valorMaximoRubroSriTmp.getRubro())) {
					valoresMaximoRubroSriMap.put(Constantes.EDUCACION, valorMaximoRubroSriTmp);
				}
			}
		}
		
		return valoresMaximoRubroSriMap;
	}

	// Getters/Setters
	public GenerarAnexoGastosDataManager getGenerarAnexoGastosDataManager() {
		return generarAnexoGastosDataManager;
	}

	public void setGenerarAnexoGastosDataManager(GenerarAnexoGastosDataManager generarAnexoGastosDataManager) {
		this.generarAnexoGastosDataManager = generarAnexoGastosDataManager;
	}
	
	public InicioDataManager getInicioDataManager() {
		return inicioDataManager;
	}

	public void setInicioDataManager(InicioDataManager inicioDataManager) {
		this.inicioDataManager = inicioDataManager;
	}

}
