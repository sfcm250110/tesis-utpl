package ec.edu.utpl.sc.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

import ec.edu.utpl.sc.core.vo.SessionUtil;

public class XhtmlUtil implements Serializable {

	private static final long serialVersionUID = -8330089123417544624L;

	public static byte[] generateXhtmlSession(String pXml, String pIdSessionTemplateXsl) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(Boolean.FALSE);
		documentBuilderFactory.setValidating(Boolean.FALSE);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(new ByteArrayInputStream(pXml.getBytes()));
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(new StreamSource(new ByteArrayInputStream(SessionUtil.getObjetoSession(pIdSessionTemplateXsl).toString().getBytes())));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		transformer.transform(new DOMSource(document), new StreamResult(outputStream));
		byte[] xhtmlBytes = outputStream.toByteArray();
		outputStream.close();
		
		return xhtmlBytes;
	}
	
	public static byte[] generateXhtmlPath(String pXml, String pPathCss) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(Boolean.FALSE);
		documentBuilderFactory.setValidating(Boolean.FALSE);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(new ByteArrayInputStream(pXml.getBytes()));
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File(pPathCss)));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		transformer.transform(new DOMSource(document), new StreamResult(outputStream));
		byte[] xhtmlBytes = outputStream.toByteArray();
		outputStream.close();
                
        return xhtmlBytes;
	}
	
	public static byte[] generateXhtmlSoup(String pXml, String pIdSessionTemplateXsl) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(Boolean.FALSE);
		documentBuilderFactory.setValidating(Boolean.FALSE);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(new ByteArrayInputStream(pXml.getBytes()));
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(new StreamSource(new ByteArrayInputStream(SessionUtil.getObjetoSession(pIdSessionTemplateXsl).toString().getBytes())));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		transformer.transform(new DOMSource(document), new StreamResult(outputStream));
		byte[] xhtmlBytes = outputStream.toByteArray();
		outputStream.close();
		
		org.jsoup.nodes.Document documentSoup = Jsoup.parse(new String(xhtmlBytes));
	    documentSoup.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
        
        
        return documentSoup.html().getBytes();
	}
	
	public static byte[] generateXhtml(String pXml, String pIdSessionTemplateXsl) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(Boolean.FALSE);
		documentBuilderFactory.setValidating(Boolean.FALSE);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(new ByteArrayInputStream(pXml.getBytes()));
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(new StreamSource(new ByteArrayInputStream(SessionUtil.getObjetoSession(pIdSessionTemplateXsl).toString().getBytes())));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		transformer.transform(new DOMSource(document), new StreamResult(outputStream));
		byte[] xhtmlBytes = outputStream.toByteArray();
		outputStream.close();
				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();		
		Tidy tidy = new Tidy();
        tidy.setShowWarnings(false);
        tidy.setXmlTags(false);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setXHTML(true); 
        tidy.setMakeClean(true);
        tidy.parseDOM(new ByteArrayInputStream(xhtmlBytes), baos);
        
        return baos.toByteArray();
	}
	
	public static String generateContentXhtml(String pXml, String pXsl) throws TransformerException {
		org.jdom.Document documentXml = TransformerUtil.stringToXml(pXml);
		org.jdom.Document documentXsl = TransformerUtil.stringToXml(pXsl);
		org.jdom.Document document = TransformerUtil.transformar(documentXml, documentXsl);
		
		return TransformerUtil.xmlToString(document);
	}
}
