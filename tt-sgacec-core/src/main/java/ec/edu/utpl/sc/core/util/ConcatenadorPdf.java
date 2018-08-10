package ec.edu.utpl.sc.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class ConcatenadorPdf {

	public static byte[] numerarMarcar(byte contentPdf[]) throws IOException, DocumentException {
		PdfReader reader = new PdfReader(contentPdf);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfStamper stamp = new PdfStamper(reader, byteArrayOutputStream);
		PdfContentByte over;
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.WINANSI, BaseFont.EMBEDDED);

		int numPaginas = reader.getNumberOfPages();
		int i = 0;
		
		while (i++ < numPaginas) {			
			over = stamp.getOverContent(i);
			over.beginText();
			over.setFontAndSize(bf, 7);
			over.setTextMatrix(680, 30);
			over.showText("P\u00E1gina " + i + " de " + numPaginas);
			over.endText();
			over.beginText();
			over.setFontAndSize(bf, 7);
			over.setTextMatrix(50, 50);
			over.showText("Generado por UTPL: Trabajo de Titulacion - Sistema de Gestion Automatica de Comprobantes Electronicos del Contribuyente - SGACEC ");
			over.endText();
			over.beginText();
			over.setFontAndSize(bf, 7);
			over.setTextMatrix(50, 40);
			over.endText();
			over.beginText();
			over.setFontAndSize(bf, 7);
			over.setTextMatrix(50, 30);
			over.endText();
		}
		
		stamp.close();
		
		return byteArrayOutputStream.toByteArray();
	}
}
