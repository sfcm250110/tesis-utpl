package ec.edu.utpl.sc.core.gestor.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.ErrorSistema;
import ec.edu.utpl.sc.core.entity.Rol;
import ec.edu.utpl.sc.core.entity.RolUsuario;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.entity.UsuarioEmpresa;
import ec.edu.utpl.sc.core.gestor.IAdmGestor;
import ec.edu.utpl.sc.core.gestor.IConsultasGestor;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.gestor.IFwGestor;
import ec.edu.utpl.sc.core.gestor.ISeleniumGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesEmail;
import ec.edu.utpl.sc.core.util.DateUtil;
import ec.edu.utpl.sc.core.util.EmailUtil;
import ec.edu.utpl.sc.core.util.SecurityUtil;
import ec.edu.utpl.sc.core.util.Utilitario;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.util.XmlUtil;
import ec.edu.utpl.sc.core.vo.Email;

@Repository(Constantes.ADM_GESTOR)
public class AdmGestor implements IAdmGestor {
	
	private static final Logger log = Logger.getLogger(Constantes.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.FW_GESTOR)
	private IFwGestor fwGestor;
	
	@Autowired
	@Qualifier(Constantes.CONSULTAS_GESTOR)
	private IConsultasGestor consultasGestor;
	
	@Autowired
	@Qualifier(Constantes.EMPRESA_GESTOR)
	private IEmpresaGestor empresaGestor;
	
	@Autowired
	@Qualifier(Constantes.SELENIUM_GESTOR)
	private ISeleniumGestor seleniumGestor;

