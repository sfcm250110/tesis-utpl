package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.xml.CheckDownloadSriXml;
import ec.edu.utpl.sc.core.entity.xml.ComprobanteEmpresaXml;
import ec.edu.utpl.sc.core.entity.xml.EmailXml;
import ec.edu.utpl.sc.core.entity.xml.RucEmisorXml;
import ec.edu.utpl.sc.core.vo.Email;

public final class ParseXmlUtil implements Serializable {
	
	private static final long serialVersionUID = -3131883682651907921L;

	private ParseXmlUtil() {
	}

	public static CheckDownloadSriXml parseCheckDownloadSriXml(CheckDownloadSri pCheckDownloadSri) {
		CheckDownloadSriXml checkDownloadSriXml = new CheckDownloadSriXml();
		checkDownloadSriXml.setFechaDownload(pCheckDownloadSri.getFechaDownload());
		checkDownloadSriXml.setFechaProceso(pCheckDownloadSri.getFechaProceso());
		checkDownloadSriXml.setFila(pCheckDownloadSri.getFila());
		checkDownloadSriXml.setIdCheckDownloadSri(pCheckDownloadSri.getIdCheckDownloadSri());
		checkDownloadSriXml.setPaginado(pCheckDownloadSri.getPaginado());
		checkDownloadSriXml.setEtapa(pCheckDownloadSri.getEtapa());
		checkDownloadSriXml.setRuc(pCheckDownloadSri.getRuc());
		checkDownloadSriXml.setTotalFilas(pCheckDownloadSri.getTotalFilas());
		checkDownloadSriXml.setTotalPaginas(pCheckDownloadSri.getTotalPaginas());
		
		return checkDownloadSriXml;
	}
	
	public static CheckDownloadSri parseCheckDownloadSri(CheckDownloadSriXml pCheckDownloadSriXml) {
		CheckDownloadSri checkDownloadSri = new CheckDownloadSri();
		checkDownloadSri.setFechaDownload(pCheckDownloadSriXml.getFechaDownload());
		checkDownloadSri.setFechaProceso(pCheckDownloadSriXml.getFechaProceso());
		checkDownloadSri.setFila(pCheckDownloadSriXml.getFila());
		checkDownloadSri.setIdCheckDownloadSri(pCheckDownloadSriXml.getIdCheckDownloadSri());
		checkDownloadSri.setPaginado(pCheckDownloadSriXml.getPaginado());
		checkDownloadSri.setEtapa(pCheckDownloadSriXml.getEtapa());
		checkDownloadSri.setRuc(pCheckDownloadSriXml.getRuc());
		checkDownloadSri.setTotalFilas(pCheckDownloadSriXml.getTotalFilas());
		checkDownloadSri.setTotalPaginas(pCheckDownloadSriXml.getTotalPaginas());
		
		return checkDownloadSri;
	}
	
	public static ComprobanteEmpresaXml parseComprobanteEmpresaXml(ComprobanteEmpresa pComprobanteEmpresa) {
		ComprobanteEmpresaXml comprobanteEmpresaXml = new ComprobanteEmpresaXml();
		comprobanteEmpresaXml.setRuc(pComprobanteEmpresa.getRuc());
		comprobanteEmpresaXml.setEstado(pComprobanteEmpresa.getEstado());
		comprobanteEmpresaXml.setSrc(pComprobanteEmpresa.getSrc());
		comprobanteEmpresaXml.setClaveAcceso(pComprobanteEmpresa.getClaveAcceso());
		comprobanteEmpresaXml.setEstablecimiento(pComprobanteEmpresa.getEstablecimiento());
		comprobanteEmpresaXml.setFechaAutorizacion(pComprobanteEmpresa.getFechaAutorizacion());
		comprobanteEmpresaXml.setFechaEmision(pComprobanteEmpresa.getFechaEmision());
		comprobanteEmpresaXml.setFechaRegistro(pComprobanteEmpresa.getFechaRegistro());
		comprobanteEmpresaXml.setNumeroAutorizacion(pComprobanteEmpresa.getNumeroAutorizacion());
		comprobanteEmpresaXml.setPdf(pComprobanteEmpresa.getPdf());
		comprobanteEmpresaXml.setPuntoEmision(pComprobanteEmpresa.getPuntoEmision());
		comprobanteEmpresaXml.setRazonSocialEmisor(pComprobanteEmpresa.getRazonSocialEmisor());
		comprobanteEmpresaXml.setRucEmisor(pComprobanteEmpresa.getRucEmisor());
		comprobanteEmpresaXml.setSecuencial(pComprobanteEmpresa.getSecuencial());
		comprobanteEmpresaXml.setTipo(pComprobanteEmpresa.getTipo());
		comprobanteEmpresaXml.setTipoEmision(pComprobanteEmpresa.getTipoEmision());
		comprobanteEmpresaXml.setXml(pComprobanteEmpresa.getXml());
		comprobanteEmpresaXml.setFila(pComprobanteEmpresa.getFila());
		
		return comprobanteEmpresaXml;
	}
	
