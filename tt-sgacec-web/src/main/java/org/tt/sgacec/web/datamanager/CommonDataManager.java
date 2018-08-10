package org.tt.sgacec.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.Estado;

@ManagedBean(name = Constantes.COMMON_DATAMANAGER)
@SessionScoped
public class CommonDataManager implements Serializable {

	private static final long serialVersionUID = 4831396690014184975L;

	private String tituloOpcionUsuario;
	private Integer maxRowsTabla;
	private List<Estado> estados;

	public Integer getMaxRowsTabla() {
		maxRowsTabla = Constantes.MAX_ROWS_TABLA;
		
		return maxRowsTabla;
	}

	public void setMaxRowsTabla(Integer maxRowsTabla) {
		this.maxRowsTabla = maxRowsTabla;
	}

	public List<Estado> getEstados() {
		if (estados == null) {
			List<Estado> estadosTmp = new ArrayList<Estado>();
			
			Estado estado = new Estado();
			estado.setName(Constantes.ACTIVO);
			estado.setValue(Boolean.TRUE);
			estadosTmp.add(estado);
			
			estado = new Estado();
			estado.setName(Constantes.INACTIVO);
			estado.setValue(Boolean.FALSE);
			estadosTmp.add(estado);
			
			estados = new ArrayList<Estado>();
			estados.addAll(estadosTmp);
		}
		
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public String getTituloOpcionUsuario() {
		return tituloOpcionUsuario;
	}

	public void setTituloOpcionUsuario(String tituloOpcionUsuario) {
		this.tituloOpcionUsuario = tituloOpcionUsuario;
	}

}
