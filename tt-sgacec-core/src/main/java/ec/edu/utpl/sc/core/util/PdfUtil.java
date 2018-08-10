package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

import ec.edu.utpl.sc.core.gestor.impl.PdfGestor;

public class PdfUtil implements Serializable {

	private static final long serialVersionUID = 6147018586865276965L;
	
	public static void main(String[] args) {
		try {
			PdfGestor pdfGestor = new PdfGestor();
			String filePathSrc = Constantes.FILE_PATH_SRC;
			String filePathDest = Constantes.FILE_PATH_DEST;
			float xInferiorIzquierda = 93f;
			float xSuperiorDerecha = 150f;
			float yInferiorIzquierda = 500f;
			float ySuperiorDerecha = 490f;
			
			pdfGestor.paintRectangle(filePathSrc, filePathDest, xInferiorIzquierda, xSuperiorDerecha, yInferiorIzquierda, ySuperiorDerecha);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
