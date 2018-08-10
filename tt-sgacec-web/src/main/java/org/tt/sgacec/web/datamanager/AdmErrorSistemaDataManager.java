package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import ec.edu.utpl.sc.core.entity.ErrorSistema;

@ManagedBean
@SessionScoped
public class AdmErrorSistemaDataManager extends CommonDataManager implements Serializable {
	
	private static final long serialVersionUID = 8796451095546196357L;
	
	private String printTraceTrace;
	private ErrorSistema errorSistema;
	private List<ErrorSistema> erroresSistema;
	private List<SelectItem> modulosSelectItem;
	private List<SelectItem> nivelesSelectItem;

	public String getPrintTraceTrace() {
		return printTraceTrace;
	}

	public void setPrintTraceTrace(String printTraceTrace) {
		this.printTraceTrace = printTraceTrace;
	}

	public ErrorSistema getErrorSistema() {
		return errorSistema;
	}

	public void setErrorSistema(ErrorSistema errorSistema) {
		this.errorSistema = errorSistema;
	}

	public List<ErrorSistema> getErroresSistema() {
		return erroresSistema;
	}

	public void setErroresSistema(List<ErrorSistema> erroresSistema) {
		this.erroresSistema = erroresSistema;
	}

	public List<SelectItem> getModulosSelectItem() {
		return modulosSelectItem;
	}

	public void setModulosSelectItem(List<SelectItem> modulosSelectItem) {
		this.modulosSelectItem = modulosSelectItem;
	}

	public List<SelectItem> getNivelesSelectItem() {
		return nivelesSelectItem;
	}

	public void setNivelesSelectItem(List<SelectItem> nivelesSelectItem) {
		this.nivelesSelectItem = nivelesSelectItem;
	}

}
