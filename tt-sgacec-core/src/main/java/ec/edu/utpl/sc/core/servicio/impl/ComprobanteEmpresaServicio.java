package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.gestor.IComprobanteEmpresaGestor;
import ec.edu.utpl.sc.core.servicio.IComprobanteEmpresaServicio;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.COMPROBANTE_EMPRESA_SERVICIO)
public class ComprobanteEmpresaServicio implements IComprobanteEmpresaServicio {
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_EMPRESA_GESTOR)
	private IComprobanteEmpresaGestor comprobanteEmpresaGestor;

	@Override
	public void crearTableEmpresa(String pRuc) throws UtplException {
		comprobanteEmpresaGestor.crearTableEmpresa(pRuc);
	}

	@Override
	public String generateFacturaXml(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException {
		return comprobanteEmpresaGestor.generateFacturaXml(pComprobanteEmpresa);
	}

	@Override
	public byte[] generateFacturaPdf(ComprobanteEmpresa pComprobanteEmpresa) throws UtplException {
		return comprobanteEmpresaGestor.generateFacturaPdf(pComprobanteEmpresa);
	}

	@Override
	public List<String> getRucEmisoresByEmpresa() throws UtplException {
		return comprobanteEmpresaGestor.getRucEmisoresByEmpresa();
	}

	@Override
	public List<ComprobanteEmpresa> getComprobantesEmpresaClasificarAnexo() throws UtplException {
		return comprobanteEmpresaGestor.getComprobantesEmpresaClasificarAnexo();
	}

}
