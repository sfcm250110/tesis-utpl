package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.RolUsuario;
import ec.edu.utpl.sc.core.entity.ValorMaximoRubroSri;
import ec.edu.utpl.sc.core.gestor.IConsultasGestor;
import ec.edu.utpl.sc.core.servicio.IConsultasServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.Periodo;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.CONSULTAS_SERVICIO)
public class ConsultasServicio implements IConsultasServicio {

	@Override
	public List<CheckDownloadSri> obtenerChecksDownloadSri(Integer pEtapa) throws UtplException {
		return consultasGestor.obtenerChecksDownloadSri(pEtapa);
	}
	
	@Autowired
	@Qualifier(Constantes.CONSULTAS_GESTOR)
	private IConsultasGestor consultasGestor;

	@Override
	public List<CheckDownloadSri> obtenerChecksDownloadSri(Integer pEtapa, Integer pTotalFilas) throws UtplException {
		return consultasGestor.obtenerChecksDownloadSri(pEtapa, pTotalFilas);
	}
	
	@Override
	public RolUsuario obtenerRolUsuario(String pUserName) throws UtplException {
		return consultasGestor.obtenerRolUsuario(pUserName);
	}

	@Override
	public List<Empresa> obtenerEmpresasUsuario(Long pIdUsuario) throws UtplException {
		return consultasGestor.obtenerEmpresasUsuario(pIdUsuario);
	}

	@Override
	public List<Periodo> getPeriodos() throws UtplException {
		return consultasGestor.getPeriodos();
	}

	@Override
	public List<ValorMaximoRubroSri> getValoresMaximoRubroSri(String pPeriodo) throws UtplException {
		return consultasGestor.getValoresMaximoRubroSri(pPeriodo);
	}

}
