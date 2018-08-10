package ec.edu.utpl.sc.core.servicio;

import java.util.List;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IEmpresaServicio {
	
	public void crearEmpresa(Empresa pEmpresa) throws UtplException;
	
	public Empresa obtenerEmpresaActiva(String pRuc) throws UtplException;
	
	public List<Empresa> obtenerEmpresasActiva() throws UtplException;
	
	public List<Empresa> obtenerEmpresas() throws UtplException;
	
	public Boolean usuarioEmpresaActivo(Long pIdEmpresa) throws UtplException;
	
	public Boolean empresaActiva(String pRuc) throws UtplException;
	
	public Empresa getEmpresaUsuario(Usuario pUsuario) throws UtplException;
	
	public List<InfoRucSri> getInfoRucsSri() throws UtplException;
	
	public void downloadInfoRucSri(String pMessageXml);

}
