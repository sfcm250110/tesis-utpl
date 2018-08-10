package ec.edu.utpl.sc.core.gestor.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.IComprobanteDao;
import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.gestor.IComprobanteEmpresaGestor;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.gestor.IPdfGestor;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.CssUtil;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Repository(Constantes.COMPROBANTE_EMPRESA_GESTOR)
public class ComprobanteEmpresaGestor implements IComprobanteEmpresaGestor {
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_DAO)
	private IComprobanteDao comprobanteDao;
	
	@Autowired
	@Qualifier(Constantes.EMPRESA_GESTOR)
	private IEmpresaGestor empresaGestor;
	
	@Autowired
	@Qualifier(Constantes.PDF_GESTOR)
	private IPdfGestor pdfGestor;

	@Override
	public void crearTableEmpresa(String pRuc) throws UtplException {
		comprobanteDao.excuteFunction(ConstantesDb.NAME_FUNCTION_CREATE_TABLE_COMPROBANTE, pRuc);
	}
	
	@Override
	public String generateFacturaXml(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException {
		try {
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, pComprobanteEmpresa.getNumeroAutorizacion());
			String sql = DaoUtil.buildSqlParameters(ConstantesDb.XML_COMPROBANTE_EMPRESA_NA, parameterValues);
			ComprobanteEmpresa comprobanteEmpresa = comprobanteDao.findOneRow(sql, pComprobanteEmpresa.getRuc());
			String fileXml = comprobanteEmpresa.getXml();
			
			return fileXml;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public byte[] generateFacturaPdf(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException {
		try {
			String xml = XmlUtil.generateXmlFactura(generateFacturaXml(pComprobanteEmpresa), pComprobanteEmpresa);
			String xsl = CssUtil.getContentCssSessionToString(Constantes.ID_SESSION_PLANTILLA_FACTURA_XSL);
			byte[] filePdf = pdfGestor.createFilePdf(xml.toString(), xsl);
			
			return filePdf;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<String> getRucEmisoresByEmpresa() throws UtplException {
		try {
			List<String> rucEmisores = new ArrayList<String>();
			
			// Obtener todos los RUC de las empresas registradas
			List<Empresa> empresas = crudDao.findListRow(Empresa.class, ConstantesDb.RUCS_EMPRESA);
			
			if (empresas != null && !empresas.isEmpty()) {
				for (Empresa empresa : empresas) {
					// Obtener todos los RUC de los Emisores de cada empresa registrada
					List<ComprobanteEmpresa> comprobantesEmpresa = comprobanteDao.findListRow(ConstantesDb.RUC_EMISORES, empresa.getRuc());
					
					if (comprobantesEmpresa != null && !comprobantesEmpresa.isEmpty()) {
						for (ComprobanteEmpresa comprobanteEmpresa : comprobantesEmpresa) {
							rucEmisores.add(comprobanteEmpresa.getRucEmisor());
						}
					}
				}
			}
			
			return rucEmisores;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<ComprobanteEmpresa> getComprobantesEmpresaClasificarAnexo() throws UtplException {
		try {
			List<ComprobanteEmpresa> comprobantesEmpresa = new ArrayList<ComprobanteEmpresa>();
			List<ComprobanteEmpresa> comprobantesEmpresaTmp = new ArrayList<ComprobanteEmpresa>();
			
			// Obtener todos los RUC de las empresas registradas
			List<Empresa> rucsEmpresa = crudDao.findListRow(Empresa.class, ConstantesDb.RUCS_EMPRESA);
			
			if (rucsEmpresa != null && !rucsEmpresa.isEmpty()) {
				
				for (Empresa rucEmpresa : rucsEmpresa) {
					// Obtener todos los comprobantes de cada empresa registrada
					List<ComprobanteEmpresa> comprobantesEmpresaFind = comprobanteDao.findListRow(ConstantesDb.COMPROBANTES_EMPRESA_CLASIFICAR, rucEmpresa.getRuc());
					
					if (comprobantesEmpresaFind != null && !comprobantesEmpresaFind.isEmpty()) {
						comprobantesEmpresaTmp.addAll(comprobantesEmpresaFind);
					}
				}
				
				// Verificar si ya se descargo la informacion del ruc para cada comprobante
				if (null != comprobantesEmpresaTmp && !comprobantesEmpresaTmp.isEmpty()) {
					for (ComprobanteEmpresa comprobanteEmpresa : comprobantesEmpresaTmp) {
						InfoRucSri infoRucSri = new InfoRucSri();
						infoRucSri.setRuc(comprobanteEmpresa.getRucEmisor());
						infoRucSri = crudDao.findOneRow(infoRucSri, Boolean.FALSE);
						
						if (infoRucSri != null) {
							comprobantesEmpresa.add(comprobanteEmpresa);
						}
					}
				}
			}
			
			return comprobantesEmpresa;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
