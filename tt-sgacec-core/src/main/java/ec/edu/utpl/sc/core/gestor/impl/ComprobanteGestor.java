package ec.edu.utpl.sc.core.gestor.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.IComprobanteDao;
import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.ComprobanteFisico;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.gestor.IAdmGestor;
import ec.edu.utpl.sc.core.gestor.IComprobanteGestor;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.gestor.IFwGestor;
import ec.edu.utpl.sc.core.gestor.ISeleniumGestor;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.ComprobanteUtil;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.ConstantesEmail;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.DateUtil;
import ec.edu.utpl.sc.core.util.Deducible;
import ec.edu.utpl.sc.core.util.EmailUtil;
import ec.edu.utpl.sc.core.util.Utilitario;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.util.XmlUtil;
import ec.edu.utpl.sc.core.vo.Email;
import ec.edu.utpl.sc.core.ws.AutorizacionComprobantesOffline;
import ec.edu.utpl.sc.core.ws.RespuestaComprobante;
import ec.edu.utpl.sc.core.xsd.v110.Factura;
import ec.edu.utpl.sc.core.xsd.v110.Factura.InfoAdicional;
import ec.edu.utpl.sc.core.xsd.v110.Factura.InfoAdicional.CampoAdicional;
import ec.edu.utpl.sc.core.xsd.v110.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto;

@Repository(Constantes.COMPROBANTE_GESTOR)
public class ComprobanteGestor implements IComprobanteGestor {
	
	private static Logger log = Logger.getLogger(ComprobanteGestor.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_DAO)
	private IComprobanteDao comprobanteDao;
	
	@Autowired
	@Qualifier(Constantes.SELENIUM_GESTOR)
	private ISeleniumGestor seleniumGestor;
	
	@Autowired
	@Qualifier(Constantes.EMPRESA_GESTOR)
	private IEmpresaGestor empresaGestor;
	
	@Autowired
	@Qualifier(Constantes.FW_GESTOR)
	private IFwGestor fwGestor;
	
	@Autowired
	@Qualifier(Constantes.ADM_GESTOR)
	private IAdmGestor admGestor; 

	@Override
	public Integer obtenerTipoComprobante(String pNombreComprobante) throws UtplException {
		Integer tipoComprobante = null;
		
		if (Constantes.NOMBRE_FACTURA.toLowerCase().equals(StringUtils.stripAccents(pNombreComprobante.toLowerCase()))) {
			tipoComprobante = Constantes.TIPO_FACTURA;
		} else
			
		if (Constantes.NOMBRE_NOTA_CREDITO.toLowerCase().equals(StringUtils.stripAccents(pNombreComprobante.toLowerCase()))) {
			tipoComprobante = Constantes.TIPO_NOTA_CREDITO;
		} else
			
		if (Constantes.NOMBRE_NOTA_DEBITO.toLowerCase().equals(StringUtils.stripAccents(pNombreComprobante.toLowerCase()))) {
			tipoComprobante = Constantes.TIPO_NOTA_DEBITO;
		} else
		
		if (Constantes.NOMBRE_GUIA_REMISION.toLowerCase().equals(StringUtils.stripAccents(pNombreComprobante.toLowerCase()))) {
			tipoComprobante = Constantes.TIPO_GUIA_REMISION;
		} else
			
		if (Constantes.NOMBRE_COMPROBANTE_RETENCION.toLowerCase().equals(StringUtils.stripAccents(pNombreComprobante.toLowerCase()))) {
			tipoComprobante = Constantes.TIPO_COMPROBANTE_RETENCION;
		}
		
		return tipoComprobante;
	}

	@Override
	public Integer obtenerTipoEmision(String pNombreEmision) throws UtplException {
		Integer tipoEmision = null;
		
		if (Constantes.NOMBRE_NORMAL.equals(pNombreEmision)) {
			tipoEmision = Constantes.TIPO_NORMAL;
		} else
			
		if (Constantes.NOMBRE_CONTINGENCIA.equals(pNombreEmision)) {
			tipoEmision = Constantes.TIPO_CONTINGENCIA;
		}
		
		return tipoEmision;
	}

