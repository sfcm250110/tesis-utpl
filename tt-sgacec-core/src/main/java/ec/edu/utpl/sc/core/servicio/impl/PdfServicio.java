package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.gestor.IPdfGestor;
import ec.edu.utpl.sc.core.servicio.IPdfServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.PDF_SERVICIO)
public class PdfServicio implements IPdfServicio {
	
	@Autowired
	@Qualifier(Constantes.PDF_GESTOR)
	private IPdfGestor pdfGestor;

	@Override
	public String obtenerNumeroAutorizacion(byte[] pFileBytes) throws UtplException {
		return pdfGestor.obtenerNumeroAutorizacion(pFileBytes);
	}

	@Override
	public String obtenerNumeroAutorizacion(String pFilePath) throws UtplException {
		return pdfGestor.obtenerNumeroAutorizacion(pFilePath);
	}

	@Override
	public String obtenerContent(String pFilePathSrc) throws UtplException {
		return pdfGestor.obtenerContent(pFilePathSrc);
	}

	@Override
	public void paintRectangle(String pFilePathSrc, String pFilePathDest, float xInferiorIzquierda, float xSuperiorDerecha, float yInferiorIzquierda, float ySuperiorDerecha) throws UtplException {
		pdfGestor.paintRectangle(pFilePathSrc, pFilePathDest, xInferiorIzquierda, xSuperiorDerecha, yInferiorIzquierda, ySuperiorDerecha);
	}

	@Override
	public List<String[]> formatContenido(String pContenido) throws UtplException {
		return pdfGestor.formatContenido(pContenido);
	}

	@Override
	public void printContentConsole(List<String[]> pContenidos) throws UtplException {
		pdfGestor.printContentConsole(pContenidos);
	}
	
	@Override
	public String obtenerRucEmpresa(byte[] pFileBytes) throws UtplException {
		return pdfGestor.obtenerRucEmpresa(pFileBytes);
	}

	@Override
	public byte[] createFilePdf(String pXml, String pIdSessionTemplateXsl, String pIdSessionTemplateCss) throws UtplException {
		return pdfGestor.createFilePdf(pXml, pIdSessionTemplateXsl, pIdSessionTemplateCss);
	}

	@Override
	public byte[] createFilePdf(String pXml, String pIdSessionTemplateXsl) throws UtplException {
		return pdfGestor.createFilePdf(pXml, pIdSessionTemplateXsl);
	}

}