	public static ComprobanteEmpresa parseComprobanteEmpresa(ComprobanteEmpresaXml pComprobanteEmpresaXml) {
		ComprobanteEmpresa comprobanteEmpresa = new ComprobanteEmpresa();
		comprobanteEmpresa.setRuc(pComprobanteEmpresaXml.getRuc());
		comprobanteEmpresa.setEstado(pComprobanteEmpresaXml.getEstado());
		comprobanteEmpresa.setSrc(pComprobanteEmpresaXml.getSrc());
		comprobanteEmpresa.setClaveAcceso(pComprobanteEmpresaXml.getClaveAcceso());
		comprobanteEmpresa.setEstablecimiento(pComprobanteEmpresaXml.getEstablecimiento());
		comprobanteEmpresa.setFechaAutorizacion(pComprobanteEmpresaXml.getFechaAutorizacion());
		comprobanteEmpresa.setFechaEmision(pComprobanteEmpresaXml.getFechaEmision());
		comprobanteEmpresa.setFechaRegistro(pComprobanteEmpresaXml.getFechaRegistro());
		comprobanteEmpresa.setNumeroAutorizacion(pComprobanteEmpresaXml.getNumeroAutorizacion());
		comprobanteEmpresa.setPdf(pComprobanteEmpresaXml.getPdf());
		comprobanteEmpresa.setPuntoEmision(pComprobanteEmpresaXml.getPuntoEmision());
		comprobanteEmpresa.setRazonSocialEmisor(pComprobanteEmpresaXml.getRazonSocialEmisor());
		comprobanteEmpresa.setRucEmisor(pComprobanteEmpresaXml.getRucEmisor());
		comprobanteEmpresa.setSecuencial(pComprobanteEmpresaXml.getSecuencial());
		comprobanteEmpresa.setTipo(pComprobanteEmpresaXml.getTipo());
		comprobanteEmpresa.setTipoEmision(pComprobanteEmpresaXml.getTipoEmision());
		comprobanteEmpresa.setXml(pComprobanteEmpresaXml.getXml());
		comprobanteEmpresa.setFila(pComprobanteEmpresaXml.getFila());
		
		return comprobanteEmpresa;
	}
	
	public static RucEmisorXml parseRucEmisorXml(String pRucEmisor) {
		RucEmisorXml rucEmisorXml = new RucEmisorXml();
		rucEmisorXml.setRucEmisor(pRucEmisor);
		
		return rucEmisorXml;
	}
	
	public static String parseCheckDownloadSri(RucEmisorXml pRucEmisorXml) {
		String pRucEmisor = pRucEmisorXml.getRucEmisor();
		
		return pRucEmisor;
	}
	
	public static EmailXml parseEmailXml(Email pEmail) {
		EmailXml emailXml = new EmailXml();
		emailXml.setServidorSmtp(pEmail.getServidorSmtp());
		emailXml.setPuerto(pEmail.getPuerto());
		emailXml.setUsuario(pEmail.getUsuario());
		emailXml.setPassword(pEmail.getPassword());
		emailXml.setDestinatarios(pEmail.getDestinatarios());
		emailXml.setAsunto(pEmail.getAsunto());
		emailXml.setMensaje(pEmail.getMensaje());
		emailXml.setIdentificadorSessionProperties(pEmail.getIdentificadorSessionProperties());
		emailXml.setIdentificadorSessionTransport(pEmail.getIdentificadorSessionTransport());
		emailXml.setFileNameAttachment(pEmail.getFileNameAttachment());
		emailXml.setFileAttachment(pEmail.getFileAttachment());
		emailXml.setPathAttachmentZip(pEmail.getPathAttachmentZip());
		
		return emailXml;
	}
	
	public static Email parseEmail(EmailXml pEmailXml) {
		Email email = new Email();
		email.setServidorSmtp(pEmailXml.getServidorSmtp());
		email.setPuerto(pEmailXml.getPuerto());
		email.setUsuario(pEmailXml.getUsuario());
		email.setPassword(pEmailXml.getPassword());
		email.setDestinatarios(pEmailXml.getDestinatarios());
		email.setAsunto(pEmailXml.getAsunto());
		email.setMensaje(pEmailXml.getMensaje());
		email.setIdentificadorSessionProperties(pEmailXml.getIdentificadorSessionProperties());
		email.setIdentificadorSessionTransport(pEmailXml.getIdentificadorSessionTransport());
		email.setFileNameAttachment(pEmailXml.getFileNameAttachment());
		email.setFileAttachment(pEmailXml.getFileAttachment());
		email.setPathAttachmentZip(pEmailXml.getPathAttachmentZip());
		
		return email;
	}

}
