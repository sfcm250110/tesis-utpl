package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.entity.ValorMaximoRubroSri;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.Periodo;

@ManagedBean(name = Constantes.ADM_VALOR_MAXIMO_RUBRO_SRI_DATAMANAGER)
@SessionScoped
public class AdmValorMaximoRubroSriDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = 4831396690014184975L;

	private String periodo;
	private List<Periodo> periodos;
	private Boolean mostrarValoresMaximosRubroSri;
	private Boolean mostrarCrearValorMaximoRubroSri;
	private Boolean mostrarNuevoValorMaximoRubroSri;
	private Boolean mostrarModificarValorMaximoRubroSri;
	private ValorMaximoRubroSri crearValorMaximoRubroSri;
	private ValorMaximoRubroSri modificarValorMaximoRubroSri;
	private List<ValorMaximoRubroSri> valoresMaximosRubroSri;

	public Boolean getMostrarValoresMaximosRubroSri() {
		return mostrarValoresMaximosRubroSri;
	}

	public void setMostrarValoresMaximosRubroSri(Boolean mostrarValoresMaximosRubroSri) {
		this.mostrarValoresMaximosRubroSri = mostrarValoresMaximosRubroSri;
	}

	public Boolean getMostrarCrearValorMaximoRubroSri() {
		return mostrarCrearValorMaximoRubroSri;
	}

	public void setMostrarCrearValorMaximoRubroSri(Boolean mostrarCrearValorMaximoRubroSri) {
		this.mostrarCrearValorMaximoRubroSri = mostrarCrearValorMaximoRubroSri;
	}

	public Boolean getMostrarNuevoValorMaximoRubroSri() {
		return mostrarNuevoValorMaximoRubroSri;
	}

	public void setMostrarNuevoValorMaximoRubroSri(Boolean mostrarNuevoValorMaximoRubroSri) {
		this.mostrarNuevoValorMaximoRubroSri = mostrarNuevoValorMaximoRubroSri;
	}

	public Boolean getMostrarModificarValorMaximoRubroSri() {
		return mostrarModificarValorMaximoRubroSri;
	}

	public void setMostrarModificarValorMaximoRubroSri(Boolean mostrarModificarValorMaximoRubroSri) {
		this.mostrarModificarValorMaximoRubroSri = mostrarModificarValorMaximoRubroSri;
	}

	public ValorMaximoRubroSri getCrearValorMaximoRubroSri() {
		return crearValorMaximoRubroSri;
	}

	public void setCrearValorMaximoRubroSri(ValorMaximoRubroSri crearValorMaximoRubroSri) {
		this.crearValorMaximoRubroSri = crearValorMaximoRubroSri;
	}

	public ValorMaximoRubroSri getModificarValorMaximoRubroSri() {
		return modificarValorMaximoRubroSri;
	}

	public void setModificarValorMaximoRubroSri(ValorMaximoRubroSri modificarValorMaximoRubroSri) {
		this.modificarValorMaximoRubroSri = modificarValorMaximoRubroSri;
	}

	public List<ValorMaximoRubroSri> getValoresMaximosRubroSri() {
		return valoresMaximosRubroSri;
	}

	public void setValoresMaximosRubroSri(List<ValorMaximoRubroSri> valoresMaximosRubroSri) {
		this.valoresMaximosRubroSri = valoresMaximosRubroSri;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

}
