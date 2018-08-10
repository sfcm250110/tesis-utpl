package org.tt.sgacec.web.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tt.sgacec.web.datamanager.DownloadDataManager;

import ec.edu.utpl.sc.core.util.Constantes;

public class DownloadHelper extends HttpServlet {

	private static final long serialVersionUID = -98167344154980690L;

	@Override
	public void doPost(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse) throws ServletException {
		processRequets(pHttpServletRequest, pHttpServletResponse);
	}

	@Override
	public void doGet(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse) throws ServletException {
		processRequets(pHttpServletRequest, pHttpServletResponse);
	}

	private void processRequets(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse) throws ServletException {
		try {
			DownloadDataManager downloadDataManager = (DownloadDataManager) pHttpServletRequest.getSession().getAttribute(Constantes.DOWNLOAD_DATAMANAGER);
			
			if (downloadDataManager != null) {
				pHttpServletResponse.setContentType(getContentType(downloadDataManager));
				
				if (Constantes.TYPE_PDF.equals(downloadDataManager.getType())) {
					processDownloadPdf(pHttpServletRequest, pHttpServletResponse, downloadDataManager);

				} else if (Constantes.TYPE_XML.equals(downloadDataManager.getType())) {
					processDownloadXml(pHttpServletRequest, pHttpServletResponse, downloadDataManager);

				} else if (Constantes.TYPE_XLS.equals(downloadDataManager.getType())) {
					processDownloadExcel(pHttpServletRequest, pHttpServletResponse, downloadDataManager);
				}

				downloadDataManager.setContent(null);
				downloadDataManager.setContentBytes(null);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void processDownloadPdf(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse, DownloadDataManager pDownloadDataManager) throws IOException {
		pHttpServletResponse.setHeader(Constantes.CONTENT_DISPOSITION, Constantes.CONTENT_ATTACHMENT_FILE_NAME + pDownloadDataManager.getName() + pDownloadDataManager.getType());
		
		byte[] contentBytes = pDownloadDataManager.getContentBytes();
		pHttpServletResponse.setHeader(Constantes.CONTENT_LENGTH, String.valueOf(contentBytes.length));
		OutputStream outputStream = pHttpServletResponse.getOutputStream();
		outputStream.write(contentBytes);
		outputStream.flush();
		outputStream.close();
	}
	
	private void processDownloadXml(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse, DownloadDataManager pDownloadDataManager) throws IOException {
		pHttpServletResponse.setHeader(Constantes.CONTENT_DISPOSITION, Constantes.CONTENT_ATTACHMENT_FILE_NAME + pDownloadDataManager.getName() + pDownloadDataManager.getType());
		pHttpServletResponse.setCharacterEncoding(Constantes.ENCODING_UTF_8);
		
		PrintWriter printWriter = pHttpServletResponse.getWriter();
		printWriter.print(pDownloadDataManager.getContent());
		printWriter.flush();
	}
	
	private void processDownloadExcel(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse, DownloadDataManager pDownloadDataManager) throws IOException  {
		pHttpServletResponse.setContentType(Constantes.CONTENT_TYPE_EXCEL);
		pHttpServletResponse.setHeader(Constantes.CONTENT_DISPOSITION, Constantes.INLINE + Constantes.PUNTO_Y_COMA + Constantes.FILENAME + Constantes.SIGNO_IGUAL + pDownloadDataManager.getName() + Constantes.TYPE_XLS + Constantes.PUNTO_Y_COMA);
		OutputStream outputStream = pHttpServletResponse.getOutputStream();
		outputStream.write(pDownloadDataManager.getContentBytes());
		outputStream.close();
	}

	private String getContentType(DownloadDataManager pDownloadDataManager) {
		String contentType = null;

		if (Constantes.TYPE_PDF.equals(pDownloadDataManager.getType())) {
			contentType = Constantes.CONTENT_TYPE_PDF;

		} else if (Constantes.TYPE_XML.equals(pDownloadDataManager.getType())) {
			contentType = Constantes.CONTENT_TYPE_XML;

		} else if (Constantes.TYPE_HTML.equals(pDownloadDataManager.getType())) {
			contentType = Constantes.CONTENT_TYPE_HTML;

		} else if (Constantes.TYPE_XLS.equals(pDownloadDataManager.getType())) {
			contentType = Constantes.CONTENT_TYPE_EXCEL;

		} else if (Constantes.TYPE_DOC.equals(pDownloadDataManager.getType())) {
			contentType = Constantes.CONTENT_TYPE_WORD;
		}

		return contentType;
	}

}
