package ec.edu.utpl.sc.core.gestor;

import java.util.List;

import ec.edu.utpl.sc.core.entity.ParametroGeneral;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.vo.Email;
import ec.edu.utpl.sc.core.ws.AutorizacionComprobantesOffline;

public interface IFwGestor {

	public Email initEmail(String pIdSessionEmail) throws UtplException;
	
	public void sendEmail(Email pEmail) throws UtplException;
	
	public List<ParametroGeneral> obtenerParametrosGeneral() throws UtplException;
	
	public ParametroGeneral obtenerParametroGeneral(String pCodigo) throws UtplException;
	
	public ParametroGeneral modificarParametroGeneral(ParametroGeneral pParametroGeneral) throws UtplException;
	
	public Boolean validateEmail(String pEmail) throws UtplException;
	
	public Email getEmail(String pDestinatario, String pAsunto, String pMsj) throws UtplException;
	
	public AutorizacionComprobantesOffline getAutorizacionComprobantesOffline() throws UtplException;
	
	public void sendEmailQueue(Email pEmail);
	
	public void sendEmail(String pMessageXml);

}
