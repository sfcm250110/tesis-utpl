package org.tt.sgacec.web.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.context.RequestContext;

import ec.edu.utpl.sc.core.util.Constantes;

public class JsfUtil implements Serializable {
	
	private static final long serialVersionUID = -3037740484921643720L;

	/**
	 * Permite obtener el contexto de la instancia actual del facesContext.
	 */
	public static FacesContext getCurrentInstanceFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Permite obtener el contexto de la instancia actual del request.
	 */
	public static RequestContext getCurrentInstanceRequestContext() {
		return RequestContext.getCurrentInstance();
	}

	public static void removeManagedBean(String pManagedBean) {
		getCurrentInstanceFacesContext().getExternalContext().getSessionMap().remove(pManagedBean);
	}

	public static void invalidateSession() {
		getCurrentInstanceFacesContext().getExternalContext().invalidateSession();
	}

	public static HttpServletRequest getHttpRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * @return Retorna el username del funcionario que se encuentra activo en el sistema
	 */
	public static String getUsername() {
		return getHttpRequest().getRemoteUser().toUpperCase();
	}

	/**
	 * @return Retorna el nombre del servidor donde se ejecuta la aplicacion
	 * @throws UnknownHostException
	 */
	public static String getHostName() throws UnknownHostException {
		return java.net.InetAddress.getLocalHost().getHostName();
	}

	public static void addMessage(Integer pNivel, String pMessage) {
		FacesMessage facesMessage = null;

		// Mensaje de error
		if (pNivel.equals(Constantes.MSJ_ERROR)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, pMessage, null);
		}

		// Mensaje de error fatal
		if (pNivel.equals(Constantes.MSJ_FATAL)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, pMessage, null);
		}

		// Mensaje de advertencia
		if (pNivel.equals(Constantes.MSJ_WARN)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, pMessage, null);
		}

		// Mensaje de informacion
		if (pNivel.equals(Constantes.MSJ_INFO)) {
			facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, pMessage, null);
		}

		getCurrentInstanceFacesContext().addMessage(null, facesMessage);
	}
	
	public static void addMessageInfo(String pMessage) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, pMessage, null);
		getCurrentInstanceFacesContext().addMessage(null, facesMessage);
	}
	
	public static void addMessageWarn(String pMessage) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, pMessage, null);
		getCurrentInstanceFacesContext().addMessage(null, facesMessage);
	}
	
	public static void addMessageFatal(String pMessage) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL, pMessage, null);
		getCurrentInstanceFacesContext().addMessage(null, facesMessage);
	}
	
	public static void addMessageError(String pMessage) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, pMessage, null);
		getCurrentInstanceFacesContext().addMessage(null, facesMessage);
	}

	public static HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest();
	}
	
	public static HttpServletResponse getHttpServletResponse() {
		return (HttpServletResponse) getCurrentInstanceFacesContext().getExternalContext().getResponse();
	}
	
	public static void sendRedirect(String pRedirectUrl) throws IOException {
		getHttpServletResponse().sendRedirect(pRedirectUrl);
	}
	
	public static void redirect(String pRedirectUrl) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(pRedirectUrl);
	}
	
	public static String getContextPath() {
		String scheme = getHttpServletRequest().getScheme();
		String host = getHttpServletRequest().getServerName();
		int port = getHttpServletRequest().getServerPort();
		String contextPath = getHttpServletRequest().getContextPath();
		
		return (scheme + "://" + host + ":" + port + contextPath);
	}

	public static ServletContext getServletContext() {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

		return servletContext;
	}

	public static String getRealPath() {
		String realPath = getServletContext().getRealPath(Constantes.SLASH);

		return realPath;
	}

	public static String getRealPath(String pDirectorio) {
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(Constantes.DOBLE_SLASH + pDirectorio);

		return realPath;
	}

	public static StringBuffer getRequestURL() {
		StringBuffer requestURL = ((HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest()).getRequestURL();

		return requestURL;
	}

	public static String getRemoteAddr() {
		return getHttpServletRequest().getRemoteAddr();
	}

	/**
	 * Permite obtener el contexto del path de la imagen para generar el codigo de barras.
	 * 
	 * @throws IOException
	 */
	public static String getContextPathImagen() {
		String[] contextPath = getRequestURL().toString().split(getContextPath());
		String contextPathImagen = contextPath[0].toString() + getContextPath();

		return contextPathImagen;
	}

	/**
	 * Permite llamar al metodo CallBackParam.
	 */
	public static void addCallbackParam(Boolean pParametro) {
		getCurrentInstanceRequestContext().addCallbackParam(Constantes.PARAM_ACEPTABLE, Boolean.valueOf(pParametro));
	}

	public static String getParameterServlet(String pParametro) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest();

		return httpServletRequest.getParameter(pParametro);
	}

	public static String getParameter(String pParametro) {
		return getCurrentInstanceFacesContext().getExternalContext().getRequestParameterMap().get(pParametro);
	}

	public static Object getAttribute(String pParametro) {
		FaceletContext faceletContext = (FaceletContext) getCurrentInstanceFacesContext().getAttributes().get(FaceletContext.FACELET_CONTEXT_KEY);
		return faceletContext.getAttribute(pParametro);
	}
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String resource) throws ServletException, IOException {
		request.getRequestDispatcher(resource).forward(request, response);
	}
	
	public static void setSessionAttribute(String pNombreParametro, Object pValorParametro) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) getCurrentInstanceFacesContext().getExternalContext().getRequest();
		httpServletRequest.getSession().setAttribute(pNombreParametro, pValorParametro);
	}
	
	public static Object getEvaluatedExpression(String pExpression){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		return facesContext.getApplication().evaluateExpressionGet(facesContext, pExpression, Object.class);
	}
	
	public static void downloadFile() throws IOException {
		getCurrentInstanceFacesContext().getExternalContext().redirect(getCurrentInstanceFacesContext().getExternalContext().getRequestContextPath() + Constantes.DOWNLOAD_SERVLET);
		getCurrentInstanceFacesContext().responseComplete();
	}
	
}
