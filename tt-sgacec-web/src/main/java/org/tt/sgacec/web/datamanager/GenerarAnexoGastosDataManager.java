package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

import ec.edu.utpl.sc.core.entity.ValorMaximoRubroSri;
import ec.edu.utpl.sc.core.util.AnexoGasto;
import ec.edu.utpl.sc.core.util.Periodo;

@ManagedBean
@SessionScoped
public class GenerarAnexoGastosDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = -2626293075817735556L;

	private AnexoGasto anexoGasto;
	private Boolean mostrarAnexoExel;
	private List<Periodo> periodos;
	private byte[] consolidarAnexoGastoExcel;
	private PieChartModel viviendaPieChartModel;
	private PieChartModel saludPieChartModel;
	private PieChartModel educacionPieChartModel;
	private PieChartModel alimentacionPieChartModel;
	private PieChartModel vestimentaPieChartModel;
	private PieChartModel anexoGastosPieChartModel;
	private PieChartModel consolidadoPieChartModel;
	private PieChartModel totalBaseImponiblePieChartModel;
	private Map<String, ValorMaximoRubroSri> valoresMaximosRubroSri;

	public AnexoGasto getAnexoGasto() {
		return anexoGasto;
	}

	public void setAnexoGasto(AnexoGasto anexoGasto) {
		this.anexoGasto = anexoGasto;
	}

	public Boolean getMostrarAnexoExel() {
		return mostrarAnexoExel;
	}

	public void setMostrarAnexoExel(Boolean mostrarAnexoExel) {
		this.mostrarAnexoExel = mostrarAnexoExel;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public byte[] getConsolidarAnexoGastoExcel() {
		return consolidarAnexoGastoExcel;
	}

	public void setConsolidarAnexoGastoExcel(byte[] consolidarAnexoGastoExcel) {
		this.consolidarAnexoGastoExcel = consolidarAnexoGastoExcel;
	}

	public PieChartModel getViviendaPieChartModel() {
		return viviendaPieChartModel;
	}

	public void setViviendaPieChartModel(PieChartModel viviendaPieChartModel) {
		this.viviendaPieChartModel = viviendaPieChartModel;
	}

	public PieChartModel getSaludPieChartModel() {
		return saludPieChartModel;
	}

	public void setSaludPieChartModel(PieChartModel saludPieChartModel) {
		this.saludPieChartModel = saludPieChartModel;
	}

	public PieChartModel getEducacionPieChartModel() {
		return educacionPieChartModel;
	}

	public void setEducacionPieChartModel(PieChartModel educacionPieChartModel) {
		this.educacionPieChartModel = educacionPieChartModel;
	}

	public PieChartModel getAlimentacionPieChartModel() {
		return alimentacionPieChartModel;
	}

	public void setAlimentacionPieChartModel(PieChartModel alimentacionPieChartModel) {
		this.alimentacionPieChartModel = alimentacionPieChartModel;
	}

	public PieChartModel getVestimentaPieChartModel() {
		return vestimentaPieChartModel;
	}

	public void setVestimentaPieChartModel(PieChartModel vestimentaPieChartModel) {
		this.vestimentaPieChartModel = vestimentaPieChartModel;
	}

	public PieChartModel getConsolidadoPieChartModel() {
		return consolidadoPieChartModel;
	}

	public void setConsolidadoPieChartModel(PieChartModel consolidadoPieChartModel) {
		this.consolidadoPieChartModel = consolidadoPieChartModel;
	}

	public Map<String, ValorMaximoRubroSri> getValoresMaximosRubroSri() {
		return valoresMaximosRubroSri;
	}

	public void setValoresMaximosRubroSri(Map<String, ValorMaximoRubroSri> valoresMaximosRubroSri) {
		this.valoresMaximosRubroSri = valoresMaximosRubroSri;
	}

	public PieChartModel getAnexoGastosPieChartModel() {
		return anexoGastosPieChartModel;
	}

	public void setAnexoGastosPieChartModel(PieChartModel anexoGastosPieChartModel) {
		this.anexoGastosPieChartModel = anexoGastosPieChartModel;
	}

	public PieChartModel getTotalBaseImponiblePieChartModel() {
		return totalBaseImponiblePieChartModel;
	}

	public void setTotalBaseImponiblePieChartModel(PieChartModel totalBaseImponiblePieChartModel) {
		this.totalBaseImponiblePieChartModel = totalBaseImponiblePieChartModel;
	}

}