	@Override
	public void crearUsuario(Usuario pUsuario, List<Rol> pRoles, List<Empresa> pEmpresas) throws UtplException {
		try {
			if (!fwGestor.validateEmail(pUsuario.getEmail())) {
				throw new UtplException("Email invalido");
			}
			
			Usuario usuario = new Usuario();
			usuario.setUserName(pUsuario.getEmail());
			usuario = crudDao.findOneRow(usuario, Boolean.FALSE);
			if (usuario != null) {
				throw new UtplException("Usuario ya existe");
			}

			// Obtener la clave encriptada
			String clave = null;
			String claveEncrypt = null;
			if (null == pUsuario.getClaveUno()) {
				throw new UtplException("La clave de usuario es obligatorio");
				
			} else {
				clave = pUsuario.getClaveUno();
				claveEncrypt = SecurityUtil.encrypt(Constantes.ALGORITHM_SHA_512, pUsuario.getClaveUno());
			}
			
			// Insertar el Usuario
			pUsuario.setFechaIngreso(new Date());
			pUsuario.setUserName(pUsuario.getEmail());
			pUsuario.setClaveUno(claveEncrypt);
			pUsuario = crudDao.create(pUsuario);
			pUsuario.setClaveUno(clave);

			// Insertar los Roles del Usuario
			for (Rol rol : pRoles) {
				RolUsuario rolUsuario = new RolUsuario();
				rolUsuario.setUsuario(pUsuario);
				rolUsuario.setRol(rol);
				rolUsuario.setUserName(pUsuario.getUserName());
				rolUsuario.setNombreRol(rol.getNombreRol());
				crudDao.create(rolUsuario);
			}
			
			// Insertar las Empresas del Usuario
			for (Empresa empresa : pEmpresas) {
				UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
				usuarioEmpresa.setUsuario(pUsuario);
				usuarioEmpresa.setEmpresa(empresa);
				crudDao.create(usuarioEmpresa);
			}
			
			// Enviar el correo con los nuevos datos al usuario
			sendEmailKeyUser(pUsuario);

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void modificarUsuario(Usuario pUsuario, List<Rol> pRoles, List<Empresa> pEmpresas) throws UtplException {
		try {
			// Obtener la clave encriptada
			String claveEncrypt = null;
			if (null == pUsuario.getClaveUno()) {
				throw new UtplException("La clave de usuario es obligatorio");
				
			} else {
				claveEncrypt = SecurityUtil.encrypt(Constantes.ALGORITHM_SHA_512, pUsuario.getClaveUno());
			}
			
			// Modificar los datos del Usuario
			pUsuario.setClaveUno(claveEncrypt);
			pUsuario = crudDao.update(pUsuario);
			
			// Modificar los Roles del Usuario
			for (Rol rol : pRoles) {
				RolUsuario rolUsuario = new RolUsuario();
				rolUsuario.setUsuario(pUsuario);
				rolUsuario = crudDao.findOneRow(rolUsuario, Boolean.FALSE);
				
				rolUsuario.setRol(rol);
				rolUsuario.setNombreRol(rol.getNombreRol());
				crudDao.update(rolUsuario);
			}
			
			// Modifica las Empresas del Usuario
			for (Empresa empresa : pEmpresas) {
				UsuarioEmpresa usuarioEmpresaFind = new UsuarioEmpresa();
				usuarioEmpresaFind.setUsuario(pUsuario);
				usuarioEmpresaFind.setEmpresa(empresa);
				usuarioEmpresaFind = crudDao.findOneRow(usuarioEmpresaFind, Boolean.FALSE);
				
				if (usuarioEmpresaFind == null) {
					UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
					usuarioEmpresa.setUsuario(pUsuario);
					usuarioEmpresa.setEmpresa(empresa);
					crudDao.create(usuarioEmpresa);
				}
			}

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void sendEmailKeyUser(Usuario pUsuario) throws UtplException {
		try {
			String destinatario = pUsuario.getEmail();
			String asunto = ConstantesEmail.MSJ_CREAR_MODIFICAR_CLAVE_ASUNTO;
			String msj = EmailUtil.msgClaveUsuario(pUsuario, ConstantesEmail.ACCION_CAMBIO_CLAVE_EMAIL);
			Email email = fwGestor.getEmail(destinatario, asunto, msj);
			fwGestor.sendEmailQueue(email);

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void recoveryKey(Usuario pUsuario) throws UtplException {
		try {
			if (!fwGestor.validateEmail(pUsuario.getEmail())) {
				throw new UtplException("Email invalido");
			}
			
			// Obtener la clave encriptada
			String claveTemporal = generateKeyTmp();
			String claveEncrypt = SecurityUtil.encrypt(Constantes.ALGORITHM_SHA_512, claveTemporal);
			
			pUsuario.setClaveUno(claveEncrypt);
			pUsuario = crudDao.update(pUsuario);
			pUsuario.setClaveUno(claveTemporal);
			
			String destinatario = pUsuario.getEmail();
			String asunto = ConstantesEmail.MSJ_RECUPERACION_CLAVE_ASUNTO;
			String msj = EmailUtil.msgClaveUsuario(pUsuario, ConstantesEmail.ACCION_CAMBIO_CLAVE_EMAIL);
			Email email = fwGestor.getEmail(destinatario, asunto, msj);
			fwGestor.sendEmailQueue(email);

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public String generateKeyTmp() throws UtplException {
		try {
			String claveTemporal = Utilitario.getIntance().generarClaveTemporal();
			
			return claveTemporal;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Usuario changeKey(String pUserName, String pClave) throws UtplException {
		try {
			consultasGestor.changeKey(pUserName, pClave);
			
			Usuario usuario = new Usuario();
			usuario.setUserName(pUserName);
			usuario = crudDao.findOneRow(usuario, Boolean.FALSE);
			
			return usuario;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<CheckDownloadSri> getChecksDownloadSri() throws UtplException {
		try {
			CheckDownloadSri checkDownloadSri = new CheckDownloadSri();
			checkDownloadSri.setEtapa(Constantes.ERROR_QUEUE);
			List<CheckDownloadSri> checksDownloadSriTmp = crudDao.findForCriteria(checkDownloadSri, Boolean.FALSE);
			List<CheckDownloadSri> checksDownloadSri = new ArrayList<CheckDownloadSri>();
			
			if (checksDownloadSriTmp != null && !checksDownloadSriTmp.isEmpty()) {
				for (CheckDownloadSri checkDownloadSriTmp : checksDownloadSriTmp) {
					
					// Solo los registros si la empresa se encuentra activa
					if (empresaGestor.empresaActiva(checkDownloadSriTmp.getRuc())) {
						checksDownloadSri.add(checkDownloadSriTmp);
					}
				}
			}
			
			return checksDownloadSri;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void procesarTodo(List<CheckDownloadSri> pChecksDownloadSri) throws UtplException {
		try {
			for (CheckDownloadSri checkDownloadSri : pChecksDownloadSri) {
				procesar(checkDownloadSri);
			}

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void procesar(CheckDownloadSri pCheckDownloadSri) throws UtplException {
		try {
			pCheckDownloadSri.setEtapa(Constantes.REGISTRADO);
			crudDao.update(pCheckDownloadSri);

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Boolean usuarioActivo(Long pIdUsuario) throws UtplException {
		try {
			Boolean usuarioActivo = Boolean.TRUE;
			
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(pIdUsuario);
			usuario.setEstado(Boolean.TRUE);
			usuario = crudDao.findOneRow(usuario, Boolean.FALSE);
			
			if (usuario == null) {
				usuarioActivo = Boolean.FALSE;
			}
			
			return usuarioActivo;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void checkDownloadSri(Empresa pEmpresa, Date pFechaCheckDownloadSri) throws UtplException {
		try {
			CheckDownloadSri checkDownloadSri = new CheckDownloadSri();
			checkDownloadSri.setRuc(pEmpresa.getRuc());
			checkDownloadSri.setFechaDownload(pFechaCheckDownloadSri);
			checkDownloadSri = crudDao.findOneRow(checkDownloadSri, Boolean.FALSE);
			
			if (checkDownloadSri == null) {
				checkDownloadSri = new CheckDownloadSri();
				checkDownloadSri.setPaginado(Constantes.I0);
				checkDownloadSri.setTotalPaginas(Constantes.I0);
				checkDownloadSri.setTotalFilas(Constantes.I0);
				checkDownloadSri.setFila(Constantes.I0);
				checkDownloadSri.setEtapa(Constantes.PRE_PROCESADO);
				checkDownloadSri.setRuc(pEmpresa.getRuc());
				checkDownloadSri.setFechaProceso(new Date());
				checkDownloadSri.setFechaDownload(pFechaCheckDownloadSri);
				crudDao.create(checkDownloadSri);
				
			} else {
				checkDownloadSri.setEtapa(Constantes.PRE_PROCESADO);
				crudDao.update(checkDownloadSri);
			}

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void downloadCheckDownloadSri(String pMessageXml) {
		CheckDownloadSri checkDownloadSriMsj = null;
		
		try {
			checkDownloadSriMsj = XmlUtil.xmlToCheckDownloadSri(pMessageXml);
			Empresa empresa = empresaGestor.obtenerEmpresaActiva(checkDownloadSriMsj.getRuc());
			CheckDownloadSri checkDownloadSri = seleniumGestor.obtenerTotalComprobantesSri(empresa.getRuc(), empresa.getClaveSri(), DateUtil.obtenerDateFindSri(checkDownloadSriMsj.getFechaDownload()));
			
			checkDownloadSriMsj.setEtapa(checkDownloadSri.getEtapa());
			checkDownloadSriMsj.setFechaProceso(new Date());
			checkDownloadSriMsj.setFila(checkDownloadSri.getFila());
			checkDownloadSriMsj.setTotalFilas(checkDownloadSri.getTotalFilas());
			checkDownloadSriMsj.setPaginado(checkDownloadSri.getPaginado());
			checkDownloadSriMsj.setTotalPaginas(checkDownloadSri.getTotalPaginas());
			crudDao.update(checkDownloadSriMsj);
			
		} catch (Exception e) {
			try {
				String mensajeUsuario = "Error al procesar el mensaje de la cola para check download del Sri";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
				registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
				
				// Actualizar el registro a error
				checkDownloadSriMsj.setEtapa(Constantes.ERROR_QUEUE);
				checkDownloadSriMsj.setIdCheckDownloadSriCrud(checkDownloadSriMsj.getIdCheckDownloadSri());
				crudDao.updateFields(checkDownloadSriMsj);
				
				// Enviar el email al administrador
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(Constantes.ID_USUARIO_DEFAULT);
				List<Usuario> usuarios = crudDao.findForCriteria(usuario, Boolean.FALSE);
				usuario = usuarios.get(Constantes.I0);
				
				String destinatario = usuario.getEmail();
				String asunto = ConstantesEmail.MSJ_ERROR_PROCESAR_SRI_WEB_ASUNTO;
				String msj = EmailUtil.msgErrorProcesarSri(usuario.getNombres(), ConstantesEmail.ACCION_ERROR_PROCESAR_SRI_WEB_EMAIL, Utilitario.formatLengthMaxFiel(e.getMessage(), Constantes.I100));
				Email email = fwGestor.getEmail(destinatario, asunto, msj);
				fwGestor.sendEmailQueue(email);
				
			} catch (Exception ex) {
				String mensajeUsuario = "Error al enviar el email al administrador [queue-web]";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
				registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
			}
		}
	}
	
	@Override
	public void registerErrorSistema(Exception pException, String pModulo, String pNivel, String pMensajeUsuario) {
		try {
			ErrorSistema errorSistema = new ErrorSistema();
			errorSistema.setLocalizacion(Utilitario.formatLengthMaxFiel(pException.getLocalizedMessage(), Constantes.I350));
			errorSistema.setMensaje(Utilitario.formatLengthMaxFiel(pException.getMessage(), Constantes.I100));
			errorSistema.setPrintTraceTrace(Utilitario.formatLengthMaxFiel(Utilitario.stackTraceToString(pException), Constantes.I10000));
			errorSistema.setFechaRegistro(new Timestamp(new Date().getTime()));
			errorSistema.setModulo(pModulo);
			errorSistema.setNivel(pNivel);
			errorSistema.setMensajeUsuario(Utilitario.formatLengthMaxFiel(pMensajeUsuario, Constantes.I1000));

			crudDao.create(errorSistema);

		} catch (Exception e) {
			log.error("Error al crear los datos del error del sistema. Causa --> " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<ErrorSistema> getErroresSistemaPrint(ErrorSistema pErrorSistema) throws UtplException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("Select es.idErrorSistema As idErrorSistema, es.modulo As modulo, es.nivel As nivel, es.mensaje As mensaje, es.localizacion As localizacion, es.fechaRegistro As fechaRegistro, es.mensajeUsuario As mensajeUsuario ");
			sql.append("From ErrorSistema es ");
			sql.append("Where 1 = 1 ");
			
			if (pErrorSistema != null) {
				
				if (null != pErrorSistema.getNivel() && !pErrorSistema.getNivel().isEmpty()) {
					sql.append("And ").append("upper").append("(es.nivel) = upper('").append(pErrorSistema.getNivel().trim()).append("') ");
				}
				
				if (null != pErrorSistema.getModulo() && !pErrorSistema.getModulo().isEmpty()) {
					sql.append("And ").append("upper").append("(es.modulo) = upper('").append(pErrorSistema.getModulo().trim()).append("') ");
				}
				
				if (null != pErrorSistema.getFechaRegistro()) {
					sql.append("And ").append("to_char(es.fechaRegistro, 'YYYY-MM-dd') = '").append(DateUtil.parseToDateString(pErrorSistema.getFechaRegistro(), Constantes.YYYY_MM_DD)).append("') ");
				}
				
				sql.append("Order By es.fechaRegistro Desc ");
			}
			
			List<ErrorSistema> erroresSistema = crudDao.findListRow(ErrorSistema.class, sql.toString());
			
			return erroresSistema;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@Override
	public ErrorSistema getErrorSistemaPrint(Long pIdErrorSistema) throws UtplException {
		try {
			ErrorSistema errorSistema = new ErrorSistema();
			errorSistema.setIdErrorSistema(pIdErrorSistema);
			List<ErrorSistema> erroresSistema = crudDao.findForCriteria(errorSistema, Boolean.FALSE);
			
			if (null != erroresSistema && !erroresSistema.isEmpty()) {
				for (ErrorSistema errorSistemaTmp : erroresSistema) {
					if (pIdErrorSistema.equals(errorSistemaTmp.getIdErrorSistema())) {
						errorSistema = errorSistemaTmp;
						break;
					}
				}
			}
			
			return errorSistema;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
