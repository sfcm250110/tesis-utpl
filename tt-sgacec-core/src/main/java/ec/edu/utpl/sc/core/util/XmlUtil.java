package ec.edu.utpl.sc.core.util;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringEscapeUtils;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.xml.CheckDownloadSriXml;
import ec.edu.utpl.sc.core.entity.xml.ComprobanteEmpresaXml;
import ec.edu.utpl.sc.core.entity.xml.EmailXml;
import ec.edu.utpl.sc.core.entity.xml.RucEmisorXml;
import ec.edu.utpl.sc.core.vo.Email;
import ec.edu.utpl.sc.core.xsd.v110.Factura;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

public final class XmlUtil implements Serializable {
	
	private static final long serialVersionUID = 8027838969950580148L;

	private XmlUtil() {
	}
	
	@SuppressWarnings(Constantes.DEPRECATION)
	public static String generarTag(String pTag, Object pValorTag) {

		if (!Utilitario.validarCampoNotNull(pValorTag)) {
			pValorTag = Constantes.GUION_MEDIO;
		}

		StringBuilder tag = new StringBuilder(Constantes.SPACE_BLANK); 
		tag.append(Constantes.ABRIR_TAG_MENOR);
		tag.append(pTag);
		tag.append(Constantes.ABRIR_TAG_MAYOR);
		tag.append(StringEscapeUtils.escapeXml(pValorTag.toString()));
		tag.append(Constantes.CERRAR_TAG_MENOR).append(pTag);
		tag.append(Constantes.ABRIR_TAG_MAYOR);
		tag.append(Constantes.SALTO_LINEA);

		return tag.toString();
	}

	public static String abrirTag(String pTag) {
		String tagApertura = Constantes.ABRIR_TAG_MENOR + pTag + Constantes.ABRIR_TAG_MAYOR + Constantes.SALTO_LINEA;

		return tagApertura;
	}

	public static String cerrarTag(String pTag) {
		String tagCierre = Constantes.CERRAR_TAG_MENOR + pTag + Constantes.ABRIR_TAG_MAYOR + Constantes.SALTO_LINEA;

		return tagCierre;
	}
	
	public static String deleteHeaderXml(String pXml) {
		pXml = pXml.replace(Constantes.ENCABEZADO_XML, Constantes.SPACE_BLANK);
		pXml = pXml.replace(Constantes.ENCABEZADO_XML_LOWER, Constantes.SPACE_BLANK);

		return pXml;
	}

	public static String checkDownloadSriToStringXml(CheckDownloadSri pCheckDownloadSri) throws JAXBException {
		CheckDownloadSriXml checkDownloadSriXml = ParseXmlUtil.parseCheckDownloadSriXml(pCheckDownloadSri);
		StringWriter checkDownloadSriString = new StringWriter();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(CheckDownloadSriXml.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(checkDownloadSriXml, checkDownloadSriString);
		
		return checkDownloadSriString.toString();
	}
	
	public static CheckDownloadSri xmlToCheckDownloadSri(String pCheckDownloadSriXml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CheckDownloadSriXml.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		CheckDownloadSriXml checkDownloadSriXml = (CheckDownloadSriXml) unmarshaller.unmarshal(new StringReader(pCheckDownloadSriXml));
		CheckDownloadSri checkDownloadSri = ParseXmlUtil.parseCheckDownloadSri(checkDownloadSriXml);
		
		return checkDownloadSri;
	}
	
	public static String comprobanteEmpresaToStringXml(ComprobanteEmpresa pComprobanteEmpresa) throws JAXBException {
		ComprobanteEmpresaXml comprobanteEmpresaXml = ParseXmlUtil.parseComprobanteEmpresaXml(pComprobanteEmpresa);
		StringWriter comprobanteEmpresaString = new StringWriter();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ComprobanteEmpresaXml.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(comprobanteEmpresaXml, comprobanteEmpresaString);
		
		return comprobanteEmpresaString.toString();
	}
	
	public static ComprobanteEmpresa xmlToComprobanteEmpresa(String pComprobanteEmpresaXml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ComprobanteEmpresaXml.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		ComprobanteEmpresaXml comprobanteEmpresaXml = (ComprobanteEmpresaXml) unmarshaller.unmarshal(new StringReader(pComprobanteEmpresaXml));
		ComprobanteEmpresa comprobanteEmpresa = ParseXmlUtil.parseComprobanteEmpresa(comprobanteEmpresaXml);
		
		return comprobanteEmpresa;
	}
	
	public static String generateXmlFactura(String pXml, ComprobanteEmpresa pComprobanteEmpresa) throws IOException, BarcodeException, OutputException {
		StringBuilder autorizacionXml = new StringBuilder();
		autorizacionXml.append(abrirTag(Constantes.TAG_AUTORIZACION));
		autorizacionXml.append(generarTag(Constantes.TAG_LOGO_EMPRESA, ImageUtil.getInstancia().generateNotFoundUtpl()));
		autorizacionXml.append(generarTag(Constantes.TAG_LOGO_CODIGO_BARRAS, CodigoBarrasUtil.getInstancia().generar(pComprobanteEmpresa.getNumeroAutorizacion())));
		autorizacionXml.append(generarTag(Constantes.TAG_NUMERO_AUTORIZACION, pComprobanteEmpresa.getNumeroAutorizacion()));
		autorizacionXml.append(generarTag(Constantes.TAG_FECHA_AUTORIZACION, DateUtil.parseToDateString(pComprobanteEmpresa.getFechaAutorizacion(), Constantes.DD_MM_YYYY_HHMMSS)));
		autorizacionXml.append(deleteHeaderXml(pXml));
		autorizacionXml.append(cerrarTag(Constantes.TAG_AUTORIZACION));
		
		return autorizacionXml.toString();
	}
	
	public static String rucEmisorToStringXml(String pRucEmisor) throws JAXBException {
		RucEmisorXml rucEmisorXml = ParseXmlUtil.parseRucEmisorXml(pRucEmisor);
		StringWriter rucEmisorString = new StringWriter();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(RucEmisorXml.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(rucEmisorXml, rucEmisorString);
		
		return rucEmisorString.toString();
	}
	
	public static String xmlToRucEmisorXml(String pRucEmisorXml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RucEmisorXml.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		RucEmisorXml rucEmisorXml = (RucEmisorXml) unmarshaller.unmarshal(new StringReader(pRucEmisorXml));
		String rucEmisor = ParseXmlUtil.parseCheckDownloadSri(rucEmisorXml);
		
		return rucEmisor;
	}
	
	public static Factura xmlToFactura(String pFacturaXml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Factura factura = (Factura) unmarshaller.unmarshal(new StringReader(pFacturaXml));
		
		return factura;
	}
	
	public static String emailToStringXml(Email pEmail) throws JAXBException {
		EmailXml emailXml = ParseXmlUtil.parseEmailXml(pEmail);
		StringWriter emailString = new StringWriter();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(EmailXml.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(emailXml, emailString);
		
		return emailString.toString();
	}
	
	public static Email xmlToEmail(String pEmailXml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(EmailXml.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		EmailXml emailXml = (EmailXml) unmarshaller.unmarshal(new StringReader(pEmailXml));
		Email email = ParseXmlUtil.parseEmail(emailXml);
		
		return email;
	}

}
