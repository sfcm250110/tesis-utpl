package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.servicio.IEmpresaServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.EMPRESA_SERVICIO)
public class EmpresaServicio implements IEmpresaServicio {
	
	@Autowired
	@Qualifier(Constantes.EMPRESA_GESTOR)
	private IEmpresaGestor empresaGestor;

	@Override
	public void crearEmpresa(Empresa pEmpresa) throws UtplException {
		empresaGestor.crearEmpresa(pEmpresa);
	}
	
	@Override
	public Empresa obtenerEmpresaActiva(String pRuc) throws UtplException {
		return empresaGestor.obtenerEmpresaActiva(pRuc);
	}

	@Override
	public List<Empresa> obtenerEmpresasActiva() throws UtplException {
		return empresaGestor.obtenerEmpresasActiva();
	}

	@Override
	public List<Empresa> obtenerEmpresas() throws UtplException {
		return empresaGestor.obtenerEmpresas();
	}

	@Override
	public Boolean usuarioEmpresaActivo(Long pIdEmpresa) throws UtplException {
		return empresaGestor.usuarioEmpresaActivo(pIdEmpresa);
	}

	@Override
	public Boolean empresaActiva(String pRuc) throws UtplException {
		return empresaGestor.empresaActiva(pRuc);
	}

	@Override
	public Empresa getEmpresaUsuario(Usuario pUsuario) throws UtplException {
		return empresaGestor.getEmpresaUsuario(pUsuario);
	}

	@Override
	public List<InfoRucSri> getInfoRucsSri() throws UtplException {
		return empresaGestor.getInfoRucsSri();
	}

	@Override
	public void downloadInfoRucSri(String pMessageXml) {
		empresaGestor.downloadInfoRucSri(pMessageXml);
	}	

}
