package ec.edu.utpl.sc.core.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ec.edu.utpl.sc.core.util.Constantes;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = Constantes.SPACE_BLANK, propOrder = { "servidorSmtp", "puerto", "usuario", "password", "destinatarios", "asunto", "mensaje", "identificadorSessionProperties", "identificadorSessionTransport", "fileNameAttachment", "fileAttachment", "pathAttachmentZip" })
@XmlRootElement(name = "EmailXml")
public class EmailXml {
	
	@XmlElement(name = "servidorSmtp")
	protected String servidorSmtp;
	
	@XmlElement(name = "puerto")
	protected String puerto;
	
	@XmlElement(name = "usuario")
	protected String usuario;

	@XmlElement(name = "password")
	protected String password;
	
	@XmlElement(name = "destinatarios")
	protected String destinatarios;
	
	@XmlElement(name = "asunto")
	protected String asunto;
	
	@XmlElement(name = "mensaje")
	protected String mensaje;
	
	@XmlElement(name = "identificadorSessionProperties")
	protected String identificadorSessionProperties;
	
	@XmlElement(name = "identificadorSessionTransport")
	protected String identificadorSessionTransport;
	
	@XmlElement(name = "fileNameAttachment")
	protected String fileNameAttachment;
	
	@XmlElement(name = "fileAttachment")
	protected byte[] fileAttachment;
	
	@XmlElement(name = "pathAttachmentZip")
	protected String pathAttachmentZip;

	public String getServidorSmtp() {
		return servidorSmtp;
	}

	public void setServidorSmtp(String servidorSmtp) {
		this.servidorSmtp = servidorSmtp;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getIdentificadorSessionProperties() {
		return identificadorSessionProperties;
	}

	public void setIdentificadorSessionProperties(String identificadorSessionProperties) {
		this.identificadorSessionProperties = identificadorSessionProperties;
	}

	public String getIdentificadorSessionTransport() {
		return identificadorSessionTransport;
	}

	public void setIdentificadorSessionTransport(String identificadorSessionTransport) {
		this.identificadorSessionTransport = identificadorSessionTransport;
	}

	public String getFileNameAttachment() {
		return fileNameAttachment;
	}

	public void setFileNameAttachment(String fileNameAttachment) {
		this.fileNameAttachment = fileNameAttachment;
	}

	public byte[] getFileAttachment() {
		return fileAttachment;
	}

	public void setFileAttachment(byte[] fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	public String getPathAttachmentZip() {
		return pathAttachmentZip;
	}

	public void setPathAttachmentZip(String pathAttachmentZip) {
		this.pathAttachmentZip = pathAttachmentZip;
	}

}