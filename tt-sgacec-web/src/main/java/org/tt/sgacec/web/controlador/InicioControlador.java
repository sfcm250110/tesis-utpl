package org.tt.sgacec.web.controlador;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.InicioDataManager;
import org.tt.sgacec.web.util.JsfUtil;
import org.tt.sgacec.web.util.Utilitarios;

import ec.edu.utpl.sc.core.entity.RolUsuario;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.util.UtplException;

/**
 * 
 * Controlador que maneja las opciones del menu del sistema
 * 
 * @author Santiago Cabrera M.
 * 
 */
@ManagedBean
@ViewScoped
public class InicioControlador extends CommonController {

	// Constantes Generales
	private static final long serialVersionUID = -8555785477669368624L;
	
	private static Logger log = Logger.getLogger(InicioControlador.class);

	@ManagedProperty(value = Constantes.INICIO_DATAMANAGER_EL)
	private InicioDataManager inicioDataManager;
	
	@ManagedProperty(value = Constantes.I18N_EL)
	private ResourceBundle i18n;

	@Override
	public void init() {
		try {
			if (inicioDataManager.getUsuario() == null) {
				Usuario usuario = new Usuario();
				usuario.setUserName(JsfUtil.getUsername().toLowerCase());
				inicioDataManager.setUsuario(FwUtplFactory.getIntance().getCrudService().findOneRow(usuario, Boolean.FALSE));
			}
			
			establecerRol();
			inicioDataManager.setMenuModel(Utilitarios.getIntance().inicializarMenu(inicioDataManager.getRol(), i18n));
			getEmpresaUsuario();

		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}
	
	// Operaciones publicas
	public void getEmpresaUsuario() throws UtplException {
		inicioDataManager.setEmpresa(FwUtplFactory.getIntance().getEmpresaService().getEmpresaUsuario(inicioDataManager.getUsuario()));
	}

	// Operaciones privadas
	private void establecerRol() throws UtplException {
		RolUsuario rolUsuario = new RolUsuario();
		rolUsuario.setUsuario(inicioDataManager.getUsuario());
		List<RolUsuario> rolesUsuario = FwUtplFactory.getIntance().getCrudService().findForCriteria(rolUsuario, Boolean.FALSE);
		inicioDataManager.setRol(rolesUsuario.get(Constantes.I0).getRol());
	}

	// Getters/Setters
	public InicioDataManager getInicioDataManager() {
		return inicioDataManager;
	}

	public void setInicioDataManager(InicioDataManager inicioDataManager) {
		this.inicioDataManager = inicioDataManager;
	}

	public ResourceBundle getI18n() {
		return i18n;
	}

	public void setI18n(ResourceBundle i18n) {
		this.i18n = i18n;
	}

}
