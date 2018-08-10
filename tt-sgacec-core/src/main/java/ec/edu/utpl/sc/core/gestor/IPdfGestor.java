package ec.edu.utpl.sc.core.gestor;

import java.util.List;

import ec.edu.utpl.sc.core.util.UtplException;

public interface IPdfGestor {
	
	public String obtenerNumeroAutorizacion(byte[] pFileBytes) throws UtplException;
	
	public String obtenerNumeroAutorizacion(String pFilePath) throws UtplException;
	
	public String obtenerContent(String pFilePathSrc) throws UtplException;
	
	public void paintRectangle(String pFilePathSrc, String pFilePathDest, float xInferiorIzquierda, float xSuperiorDerecha, float yInferiorIzquierda, float ySuperiorDerecha) throws UtplException;
	
	public List<String[]> formatContenido(String pContenido) throws UtplException;
	
	public void printContentConsole(List<String[]> pContenidos) throws UtplException;
	
	public String obtenerRucEmpresa(byte[] pFileBytes) throws UtplException;
	
	public byte[] createFilePdf(String pXml, String pIdSessionTemplateXsl, String pIdSessionTemplateCss) throws UtplException;
	
	public byte[] createFilePdf(String pXml, String pIdSessionTemplateXsl) throws UtplException;

}
