package ec.edu.utpl.sc.core.gestor;

import java.util.Date;
import java.util.List;

import ec.edu.utpl.sc.core.entity.ComprobanteFisico;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IComprobanteGestor {
	
	public Integer obtenerTipoComprobante(String pNombreComprobante) throws UtplException;
	
	public Integer obtenerTipoEmision(String pNombreEmision) throws UtplException;
	
	public String obtenerTagComprobanteXml(String pComprobanteXml, String pTag) throws UtplException;
	
	public String obtenerTagComprobante(String pComprobanteXml, String pTag) throws UtplException;
	
	public void downloadComprobantesSri(String pMessageXml);
	
	public void downloadComprobanteSriWs(String pMsgComprobanteXml);
	
	public List<ComprobanteEmpresa> getComprobantes() throws UtplException;
	
	public void procesarTodo(List<ComprobanteEmpresa> pComprobantesEmpresa) throws UtplException;
	
	public void procesar(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException;
	
	public List<ComprobanteEmpresa> getComprobantesEmpresa(ComprobanteEmpresa pComprobanteEmpresa, Date pFechaEmisionDesde, Date pFechaEmisionHasta) throws UtplException;
	
	public List<ComprobanteFisico> getComprobantesFisico(ComprobanteFisico pComprobanteFisico) throws UtplException;
	
	public void crearComprobanteFisico(ComprobanteFisico pComprobanteFisico) throws UtplException;
	
	public void crearComprobantesFisicos(List<ComprobanteFisico> pComprobantesFisicos) throws UtplException;
	
	public void modificarComprobanteFisico(ComprobanteFisico pComprobanteFisico) throws UtplException;
	
	public List<ComprobanteEmpresa> getComprobantesEmpresaAnexo(String pRuc, String pPeriodo) throws UtplException;
	
	public List<ComprobanteFisico> getComprobantesFisicoAnexo(String pRuc, String pPeriodo) throws UtplException;
	
	public void clasificarComprobanteAnexo(String pMessageXml);
	
	public List<AnexoGastoSri> findAnexosGastoSri(String pPeriodo) throws UtplException;

}
