package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.vo.SessionUtil;

public class EmailUtil implements Serializable {
	
	private static final long serialVersionUID = 3378905809255982672L;

	public static String msgClaveUsuario(Usuario pUsuario, String pAccion) {
		String msjTemplateHtml = SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_EMAIL_REGISTRO_RECUPERACION_CLAVE).toString();
		
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_USUARIO_EMAIL, pUsuario.getNombres());
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_ACCION_EMAIL, pAccion);
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_USERNAME_EMAIL, pUsuario.getUserName());
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_CLAVE_EMAIL, pUsuario.getClaveUno());
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_PREGUNTA_EMAIL, pUsuario.getPreguntaSeguridad().getPreguntaSeguridad());
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_RESPUESTA_EMAIL, pUsuario.getRespuestaSeguridad());
		
		return msjTemplateHtml;
	}
	
	public static String msgErrorProcesarSri(String pNombre, String pAccion, String pDetalle) {
		String msjTemplateHtml = SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_EMAIL_ERROR_PROCESAR_SRI).toString();
		
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_USUARIO_EMAIL, pNombre);
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_ACCION_EMAIL, pAccion);
		msjTemplateHtml = msjTemplateHtml.replace(ConstantesEmail.PARAM_DETALLE_EMAIL, pDetalle);
		
		return msjTemplateHtml;
	}

}