package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.edu.utpl.sc.core.servicio.IAdmServicio;
import ec.edu.utpl.sc.core.servicio.IAnexoGastoServicio;
import ec.edu.utpl.sc.core.servicio.IComprobanteEmpresaServicio;
import ec.edu.utpl.sc.core.servicio.IComprobanteServicio;
import ec.edu.utpl.sc.core.servicio.IConsultasServicio;
import ec.edu.utpl.sc.core.servicio.ICrudServicio;
import ec.edu.utpl.sc.core.servicio.IDownloadSriServicio;
import ec.edu.utpl.sc.core.servicio.IEmpresaServicio;
import ec.edu.utpl.sc.core.servicio.IFileServicio;
import ec.edu.utpl.sc.core.servicio.IFwServicio;
import ec.edu.utpl.sc.core.servicio.IGenericoServicio;
import ec.edu.utpl.sc.core.servicio.IHttpServicio;
import ec.edu.utpl.sc.core.servicio.IParametroGeneralServicio;
import ec.edu.utpl.sc.core.servicio.IPdfServicio;
import ec.edu.utpl.sc.core.servicio.ISeleniumServicio;

public class FwUtplFactory implements Serializable {
	
	private static final long serialVersionUID = 5818660970303605924L;
	
	private static final FwUtplFactory INTANCE = new FwUtplFactory();

	private FwUtplFactory() {
		applicationContext = new ClassPathXmlApplicationContext(Constantes.PATH_SPRING_CONFIG);
	}

	public static FwUtplFactory getIntance() {
		return INTANCE;
	}

	private ApplicationContext applicationContext;

	public IGenericoServicio getGenericoService() {
		return (IGenericoServicio) applicationContext.getBean(Constantes.GENERICO_SERVICIO);
	}
	
	public ICrudServicio getCrudService() {
		return (ICrudServicio) applicationContext.getBean(Constantes.CRUD_SERVICIO);
	}
	
	public ISeleniumServicio getSeleniumService() {
		return (ISeleniumServicio) applicationContext.getBean(Constantes.SELENIUM_SERVICIO);
	}
	
	public IComprobanteServicio getComprobanteService() {
		return (IComprobanteServicio) applicationContext.getBean(Constantes.COMPROBANTE_SERVICIO);
	}
	
	public IFileServicio getFileService() {
		return (IFileServicio) applicationContext.getBean(Constantes.FILE_SERVICIO);
	}
	
	public IPdfServicio getPdfService() {
		return (IPdfServicio) applicationContext.getBean(Constantes.PDF_SERVICIO);
	}
	
	public IParametroGeneralServicio getParametroGeneralService() {
		return (IParametroGeneralServicio) applicationContext.getBean(Constantes.PARAMETRO_GENERAL_SERVICIO);
	}
	
	public IDownloadSriServicio getDownloadSriService() {
		return (IDownloadSriServicio) applicationContext.getBean(Constantes.DOWNLOAD_SRI_SERVICIO);
	}
	
	public IEmpresaServicio getEmpresaService() {
		return (IEmpresaServicio) applicationContext.getBean(Constantes.EMPRESA_SERVICIO);
	}
	
	public IConsultasServicio getConsultasService() {
		return (IConsultasServicio) applicationContext.getBean(Constantes.CONSULTAS_SERVICIO);
	}
	
	public IComprobanteEmpresaServicio getComprobanteEmpresaService() {
		return (IComprobanteEmpresaServicio) applicationContext.getBean(Constantes.COMPROBANTE_EMPRESA_SERVICIO);
	}
	
	public IAdmServicio getAdmService() {
		return (IAdmServicio) applicationContext.getBean(Constantes.ADM_SERVICIO);
	}
	
	public IFwServicio getFwService() {
		return (IFwServicio) applicationContext.getBean(Constantes.FW_SERVICIO);
	}
	
	public IAnexoGastoServicio getAnexoGastoService() {
		return (IAnexoGastoServicio) applicationContext.getBean(Constantes.ANEXO_GASTO_SERVICIO);
	}
	
	public IHttpServicio getHttpService() {
		return (IHttpServicio) applicationContext.getBean(Constantes.HTTP_SERVICIO);
	}

}
