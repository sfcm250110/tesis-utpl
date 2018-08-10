package ec.edu.utpl.sc.core.gestor;

import java.util.Date;
import java.util.List;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.ErrorSistema;
import ec.edu.utpl.sc.core.entity.Rol;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IAdmGestor {

	public void crearUsuario(Usuario pUsuario, List<Rol> pRoles, List<Empresa> pEmpresas) throws UtplException;
	
	public void modificarUsuario(Usuario pUsuario, List<Rol> pRoles, List<Empresa> pEmpresas) throws UtplException;
	
	public void sendEmailKeyUser(Usuario pUsuario) throws UtplException;
	
	public void recoveryKey(Usuario pUsuario) throws UtplException;
	
	public String generateKeyTmp() throws UtplException;
	
	public Usuario changeKey(String pUserName, String pClave) throws UtplException;
	
	public List<CheckDownloadSri> getChecksDownloadSri() throws UtplException;
	
	public void procesarTodo(List<CheckDownloadSri> pChecksDownloadSri) throws UtplException;
	
	public void procesar(CheckDownloadSri pCheckDownloadSri) throws UtplException;
	
	public Boolean usuarioActivo(Long pIdUsuario) throws UtplException;
	
	public void checkDownloadSri(Empresa pEmpresa, Date pFechaCheckDownloadSri) throws UtplException;
	
	public void registerErrorSistema(Exception pException, String pModulo, String pNivel, String pMensajeUsuario);
	
	public List<ErrorSistema> getErroresSistemaPrint(ErrorSistema pErrorSistema) throws UtplException;
	
	public ErrorSistema getErrorSistemaPrint(Long pIdErrorSistema) throws UtplException;
	
	public void downloadCheckDownloadSri(String pMessageXml);

}
