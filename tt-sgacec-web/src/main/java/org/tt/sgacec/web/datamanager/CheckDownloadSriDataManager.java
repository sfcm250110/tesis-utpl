package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;

@ManagedBean
@SessionScoped
public class CheckDownloadSriDataManager extends CommonDataManager implements Serializable {
	
	private static final long serialVersionUID = 2236591941883266425L;
	
	private Date fechaCheckDownloadSri;
	private CheckDownloadSri checkDownloadSri;
	private List<CheckDownloadSri> checksDownloadSri;

	public Date getFechaCheckDownloadSri() {
		return fechaCheckDownloadSri;
	}

	public void setFechaCheckDownloadSri(Date fechaCheckDownloadSri) {
		this.fechaCheckDownloadSri = fechaCheckDownloadSri;
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
