package ec.edu.utpl.sc.core.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Set;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;

public final class TransformerUtil {

	private static Logger log = Logger.getLogger(TransformerUtil.class);
	
	private static TransformerFactory factory = null;

	static {
		factory = TransformerFactory.newInstance();
	}
	
	private TransformerUtil() {	
	}
	
	public static Document stringToXml(String str) {
		Document document = null;
		
		try {
			SAXBuilder parser = new SAXBuilder();
			document = parser.build(new StringReader(str));
			
		} catch (JDOMException e) {
			log.error("Error", e);
			
		} catch (IOException e) {
			log.error("Error", e);
		}
		
		return document;
	}
	
	public static Document transformar(Document xml, Document xsl) throws TransformerException {
		return transformar(xml, xsl, null, null, Boolean.FALSE);
	}
	
	public static Document transformar(Document xml, Document xsl, Map<String, ?> parametros, String cabeceraXsl, Boolean limit) throws TransformerException {
		JDOMSource xsltSource = new JDOMSource(xsl);
		
		if ((limit != null) && (limit.booleanValue())) {
			factory.setAttribute("http://www.ibm.com/xmlns/prod/xltxe-j/split-limit", Integer.valueOf(2000));
		}

		if (cabeceraXsl != null) {
			factory.setURIResolver(new BdUriResolver(cabeceraXsl));
		}

		Transformer trans = factory.newTransformer(xsltSource);
		if ((parametros != null) && (!(parametros.isEmpty()))) {
			Set<String> keys = parametros.keySet();
			for (String key : keys) {
				trans.setParameter(key, parametros.get(key));
			}
		}
		
		JDOMSource docIn = new JDOMSource(xml);
		JDOMResult docOut = new JDOMResult();
		trans.setOutputProperty("indent", "no");
		trans.transform(docIn, docOut);
		
		return docOut.getDocument();
	}
	
	public static String xmlToString(Document document) {
		XMLOutputter outPutter = new XMLOutputter();
		outPutter.setFormat(Format.getPrettyFormat());
		return outPutter.outputString(document);
	}
}
