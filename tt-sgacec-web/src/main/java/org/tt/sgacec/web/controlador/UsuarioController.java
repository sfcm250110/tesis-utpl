package org.tt.sgacec.web.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.UsuarioDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.PreguntaSeguridad;
import ec.edu.utpl.sc.core.entity.Rol;
import ec.edu.utpl.sc.core.entity.RolUsuario;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.util.UtplException;

@ManagedBean(name = Constantes.USUARIO_CONTROLLER)
@ViewScoped
public class UsuarioController extends CommonController implements Serializable {
	
	private static final long serialVersionUID = -7112958012726762016L;
	
	private static Logger log = Logger.getLogger(UsuarioController.class);

	@ManagedProperty(value = Constantes.USUARIO_DATAMANAGER_EL)
	private UsuarioDataManager usuarioDataManager;
	
	@Override
	public void init() {
		try {
			usuarioDataManager.setRoles(new ArrayList<Rol>());
			usuarioDataManager.setRol(new Rol());
			consultar();
			
			usuarioDataManager.setMostrarUsuarios(Boolean.TRUE);
			usuarioDataManager.setMostrarNuevoUsuario(Boolean.TRUE);
			usuarioDataManager.setMostrarCrearUsuario(Boolean.FALSE);
			usuarioDataManager.setMostrarModificarUsuario(Boolean.FALSE);
			
			establecerPreguntasSeguridad();
			establecerRoles();
			
		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() throws UtplException {
		usuarioDataManager.setUsuarios(FwUtplFactory.getIntance().getCrudService().findForCriteria(new Usuario(), Boolean.FALSE));
		usuarioDataManager.setEmpresas(FwUtplFactory.getIntance().getEmpresaService().obtenerEmpresas());
	}
	
	public void nuevoUsuario() {
		Usuario usuario = new Usuario();
		usuario.setPreguntaSeguridad(new PreguntaSeguridad());
		usuario.setEstado(Boolean.TRUE);
		
		usuarioDataManager.setCrearUsuario(usuario);
		usuarioDataManager.setRol(new Rol());
		usuarioDataManager.setRoles(new ArrayList<Rol>());
		usuarioDataManager.setEmpresasSelect(new ArrayList<Empresa>());
		usuarioDataManager.setMostrarUsuarios(Boolean.FALSE);
		usuarioDataManager.setMostrarCrearUsuario(Boolean.TRUE);
		usuarioDataManager.setMostrarModificarUsuario(Boolean.FALSE);
		usuarioDataManager.setMostrarNuevoUsuario(Boolean.FALSE);
	}
	
	public void crearUsuario() {
		try {
			establecerPreguntaSeguridadCrearUsuario();
			establecerRolUsuario();
			FwUtplFactory.getIntance().getAdmService().crearUsuario(usuarioDataManager.getCrearUsuario(), usuarioDataManager.getRoles(), usuarioDataManager.getEmpresasSelect());

			usuarioDataManager.setUsuarios(FwUtplFactory.getIntance().getCrudService().findForCriteria(new Usuario(), Boolean.FALSE));
			usuarioDataManager.setRoles(new ArrayList<Rol>());
			usuarioDataManager.setCrearUsuario(null);
			usuarioDataManager.setMostrarUsuarios(Boolean.TRUE);
			usuarioDataManager.setMostrarCrearUsuario(Boolean.FALSE);
			usuarioDataManager.setMostrarNuevoUsuario(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Usuario registrado exitosamente");

		} catch (Exception e) {
			usuarioDataManager.setRoles(new ArrayList<Rol>());
			
			log.error("[crearUsuario()] Error al crear el usuario. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al crear el usuario. " + e.getMessage());
		}
	}
	
	public void inicioModificarUsuario(Usuario pUsuario) {
		try {
			usuarioDataManager.setModificarUsuario(pUsuario);
			
			RolUsuario rolUsuario = new RolUsuario();
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(pUsuario.getIdUsuario());
			rolUsuario.setUsuario(usuario);
			List<RolUsuario> rolesUsuario = FwUtplFactory.getIntance().getCrudService().findForCriteria(rolUsuario, Boolean.FALSE);
			List<Empresa> empresasUsuario = FwUtplFactory.getIntance().getConsultasService().obtenerEmpresasUsuario(pUsuario.getIdUsuario());
			
			usuarioDataManager.setRol(rolesUsuario.get(Constantes.I0).getRol());
			usuarioDataManager.setEmpresasSelect(empresasUsuario);
			usuarioDataManager.setMostrarUsuarios(Boolean.FALSE);
			usuarioDataManager.setMostrarModificarUsuario(Boolean.TRUE);
			usuarioDataManager.setMostrarCrearUsuario(Boolean.FALSE);
			usuarioDataManager.setMostrarNuevoUsuario(Boolean.FALSE);
		
		} catch (UtplException e) {
			log.error("[inicioModificarUsuario()] Error al inicio modificar el usuario. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicio modificar el usuario. " + e.getMessage());
		}
	}
	
	public void modificarUsuario() {
		try {
			if (validarLongitudCedulaRuc()) {
				establecerPreguntaSeguridadModificarUsuario();
				establecerRolUsuario();
				FwUtplFactory.getIntance().getAdmService().modificarUsuario(usuarioDataManager.getModificarUsuario(), usuarioDataManager.getRoles(), usuarioDataManager.getEmpresasSelect());
				
				usuarioDataManager.setUsuarios(FwUtplFactory.getIntance().getCrudService().findForCriteria(new Usuario(), Boolean.FALSE));
				usuarioDataManager.setModificarUsuario(null);
				usuarioDataManager.setMostrarUsuarios(Boolean.TRUE);
				usuarioDataManager.setMostrarModificarUsuario(Boolean.FALSE);
				usuarioDataManager.setMostrarNuevoUsuario(Boolean.TRUE);
				
				JsfUtil.addMessage(Constantes.MSJ_INFO, "Usuario modificado exitosamente");
			}

		} catch (UtplException e) {
			log.error("[modificarPreguntaSeguridad()] Error al modificar el usuario. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al modificar el usuario. " + e.getMessage());
		}
	}

	public String obtenerNombreRol(String pUserName) {
		String nombreRol = Constantes.SPACE_BLANK;
		
		try {
			RolUsuario rolUsuario = FwUtplFactory.getIntance().getConsultasService().obtenerRolUsuario(pUserName);
			
			if (rolUsuario != null) {
				nombreRol = rolUsuario.getRol().getDescripcionRol();
			}
			
		} catch (Exception e) {
			log.error("[obtenerNombreRol()] Error al consultar el rol del usuario. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al consulta el rol del usuario. Causa --> " + e);
		}
		
		return nombreRol;
	}
	
	public void cancelarIn() {
		init();
	}
	
	// Operaciones privadas
	private void establecerPreguntasSeguridad() throws UtplException {
		List<PreguntaSeguridad> preguntasSeguridad = FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE);
		List<SelectItem> preguntasSeguridadSelectItem = new ArrayList<SelectItem>();
		
		for (PreguntaSeguridad preguntaSeguridad : preguntasSeguridad) {
			preguntasSeguridadSelectItem.add(new SelectItem(preguntaSeguridad.getIdPreguntaSeguridad(), preguntaSeguridad.getPreguntaSeguridad()));
		}

		usuarioDataManager.setPreguntasSeguridadSelectItem(preguntasSeguridadSelectItem);
	}

	private void establecerRoles() throws UtplException {
		if (usuarioDataManager.getRolesSelectItem() == null) {
			List<Rol> roles = FwUtplFactory.getIntance().getCrudService().findForCriteria(new Rol(), Boolean.FALSE);;
			List<SelectItem> rolesSelectItem = new ArrayList<SelectItem>();
			
			for (Rol rol : roles) {
				rolesSelectItem.add(new SelectItem(rol.getIdRol(), rol.getDescripcionRol()));
			}

			usuarioDataManager.setRolesSelectItem(rolesSelectItem);
		}
	}
	
	private void establecerPreguntaSeguridadCrearUsuario() throws UtplException {
		List<PreguntaSeguridad> preguntasSeguridad = FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE);;
		
		for (PreguntaSeguridad preguntaSeguridad : preguntasSeguridad) {
			if (usuarioDataManager.getCrearUsuario().getPreguntaSeguridad().getIdPreguntaSeguridad().equals(preguntaSeguridad.getIdPreguntaSeguridad())) {
				usuarioDataManager.getCrearUsuario().setPreguntaSeguridad(preguntaSeguridad);
				break;
			}
		}
	}
	
	private void establecerPreguntaSeguridadModificarUsuario() throws UtplException {
		List<PreguntaSeguridad> preguntasSeguridad = FwUtplFactory.getIntance().getCrudService().findForCriteria(new PreguntaSeguridad(), Boolean.FALSE);;
		
		for (PreguntaSeguridad preguntaSeguridad : preguntasSeguridad) {
			if (usuarioDataManager.getModificarUsuario().getPreguntaSeguridad().getIdPreguntaSeguridad().equals(preguntaSeguridad.getIdPreguntaSeguridad())) {
				usuarioDataManager.getModificarUsuario().setPreguntaSeguridad(preguntaSeguridad);
				break;
			}
		}
	}
	
	private void establecerRolUsuario() throws UtplException {
		List<Rol> roles = FwUtplFactory.getIntance().getCrudService().findForCriteria(new Rol(), Boolean.FALSE);;
		
		for (Rol rol : roles) {
			if (usuarioDataManager.getRol().getIdRol().equals(rol.getIdRol())) {
				usuarioDataManager.setRol(rol);
				break;
			}
		}
		
		usuarioDataManager.getRoles().add(usuarioDataManager.getRol());
	}
	
	private Boolean validarLongitudCedulaRuc() {
		Boolean valido = Boolean.FALSE;
		
		if (Constantes.I10 == usuarioDataManager.getModificarUsuario().getCedulaRuc().length() || Constantes.I13 == usuarioDataManager.getModificarUsuario().getCedulaRuc().length()) {
			valido = Boolean.TRUE;
			
		} else {
			JsfUtil.addMessage(Constantes.MSJ_WARN, "Longitud de la C\u00e9dula no v\u00e1lida");
		}
		
		return valido;
	}
	
	// Getters/Setters
	public UsuarioDataManager getUsuarioDataManager() {
		return usuarioDataManager;
	}

	public void setUsuarioDataManager(UsuarioDataManager usuarioDataManager) {
		this.usuarioDataManager = usuarioDataManager;
	}
}
