package org.tt.sgacec.web.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlForm;

import org.tt.sgacec.web.datamanager.DownloadDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.util.Constantes;

/**
 * 
 * Controlador con operaciones comunes a todos los controladores de la aplicacion
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public abstract class CommonController implements Serializable {
	
	private static final long serialVersionUID = -2480307542296598770L;

	private HtmlForm form;

	@ManagedProperty(value = Constantes.DOWNLOAD_DATAMANAGER_EL)
	private DownloadDataManager downloadDataManager;

	public abstract void init();
	
	@PostConstruct
	public void inicializarServicios() {
	}
	
	public String cancelar() {
		return Constantes.REDIRIGIR_INICIO;
	}
	
	public String obtenerIp() throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		
		return inetAddress.getHostAddress();
	}
	
	public void downloadXml(String pContent, String pNameFile) throws IOException {
		downloadDataManager.setType(Constantes.TYPE_XML);
		downloadDataManager.setName(pNameFile);
		downloadDataManager.setContent(pContent);
		
		JsfUtil.downloadFile();
	}
	
	public void downloadPdf(byte[] pContent, String pNameFile) throws IOException {
		downloadDataManager.setType(Constantes.TYPE_PDF);
		downloadDataManager.setName(pNameFile);
		downloadDataManager.setContentBytes(pContent);
		
		JsfUtil.downloadFile();
	}
	
	public void downloadExcel(byte[] pContent, String pNameFile) {
		try {
			downloadDataManager.setType(Constantes.TYPE_XLS);
			downloadDataManager.setName(pNameFile);
			downloadDataManager.setContentBytes(pContent);
			
			JsfUtil.downloadFile();

		} catch (Exception e) {
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al descargar el archivo Excel. Causa --> " + e);
		}
	}

	// Getters/Setters
	public HtmlForm getForm() {
		init();
		
		return this.form;
	}

	public void inicializarDatos(HtmlForm form) {
		this.form = form;
	}

	public DownloadDataManager getDownloadDataManager() {
		return downloadDataManager;
	}

	public void setDownloadDataManager(DownloadDataManager downloadDataManager) {
		this.downloadDataManager = downloadDataManager;
	}

}
