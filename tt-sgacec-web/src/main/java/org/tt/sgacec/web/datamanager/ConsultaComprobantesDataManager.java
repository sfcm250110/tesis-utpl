package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;

@ManagedBean
@SessionScoped
public class ConsultaComprobantesDataManager extends CommonDataManager implements Serializable {

	private static final long serialVersionUID = -2626293075817735556L;
	
	private Date fechaEmisionDesde;
	private Date fechaEmisionHasta;
	private ComprobanteEmpresa comprobanteEmpresa;
	private List<ComprobanteEmpresa> comprobantesEmpresa;

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

	public Date getFechaEmisionDesde() {
		return fechaEmisionDesde;
	}

	public void setFechaEmisionDesde(Date fechaEmisionDesde) {
		this.fechaEmisionDesde = fechaEmisionDesde;
	}

	public Date getFechaEmisionHasta() {
		return fechaEmisionHasta;
	}

	public void setFechaEmisionHasta(Date fechaEmisionHasta) {
		this.fechaEmisionHasta = fechaEmisionHasta;
	}

}
