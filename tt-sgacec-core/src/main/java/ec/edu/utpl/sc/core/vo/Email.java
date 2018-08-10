package ec.edu.utpl.sc.core.vo;

import java.io.Serializable;

public class Email implements Serializable {

	private static final long serialVersionUID = -7285603637818267146L;
	
	private String servidorSmtp;
	private String puerto;
	private String usuario;
	private String password;
	private String destinatarios;
	private String asunto;
	private String mensaje;
	private String identificadorSessionProperties;
	private String identificadorSessionTransport;
	private String fileNameAttachment;
	private byte[] fileAttachment;
	private String pathAttachmentZip;

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

	public String getPathAttachmentZip() {
		return pathAttachmentZip;
	}

	public void setPathAttachmentZip(String pathAttachmentZip) {
		this.pathAttachmentZip = pathAttachmentZip;
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

}
