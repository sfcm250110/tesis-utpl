package ec.edu.utpl.sc.core.util;

import javax.xml.transform.Source;
import javax.xml.transform.URIResolver;

import org.jdom.Document;
import org.jdom.transform.JDOMSource;


public class BdUriResolver implements URIResolver {
	
	String XSLTREF;

	public BdUriResolver(String xslt) {
		this.XSLTREF = xslt;
	}

	public Source resolve(String href, String base) {
		Document xsltDoc = TransformerUtil.stringToXml(this.XSLTREF);
		JDOMSource xsltSource = new JDOMSource(xsltDoc);
		
		return xsltSource;
	}
}