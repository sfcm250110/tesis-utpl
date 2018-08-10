package ec.edu.utpl.sc.core.gestor.impl;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.IComprobanteDao;
import ec.edu.utpl.sc.core.gestor.IComprobanteGestor;
import ec.edu.utpl.sc.core.gestor.IFileGestor;
import ec.edu.utpl.sc.core.gestor.IPdfGestor;
import ec.edu.utpl.sc.core.util.Base64Util;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.FILE_GESTOR)
public class FileGestor implements IFileGestor {
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_DAO)
	private IComprobanteDao comprobanteDao;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_GESTOR)
	private IComprobanteGestor comprobanteGestor;
	
	@Autowired
	@Qualifier(Constantes.PDF_GESTOR)
	private IPdfGestor pdfGestor;

	@Override
	public void uploadComprobanteXml(File pComprobanteXml) throws UtplException {
		try {
			byte[] comprobanteXmlBytes = Files.readAllBytes(pComprobanteXml.toPath());
			String comprobanteXmlBase64 = Base64Util.encodeBytesBase64(comprobanteXmlBytes);
			String comprobanteXmlString = new String(comprobanteXmlBytes);
			String rucEmpresa = obtenerRucEmpresa(comprobanteXmlString);
			String numeroAutorizacion = comprobanteGestor.obtenerTagComprobanteXml(comprobanteXmlString, Constantes.TAG_NUMERO_AUTORIZACION);
			
			// Actualizar el archivo XML del comprobante
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_XML, comprobanteXmlBase64);
			parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, numeroAutorizacion);
			String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_XML, parameterValues);
			comprobanteDao.update(sql, rucEmpresa);
			
			// Eliminar el comprobante
			pComprobanteXml.delete();

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@Override
	public void uploadComprobantePdf(File pComprobantePdf) throws UtplException {
		try {
			byte[] comprobantePdfBytes = Files.readAllBytes(pComprobantePdf.toPath());
			String comprobantePdfBase64 = Base64Util.encodeBytesBase64(comprobantePdfBytes);
			String numeroAutorizacion = pdfGestor.obtenerNumeroAutorizacion(comprobantePdfBytes);
			String rucEmpresa = pdfGestor.obtenerRucEmpresa(comprobantePdfBytes);
			
			// Actualizar el archivo XML del comprobante
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_PDF, comprobantePdfBase64);
			parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, numeroAutorizacion);
			String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_PDF, parameterValues);
			comprobanteDao.update(sql, rucEmpresa);
			
			// Eliminar el comprobante
			pComprobantePdf.delete();

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	private String obtenerRucEmpresa(String pComprobanteXmlString) throws UtplException {
		String tipoIdentificacionComprador = comprobanteGestor.obtenerTagComprobante(pComprobanteXmlString, Constantes.TAG_TIPO_IDENTIFICACION_COMPRADOR);
		String identificacionComprador = comprobanteGestor.obtenerTagComprobante(pComprobanteXmlString, Constantes.TAG_IDENTIFICACION_COMPRADOR);
		String rucEmpresa = null;
		
		if (Constantes.TIPO_IDENTIFICACION_COMPRADOR_RUC.equals(tipoIdentificacionComprador)) {
			rucEmpresa = identificacionComprador;
			
		} else if (Constantes.TIPO_IDENTIFICACION_COMPRADOR_CEDULA.equals(tipoIdentificacionComprador)) {
			rucEmpresa = identificacionComprador + Constantes.SUFIJO_RUC;
		}
		
		return rucEmpresa;
	}

}
