package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.entity.ParametroGeneral;

@ManagedBean
@SessionScoped
public class AdministrarParametrosSistemaDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private ParametroGeneral parametroGeneral;
	private List<ParametroGeneral> parametrosGenerales;
	private Boolean modoEditar;

	public ParametroGeneral getParametroGeneral() {
		return parametroGeneral;
	}

	public void setParametroGeneral(ParametroGeneral parametroGeneral) {
		this.parametroGeneral = parametroGeneral;
	}

	public List<ParametroGeneral> getParametrosGenerales() {
		return parametrosGenerales;
	}

	public void setParametrosGenerales(List<ParametroGeneral> parametrosGenerales) {
		this.parametrosGenerales = parametrosGenerales;
	}

	public Boolean getModoEditar() {
		return modoEditar;
	}

	public void setModoEditar(Boolean modoEditar) {
		this.modoEditar = modoEditar;
	}

}
