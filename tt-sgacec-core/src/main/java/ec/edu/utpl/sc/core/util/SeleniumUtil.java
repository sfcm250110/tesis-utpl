package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import ec.edu.utpl.sc.core.gestor.IComprobanteGestor;
import ec.edu.utpl.sc.core.vo.SessionUtil;

public class SeleniumUtil implements Serializable {
	
	private static final long serialVersionUID = 3751206929657222196L;

	public static DesiredCapabilities configWebDriverChrome(String pPathDirDownload, String pPathChromeWebDriver) {
		String pathChromeWebDriver = (String) SessionUtil.getObjetoSession(pPathChromeWebDriver);
		
		if (pathChromeWebDriver == null) {
			System.setProperty(Constantes.WEBDRIVER_CHROME_DRIVER, pPathChromeWebDriver);
			SessionUtil.addObjetoSession(pPathChromeWebDriver, pPathChromeWebDriver);
		}
		
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put(Constantes.PROFILE_DEFAULT_CONTENT_SETTINGS_POPUPS, Constantes.I0);
		chromePrefs.put(Constantes.DOWNLOAD_DEFAULT_DIRECTORY, pPathDirDownload);
		chromePrefs.put(Constantes.SAFE_BROWSING_ENABLED, Boolean.TRUE.toString());
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption(Constantes.PREFS, chromePrefs);
		
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, Boolean.TRUE);
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		return desiredCapabilities;
	}
	
	public static ComprobanteEmpresa obtenerFila(WebElement pColumnComprobante, ComprobanteEmpresa pComprobante) {
		Integer fila = Integer.parseInt(pColumnComprobante.getText().toString());
		pComprobante.setFila(fila);
		
		return pComprobante;
	}
	
	public static ComprobanteEmpresa obtenerRucRazonSocialEmisor(WebElement pColumnComprobante, ComprobanteEmpresa pComprobante) {
		String rucRazonSocialEmisor = pColumnComprobante.getText();
		String[] rucRazonSocialEmisorObject = rucRazonSocialEmisor.split(Constantes.BREAK_LINE);
		
		String rucEmisor = rucRazonSocialEmisorObject[Constantes.I0];
		String razonSocialEmisor = rucRazonSocialEmisorObject[Constantes.I1];
		
		pComprobante.setRucEmisor(rucEmisor);
		pComprobante.setRazonSocialEmisor(razonSocialEmisor);
		
		return pComprobante;
	}
	
	public static ComprobanteEmpresa obtenerTipoSerie(WebElement pColumnComprobante, ComprobanteEmpresa pComprobante, IComprobanteGestor pComprobanteGestor) throws UtplException {
		String tipoSerie = pColumnComprobante.getText();
		String[] tipoSerieObject = tipoSerie.split(Constantes.SPACE_BLANK);
		
		String tipo = null;
		String serie = null;
		
		if (tipoSerieObject.length > Constantes.I2) {
			tipo = tipoSerieObject[Constantes.I0] + Constantes.SPACE_BLANK + tipoSerieObject[Constantes.I1] + Constantes.SPACE_BLANK + tipoSerieObject[Constantes.I2];
			serie = tipoSerieObject[Constantes.I3];
			
		} else {
			tipo = tipoSerieObject[Constantes.I0];
			serie = tipoSerieObject[Constantes.I1];
		}
		
		pComprobante.setTipo(pComprobanteGestor.obtenerTipoComprobante(tipo));
		pComprobante.setEstablecimiento(serie.substring(Constantes.I0, Constantes.I3));
		pComprobante.setPuntoEmision(serie.substring(Constantes.I4, Constantes.I7));
		pComprobante.setSecuencial(serie.substring(Constantes.I8, serie.length()));
		
		return pComprobante;
	}
	
	public static ComprobanteEmpresa obtenerClaveAccesoNumeroAutorizacion(WebElement pColumnComprobante, ComprobanteEmpresa pComprobante) {
		String claveAccesoNumeroAutorizacion = pColumnComprobante.getText();
		String[] claveAccesoNumeroAutorizacionObject = claveAccesoNumeroAutorizacion.split(Constantes.BREAK_LINE);
		
		String claveAcceso = claveAccesoNumeroAutorizacionObject[Constantes.I0];
		claveAcceso = claveAcceso.substring(Constantes.I3, claveAcceso.length());
		
		String numeroAutorizacion = claveAccesoNumeroAutorizacionObject[Constantes.I1];
		numeroAutorizacion = numeroAutorizacion.substring(Constantes.I3, numeroAutorizacion.length());
		
		pComprobante.setClaveAcceso(claveAcceso);
		pComprobante.setNumeroAutorizacion(numeroAutorizacion);
		
		return pComprobante;
	}
	
	public static ComprobanteEmpresa obtenerFechaAutorizacion(WebElement pColumnComprobante, ComprobanteEmpresa pComprobante) {
		String fechaAutorizacion = pColumnComprobante.getText();
		pComprobante.setFechaAutorizacion(DateUtil.parseStringToDate(fechaAutorizacion, Constantes.DD_MM_YYYY_HHMMSS));
		
		return pComprobante;
	}
	
	public static ComprobanteEmpresa obtenerFechaEmision(WebElement pColumnComprobante, ComprobanteEmpresa pComprobante) {
		String fechaEmision = pColumnComprobante.getText();
		pComprobante.setFechaEmision(DateUtil.parseStringToDate(fechaEmision, Constantes.DD_MM_YYYY));
		
		return pComprobante;
	}
	
	public static ComprobanteEmpresa obtenerTipoEmision(WebElement pColumnComprobante, ComprobanteEmpresa pComprobante, IComprobanteGestor pComprobanteGestor) throws UtplException {
		String tipoEmision = pColumnComprobante.getText();
		pComprobante.setTipoEmision(pComprobanteGestor.obtenerTipoEmision(tipoEmision));
		
		return pComprobante;
	}

}
