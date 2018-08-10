package ec.edu.utpl.sc.core.util;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import ec.edu.utpl.sc.core.vo.SessionUtil;

public class CssUtil implements Serializable {
	
	private static final long serialVersionUID = -8880253955542600185L;

	public static String getContentCssPathDefaul() throws IOException {
		String pathNameCss = Constantes.PATH_DIR_TEMPLATES + Constantes.NAME_TEMPLATE_XSL;
		
		byte[] contentCssBytes = getContentCssPath(pathNameCss);
		String contentCss = new String(contentCssBytes);
		
		return contentCss;
	}
	
	public static byte[] getContentCssPath(String pPathCss) throws IOException {
		return Files.readAllBytes(Paths.get(pPathCss));
	}
	
	public static byte[] getContentCssSession(String pIdSessionTemplateCss) throws IOException {
		byte[] contentCss = SessionUtil.getObjetoSession(pIdSessionTemplateCss).toString().getBytes();
		
		return contentCss;		
	}
	
	public static String getContentCssSessionToString(String pIdSessionTemplateCss) throws IOException {
		String contentCss = new String(SessionUtil.getObjetoSession(pIdSessionTemplateCss).toString().getBytes());		
		
		return contentCss;
	}
}
