package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.util.Constantes;

@ManagedBean(name = Constantes.ADM_EMPRESA_DATAMANAGER)
@SessionScoped
public class AdmEmpresaDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = 4831396690014184975L;

	private Boolean mostrarEmpresas;
	private Boolean mostrarCrearEmpresa;
	private Boolean mostrarNuevaEmpresa;
	private Boolean mostrarModificarEmpresa;
	private Empresa crearEmpresa;
	private Empresa modificarEmpresa;
	private List<Empresa> empresas;

	public Boolean getMostrarEmpresas() {
		return mostrarEmpresas;
	}

	public void setMostrarEmpresas(Boolean mostrarEmpresas) {
		this.mostrarEmpresas = mostrarEmpresas;
	}

	public Boolean getMostrarCrearEmpresa() {
		return mostrarCrearEmpresa;
	}

	public void setMostrarCrearEmpresa(Boolean mostrarCrearEmpresa) {
		this.mostrarCrearEmpresa = mostrarCrearEmpresa;
	}

	public Boolean getMostrarNuevaEmpresa() {
		return mostrarNuevaEmpresa;
	}

	public void setMostrarNuevaEmpresa(Boolean mostrarNuevaEmpresa) {
		this.mostrarNuevaEmpresa = mostrarNuevaEmpresa;
	}

	public Boolean getMostrarModificarEmpresa() {
		return mostrarModificarEmpresa;
	}

	public void setMostrarModificarEmpresa(Boolean mostrarModificarEmpresa) {
		this.mostrarModificarEmpresa = mostrarModificarEmpresa;
	}

	public Empresa getCrearEmpresa() {
		return crearEmpresa;
	}

	public void setCrearEmpresa(Empresa crearEmpresa) {
		this.crearEmpresa = crearEmpresa;
	}

	public Empresa getModificarEmpresa() {
		return modificarEmpresa;
	}

	public void setModificarEmpresa(Empresa modificarEmpresa) {
		this.modificarEmpresa = modificarEmpresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
