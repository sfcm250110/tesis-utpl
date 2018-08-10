package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.ParametroGeneral;
import ec.edu.utpl.sc.core.gestor.IFwGestor;
import ec.edu.utpl.sc.core.servicio.IFwServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.vo.Email;
import ec.edu.utpl.sc.core.ws.AutorizacionComprobantesOffline;

@Service(Constantes.FW_SERVICIO)
public class FwServicio implements IFwServicio {
	
	@Autowired
	@Qualifier(Constantes.FW_GESTOR)
	private IFwGestor fwGestor;

	@Override
	public Email initEmail(String pIdSessionEmail) throws UtplException {
		return fwGestor.initEmail(pIdSessionEmail);
	}

	@Override
	public void sendEmail(Email pEmail) throws UtplException {
		fwGestor.sendEmail(pEmail);
	}

	@Override
	public List<ParametroGeneral> obtenerParametrosGeneral() throws UtplException {
		return fwGestor.obtenerParametrosGeneral();
	}

	@Override
	public ParametroGeneral obtenerParametroGeneral(String pCodigo) throws UtplException {
		return fwGestor.obtenerParametroGeneral(pCodigo);
	}

	@Override
	public ParametroGeneral modificarParametroGeneral(ParametroGeneral pParametroGeneral) throws UtplException {
		return fwGestor.modificarParametroGeneral(pParametroGeneral);
	}

	@Override
	public Boolean validateEmail(String pEmail) throws UtplException {
		return fwGestor.validateEmail(pEmail);
	}

	@Override
	public Email getEmail(String pDestinatario, String pAsunto, String pMsj) throws UtplException {
		return fwGestor.getEmail(pDestinatario, pAsunto, pMsj);
	}

	@Override
	public AutorizacionComprobantesOffline getAutorizacionComprobantesOffline() throws UtplException {
		return fwGestor.getAutorizacionComprobantesOffline();
	}

	@Override
	public void sendEmailQueue(Email pEmail) {
		fwGestor.sendEmailQueue(pEmail);
	}

	@Override
	public void sendEmail(String pMessageXml) {
		fwGestor.sendEmail(pMessageXml);
	}

}
