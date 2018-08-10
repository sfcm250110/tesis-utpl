package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;

@ManagedBean
@SessionScoped
public class ProcesarSriWebDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = -2626293075817735556L;

	private Boolean mostrarProcesar;
	private Boolean mostrarProcesarTodo;
	private CheckDownloadSri checkDownloadSri;
	private List<CheckDownloadSri> checksDownloadSri;

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

	public CheckDownloadSri getCheckDownloadSri() {
		return checkDownloadSri;
	}

	public void setCheckDownloadSri(CheckDownloadSri checkDownloadSri) {
		this.checkDownloadSri = checkDownloadSri;
	}

	public List<CheckDownloadSri> getChecksDownloadSri() {
		return checksDownloadSri;
	}

	public void setChecksDownloadSri(List<CheckDownloadSri> checksDownloadSri) {
		this.checksDownloadSri = checksDownloadSri;
	}

}
