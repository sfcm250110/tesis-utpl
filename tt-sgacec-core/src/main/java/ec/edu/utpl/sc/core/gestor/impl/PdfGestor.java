package ec.edu.utpl.sc.core.gestor.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.pdfcleanup.PdfCleanUpLocation;
import com.itextpdf.text.pdf.pdfcleanup.PdfCleanUpProcessor;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import ec.edu.utpl.sc.core.gestor.IPdfGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.CssUtil;
import ec.edu.utpl.sc.core.util.HtmltoPdf;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.util.XhtmlUtil;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Repository(Constantes.PDF_GESTOR)
public class PdfGestor implements IPdfGestor {
	
	private static Logger log = Logger.getLogger(PdfGestor.class);
	
	@Override
	public String obtenerNumeroAutorizacion(byte[] pFileBytes) throws UtplException {
		try {
			PdfReader pdfReader = new PdfReader(pFileBytes);
			Rectangle rectangle = new Rectangle(Constantes.X_INFERIOR_IZQUIERDA, Constantes.Y_INFERIOR_IZQUIERDA, Constantes.X_SUPERIOR_DERECHA, Constantes.Y_SUPERIOR_DERECHA);
			RenderFilter renderFilter = new RegionTextRenderFilter(rectangle);
			TextExtractionStrategy textExtractionStrategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), renderFilter);
			String numeroAutorizacion = PdfTextExtractor.getTextFromPage(pdfReader, Constantes.I1, textExtractionStrategy);
			pdfReader.close();
			
			return numeroAutorizacion;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@Override
	public String obtenerNumeroAutorizacion(String pFilePath) throws UtplException {
		try {
			PdfReader pdfReader = new PdfReader(pFilePath);
			Rectangle rectangle = new Rectangle(Constantes.X_INFERIOR_IZQUIERDA, Constantes.Y_INFERIOR_IZQUIERDA, Constantes.X_SUPERIOR_DERECHA, Constantes.Y_SUPERIOR_DERECHA);
			RenderFilter renderFilter = new RegionTextRenderFilter(rectangle);
			TextExtractionStrategy textExtractionStrategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), renderFilter);
			String numeroAutorizacion = PdfTextExtractor.getTextFromPage(pdfReader, Constantes.I1, textExtractionStrategy);
			pdfReader.close();
			
			return numeroAutorizacion;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public String obtenerContent(String pFilePathSrc) throws UtplException {
		try {
			String content = new String();
			PdfReader pdfReader = new PdfReader(pFilePathSrc);
			PrintWriter printWriter = new PrintWriter(content);

			for (int numberPage = Constantes.I1; numberPage <= pdfReader.getNumberOfPages(); numberPage++) {
				String contenido = PdfTextExtractor.getTextFromPage(pdfReader, numberPage);
				printWriter.println(contenido);
			}

			printWriter.flush();
			printWriter.close();
			pdfReader.close();
			
			return content;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void paintRectangle(String pFilePathSrc, String pFilePathDest, float xInferiorIzquierda, float xSuperiorDerecha, float yInferiorIzquierda, float ySuperiorDerecha) throws UtplException {
		try {
			PdfReader pdfReader = new PdfReader(pFilePathSrc);
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(pFilePathDest));
			List<PdfCleanUpLocation> pdfCleanUpLocations = new ArrayList<PdfCleanUpLocation>();
			pdfCleanUpLocations.add(new PdfCleanUpLocation(Constantes.I1, new Rectangle(xInferiorIzquierda, yInferiorIzquierda, xSuperiorDerecha, ySuperiorDerecha), BaseColor.GRAY));
			PdfCleanUpProcessor pdfCleanUpProcessor = new PdfCleanUpProcessor(pdfCleanUpLocations, pdfStamper);
			
			pdfCleanUpProcessor.cleanUp();
			pdfStamper.close();
			pdfReader.close();

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<String[]> formatContenido(String pContenido) throws UtplException {
		String[] contenidosArray = pContenido.split(Constantes.NEWLINE);
		List<String[]> contenidos = new ArrayList<String[]>();
		
		for (String contenidoArray : contenidosArray) {
			String[] contenidoTmp = contenidoArray.split(Constantes.SPACE_BLANK);
			
			int contadorLongitud = Constantes.I0;
			for (int contador = Constantes.I0; contador < contenidoTmp.length; contador++) {
				if (!contenidoTmp[contador].equals(Constantes.STRING_EMPTY)) {
					contadorLongitud = contadorLongitud + Constantes.I1;
				}
			}
			
			int contador = Constantes.I0;
			String[] contenidoTmps = new String[contadorLongitud];
			for (int i = Constantes.I0; i < contenidoTmp.length; i++) {
				if (!contenidoTmp[i].equals(Constantes.STRING_EMPTY)) {
					contenidoTmps[contador] = contenidoTmp[i];
					contador = contador + Constantes.I1;
				}
			}
			
			contenidos.add(contenidoTmps);
		}
		
		return contenidos;
	}
	
	@Override
	public void printContentConsole(List<String[]> pContenidos) throws UtplException {
		for (String[] filaInformacionArray : pContenidos) {
			
			for (int contador = Constantes.I0; contador < filaInformacionArray.length; contador++) {
				log.info(filaInformacionArray[contador] + Constantes.TAB);
			}
			
			System.out.println();
		}
	}
	
	@Override
	public String obtenerRucEmpresa(byte[] pFileBytes) throws UtplException {
		try {
			PdfReader pdfReader = new PdfReader(pFileBytes);
			Rectangle rectangle = new Rectangle(Constantes.X_INFERIOR_IZQUIERDA_RUC_CEDULA, Constantes.Y_INFERIOR_IZQUIERDA_RUC_CEDULA, Constantes.X_SUPERIOR_DERECHA_RUC_CEDULA, Constantes.Y_SUPERIOR_DERECHA_RUC_CEDULA);
			RenderFilter renderFilter = new RegionTextRenderFilter(rectangle);
			TextExtractionStrategy textExtractionStrategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), renderFilter);
			String ruc = PdfTextExtractor.getTextFromPage(pdfReader, Constantes.I1, textExtractionStrategy);
			pdfReader.close();
			
			String rucEmpresa = null;
			if (Constantes.I13 == ruc.trim().length()) {
				rucEmpresa = ruc;
				
			} else if (Constantes.I10 == ruc.trim().length()) {
				rucEmpresa = ruc + Constantes.SUFIJO_RUC;
			}
			
			return rucEmpresa;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public byte[] createFilePdf(String pXml, String pIdSessionTemplateXsl, String pIdSessionTemplateCss) throws UtplException {
		try {
			Document document = new Document(PageSize.A4, 10.0F, 10.0F, 10.0F, 0.0F);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, byteArrayOutputStream);
			document.open();
			
			ByteArrayInputStream xhtml = new ByteArrayInputStream(XhtmlUtil.generateXhtml(pXml, pIdSessionTemplateXsl));
			ByteArrayInputStream css = new ByteArrayInputStream(CssUtil.getContentCssSession(pIdSessionTemplateCss));
			XMLWorkerFontProvider font = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
			XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document, xhtml, css, font);
			
			xhtml.close();
			css.close();
			document.close();
			
			return byteArrayOutputStream.toByteArray();

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public byte[] createFilePdf(String pXml, String pXsl) throws UtplException {
		try {
			String xhtml = XmlUtil.deleteHeaderXml(XhtmlUtil.generateContentXhtml(pXml, pXsl));
			byte contentPdf[] = HtmltoPdf.convertir(xhtml);

			return contentPdf;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
