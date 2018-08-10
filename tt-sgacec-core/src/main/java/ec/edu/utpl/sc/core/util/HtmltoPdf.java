package ec.edu.utpl.sc.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.DOMOutputter;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;
import org.w3c.tidy.Tidy;

import com.itextpdf.text.DocumentException;

import ec.edu.utpl.sc.core.vo.SessionUtil;

public final class HtmltoPdf {

	private static FopFactory fopFactory;
	private static TransformerFactory factory;
	private static FOUserAgent foUserAgent;
	private static org.jdom.Document docFopXsltTransformacion;
	private static Tidy tidy;
	
	static {
		try {
			if (docFopXsltTransformacion == null) {
				SAXBuilder parser = new SAXBuilder();
				docFopXsltTransformacion = parser.build(new ByteArrayInputStream(SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_XHTML2FO).toString().getBytes()));
			}

			factory = TransformerFactory.newInstance();
			fopFactory = FopFactory.newInstance();
			foUserAgent = fopFactory.newFOUserAgent();
			tidy = new Tidy();
			tidy.setXHTML(true);
			tidy.setTidyMark(false);
			tidy.setShowWarnings(false);
			tidy.setQuiet(true);
			tidy.setInputEncoding("latin1");
			tidy.setOutputEncoding("latin1");
			
		} catch (IOException | JDOMException e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] convertir(String html) throws IOException, JDOMException, TransformerException, DocumentException {
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put(Constantes.ANCHO_CODIGO_BARRAS, Constantes.VALOR_ANCHO_CODIGO_BARRAS_73);
		parametros.put("page-width", "29.7cm");
		parametros.put("page-height", "21cm");
		
		org.jdom.Document docXhtml = html2Xhtml(html);
		org.jdom.Document docFop = transformar(docXhtml, parametros);
		DOMOutputter output = new DOMOutputter();
		org.w3c.dom.Document docFopDom = output.output(docFop);
		
		byte contentPdf[] = convertDom2PdfBytes(docFopDom);
		contentPdf = ConcatenadorPdf.numerarMarcar(contentPdf);
		
		return contentPdf;
	}
	
	private static org.jdom.Document html2Xhtml(String html) throws IOException, JDOMException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ByteArrayInputStream input = new ByteArrayInputStream(html.getBytes());
		
		try {
			tidy.parseDOM(input, output);
			input = new ByteArrayInputStream(output.toByteArray());
			SAXBuilder parser = new SAXBuilder();
			parser.setDTDHandler(null);
			parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			
			return parser.build(input);
			
		} finally {
			input.close();
			output.close();
		}
	}
	
	private static org.jdom.Document transformar(org.jdom.Document pXML, Map<String, String> parametros) throws TransformerException {
		pXML.setDocType(null);
		JDOMSource xsltSource = new JDOMSource(docFopXsltTransformacion);
		Transformer trans = factory.newTransformer(xsltSource);
		
		JDOMSource docIn = new JDOMSource(pXML);
		JDOMResult docOut = new JDOMResult();
		
		trans.setParameter("page-number-print-in-footer", Boolean.valueOf(false));
		
		if (parametros != null) {
			Set<Entry<String, String>> set = parametros.entrySet();
			Iterator<Entry<String, String>> iter = set.iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
				trans.setParameter(entry.getKey().toString(), entry.getValue());
			}
		}
		
		trans.transform(docIn, docOut);
		return docOut.getDocument();
	}
	
	private static byte[] convertDom2PdfBytes(org.w3c.dom.Document pXslFoDoc) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			try {
				Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
				Transformer transformer = factory.newTransformer();
				transformer.transform(new DOMSource(pXslFoDoc), new SAXResult(fop.getDefaultHandler()));
				
				return out.toByteArray();
			
			} finally {
				out.close();
			}
			
		} catch (ConcurrentModificationException e) {
			throw e;
			
		} catch (FOPException | TransformerException | IOException e) {
			e.printStackTrace();
			
			return null;
		}
	}

}