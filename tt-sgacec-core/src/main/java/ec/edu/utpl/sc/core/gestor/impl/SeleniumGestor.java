package ec.edu.utpl.sc.core.gestor.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.gestor.IComprobanteGestor;
import ec.edu.utpl.sc.core.gestor.IParametroGeneralGestor;
import ec.edu.utpl.sc.core.gestor.ISeleniumGestor;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.DateFindSri;
import ec.edu.utpl.sc.core.util.SeleniumUtil;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.SELENIUM_GESTOR)
public class SeleniumGestor implements ISeleniumGestor {
	
	private static final Logger log = Logger.getLogger(SeleniumGestor.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_GESTOR)
	private IComprobanteGestor comprobanteGestor;
	
	@Autowired
	@Qualifier(Constantes.PARAMETRO_GENERAL_GESTOR)
	private IParametroGeneralGestor parametroGeneralGestor;
	
	@Override
	public CheckDownloadSri obtenerTotalComprobantesSri(String pUsuarioSri, String pClaveSri, DateFindSri pDateFindSri) throws UtplException {
		WebDriver webDriver = null;
		
		try {
			String pathChromeWebDriver = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_CHROME_WEBDRIVER);
			String pathDirDownload = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_DOWNLOAD_CHROME);
			webDriver = new ChromeDriver(SeleniumUtil.configWebDriverChrome(pathDirDownload, pathChromeWebDriver));
			webDriver.manage().timeouts().pageLoadTimeout(Constantes.I40, TimeUnit.SECONDS);
			//TODO:
			// webDriver.manage().window().setPosition(new Point(-2000, 0));
			
			// Ingresar al sistema
			webDriver.get(Constantes.URL_SRI);
			webDriver.findElement(By.name(Constantes.ELEMENT_USER_NAME)).sendKeys(pUsuarioSri);
			webDriver.findElement(By.name(Constantes.ELEMENT_PASSWORD)).sendKeys(pClaveSri);
			webDriver.findElement(By.name(Constantes.ELEMENT_BOTON)).click();
			
			// Cerrar el popUp
			try {
				webDriver.findElement(By.linkText(Constantes.ELEMENT_OCULTAR)).click();
				
			} catch (org.openqa.selenium.NoSuchElementException e) {
				log.info("No existe el popUp Ocultar");
			}
			
