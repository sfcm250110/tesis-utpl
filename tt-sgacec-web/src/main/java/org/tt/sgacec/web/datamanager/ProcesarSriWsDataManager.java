package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;

@ManagedBean
@SessionScoped
public class ProcesarSriWsDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = -2626293075817735556L;

	private Boolean mostrarProcesar;
	private Boolean mostrarProcesarTodo;
	private ComprobanteEmpresa comprobanteEmpresa;
	private List<ComprobanteEmpresa> comprobantesEmpresa;

	public Boolean getMostrarProcesar() {
		return mostrarProcesar;
	}

	public void setMostrarProcesar(Boolean mostrarProcesar) {
		this.mostrarProcesar = mostrarProcesar;
	}

	public Boolean getMostrarProcesarTodo() {
		return mostrarProcesarTodo;
	}

	public void setMostrarProcesarTodo(Boolean mostrarProcesarTodo) {
		this.mostrarProcesarTodo = mostrarProcesarTodo;
	}

	public ComprobanteEmpresa getComprobanteEmpresa() {
		return comprobanteEmpresa;
	}

	public void setComprobanteEmpresa(ComprobanteEmpresa comprobanteEmpresa) {
		this.comprobanteEmpresa = comprobanteEmpresa;
	}

	public List<ComprobanteEmpresa> getComprobantesEmpresa() {
		return comprobantesEmpresa;
	}

	public void setComprobantesEmpresa(List<ComprobanteEmpresa> comprobantesEmpresa) {
		this.comprobantesEmpresa = comprobantesEmpresa;
	}

}
