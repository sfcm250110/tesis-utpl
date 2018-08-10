package ec.edu.utpl.sc.core.gestor.impl;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.ParametroGeneral;
import ec.edu.utpl.sc.core.gestor.IAdmGestor;
import ec.edu.utpl.sc.core.gestor.IFwGestor;
import ec.edu.utpl.sc.core.queue.QueueServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesEmail;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.util.XmlUtil;
import ec.edu.utpl.sc.core.vo.Email;
import ec.edu.utpl.sc.core.vo.SessionUtil;
import ec.edu.utpl.sc.core.ws.AutorizacionComprobantesOffline;
import ec.edu.utpl.sc.core.ws.AutorizacionComprobantesOfflineService;

@Repository(Constantes.FW_GESTOR)
public class FwGestor implements IFwGestor {
	
	private static Logger log = Logger.getLogger(FwGestor.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.ADM_GESTOR)
	private IAdmGestor admGestor; 

	@Override
	public Email initEmail(String pIdSessionEmail) throws UtplException {
		try {
			Email email = null;

			// Si no se encuentra en session CONSULTAR en la db, caso contrario obtener de session
			if (SessionUtil.getObjetoSession(pIdSessionEmail) == null) {
				email = new Email();
				email.setIdentificadorSessionProperties(Constantes.ID_SESSION_PROPERTIES_EMAIL);
				email.setIdentificadorSessionTransport(Constantes.ID_SESSION_TRANSPORT_EMAIL);

				// Ip o Dns
				ParametroGeneral parametroGeneral = new ParametroGeneral();
				parametroGeneral.setValorCrud(Constantes.TYPE_S_SELECT);
				parametroGeneral.setNombre(ConstantesEmail.IP_DNS_SERVER_MAIL);
				parametroGeneral = crudDao.findOneRow(parametroGeneral, Boolean.TRUE);
				email.setServidorSmtp(parametroGeneral == null ? null : parametroGeneral.getValor());

				// Puerto
				parametroGeneral = new ParametroGeneral();
				parametroGeneral.setValorCrud(Constantes.TYPE_S_SELECT);
				parametroGeneral.setNombre(ConstantesEmail.PUERTO_SERVER_MAIL);
				parametroGeneral = crudDao.findOneRow(parametroGeneral, Boolean.TRUE);
				email.setPuerto(parametroGeneral == null ? null : parametroGeneral.getValor());

				// Usuario
				parametroGeneral = new ParametroGeneral();
				parametroGeneral.setValorCrud(Constantes.TYPE_S_SELECT);
				parametroGeneral.setNombre(ConstantesEmail.USUARIO_SERVER_MAIL);
				parametroGeneral = crudDao.findOneRow(parametroGeneral, Boolean.TRUE);
				email.setUsuario(parametroGeneral == null ? null : parametroGeneral.getValor());

				// Clave
				parametroGeneral = new ParametroGeneral();
				parametroGeneral.setValorCrud(Constantes.TYPE_S_SELECT);
				parametroGeneral.setNombre(ConstantesEmail.CLAVE_SERVER_MAIL);
				parametroGeneral = crudDao.findOneRow(parametroGeneral, Boolean.TRUE);
				email.setPassword(parametroGeneral == null ? null : parametroGeneral.getValor());

				if (email.getServidorSmtp() == null) {
					throw new UtplException("No se encuentran configurados los parametros para el envio de email");

				} else {
					SessionUtil.addObjetoSession(pIdSessionEmail, email);
				}

			} else {
				email = (Email) SessionUtil.getObjetoSession(pIdSessionEmail);
			}

			return email;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@Override
	public void sendEmail(Email pEmail) throws UtplException {
		try {
			Session session = getSessionEmail(pEmail);
			
			if (pEmail.getDestinatarios() != null && !Constantes.SPACE_BLANK.equals(pEmail.getDestinatarios())) {
				String[] destinatarios = pEmail.getDestinatarios().split(Constantes.PUNTO_Y_COMA);

				if (destinatarios != null && destinatarios.length > Constantes.I0) {
					
					for (String destinatario : destinatarios) {
						MimeMessage mimeMessage = new MimeMessage(session);
						mimeMessage.setFrom(new InternetAddress(ConstantesEmail.DIRECCION_EMAIL_ENVIO));
						mimeMessage.setDescription(ConstantesEmail.DESCRIPCION_MSJ_MAIL);
						mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
						mimeMessage.setSubject(pEmail.getAsunto());
						mimeMessage.setSentDate(new Date());
						mimeMessage.setText(pEmail.getMensaje());
						mimeMessage.setContent(pEmail.getMensaje(), Constantes.CONTENT_TYPE_HTML);
						
						Transport transport = session.getTransport(Constantes.PROTOCOLO_MAIL);
						transport.connect(pEmail.getServidorSmtp(), pEmail.getUsuario(), pEmail.getPassword());
						mimeMessage.saveChanges();
						transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
						transport.close();
					}
				}
			}

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public List<ParametroGeneral> obtenerParametrosGeneral() throws UtplException {
		try {
			List<ParametroGeneral> parametrosGeneral = null;
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PARAMETROS_GENERAL) == null) {
				parametrosGeneral = crudDao.findForCriteria(new ParametroGeneral(), Boolean.FALSE);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PARAMETROS_GENERAL, parametrosGeneral);
				
			} else {
				parametrosGeneral = (List<ParametroGeneral>) SessionUtil.getObjetoSession(Constantes.ID_SESSION_PARAMETROS_GENERAL);
			}
			
			return parametrosGeneral;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@Override
	public ParametroGeneral obtenerParametroGeneral(String pCodigo) throws UtplException {
		try {
			ParametroGeneral parametroGeneral = null;
			
			if (SessionUtil.getObjetoSession(pCodigo) == null) {
				
				for (ParametroGeneral parametroGeneralTmp : obtenerParametrosGeneral()) {
					if (pCodigo.equals(parametroGeneralTmp.getNombre())) {
						parametroGeneral = parametroGeneralTmp;
						SessionUtil.addObjetoSession(pCodigo, parametroGeneral);
						break;
					}
				}
				
			} else {
				parametroGeneral = (ParametroGeneral) SessionUtil.getObjetoSession(pCodigo);
			}
			
			return parametroGeneral;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public ParametroGeneral modificarParametroGeneral(ParametroGeneral pParametroGeneral) throws UtplException {
		try {
			SessionUtil.removeObjetoSession(pParametroGeneral.getNombre());
			pParametroGeneral = crudDao.update(pParametroGeneral);
			
			return pParametroGeneral;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Boolean validateEmail(String pEmail) throws UtplException {
		try {
			Pattern pattern = Pattern.compile(Constantes.PATTERN_EMAIL);
			Matcher matcher = pattern.matcher(pEmail);
			
	        return matcher.matches();
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Email getEmail(String pDestinatario, String pAsunto, String pMsj) throws UtplException {
		try {
			Email email = initEmail(Constantes.ID_SESSION_INIT_EMAIL);
			email.setDestinatarios(pDestinatario);
			email.setAsunto(pAsunto);
			email.setMensaje(pMsj);
			
			return email;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public AutorizacionComprobantesOffline getAutorizacionComprobantesOffline() throws UtplException {
		try {
			URL baseUrl = AutorizacionComprobantesOfflineService.class.getResource(Constantes.PUNTO);
			URL url = new URL(baseUrl, Constantes.AUTORIZACION_PRODUCCION_OFFLINE_WSDL);
			QName qName = new QName(Constantes.NAMESPACE_URI_AUTORIZACION, Constantes.LOCAL_PART_AUTORIZACION_OFFLINE);
			AutorizacionComprobantesOfflineService autorizacionComprobantesOfflineService = new AutorizacionComprobantesOfflineService(url, qName);
			AutorizacionComprobantesOffline autorizacionComprobantesOffline = autorizacionComprobantesOfflineService.getAutorizacionComprobantesOfflinePort();
			
			return autorizacionComprobantesOffline;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void sendEmailQueue(Email pEmail) {
		try {
			String xml = XmlUtil.emailToStringXml(pEmail);
			QueueServicio.send(xml, Constantes.QUEUE_SEND_EMAIL);
			
		} catch (Exception e) {
			String mensajeUsuario = "Error al enviar el email a la cola";
			log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			admGestor.registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
		}
	}
	
	@Override
	public void sendEmail(String pMessageXml) {
		try {
			Email email = XmlUtil.xmlToEmail(pMessageXml);
			Session session = getSessionEmail(email);
			
			if (email.getDestinatarios() != null && !Constantes.SPACE_BLANK.equals(email.getDestinatarios())) {
				String[] destinatarios = email.getDestinatarios().split(Constantes.PUNTO_Y_COMA);

				if (destinatarios != null && destinatarios.length > Constantes.I0) {
					
					for (String destinatario : destinatarios) {
						MimeMessage mimeMessage = new MimeMessage(session);
						mimeMessage.setFrom(new InternetAddress(ConstantesEmail.DIRECCION_EMAIL_ENVIO));
						mimeMessage.setDescription(ConstantesEmail.DESCRIPCION_MSJ_MAIL);
						mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
						mimeMessage.setSubject(email.getAsunto());
						mimeMessage.setSentDate(new Date());
						mimeMessage.setText(email.getMensaje());
						mimeMessage.setContent(email.getMensaje(), Constantes.CONTENT_TYPE_HTML);
						
						Transport transport = session.getTransport(Constantes.PROTOCOLO_MAIL);
						transport.connect(email.getServidorSmtp(), email.getUsuario(), email.getPassword());
						mimeMessage.saveChanges();
						transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
						transport.close();
					}
				}
			}

		} catch (Exception e) {
			String mensajeUsuario = "Error al enviar el email al destinatario";
			log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			admGestor.registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
		}
	}
	
	private Session getSessionEmail(Email pEmail) throws UtplException {
		try {
			Session session = null;
			
			if (SessionUtil.getObjetoSession(pEmail.getIdentificadorSessionProperties()) == null) {
				Properties properties = new Properties();
				properties.put(ConstantesEmail.DEBUG_PROPERTY_MAIL, Boolean.TRUE.toString());
				properties.put(ConstantesEmail.AUTH_PROPERTY_MAIL, Boolean.TRUE);
				properties.put(ConstantesEmail.STARTTLS_ENABLE_PROPERTY_MAIL, Boolean.TRUE);
				properties.put(ConstantesEmail.HOST_PROPERTY_MAIL, pEmail.getServidorSmtp());
				properties.put(ConstantesEmail.PORT_PROPERTY_MAIL, pEmail.getPuerto());
				
				session = Session.getInstance(properties, null);
				session.setDebug(Boolean.FALSE);
				
				SessionUtil.addObjetoSession(pEmail.getIdentificadorSessionProperties(), session);

			} else {
				session = (Session) SessionUtil.getObjetoSession(pEmail.getIdentificadorSessionProperties());
			}
			
			return session;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
