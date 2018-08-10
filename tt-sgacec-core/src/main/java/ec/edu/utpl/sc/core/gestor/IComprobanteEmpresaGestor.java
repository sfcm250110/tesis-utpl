package ec.edu.utpl.sc.core.gestor;

import java.util.List;

import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IComprobanteEmpresaGestor {

	public void crearTableEmpresa(String pRuc) throws UtplException;
	
	public String generateFacturaXml(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException;
	
	public byte[] generateFacturaPdf(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException;
	
	public List<String> getRucEmisoresByEmpresa() throws UtplException;
	
	public List<ComprobanteEmpresa> getComprobantesEmpresaClasificarAnexo() throws UtplException;

}
