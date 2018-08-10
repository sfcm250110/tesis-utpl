package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.MenuModel;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.Rol;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.vo.AnioVo;
import ec.edu.utpl.sc.core.vo.MesVo;

@ManagedBean
@SessionScoped
public class InicioDataManager extends CommonDataManager implements Serializable {
	
	private static final long serialVersionUID = -7969788938106448835L;
	
	private MenuModel menuModel;
	private Usuario usuario;
	private Empresa empresa;
	private Rol rol;
	private List<AnioVo> aniosVo;
	private List<MesVo> mesesVo;
	private Boolean mostrarCambiarClave;
	private Boolean mostrarInicio;

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AnioVo> getAniosVo() {
		return aniosVo;
	}

	public void setAniosVo(List<AnioVo> aniosVo) {
		this.aniosVo = aniosVo;
	}

	public List<MesVo> getMesesVo() {
		return mesesVo;
	}

	public void setMesesVo(List<MesVo> mesesVo) {
		this.mesesVo = mesesVo;
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public Boolean getMostrarCambiarClave() {
		return mostrarCambiarClave;
	}

	public void setMostrarCambiarClave(Boolean mostrarCambiarClave) {
		this.mostrarCambiarClave = mostrarCambiarClave;
	}

	public Boolean getMostrarInicio() {
		return mostrarInicio;
	}

	public void setMostrarInicio(Boolean mostrarInicio) {
		this.mostrarInicio = mostrarInicio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
