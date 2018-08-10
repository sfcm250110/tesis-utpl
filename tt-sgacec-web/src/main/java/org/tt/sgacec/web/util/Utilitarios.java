package org.tt.sgacec.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.fusesource.hawtbuf.ByteArrayInputStream;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.xml.sax.SAXException;

import ec.edu.utpl.sc.core.entity.ComprobanteFisico;
import ec.edu.utpl.sc.core.entity.Rol;
import ec.edu.utpl.sc.core.util.AnexoGasto;
import ec.edu.utpl.sc.core.util.Comprobante;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.Utilitario;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.vo.SessionUtil;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

/**
 * 
 * @author Santiago Cabrera M.
 * @revision $Revision: 1.0 $
 */
public final class Utilitarios implements Serializable {
	
	private static final long serialVersionUID = 4244440908945163554L;

	private static final Utilitarios instance = new Utilitarios();

	private Utilitarios() {
	}

	public static Utilitarios getIntance() {
		return instance;
	}
	
	public DefaultMenuModel inicializarMenu(Rol pRol, ResourceBundle pI18n) {
		DefaultMenuModel menuModel = new DefaultMenuModel();
		
        // Sub Menu Catalogos
		DefaultSubMenu subMenuCatalogos = new DefaultSubMenu();
		subMenuCatalogos.setLabel(pI18n.getString(Constantes.LABEL_MENU_CATALOGOS));
		subMenuCatalogos.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        
        // Item Preguntas Seguridad
        DefaultMenuItem menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_PREGUNTAS_SEGURIDAD));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_ADM_PREGUNTAS_SEGURIDAD);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuCatalogos.addElement(menuItem);
        
        // Item Parametros Sistema
        menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_PARAMETROS_SISTEMA));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_ADM_PARAMETROS_SISTEMA);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuCatalogos.addElement(menuItem);
        
        // Item Valor Maximo Rubro Sri
        menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_VALOR_MAXIMO_RUBRO_SRI));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_ADM_VALOR_MAXIMO_RUBRO_SRI);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuCatalogos.addElement(menuItem);
        
        menuModel.addElement(subMenuCatalogos);
        
        // Sub Menu Gestion
 		DefaultSubMenu subMenuGestion = new DefaultSubMenu();
 		subMenuGestion.setLabel(pI18n.getString(Constantes.LABEL_MENU_GESTION));
 		subMenuGestion.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        
        // Item Empresa
        menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_EMPRESA));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_ADM_EMPRESA);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuGestion.addElement(menuItem);
        
        // Item Usuario
        menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_USUARIO));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_ADM_USUARIO);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuGestion.addElement(menuItem);
        
        menuModel.addElement(subMenuGestion);
        
        // Sub Menu ProcesoAdm
 		DefaultSubMenu subMenuProcesoAdm = new DefaultSubMenu();
 		subMenuProcesoAdm.setLabel(pI18n.getString(Constantes.LABEL_MENU_PROCESOS));
 		subMenuProcesoAdm.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        
        // Item Procesar Sri Web
        menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_PROCESAR_SRI_WEB));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_PROCESAR_SRI_WEB);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuProcesoAdm.addElement(menuItem);
        
        // Item Procesar Sri Ws
        menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_PROCESAR_SRI_WS));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_PROCESAR_SRI_WS);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuProcesoAdm.addElement(menuItem);
        
        menuModel.addElement(subMenuProcesoAdm);
        
        // Sub Menu Errores
 		DefaultSubMenu subMenuErrores = new DefaultSubMenu();
 		subMenuErrores.setLabel(pI18n.getString(Constantes.LABEL_MENU_ERRORES));
 		subMenuErrores.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        
        // Item Errores Sistema
        menuItem = new DefaultMenuItem();
        menuItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_VER_ERRORES_SISTEMA));
        menuItem.setOutcome(Constantes.MENU_OUTCOME_ADM_ERRORES_SISTEMA);
        menuItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_ADMIN));
        subMenuErrores.addElement(menuItem);
        
        menuModel.addElement(subMenuErrores);
        
        
        // Sub Menu Consultas
        DefaultSubMenu subMenuConsultas = new DefaultSubMenu();
        subMenuConsultas.setLabel(pI18n.getString(Constantes.LABEL_MENU_CONSULTAS));
        subMenuConsultas.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_OPERADOR));
        
        // Item Comprobantes Electronicos
        DefaultMenuItem menuConsultaComprobantesItem = new DefaultMenuItem();
        menuConsultaComprobantesItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_COMPROBANTES_ELECTRONICOS));
        menuConsultaComprobantesItem.setOutcome(Constantes.MENU_OUTCOME_GESTION_COMPROBANTES_ELECTRONICOS);
        menuConsultaComprobantesItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_OPERADOR));
        subMenuConsultas.addElement(menuConsultaComprobantesItem);
        
        // Item Comprobantes Fisicos
        DefaultMenuItem menuComprobantesFisicosItem = new DefaultMenuItem();
        menuComprobantesFisicosItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_COMPROBANTES_FISICOS));
        menuComprobantesFisicosItem.setOutcome(Constantes.MENU_OUTCOME_GESTION_COMPROBANTES_FISICOS);
        menuComprobantesFisicosItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_OPERADOR));
        subMenuConsultas.addElement(menuComprobantesFisicosItem);
        
        menuModel.addElement(subMenuConsultas);
        
        // Sub Proceso
        DefaultSubMenu subMenuProceso = new DefaultSubMenu();
        subMenuProceso.setLabel(pI18n.getString(Constantes.LABEL_MENU_PROCESOS));
        subMenuProceso.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_OPERADOR));
        
        // Check Download Sri
        DefaultMenuItem menuCheckDownloadItem = new DefaultMenuItem();
        menuCheckDownloadItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_CHECK_DOWNLOAD_SRI));
        menuCheckDownloadItem.setOutcome(Constantes.MENU_OUTCOME_CHECK_DOWNLOAD_SRI);
        menuCheckDownloadItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_OPERADOR));
        subMenuProceso.addElement(menuCheckDownloadItem);
        
        // Item Generar Anexo
        DefaultMenuItem menuGenerarAnexoItem = new DefaultMenuItem();
        menuGenerarAnexoItem.setValue(pI18n.getString(Constantes.LABEL_MENU_ITEM_GENERAR_ANEXO_GASTOS));
        menuGenerarAnexoItem.setOutcome(Constantes.MENU_OUTCOME_GENERAR_ANEXO_GASTOS);
        menuGenerarAnexoItem.setRendered(Utilitario.getIntance().isUserInRole(pRol, Constantes.ROL_OPERADOR));
        subMenuProceso.addElement(menuGenerarAnexoItem);
        
        menuModel.addElement(subMenuProceso);
        
        return menuModel;
	}
	
	public void descargarByteArray(HttpServletResponse response, String nombreArchivo, String contentType, String encoding, byte[] contenido) {
		try {
			ServletOutputStream outputStream = response.getOutputStream();

			response.setHeader("Content-Disposition", "inline; filename=\"" + nombreArchivo + "\"");
			response.setContentType(contentType + "; charset=" + encoding);
			response.setContentLength(contenido.length);

			outputStream.write(contenido, 0, contenido.length);
			outputStream.flush();
			outputStream.close();

			FacesContext.getCurrentInstance().responseComplete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<ComprobanteFisico> getComprobantesFisicos(ComprobanteFisico pComprobanteFisico, byte[] pFileExcel) throws IOException, SAXException, InvalidFormatException, UtplException {
		if (pFileExcel == null) {
			List<ComprobanteFisico> comprobantesFisicos = new ArrayList<ComprobanteFisico>();
			pComprobanteFisico.setSrc(Constantes.SRC_WEB);
			comprobantesFisicos.add(pComprobanteFisico);
			
			return comprobantesFisicos;
			
		} else {
			List<ComprobanteFisico> comprobantesFisicosTmp = new ArrayList<ComprobanteFisico>();
			Map<String, Object> comprobantesFisicosmap = new HashMap<String, Object>();
	        comprobantesFisicosmap.put("comprobantesFisicos", comprobantesFisicosTmp);
	        
	        InputStream inputStreamXml = new ByteArrayInputStream(SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_COMPROBANTE_FISICO_XML).toString().getBytes());
			InputStream inputStreamXsl = new ByteArrayInputStream(pFileExcel);
			XLSReader xslReader = ReaderBuilder.buildFromXML(inputStreamXml);
	        XLSReadStatus xlsReadStatus = xslReader.read(inputStreamXsl, comprobantesFisicosmap);
	        
	        if (!xlsReadStatus.isStatusOK()) {
	        	throw new UtplException("Archivo excel no cumple con el formato esperado");
	        }
	        
	        List<ComprobanteFisico> comprobantesFisicos = new ArrayList<ComprobanteFisico>();
	        
			if (comprobantesFisicosTmp != null && !comprobantesFisicosTmp.isEmpty()) {
				for (ComprobanteFisico comprobanteFisico : comprobantesFisicosTmp) {
					comprobanteFisico.setSrc(Constantes.SRC_FILE);
					comprobanteFisico.setRuc(pComprobanteFisico.getRuc());
					comprobantesFisicos.add(comprobanteFisico);
				}
			}
			
			return comprobantesFisicos;
		}
	}
	
	public static AnexoGasto getConsolidarAnexoGasto(byte[] pFileExcel) throws IOException, SAXException, InvalidFormatException, UtplException {
		List<Comprobante> comprobantesSinClasificar = new ArrayList<Comprobante>();
		List<Comprobante> comprobantesClasificados = new ArrayList<Comprobante>();
		
		AnexoGasto anexoGasto = new AnexoGasto();
		Map<String, Object> anexoGastoMap = new HashMap<String, Object>();
		anexoGastoMap.put("anexoGasto", anexoGasto);
		anexoGastoMap.put("comprobantesSinClasificar", comprobantesSinClasificar);
		anexoGastoMap.put("comprobantesClasificados", comprobantesClasificados);
        
		InputStream inputStreamXml = new ByteArrayInputStream(SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_CONSOLIDADR_ANEXO_GASTOS_XML).toString().getBytes());
		InputStream inputStreamXsl = new ByteArrayInputStream(pFileExcel);
		XLSReader xslReader = ReaderBuilder.buildFromXML(inputStreamXml);
        XLSReadStatus xlsReadStatus = xslReader.read(inputStreamXsl, anexoGastoMap);
        
        if (!xlsReadStatus.isStatusOK()) {
        	throw new UtplException("Archivo excel no cumple con el formato esperado");
        	
        } else {
        	anexoGasto.setComprobantesSinClasificar(comprobantesSinClasificar);
        	anexoGasto.setComprobantesClasificados(comprobantesClasificados);
		}
		
        return anexoGasto;
	}
	
}