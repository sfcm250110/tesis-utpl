package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class ConstantesEmail implements Serializable {
	
	private static final long serialVersionUID = 4598396573279368409L;
	
	// Generales
	public final static String PROTOCOLO_MAIL = "smtp";
	public final static String DEBUG_PROPERTY_MAIL = "mail.debug";
	public final static String AUTH_PROPERTY_MAIL = "mail.smtp.auth";
	public final static String STARTTLS_ENABLE_PROPERTY_MAIL = "mail.smtp.starttls.enable";
	public final static String HOST_PROPERTY_MAIL = "mail.smtp.host";
	public final static String PORT_PROPERTY_MAIL = "mail.smtp.port";
	public final static String IP_DNS_SERVER_MAIL = "ipDnsServerEmail";
	public final static String PUERTO_SERVER_MAIL = "puertoServerEmail";
	public final static String USUARIO_SERVER_MAIL = "usuarioServerEmail";
	public final static String CLAVE_SERVER_MAIL = "claveServerEmail";
	public final static String DESTINATARIOS_USUARIO_SISTEMA = "destinatariosUsuarioSistema";
	public final static String CODIFICACION_MAIL = "ISO-8859-1";
	public final static String FORMATO_MSJ_MAIL = "html";
	public final static String DESCRIPCION_MSJ_MAIL = "UTPL";
	public final static String DIRECCION_EMAIL_PRINCIPAL = "emailPrincipal";
	public final static String DIRECCION_EMAIL_ENVIO = "informacion@utpl.edu.ec";
	public final static String MSJ_ESTIMADO_EMAIL = "Estimado(a)";
	public final static String MSJ_SALTO_LINEA_EMAIL = "<br></br>";
	public final static String USUARIO_DEPARTAMENTO_OPERACIONES = "Departamento de Operaciones";
	public final static String USUARIO_DEPARTAMENTO_RR_HH = "Departamento de Recursos Humanos";
	public final static String USUARIO_GERENTE = "Gerente";
	public final static String PARAM_USUARIO_EMAIL = "&paramUsuario&";
	public final static String PARAM_ACCION_EMAIL = "&paramAccion&";
	public final static String PARAM_DETALLE_EMAIL = "&paramDetalle&";
	public final static String PARAM_OBSERVACIONES_EMAIL = "&paramObservaciones&";
	public final static String PARAM_USERNAME_EMAIL = "&paramUsername&";
	public final static String PARAM_CLAVE_EMAIL = "&paramClave&";
	public final static String PARAM_PREGUNTA_EMAIL = "&paramPregunta&";
	public final static String PARAM_RESPUESTA_EMAIL = "&paramRespuesta&";
	public final static String ACCION_CAMBIO_CLAVE_EMAIL = "Su clave fue cambiada exitosamente.";
	public final static String ACCION_ERROR_PROCESAR_SRI_WEB_EMAIL = "Se ha producido un error al procesar los comprobantes en el portal web del SRI.";
	public final static String ACCION_ERROR_PROCESAR_SRI_WS_EMAIL = "Se ha producido un error al procesar los comprobantes con el servicio web del SRI.";
	
	// Recuperacion Clave
	public final static String MSJ_RECUPERACION_CLAVE_ASUNTO = "Recuperaci\u00F3n de Clave.";
	public final static String MSJ_RECUPERACION_CLAVE_DESCRIPCION = "Su clave fue cambiada exitosamente.";
	public final static String MSJ_RECUPERACION_CLAVE_USUARIO = "Su usuario es: ";
	public final static String MSJ_RECUPERACION_CLAVE = "Su nueva clave es: ";
	public final static String MSJ_RECUPERACION_PREGUNTA_SEGURIDAD = "Su pregunta de seguridad es: ";
	public final static String MSJ_RECUPERACION_RESPUESTA_SEGURIDAD = "Su respuesta de seguridad es: ";
	
	// Crear/Modificar Usuario Clave
	public final static String MSJ_CREAR_MODIFICAR_CLAVE_ASUNTO = "Crear/Modificar clave.";
	public final static String MSJ_CREAR_MODIFICAR_CLAVE_DESCRIPCION = "Su clave fue cambiada exitosamente.";
	public final static String MSJ_CREAR_MODIFICAR_CLAVE_USUARIO = "Su usuario es: ";
	public final static String MSJ_CREAR_MODIFICAR_CLAVE = "Su nueva clave es: ";
	public final static String MSJ_CREAR_MODIFICAR_PREGUNTA_SEGURIDAD = "Su pregunta de seguridad es: ";
	public final static String MSJ_CREAR_MODIFICAR_RESPUESTA_SEGURIDAD = "Su respuesta de seguridad es: ";
	
	// Error al procesar comprobantes SRI
	public final static String MSJ_ERROR_PROCESAR_SRI_WEB_ASUNTO = "Error al procesar portal SRI.";
	public final static String MSJ_ERROR_PROCESAR_SRI_WS_ASUNTO = "Error al procesar ws SRI.";

}