	@Override
	public String obtenerTagComprobanteXml(String pComprobanteXml, String pTag) throws UtplException {
		Document document = Jsoup.parseBodyFragment(pComprobanteXml);
		String tag = document.select(pTag).text();

		return tag;
	}
	
	@Override
	public String obtenerTagComprobante(String pComprobanteXml, String pTag) throws UtplException {
		Document documentXml = Jsoup.parseBodyFragment(pComprobanteXml);
		String comprobante = documentXml.select(Constantes.TAG_COMPROBANTE).text();
		Document documentComprobante = Jsoup.parseBodyFragment(comprobante);
		String tag = documentComprobante.select(pTag).text();

		return tag;
	}

	@Override
	public void downloadComprobantesSri(String pMessageXml) {
		CheckDownloadSri checkDownloadSri = null;
		
		try {
			Boolean downloadWeb = Boolean.parseBoolean(fwGestor.obtenerParametroGeneral(Constantes.DOWNLOAD_WEB).getValor());
			String srcDownload = ComprobanteUtil.getSrcDownload(downloadWeb);
			
			checkDownloadSri = XmlUtil.xmlToCheckDownloadSri(pMessageXml);
			Empresa empresa = empresaGestor.obtenerEmpresaActiva(checkDownloadSri.getRuc());
			List<ComprobanteEmpresa> comprobantesEmpresa = seleniumGestor.downloadComprobantesSri(empresa.getRuc(), empresa.getClaveSri(), DateUtil.obtenerDateFindSri(checkDownloadSri.getFechaDownload()), downloadWeb);
			
			for (ComprobanteEmpresa comprobanteEmpresa : comprobantesEmpresa) {
				
				Map<String, String> parameterValues = new HashMap<String, String>();
				parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
				String sql = DaoUtil.buildSqlParameters(ConstantesDb.COMPROBANTE_EMPRESA_NA, parameterValues);
				ComprobanteEmpresa comprobanteEmpresaFind = comprobanteDao.findOneRow(sql, checkDownloadSri.getRuc());
				
				if (comprobanteEmpresaFind == null) {
					comprobanteEmpresa.setSrc(srcDownload);
					comprobanteEmpresa.setClasificado(Boolean.FALSE);
					comprobanteDao.create(comprobanteEmpresa, checkDownloadSri.getRuc());
				}
			}
			
			checkDownloadSri.setFila(comprobantesEmpresa.size());
			checkDownloadSri.setEtapa(Constantes.PROCESADO);
			checkDownloadSri.setIdCheckDownloadSriCrud(checkDownloadSri.getIdCheckDownloadSri());
			crudDao.updateFields(checkDownloadSri);
			
		} catch (Exception e) {
			try {
				String mensajeUsuario = "Error al descargar los comprobantes del Sri";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
				admGestor.registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
				
				// Actualizar el registro a error
				checkDownloadSri.setEtapa(Constantes.ERROR_QUEUE);
				checkDownloadSri.setIdCheckDownloadSriCrud(checkDownloadSri.getIdCheckDownloadSri());
				crudDao.updateFields(checkDownloadSri);
				
				// Enviar el email al administrador
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(Constantes.ID_USUARIO_DEFAULT);
				List<Usuario> usuarios = crudDao.findForCriteria(usuario, Boolean.FALSE);
				usuario = usuarios.get(Constantes.I0);
				
				String destinatario = usuario.getEmail();
				String asunto = ConstantesEmail.MSJ_ERROR_PROCESAR_SRI_WEB_ASUNTO;
				String msj = EmailUtil.msgErrorProcesarSri(usuario.getNombres(), ConstantesEmail.ACCION_ERROR_PROCESAR_SRI_WEB_EMAIL, Utilitario.formatLengthMaxFiel(e.getMessage(), Constantes.I100));
				Email email = fwGestor.getEmail(destinatario, asunto, msj);
				fwGestor.sendEmailQueue(email);
				
			} catch (Exception ex) {
				String mensajeUsuario = "Error al enviar el email al administrador [queue-web]";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + ex);
				admGestor.registerErrorSistema(ex, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
			}
		}
	}
	
