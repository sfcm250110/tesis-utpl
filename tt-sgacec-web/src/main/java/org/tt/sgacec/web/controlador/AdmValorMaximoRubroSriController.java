package org.tt.sgacec.web.controlador;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;
import org.tt.sgacec.web.datamanager.AdmValorMaximoRubroSriDataManager;
import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.ValorMaximoRubroSri;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.FwUtplFactory;

@ManagedBean(name = Constantes.ADM_VALOR_MAXIMO_RUBRO_SRI_CONTROLLER)
@ViewScoped
public class AdmValorMaximoRubroSriController extends CommonController {
	
	// Constantes Generales
	private static final long serialVersionUID = -7112958012726762016L;
	private static Logger log = Logger.getLogger(AdmValorMaximoRubroSriController.class);

	@ManagedProperty(value = Constantes.ADM_VALOR_MAXIMO_RUBRO_SRI_DATAMANAGER_EL)
	private AdmValorMaximoRubroSriDataManager admValorMaximoRubroSriDataManager;

	@Override
	public void init() {
		try {
			admValorMaximoRubroSriDataManager.setMostrarValoresMaximosRubroSri(Boolean.TRUE);
			admValorMaximoRubroSriDataManager.setMostrarNuevoValorMaximoRubroSri(Boolean.TRUE);
			admValorMaximoRubroSriDataManager.setMostrarCrearValorMaximoRubroSri(Boolean.FALSE);
			admValorMaximoRubroSriDataManager.setMostrarModificarValorMaximoRubroSri(Boolean.FALSE);
			admValorMaximoRubroSriDataManager.setPeriodos(FwUtplFactory.getIntance().getConsultasService().getPeriodos());
			
		} catch (Exception e) {
			log.error("[inicializarDatos()] Error al inicializar los datos de la pagina. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al inicializar los datos de la pagina. Causa --> " + e);
		}
	}

	// Operaciones publicas
	public void consultar() {
		try {
			admValorMaximoRubroSriDataManager.setValoresMaximosRubroSri(FwUtplFactory.getIntance().getConsultasService().getValoresMaximoRubroSri(admValorMaximoRubroSriDataManager.getPeriodo()));
			
		} catch (Exception e) {
			log.info("[consultar()] Error al consultar los valores maximos de los rubro del Sri. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al consultar los valores m\u00e1ximos de los rubro del Sri. Causa --> " + e);
		}
	}
	
	public void nuevoValorMaximoRubroSri() {
		ValorMaximoRubroSri valorMaximoRubroSri = new ValorMaximoRubroSri();
		valorMaximoRubroSri.setFechaRegistro(new Date());
		admValorMaximoRubroSriDataManager.setCrearValorMaximoRubroSri(valorMaximoRubroSri);
		
		admValorMaximoRubroSriDataManager.setMostrarValoresMaximosRubroSri(Boolean.FALSE);
		admValorMaximoRubroSriDataManager.setMostrarCrearValorMaximoRubroSri(Boolean.TRUE);
		admValorMaximoRubroSriDataManager.setMostrarModificarValorMaximoRubroSri(Boolean.FALSE);
		admValorMaximoRubroSriDataManager.setMostrarNuevoValorMaximoRubroSri(Boolean.FALSE);
	}
	
	public void crearValorMaximoRubroSri() {
		try {
			FwUtplFactory.getIntance().getCrudService().create(admValorMaximoRubroSriDataManager.getCrearValorMaximoRubroSri());
			
			consultar();
			admValorMaximoRubroSriDataManager.setCrearValorMaximoRubroSri(null);
			admValorMaximoRubroSriDataManager.setMostrarValoresMaximosRubroSri(Boolean.TRUE);
			admValorMaximoRubroSriDataManager.setMostrarCrearValorMaximoRubroSri(Boolean.FALSE);
			admValorMaximoRubroSriDataManager.setMostrarNuevoValorMaximoRubroSri(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Valor M\u00e1ximo del Rubro del Sri registrado exitosamente");

		} catch (Exception e) {
			log.error("[crearValorMaximoRubroSri()] Error al crear el valor maximo del rubro del Sri. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al crear el valor m\u00e1ximo del rubro del Sri. " + e.getMessage());
		}
	}
	
	public void inicioModificarValorMaximoRubroSri(ValorMaximoRubroSri pValorMaximoRubroSri) {
		pValorMaximoRubroSri.setFechaModificacion(new Date());
		admValorMaximoRubroSriDataManager.setModificarValorMaximoRubroSri(pValorMaximoRubroSri);
		
		admValorMaximoRubroSriDataManager.setMostrarValoresMaximosRubroSri(Boolean.FALSE);
		admValorMaximoRubroSriDataManager.setMostrarModificarValorMaximoRubroSri(Boolean.TRUE);
		admValorMaximoRubroSriDataManager.setMostrarCrearValorMaximoRubroSri(Boolean.FALSE);
		admValorMaximoRubroSriDataManager.setMostrarNuevoValorMaximoRubroSri(Boolean.FALSE);
	}
	
	public void modificarValorMaximoRubroSri() {
		try {
			FwUtplFactory.getIntance().getCrudService().update(admValorMaximoRubroSriDataManager.getModificarValorMaximoRubroSri());
			
			consultar();
			admValorMaximoRubroSriDataManager.setModificarValorMaximoRubroSri(null);
			admValorMaximoRubroSriDataManager.setMostrarValoresMaximosRubroSri(Boolean.TRUE);
			admValorMaximoRubroSriDataManager.setMostrarModificarValorMaximoRubroSri(Boolean.FALSE);
			admValorMaximoRubroSriDataManager.setMostrarNuevoValorMaximoRubroSri(Boolean.TRUE);
			
			JsfUtil.addMessage(Constantes.MSJ_INFO, "Valor M\u00e1ximo del Rubro del Sri actualizado exitosamente");
			
		} catch (Exception e) {
			log.error("[modificarValorMaximoRubroSri()] Error al actualizar el Valor maximo del Rubro del Sri. Causa --> " + e);
			JsfUtil.addMessage(Constantes.MSJ_ERROR, "Error al actualizar el Valor M\u00e1ximo del Rubro del Sri. " + e.getMessage());
		}
	}
	
	public void cancelarIn() {
		init();
	}

	// Operaciones privadas

	// Getters/Setters
	public AdmValorMaximoRubroSriDataManager getAdmValorMaximoRubroSriDataManager() {
		return admValorMaximoRubroSriDataManager;
	}

	public void setAdmValorMaximoRubroSriDataManager(AdmValorMaximoRubroSriDataManager admValorMaximoRubroSriDataManager) {
		this.admValorMaximoRubroSriDataManager = admValorMaximoRubroSriDataManager;
	}
	
}
