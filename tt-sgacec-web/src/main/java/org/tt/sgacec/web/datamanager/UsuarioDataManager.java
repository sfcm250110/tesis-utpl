package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.Rol;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.util.Constantes;

@ManagedBean(name = Constantes.USUARIO_DATAMANAGER)
@SessionScoped
public class UsuarioDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = 4831396690014184975L;

	private Boolean mostrarUsuarios;
	private Boolean mostrarCrearUsuario;
	private Boolean mostrarNuevoUsuario;
	private Boolean mostrarModificarUsuario;
	private Usuario crearUsuario;
	private Usuario modificarUsuario;
	private List<Usuario> usuarios;
	private Rol rol;
	private List<Rol> roles;
	private List<SelectItem> rolesSelectItem;
	private List<SelectItem> preguntasSeguridadSelectItem;
	private List<Empresa> empresas;
    private List<Empresa> empresasSelect;

	public Boolean getMostrarUsuarios() {
		return mostrarUsuarios;
	}

	public void setMostrarUsuarios(Boolean mostrarUsuarios) {
		this.mostrarUsuarios = mostrarUsuarios;
	}

	public Boolean getMostrarCrearUsuario() {
		return mostrarCrearUsuario;
	}

	public void setMostrarCrearUsuario(Boolean mostrarCrearUsuario) {
		this.mostrarCrearUsuario = mostrarCrearUsuario;
	}

	public Boolean getMostrarNuevoUsuario() {
		return mostrarNuevoUsuario;
	}

	public void setMostrarNuevoUsuario(Boolean mostrarNuevoUsuario) {
		this.mostrarNuevoUsuario = mostrarNuevoUsuario;
	}

	public Boolean getMostrarModificarUsuario() {
		return mostrarModificarUsuario;
	}

	public void setMostrarModificarUsuario(Boolean mostrarModificarUsuario) {
		this.mostrarModificarUsuario = mostrarModificarUsuario;
	}

	public Usuario getCrearUsuario() {
		return crearUsuario;
	}

	public void setCrearUsuario(Usuario crearUsuario) {
		this.crearUsuario = crearUsuario;
	}

	public Usuario getModificarUsuario() {
		return modificarUsuario;
	}

	public void setModificarUsuario(Usuario modificarUsuario) {
		this.modificarUsuario = modificarUsuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<SelectItem> getRolesSelectItem() {
		return rolesSelectItem;
	}

	public void setRolesSelectItem(List<SelectItem> rolesSelectItem) {
		this.rolesSelectItem = rolesSelectItem;
	}

	public List<SelectItem> getPreguntasSeguridadSelectItem() {
		return preguntasSeguridadSelectItem;
	}

	public void setPreguntasSeguridadSelectItem(List<SelectItem> preguntasSeguridadSelectItem) {
		this.preguntasSeguridadSelectItem = preguntasSeguridadSelectItem;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Empresa> getEmpresasSelect() {
		return empresasSelect;
	}

	public void setEmpresasSelect(List<Empresa> empresasSelect) {
		this.empresasSelect = empresasSelect;
	}

}
