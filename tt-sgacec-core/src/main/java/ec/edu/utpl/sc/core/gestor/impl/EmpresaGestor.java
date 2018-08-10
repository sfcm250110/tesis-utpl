package ec.edu.utpl.sc.core.gestor.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.entity.Usuario;
import ec.edu.utpl.sc.core.entity.UsuarioEmpresa;
import ec.edu.utpl.sc.core.gestor.IComprobanteEmpresaGestor;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.gestor.IHttpGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Repository(Constantes.EMPRESA_GESTOR)
public class EmpresaGestor implements IEmpresaGestor {
	
	private static Logger log = Logger.getLogger(EmpresaGestor.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_EMPRESA_GESTOR)
	private IComprobanteEmpresaGestor comprobanteEmpresaGestor;
	
	@Autowired
	@Qualifier(Constantes.HTTP_GESTOR)
	private IHttpGestor httpGestor;

	@Override
	public void crearEmpresa(Empresa pEmpresa) throws UtplException {
		try {
			pEmpresa.setEstado(Boolean.FALSE);
			pEmpresa.setFechaDownload(pEmpresa.getFechaInitDownload());
			crudDao.create(pEmpresa);
			
			comprobanteEmpresaGestor.crearTableEmpresa(pEmpresa.getRuc());
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Empresa obtenerEmpresaActiva(String pRuc) throws UtplException {
		try {
			Empresa empresa = new Empresa();
			empresa.setEstado(Boolean.TRUE);
			empresa.setRuc(pRuc);
			empresa = crudDao.findOneRow(empresa, Boolean.FALSE);
			
			return empresa;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<Empresa> obtenerEmpresasActiva() throws UtplException {
		try {
			List<Empresa> empresasFind = obtenerEmpresas();
			List<Empresa> empresas = new ArrayList<Empresa>();
			
			if (empresasFind != null && !empresasFind.isEmpty()) {
				for (Empresa empresa : empresasFind) {
					
					if (empresa.getEstado()) {
						empresas.add(empresa);
					}
				}
			}
			
			return empresas;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<Empresa> obtenerEmpresas() throws UtplException {
		try {
			List<Empresa> empresasFind = crudDao.findForCriteria(new Empresa(), Boolean.TRUE);
			List<Empresa> empresas = new ArrayList<Empresa>();
			
			if (empresasFind != null && !empresasFind.isEmpty()) {
				for (Empresa empresa : empresasFind) {
					
					if (!Constantes.ID_EMPRESA_DEFAULT.equals(empresa.getIdEmpresa())) {
						empresas.add(empresa);
					}
				}
			}
			
			return empresas;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Boolean usuarioEmpresaActivo(Long pIdEmpresa) throws UtplException {
		try {
			Boolean usuarioEmpresaActivo = Boolean.FALSE;
			
			Empresa empresa = new Empresa();
			empresa.setIdEmpresa(pIdEmpresa);
			
			UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
			usuarioEmpresa.setEmpresa(empresa);
			usuarioEmpresa = crudDao.findOneRow(usuarioEmpresa, Boolean.FALSE);
			
			if (usuarioEmpresa != null) {
				Usuario usuario = usuarioEmpresa.getUsuario();
				
				if (usuario.getEstado()) {
					usuarioEmpresaActivo = Boolean.TRUE;
				}
			}
			
			return usuarioEmpresaActivo;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Boolean empresaActiva(String pRuc) throws UtplException {
		try {
			Boolean empresaActiva = Boolean.TRUE;
			
			Empresa empresa = new Empresa();
			empresa.setRuc(pRuc);
			empresa.setEstado(Boolean.TRUE);
			empresa = crudDao.findOneRow(empresa, Boolean.FALSE);
			
			if (empresa == null) {
				empresaActiva = Boolean.FALSE;
			}
			
			return empresaActiva;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public Empresa getEmpresaUsuario(Usuario pUsuario) throws UtplException {
		try {
			Empresa empresa = null;
			UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
			usuarioEmpresa.setUsuario(pUsuario);
			usuarioEmpresa = crudDao.findOneRow(usuarioEmpresa, Boolean.FALSE);
			
			if (usuarioEmpresa != null) {
				empresa = usuarioEmpresa.getEmpresa();
			}
			
			return empresa;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<InfoRucSri> getInfoRucsSri() throws UtplException {
		try {
			List<InfoRucSri> infoRucsSri = crudDao.findListRow(InfoRucSri.class, ConstantesDb.INFO_RUCS_SRI);
			
			return infoRucsSri;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void downloadInfoRucSri(String pMessageXml) {
		try {
			String rucEmisor = XmlUtil.xmlToRucEmisorXml(pMessageXml);
			InfoRucSri infoRucSri = httpGestor.downloadInfoRucSri(rucEmisor);
			
			if (null != infoRucSri ) {
				InfoRucSri infoRucSriFind = new InfoRucSri();
				infoRucSriFind.setRuc(infoRucSri.getRuc());
				infoRucSriFind = crudDao.findOneRow(infoRucSriFind, Boolean.FALSE);
				
				if (infoRucSriFind == null) {
					infoRucSri.setFechaRegistro(new Date());
					crudDao.create(infoRucSri);
				}
			}
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al descargar la informacion del ruc del Sri. Causa --> " + e);
		}
	}

}
