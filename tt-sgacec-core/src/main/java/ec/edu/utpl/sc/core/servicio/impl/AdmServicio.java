package ec.edu.utpl.sc.core.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.ErrorSistema;
import ec.edu.utpl.sc.core.entity.Rol;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.gestor.IAdmGestor;
import ec.edu.utpl.sc.core.servicio.IAdmServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.ADM_SERVICIO)
public class AdmServicio implements IAdmServicio {
	
	@Autowired
	@Qualifier(Constantes.ADM_GESTOR)
	private IAdmGestor admGestor;

	@Override
	public void crearUsuario(Usuario pUsuario, List<Rol> pRoles, List<Empresa> pEmpresas) throws UtplException {
		admGestor.crearUsuario(pUsuario, pRoles, pEmpresas);
	}

	@Override
	public void modificarUsuario(Usuario pUsuario, List<Rol> pRoles, List<Empresa> pEmpresas) throws UtplException {
		admGestor.modificarUsuario(pUsuario, pRoles, pEmpresas);
	}

	@Override
	public void sendEmailKeyUser(Usuario pUsuario) throws UtplException {
		admGestor.sendEmailKeyUser(pUsuario);
	}

	@Override
	public void recoveryKey(Usuario pUsuario) throws UtplException {
		admGestor.recoveryKey(pUsuario);
	}

	@Override
	public String generateKeyTmp() throws UtplException {
		return admGestor.generateKeyTmp();
	}

	@Override
	public Usuario changeKey(String pUserName, String pClave) throws UtplException {
		return admGestor.changeKey(pUserName, pClave);
	}

	@Override
	public List<CheckDownloadSri> getChecksDownloadSri() throws UtplException {
		return admGestor.getChecksDownloadSri();
	}

	@Override
	public void procesarTodo(List<CheckDownloadSri> pChecksDownloadSri) throws UtplException {
		admGestor.procesarTodo(pChecksDownloadSri);
	}

	@Override
	public void procesar(CheckDownloadSri pCheckDownloadSri) throws UtplException {
		admGestor.procesar(pCheckDownloadSri);
	}

	@Override
	public Boolean usuarioActivo(Long pIdUsuario) throws UtplException {
		return admGestor.usuarioActivo(pIdUsuario);
	}

	@Override
	public void checkDownloadSri(Empresa pEmpresa, Date pFechaCheckDownloadSri) throws UtplException {
		admGestor.checkDownloadSri(pEmpresa, pFechaCheckDownloadSri);
	}

	@Override
	public void registerErrorSistema(Exception pException, String pModulo, String pNivel, String pMensajeUsuario) {
		admGestor.registerErrorSistema(pException, pModulo, pNivel, pMensajeUsuario);
	}

	@Override
	public List<ErrorSistema> getErroresSistemaPrint(ErrorSistema pErrorSistema) throws UtplException {
		return admGestor.getErroresSistemaPrint(pErrorSistema);
	}

	@Override
	public ErrorSistema getErrorSistemaPrint(Long pIdErrorSistema) throws UtplException {
		return admGestor.getErrorSistemaPrint(pIdErrorSistema);
	}

	@Override
	public void downloadCheckDownloadSri(String pMessageXml) {
		admGestor.downloadCheckDownloadSri(pMessageXml);
	}

}