	@Override
	public void downloadComprobanteSriWs(String pMsgComprobanteXml) {
		ComprobanteEmpresa comprobanteEmpresa = null;
		try {
			comprobanteEmpresa = XmlUtil.xmlToComprobanteEmpresa(pMsgComprobanteXml);
			
			AutorizacionComprobantesOffline autorizacionComprobantesOffline = fwGestor.getAutorizacionComprobantesOffline();
			RespuestaComprobante respuestaComprobante = autorizacionComprobantesOffline.autorizacionComprobante(comprobanteEmpresa.getClaveAcceso());
			String xml = respuestaComprobante.getAutorizaciones().getAutorizacion().get(Constantes.I0).getComprobante();
			
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
			parameterValues.put(ConstantesDb.PARAM_XML, xml);
			parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.PROCESADO.toString());
			String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_XML_ESTADO, parameterValues);
			comprobanteDao.update(sql, comprobanteEmpresa.getRuc());
			
		} catch (Exception e) {
			try {
				String mensajeUsuario = "Error al descargar el xml del comprobante del Sri. Se reintentara";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
				admGestor.registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
				
				// Actualizar el registro a error
				Map<String, String> parameterValues = new HashMap<String, String>();
				parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.REGISTRADO_LBL.toString());
				parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
				String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_ESTADO, parameterValues);
				comprobanteDao.update(sql, comprobanteEmpresa.getRuc());
				
				// Enviar el email al administrador
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(Constantes.ID_USUARIO_DEFAULT);
				List<Usuario> usuarios = crudDao.findForCriteria(usuario, Boolean.FALSE);
				usuario = usuarios.get(Constantes.I0);
				
				String destinatario = usuario.getEmail();
				String asunto = ConstantesEmail.MSJ_ERROR_PROCESAR_SRI_WS_ASUNTO;
				String msj = EmailUtil.msgErrorProcesarSri(usuario.getNombres(), ConstantesEmail.ACCION_ERROR_PROCESAR_SRI_WS_EMAIL, Utilitario.formatLengthMaxFiel(e.getMessage(), Constantes.I100));
				Email email = fwGestor.getEmail(destinatario, asunto, msj);
				fwGestor.sendEmailQueue(email);
				
			} catch (Exception ex) {
				String mensajeUsuario = "Error al enviar el email al administrador [queue-ws]";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + ex);
				admGestor.registerErrorSistema(ex, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
			}
		}
	}
	
	@Override
	public List<ComprobanteEmpresa> getComprobantes() throws UtplException {
		try {
			List<Empresa> empresas = empresaGestor.obtenerEmpresasActiva();
			List<ComprobanteEmpresa> comprobantesEmpresas = new ArrayList<ComprobanteEmpresa>();
			
			if (empresas != null && !empresas.isEmpty()) {
				
				for (Empresa empresa : empresas) {
					Map<String, String> parameterValues = new HashMap<String, String>();
					parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.ERROR_QUEUE.toString());
					String sql = DaoUtil.buildSqlParameters(ConstantesDb.COMPROBANTES_EMPRESA_ESTADO, parameterValues);
					List<ComprobanteEmpresa> comprobantesEmpresasFind = comprobanteDao.findListRow(sql, empresa.getRuc());
					
					if (comprobantesEmpresasFind != null && !comprobantesEmpresasFind.isEmpty()) {
						comprobantesEmpresas.addAll(comprobantesEmpresasFind);
					}
				}
			}
			
			return comprobantesEmpresas;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}		
	}
	
	@Override
	public void procesarTodo(List<ComprobanteEmpresa> pComprobantesEmpresa) throws UtplException {
		try {
			for (ComprobanteEmpresa comprobanteEmpresa : pComprobantesEmpresa) {
				procesar(comprobanteEmpresa);
			}

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void procesar(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException {
		try {
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.REGISTRADO.toString());
			parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, pComprobanteEmpresa.getNumeroAutorizacion());
			String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_ESTADO, parameterValues);
			
			comprobanteDao.update(sql, pComprobanteEmpresa.getRuc());

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<ComprobanteEmpresa> getComprobantesEmpresa(ComprobanteEmpresa pComprobanteEmpresa, Date pFechaEmisionDesde, Date pFechaEmisionHasta) throws UtplException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("Select ruc_emisor As rucEmisor, razon_social_emisor As razonSocialEmisor, numero_autorizacion As numeroAutorizacion, fecha_autorizacion As fechaAutorizacion, fecha_emision As fechaEmision, punto_emision As puntoEmision, establecimiento As establecimiento, secuencial As secuencial, estado As estado, tipo_emision As tipoEmision, clave_acceso As claveAcceso, tipo As tipo ");
			sql.append("From utpl_comprobante ");
			sql.append("Where 1 = 1 ");
			
			if (pComprobanteEmpresa != null) {
				
				if (pComprobanteEmpresa.getRucEmisor() != null && !pComprobanteEmpresa.getRucEmisor().isEmpty()) {
					sql.append("And ").append("ruc_emisor = '").append(pComprobanteEmpresa.getRucEmisor().trim()).append("'");
				}
				
				if (pComprobanteEmpresa.getRazonSocialEmisor() != null && !pComprobanteEmpresa.getRazonSocialEmisor().isEmpty()) {
					sql.append("And ").append("upper(").append("razon_social_emisor) Like upper('%").append(pComprobanteEmpresa.getRazonSocialEmisor().trim()).append("%')");
				}
				
				if (pComprobanteEmpresa.getSecuencial() != null && !pComprobanteEmpresa.getSecuencial().isEmpty()) {
					sql.append("And ").append("secuencial = '").append(pComprobanteEmpresa.getSecuencial().trim()).append("'");
				}
				
				if (pFechaEmisionDesde != null && pFechaEmisionHasta != null) {
					sql.append("And ").append("fecha_emision >= '").append(DateUtil.parseToDateString(pFechaEmisionDesde, Constantes.YYYY_MM_DD)).append("'");
					sql.append("And ").append("fecha_emision <= '").append(DateUtil.parseToDateString(pFechaEmisionHasta, Constantes.YYYY_MM_DD)).append("'");
				}
				
				sql.append("Order By fecha_emision Desc ");
			}
			
			return comprobanteDao.findListRow(sql.toString(), pComprobanteEmpresa.getRuc());
			
		} catch (Exception e) {
			throw new UtplException(e);
		}		
	}
	
	@Override
	public List<ComprobanteFisico> getComprobantesFisico(ComprobanteFisico pComprobanteFisico) throws UtplException {
		try {
			return crudDao.findForCriteria(pComprobanteFisico, Boolean.FALSE);
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void crearComprobanteFisico(ComprobanteFisico pComprobanteFisico) throws UtplException {
		try {
			Double vivienda = Constantes.D0;
			Double educacion = Constantes.D0;
			Double alimentacion = Constantes.D0;
			Double vestimenta = Constantes.D0;
			Double salud = Constantes.D0;
			Boolean clasificado = Boolean.FALSE;
			
			if (pComprobanteFisico.getVivienda() != null && !Constantes.D0.equals(pComprobanteFisico.getVivienda())) {
				vivienda = pComprobanteFisico.getVivienda();
			}
			
			if (pComprobanteFisico.getEducacion() != null && !Constantes.D0.equals(pComprobanteFisico.getEducacion())) {
				educacion = pComprobanteFisico.getEducacion();
			}
			
			if (pComprobanteFisico.getAlimentacion() != null && !Constantes.D0.equals(pComprobanteFisico.getAlimentacion())) {
				alimentacion = pComprobanteFisico.getAlimentacion();
			}
			
			if (pComprobanteFisico.getVestimenta() != null && !Constantes.D0.equals(pComprobanteFisico.getVestimenta())) {
				vestimenta = pComprobanteFisico.getVestimenta();
			}
			
			if (pComprobanteFisico.getSalud() != null && !Constantes.D0.equals(pComprobanteFisico.getSalud())) {
				salud = pComprobanteFisico.getSalud();
			}
			
			if (!Constantes.D0.equals(vivienda) || !Constantes.D0.equals(educacion) || !Constantes.D0.equals(alimentacion) || !Constantes.D0.equals(vestimenta) || !Constantes.D0.equals(salud)) {
				clasificado = Boolean.TRUE;
			}
			
			pComprobanteFisico.setClasificado(clasificado);
			pComprobanteFisico.setEstado(Boolean.TRUE);
			pComprobanteFisico.setTipo(Constantes.TIPO_FACTURA);
			pComprobanteFisico.setFechaRegistro(new Date());
			crudDao.create(pComprobanteFisico);
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void crearComprobantesFisicos(List<ComprobanteFisico> pComprobantesFisicos) throws UtplException {
		try {
			if (pComprobantesFisicos != null && !pComprobantesFisicos.isEmpty()) {
				for (ComprobanteFisico comprobanteFisico : pComprobantesFisicos) {
					crearComprobanteFisico(comprobanteFisico);
				}
			}
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void modificarComprobanteFisico(ComprobanteFisico pComprobanteFisico) throws UtplException {
		try {
			crudDao.update(pComprobanteFisico);
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<ComprobanteEmpresa> getComprobantesEmpresaAnexo(String pRuc, String pPeriodo) throws UtplException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("Select ruc_emisor As rucEmisor, razon_social_emisor As razonSocialEmisor, punto_emision As puntoEmision, establecimiento As establecimiento, secuencial As secuencial, fecha_emision As fechaEmision, clasificado As clasificado, vivienda As vivienda, educacion As educacion, vestimenta As vestimenta, salud As salud, alimentacion As alimentacion, base_imponible As baseImponible ");
			sql.append("From utpl_comprobante ");
			sql.append("Where estado = ").append(Constantes.CLASIFICADO).append(" ");
			sql.append("And date_part('year', fecha_emision) = '").append(pPeriodo.trim()).append("'");
			sql.append("Order By fecha_emision Desc ");
			
			return comprobanteDao.findListRow(sql.toString(), pRuc);
			
		} catch (Exception e) {
			throw new UtplException(e);
		}		
	}
	
	@Override
	public List<ComprobanteFisico> getComprobantesFisicoAnexo(String pRuc, String pPeriodo) throws UtplException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("Select rucEmisor As rucEmisor, razonSocialEmisor As razonSocialEmisor, puntoEmision As puntoEmision, establecimiento As establecimiento, secuencial As secuencial, fechaEmision As fechaEmision, vivienda As vivienda, educacion As educacion, vestimenta As vestimenta, salud As salud, alimentacion As alimentacion, baseImponible As baseImponible, clasificado As clasificado ");
			sql.append("From ComprobanteFisico ");
			sql.append("Where ruc = '").append(pRuc).append("' ");
			sql.append("And date_part('year', fechaEmision) = '").append(pPeriodo.trim()).append("'");
			
			return crudDao.findListRow(ComprobanteFisico.class, sql.toString());
			
		} catch (Exception e) {
			throw new UtplException(e);
		}		
	}

	@Override
	public void clasificarComprobanteAnexo(String pMessageXml) {
		ComprobanteEmpresa comprobanteEmpresa = null;
		
		try {
			comprobanteEmpresa = XmlUtil.xmlToComprobanteEmpresa(pMessageXml);
			log.info("Procesando el comprobante de la empresa: " + comprobanteEmpresa.getRuc() + ", con numero de autorizacion: " + comprobanteEmpresa.getNumeroAutorizacion());
			
			Double vivienda = Constantes.D0;
			Double educacion = Constantes.D0;
			Double alimentacion = Constantes.D0;
			Double vestimenta = Constantes.D0;
			Double salud = Constantes.D0;
			Boolean clasificado = Boolean.FALSE;
			
			InfoRucSri infoRucSri = new InfoRucSri();
			infoRucSri.setRuc(comprobanteEmpresa.getRucEmisor());
			infoRucSri = crudDao.findOneRow(infoRucSri, Boolean.FALSE);
			
			if (infoRucSri == null) {
				Map<String, String> parameterValues = new HashMap<String, String>();
				parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.PROCESADO.toString());
				parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
				String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_CLASIFICAR, parameterValues);
				comprobanteDao.update(sql, comprobanteEmpresa.getRuc());
				
			} else {
				Factura factura = XmlUtil.xmlToFactura(comprobanteEmpresa.getXml());
				
				// Buscar los valores deducibles en la informacion adicional
				List<Deducible> deducibles = getDeducibles(factura.getInfoAdicional());
				
				if (!deducibles.isEmpty()) {
					for (Deducible deducible : deducibles) {
						if (deducible.getFound()) {
							clasificado = Boolean.TRUE;
							
							switch (deducible.getTipoGasto()) {
								// No Encontrado
								case 0: {
									clasificado = Boolean.FALSE;
									break;
								}
								
								// Vivienda
								case 1: {
									vivienda = deducible.getBaseImponible();
									break;
								}
								
								// Educacion
								case 2: {
									educacion = deducible.getBaseImponible();
									break;
								}
								
								// Alimentacion
								case 3: {
									alimentacion = deducible.getBaseImponible();
									break;
								}
								
								// Vestimenta
								case 4: {
									vestimenta = deducible.getBaseImponible();
									break;
								}
								
								// Salud
								case 5: {
									salud = deducible.getBaseImponible();
									break;
								}
								
								// No Encontrado
								default: {
									clasificado = Boolean.FALSE;
									break;
								}
							}
						}
					}
				
				// Buscar los valores deducibles en la informacion adicional
				} else {
					clasificado = Boolean.TRUE;
					
					// Alimentacion
					if (checkFromActividadEconomicaSri(infoRucSri.getActividadEconomicaPrincipal(), Constantes.IALIMENTACION)) {
						alimentacion = factura.getInfoFactura().getTotalSinImpuestos().doubleValue();
						
						// Descartar el valor para el impuesto que tiene ICE
						alimentacion = alimentacion - getTotalImpuestoIce(factura.getInfoFactura().getTotalConImpuestos().getTotalImpuesto());
						
					// Salud
					} else if (checkFromActividadEconomicaSri(infoRucSri.getActividadEconomicaPrincipal(), Constantes.ISALUD)) {
						salud = factura.getInfoFactura().getTotalSinImpuestos().doubleValue();
						
						// Descartar el valor para el impuesto que tiene ICE
						salud = salud - getTotalImpuestoIce(factura.getInfoFactura().getTotalConImpuestos().getTotalImpuesto());
						
					// Educacion
					} else if (checkFromActividadEconomicaSri(infoRucSri.getActividadEconomicaPrincipal(), Constantes.IEDUCACION)) {
						educacion = factura.getInfoFactura().getTotalSinImpuestos().doubleValue();
								
						// Descartar el valor para el impuesto que tiene ICE
						educacion = educacion - getTotalImpuestoIce(factura.getInfoFactura().getTotalConImpuestos().getTotalImpuesto());
						
					// Vestimenta
					} else if (checkFromActividadEconomicaSri(infoRucSri.getActividadEconomicaPrincipal(), Constantes.IVESTIMENTA)) {
						vestimenta = factura.getInfoFactura().getTotalSinImpuestos().doubleValue();
									
						// Descartar el valor para el impuesto que tiene ICE
						vestimenta = vestimenta - getTotalImpuestoIce(factura.getInfoFactura().getTotalConImpuestos().getTotalImpuesto());
					
					// Vivienda
					} else if (checkFromActividadEconomicaSri(infoRucSri.getActividadEconomicaPrincipal(), Constantes.IVIVIENDA)) {
						vivienda = factura.getInfoFactura().getTotalSinImpuestos().doubleValue();
										
						// Descartar el valor para el impuesto que tiene ICE
						vivienda = vivienda - getTotalImpuestoIce(factura.getInfoFactura().getTotalConImpuestos().getTotalImpuesto());
						
					} else {
						clasificado = Boolean.FALSE;
					}
				}
				
				Map<String, String> parameterValues = new HashMap<String, String>();
				parameterValues.put(ConstantesDb.PARAM_VIVIENDA, vivienda.toString());
				parameterValues.put(ConstantesDb.PARAM_EDUCACION, educacion.toString());
				parameterValues.put(ConstantesDb.PARAM_ALIMENTACION, alimentacion.toString());
				parameterValues.put(ConstantesDb.PARAM_VESTIMENTA, vestimenta.toString());
				parameterValues.put(ConstantesDb.PARAM_SALUD, salud.toString());
				parameterValues.put(ConstantesDb.PARAM_BASE_IMPONIBLE, String.valueOf(factura.getInfoFactura().getTotalSinImpuestos().doubleValue()));
				parameterValues.put(ConstantesDb.PARAM_CLASIFICADO, clasificado.toString());
				parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.CLASIFICADO.toString());
				parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
				String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_CLASIFICADO, parameterValues);
				comprobanteDao.update(sql, comprobanteEmpresa.getRuc());
			}
			
		} catch (Exception e) {
			try {
				String mensajeUsuario = "Error al clasificar el comprobante";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
				admGestor.registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
				
				// Actualizar el registro a error
				Map<String, String> parameterValues = new HashMap<String, String>();
				parameterValues.put(ConstantesDb.PARAM_CLASIFICADO, Boolean.FALSE.toString());
				parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.ERROR_QUEUE.toString());
				parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
				String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_CLASIFICAR, parameterValues);
				comprobanteDao.update(sql, comprobanteEmpresa.getRuc());
				
			} catch (Exception ex) {
				String mensajeUsuario = "Error al actualizar el comprobante con error al momento de clasificar";
				log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + ex);
				admGestor.registerErrorSistema(ex, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
			}
		}
	}
	
	@Override
	public List<AnexoGastoSri> findAnexosGastoSri(String pPeriodo) throws UtplException {
		try {
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_PERIODO, pPeriodo.toString());
			
			String sql = DaoUtil.buildSqlParameters(ConstantesDb.ANEXO_GASTOS_FISICO, parameterValues);
			List<AnexoGastoSri> anexosGastoSri = crudDao.findListClassRowNative(AnexoGastoSri.class, sql);
			
			return anexosGastoSri;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	private Double getTotalImpuestoIce(List<TotalImpuesto> pTotalesImpuesto) {
		BigDecimal baseImponibleIce = new BigDecimal(Constantes.I0);
		
		for (TotalImpuesto totalImpuesto : pTotalesImpuesto) {
			
			if (Constantes.CODIGO_IMPUESTO_ICE.equals(totalImpuesto.getCodigo())) {
				baseImponibleIce = totalImpuesto.getBaseImponible();
				break;
			}
		}
		
		return baseImponibleIce.doubleValue();
	}
	
	private List<Deducible> getDeducibles(InfoAdicional pInfoAdicional) throws ParseException, UtplException {
		List<Deducible> deducibles = new ArrayList<Deducible>();
		
		if (pInfoAdicional != null && pInfoAdicional.getCampoAdicional() != null) {
			for (CampoAdicional campoAdicional : pInfoAdicional.getCampoAdicional()) {
				
				if (campoAdicional.getNombre().toUpperCase().contains(Constantes.DEDUCIBLE.toUpperCase())) {
					Deducible deducible = new Deducible();
					deducible.setFound(Boolean.TRUE);
					
					if (checkFromActividadEconomicaSri(campoAdicional.getNombre(), Constantes.IVIVIENDA)) {
						deducible.setBaseImponible(Double.parseDouble(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IVIVIENDA);
						
					} else if (checkFromActividadEconomicaSri(campoAdicional.getNombre(), Constantes.IEDUCACION)) {
						deducible.setBaseImponible(Double.parseDouble(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IEDUCACION);
						
					} else if (checkFromActividadEconomicaSri(campoAdicional.getNombre(), Constantes.IALIMENTACION)) {
						deducible.setBaseImponible(Double.parseDouble(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IALIMENTACION);
						
					} else if (checkFromActividadEconomicaSri(campoAdicional.getNombre(), Constantes.IVESTIMENTA)) {
						deducible.setBaseImponible(Double.parseDouble(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IVESTIMENTA);
						
					} else if (checkFromActividadEconomicaSri(campoAdicional.getNombre(), Constantes.ISALUD)) {
						deducible.setBaseImponible(Double.parseDouble(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.ISALUD);
						
					} else if (checkFromActividadEconomicaSri(campoAdicional.getValue(), Constantes.IVIVIENDA)) {
						deducible.setBaseImponible(Utilitario.extractQuantity(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IVIVIENDA);
						
					} else if (checkFromActividadEconomicaSri(campoAdicional.getValue(), Constantes.IEDUCACION)) {
						deducible.setBaseImponible(Utilitario.extractQuantity(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IEDUCACION);
					
					} else if (checkFromActividadEconomicaSri(campoAdicional.getValue(), Constantes.IALIMENTACION)) {
						deducible.setBaseImponible(Utilitario.extractQuantity(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IALIMENTACION);
						
					} else if (checkFromActividadEconomicaSri(campoAdicional.getValue(), Constantes.IVESTIMENTA)) {
						deducible.setBaseImponible(Utilitario.extractQuantity(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.IVESTIMENTA);
					
					} else if (checkFromActividadEconomicaSri(campoAdicional.getValue(), Constantes.ISALUD)) {
						deducible.setBaseImponible(Utilitario.extractQuantity(campoAdicional.getValue()));
						deducible.setTipoGasto(Constantes.ISALUD);
						
					} else {
						deducible.setFound(Boolean.FALSE);
						deducible.setTipoGasto(Constantes.INOT_FOUND);
					}
					
					deducibles.add(deducible);
				}
			}
		}
		
		return deducibles;
	}
	
	private Boolean checkFromActividadEconomicaSri(String pActividadEconomicaSri, Integer pTipoGasto) throws UtplException {
		Boolean isFromActividadEconomicaSri = Boolean.FALSE;
		
		if (pActividadEconomicaSri != null) {
			String tipoGastoOpstions = getTipoGastoOpstions(pTipoGasto);
			String[] tipoGastoOpstionsSplit = tipoGastoOpstions.split(Constantes.SIGNO_NUMERAL);
			
			for (int contador = Constantes.I0; contador < tipoGastoOpstionsSplit.length; contador++) {
				String tipoGasto = tipoGastoOpstionsSplit[contador];
				
				if (StringUtils.stripAccents(pActividadEconomicaSri).toLowerCase().contains(tipoGasto.toLowerCase())) {
					isFromActividadEconomicaSri = Boolean.TRUE;
					break;
				}
			}
		}
		
		return isFromActividadEconomicaSri;
	}
	
	private String getTipoGastoOpstions(Integer pTipoGasto) throws UtplException {
		String tipoGastoOpstions = null;
		
		if (Constantes.IALIMENTACION.equals(pTipoGasto)) {
			tipoGastoOpstions = fwGestor.obtenerParametroGeneral(Constantes.SESSION_OPTIONS_ALIMENTACION).getValor();
			
		} else if (Constantes.ISALUD.equals(pTipoGasto)) {
			tipoGastoOpstions = fwGestor.obtenerParametroGeneral(Constantes.SESSION_OPTIONS_SALUD).getValor();
			
		} else if (Constantes.IEDUCACION.equals(pTipoGasto)) {
			tipoGastoOpstions = fwGestor.obtenerParametroGeneral(Constantes.SESSION_OPTIONS_EDUCACION).getValor();
			
		} else if (Constantes.IVESTIMENTA.equals(pTipoGasto)) {
			tipoGastoOpstions = fwGestor.obtenerParametroGeneral(Constantes.SESSION_OPTIONS_VESTIMENTA).getValor();
			
		} else if (Constantes.IVIVIENDA.equals(pTipoGasto)) {
			tipoGastoOpstions = fwGestor.obtenerParametroGeneral(Constantes.SESSION_OPTIONS_VIVIENDA).getValor();
		}
		
		return tipoGastoOpstions;
	}

}
