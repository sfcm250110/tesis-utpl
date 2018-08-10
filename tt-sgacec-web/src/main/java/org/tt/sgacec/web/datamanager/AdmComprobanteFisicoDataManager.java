package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.entity.ComprobanteFisico;

@ManagedBean
@SessionScoped
public class AdmComprobanteFisicoDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = 4831396690014184975L;

	private Boolean mostrarComprobantesFisico;
	private Boolean mostrarNuevoComprobanteFisico;
	private Boolean mostrarModificarComprobanteFisico;
	private Boolean mostrarEliminarComprobanteFisico;
	private byte[] fileExcel;
	private String cargaByFile;
	private ComprobanteFisico crearComprobanteFisico;
	private ComprobanteFisico modificarComprobanteFisico;
	private ComprobanteFisico eliminarComprobanteFisico;
	private List<ComprobanteFisico> comprobantesFisico;

	public Boolean getMostrarComprobantesFisico() {
		return mostrarComprobantesFisico;
	}

	public void setMostrarComprobantesFisico(Boolean mostrarComprobantesFisico) {
		this.mostrarComprobantesFisico = mostrarComprobantesFisico;
	}

	public Boolean getMostrarNuevoComprobanteFisico() {
		return mostrarNuevoComprobanteFisico;
	}

	public void setMostrarNuevoComprobanteFisico(Boolean mostrarNuevoComprobanteFisico) {
		this.mostrarNuevoComprobanteFisico = mostrarNuevoComprobanteFisico;
	}

	public Boolean getMostrarModificarComprobanteFisico() {
		return mostrarModificarComprobanteFisico;
	}

	public void setMostrarModificarComprobanteFisico(Boolean mostrarModificarComprobanteFisico) {
		this.mostrarModificarComprobanteFisico = mostrarModificarComprobanteFisico;
	}

	public ComprobanteFisico getCrearComprobanteFisico() {
		return crearComprobanteFisico;
	}

	public void setCrearComprobanteFisico(ComprobanteFisico crearComprobanteFisico) {
		this.crearComprobanteFisico = crearComprobanteFisico;
	}

	public ComprobanteFisico getModificarComprobanteFisico() {
		return modificarComprobanteFisico;
	}

	public void setModificarComprobanteFisico(ComprobanteFisico modificarComprobanteFisico) {
		this.modificarComprobanteFisico = modificarComprobanteFisico;
	}

	public List<ComprobanteFisico> getComprobantesFisico() {
		return comprobantesFisico;
	}

	public void setComprobantesFisico(List<ComprobanteFisico> comprobantesFisico) {
		this.comprobantesFisico = comprobantesFisico;
	}

	public String getCargaByFile() {
		return cargaByFile;
	}

	public void setCargaByFile(String cargaByFile) {
		this.cargaByFile = cargaByFile;
	}

	public byte[] getFileExcel() {
		return fileExcel;
	}

	public void setFileExcel(byte[] fileExcel) {
		this.fileExcel = fileExcel;
	}

	public Boolean getMostrarEliminarComprobanteFisico() {
		return mostrarEliminarComprobanteFisico;
	}

	public void setMostrarEliminarComprobanteFisico(Boolean mostrarEliminarComprobanteFisico) {
		this.mostrarEliminarComprobanteFisico = mostrarEliminarComprobanteFisico;
	}

	public ComprobanteFisico getEliminarComprobanteFisico() {
		return eliminarComprobanteFisico;
	}

	public void setEliminarComprobanteFisico(ComprobanteFisico eliminarComprobanteFisico) {
		this.eliminarComprobanteFisico = eliminarComprobanteFisico;
	}

}