package ec.edu.utpl.sc.core.servicio.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.ComprobanteFisico;
import ec.edu.utpl.sc.core.gestor.IComprobanteGestor;
import ec.edu.utpl.sc.core.servicio.IComprobanteServicio;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.COMPROBANTE_SERVICIO)
public class ComprobanteServicio implements IComprobanteServicio {
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_GESTOR)
	private IComprobanteGestor comprobanteGestor;

	@Override
	public Integer obtenerTipoComprobante(String pNombreComprobante) throws UtplException {
		return comprobanteGestor.obtenerTipoComprobante(pNombreComprobante);
	}

	@Override
	public Integer obtenerTipoEmision(String pNombreEmision) throws UtplException {
		return comprobanteGestor.obtenerTipoEmision(pNombreEmision);
	}

	@Override
	public String obtenerTagComprobanteXml(String pComprobanteXml, String pTag) throws UtplException {
		return comprobanteGestor.obtenerTagComprobanteXml(pComprobanteXml, pTag);
	}

	@Override
	public String obtenerTagComprobante(String pComprobanteXml, String pTag) throws UtplException {
		return comprobanteGestor.obtenerTagComprobante(pComprobanteXml, pTag);
	}

	@Override
	public void downloadComprobantesSri(String pMessageXml) {
		comprobanteGestor.downloadComprobantesSri(pMessageXml);
	}

	@Override
	public void downloadComprobanteSriWs(String pMsgComprobanteXml) {
		comprobanteGestor.downloadComprobanteSriWs(pMsgComprobanteXml);
	}

	@Override
	public List<ComprobanteEmpresa> getComprobantes() throws UtplException {
		return comprobanteGestor.getComprobantes();
	}

	@Override
	public void procesarTodo(List<ComprobanteEmpresa> pComprobantesEmpresa) throws UtplException {
		comprobanteGestor.procesarTodo(pComprobantesEmpresa);
	}

	@Override
	public void procesar(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException {
		comprobanteGestor.procesar(pComprobanteEmpresa);
	}

	@Override
	public List<ComprobanteEmpresa> getComprobantesEmpresa(ComprobanteEmpresa pComprobanteEmpresa, Date pFechaEmisionDesde, Date pFechaEmisionHasta) throws UtplException {
		return comprobanteGestor.getComprobantesEmpresa(pComprobanteEmpresa, pFechaEmisionDesde, pFechaEmisionHasta);
	}

	@Override
	public List<ComprobanteFisico> getComprobantesFisico(ComprobanteFisico pComprobanteFisico) throws UtplException {
		return comprobanteGestor.getComprobantesFisico(pComprobanteFisico);
	}
	
	@Override
	public void crearComprobanteFisico(ComprobanteFisico pComprobanteFisico) throws UtplException {
		comprobanteGestor.crearComprobanteFisico(pComprobanteFisico);
	}

	@Override
	public void crearComprobantesFisicos(List<ComprobanteFisico> pComprobantesFisicos) throws UtplException {
		comprobanteGestor.crearComprobantesFisicos(pComprobantesFisicos);
	}

	@Override
	public void modificarComprobanteFisico(ComprobanteFisico pComprobanteFisico) throws UtplException {
		comprobanteGestor.modificarComprobanteFisico(pComprobanteFisico);
	}

	@Override
	public List<ComprobanteEmpresa> getComprobantesEmpresaAnexo(String pRuc, String pPeriodo) throws UtplException {
		return comprobanteGestor.getComprobantesEmpresaAnexo(pRuc, pPeriodo);
	}

	@Override
	public List<ComprobanteFisico> getComprobantesFisicoAnexo(String pRuc, String pPeriodo) throws UtplException {
		return comprobanteGestor.getComprobantesFisicoAnexo(pRuc, pPeriodo);
	}

	@Override
	public void clasificarComprobanteAnexo(String pMessageXml) {
		comprobanteGestor.clasificarComprobanteAnexo(pMessageXml);		
	}

	@Override
	public List<AnexoGastoSri> findAnexosGastoSri(String pPeriodo) throws UtplException {
		return comprobanteGestor.findAnexosGastoSri(pPeriodo);
	}	

}