			// Consultar los comprobantes
			webDriver.get(Constantes.URL_SRI_CONSULTA_COMPROBANTES_ELECTRONICOS);
			webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_ID_ANIO)).sendKeys(pDateFindSri.getAnio());
			webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_ID_MES)).sendKeys(pDateFindSri.getMes());
			new Select(webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_ID_DIA))).selectByValue(pDateFindSri.getDia());
			webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_BTN_BUSCAR)).click();
			
			// Obtener la tabla de comprobantes encontrados
			WebElement comprobantesTable = null;
			try {
				comprobantesTable = webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_TABLE_COMP_RECIBIDOS));
				
			} catch (NoSuchElementException e) {
				log.info("No se encontraron resultados para la consulta");
				comprobantesTable = null;
			}
						
			CheckDownloadSri checkDownloadSri = new CheckDownloadSri();
			Integer paginado = null;
			Integer totalFilas = null;
			Integer totalPaginas = null;
			Integer fila = null;
			
			if (comprobantesTable == null) {
				paginado = Constantes.I0;
				totalPaginas = Constantes.I0;
				totalFilas = Constantes.I0;
				fila = Constantes.I0;
				
			} else {
				WebElement paginadoSelected = comprobantesTable.findElement(By.xpath(Constantes.ELEMENT_XPATH_PAGINADO));
				paginado = Integer.parseInt(paginadoSelected.getText());
				
				WebElement numeroPaginasSelected = comprobantesTable.findElement(By.xpath(Constantes.ELEMENT_XPATH_NUMERO_PAGINAS));
				String numeroPaginasLbl = numeroPaginasSelected.getText();
				int start = numeroPaginasLbl.indexOf(Constantes.OF) + Constantes.I3;
				int finish = numeroPaginasLbl.length() - Constantes.I1;
				totalPaginas = Integer.parseInt(numeroPaginasLbl.substring(start, finish));
				
				totalFilas = (totalPaginas - Constantes.I1) * paginado;
				Integer numeroRows = Constantes.I0;
				if (Constantes.I0.equals(totalFilas)) {
					// Numero de comprobantes en la primera pagina
					List<WebElement> rowsComprobantesFirstPage = comprobantesTable.findElements(By.xpath(Constantes.ELEMENT_XPATH_FRM_PRINCIPAL_TABLE_COMP_RECIBIDOS_ROW));
					numeroRows = rowsComprobantesFirstPage.size();
					totalFilas = totalFilas + numeroRows;
					
				} else {
					//TODO: Verificar cuando se tenga una consulta como mas 2 paginas
					// Clic en la ultima pagina
					comprobantesTable.findElement(By.xpath(Constantes.ELEMENT_XPATH_LAST_PAGE)).click();
					
					// Numero de comprobantes en la ultima pagina
					List<WebElement> rowsComprobantesLastPage = comprobantesTable.findElements(By.xpath(Constantes.ELEMENT_XPATH_FRM_PRINCIPAL_TABLE_COMP_RECIBIDOS_ROW));
					numeroRows = rowsComprobantesLastPage.size();
					totalFilas = totalFilas + numeroRows;
				}
			}
			
			checkDownloadSri.setPaginado(paginado);
			checkDownloadSri.setTotalPaginas(totalPaginas);
			checkDownloadSri.setTotalFilas(totalFilas);
			checkDownloadSri.setFila(fila);
			checkDownloadSri.setEtapa(Constantes.REGISTRADO);
			
			if (Constantes.I0.equals(checkDownloadSri.getTotalFilas())) {
				checkDownloadSri.setEtapa(Constantes.NO_PROCESAR);
			}
			
			return checkDownloadSri;
			
		} catch (Exception e) {
			throw new UtplException(e);
			
		} finally {
			if (webDriver != null) {
				webDriver.quit();
			}
		}
	}
	
	@Override
	public List<ComprobanteEmpresa> downloadComprobantesSri(String pUsuarioSri, String pClaveSri, DateFindSri pDateFindSri, Boolean pXmlPdf) throws UtplException {
		WebDriver webDriver = null;
		
		try {
			String pathChromeWebDriver = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_CHROME_WEBDRIVER);
			String pathDirDownload = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_DOWNLOAD_CHROME);
			webDriver = new ChromeDriver(SeleniumUtil.configWebDriverChrome(pathDirDownload, pathChromeWebDriver));
			webDriver.manage().timeouts().pageLoadTimeout(Constantes.I40, TimeUnit.SECONDS);
			//TODO:
			// webDriver.manage().window().setPosition(new Point(-2000, 0));
			
			// Ingresar al sistema
			webDriver.get(Constantes.URL_SRI);
			webDriver.findElement(By.name(Constantes.ELEMENT_USER_NAME)).sendKeys(pUsuarioSri);
			webDriver.findElement(By.name(Constantes.ELEMENT_PASSWORD)).sendKeys(pClaveSri);
			webDriver.findElement(By.name(Constantes.ELEMENT_BOTON)).click();
			
			// Cerrar el popUp
			try {
				webDriver.findElement(By.linkText(Constantes.ELEMENT_OCULTAR)).click();
				
			} catch (org.openqa.selenium.NoSuchElementException e) {
				log.info("No existe el popUp Ocultar");
			}
			
			webDriver.get(Constantes.URL_SRI_CONSULTA_COMPROBANTES_ELECTRONICOS);
			webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_ID_ANIO)).sendKeys(pDateFindSri.getAnio());
			webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_ID_MES)).sendKeys(pDateFindSri.getMes());
			new Select(webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_ID_DIA))).selectByValue(pDateFindSri.getDia());
			webDriver.findElement(By.id(Constantes.ELEMENT_FRM_PRINCIPAL_BTN_BUSCAR)).click();
			
			// Obtener la tabla de comprobantes encontrados
			String elementSriFrmPrincipalTable = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_ELEMENT_SRI_FRM_PRINCIPAL_TABLE);
			WebElement comprobantesTable = webDriver.findElement(By.id(elementSriFrmPrincipalTable));
			List<ComprobanteEmpresa> comprobantesEmpresa = new ArrayList<ComprobanteEmpresa>();
			
			String elementXpathFrmPrincipalTableCompRecibidosRow = Constantes.ELEMENT_XPATH_ID + elementSriFrmPrincipalTable + Constantes.ELEMENT_XPATH_TABLE_TBODY_TR;
			List<WebElement> rowsComprobantes = comprobantesTable.findElements(By.xpath(elementXpathFrmPrincipalTableCompRecibidosRow));
			int rowIndex = Constantes.I1;
			
			if (null != rowsComprobantes) {
				
				for (WebElement rowComprobante : rowsComprobantes) {
					List<WebElement> columnsComprobante = rowComprobante.findElements(By.xpath(Constantes.ELEMENT_TD));
					ComprobanteEmpresa comprobanteEmpresa = new ComprobanteEmpresa();
					comprobanteEmpresa.setFechaRegistro(new Date());
					int columnIndex = Constantes.I1;
					
					for (WebElement columnComprobante : columnsComprobante) {
						
						if (columnIndex == Constantes.COLUMNA_FILA) {
							comprobanteEmpresa = SeleniumUtil.obtenerFila(columnComprobante, comprobanteEmpresa);
						} else
						
						if (columnIndex == Constantes.COLUMNA_RUC_RAZON_SOCIAL) {
							comprobanteEmpresa = SeleniumUtil.obtenerRucRazonSocialEmisor(columnComprobante, comprobanteEmpresa);
						} else
							
						if (columnIndex == Constantes.COLUMNA_CLAVE_ACCESO_NUMERO_AUTORIZACION) {
							comprobanteEmpresa = SeleniumUtil.obtenerClaveAccesoNumeroAutorizacion(columnComprobante, comprobanteEmpresa);
						} else
							
						if (columnIndex == Constantes.COLUMNA_TIPO_SERIE) {
							comprobanteEmpresa = SeleniumUtil.obtenerTipoSerie(columnComprobante, comprobanteEmpresa, comprobanteGestor);
						} else
							
						if (columnIndex == Constantes.COLUMNA_FECHA_AUTORIZACION) {
							comprobanteEmpresa = SeleniumUtil.obtenerFechaAutorizacion(columnComprobante, comprobanteEmpresa);
						} else
							
						if (columnIndex == Constantes.COLUMNA_FECHA_EMISION) {
							comprobanteEmpresa = SeleniumUtil.obtenerFechaEmision(columnComprobante, comprobanteEmpresa);
						} else
							
						if (columnIndex == Constantes.COLUMNA_TIPO_EMISION) {
							comprobanteEmpresa = SeleniumUtil.obtenerTipoEmision(columnComprobante, comprobanteEmpresa, comprobanteGestor);
						} else
						
						if (columnIndex == Constantes.COLUMNA_XML || columnIndex == Constantes.COLUMNA_PDF) {
							if (pXmlPdf) {
								//TODO:
								columnComprobante.click();
							}
						}
						
						Thread.sleep(Constantes.I500);
						columnIndex = columnIndex + 1;
					}
					
					comprobantesEmpresa.add(comprobanteEmpresa);
					rowIndex = rowIndex + 1;
				}
			}
			
			return comprobantesEmpresa;
			
		} catch (Exception e) {
			throw new UtplException(e);
			
		} finally {
			if (webDriver != null) {
				webDriver.quit();
			}
		}
	}

}
