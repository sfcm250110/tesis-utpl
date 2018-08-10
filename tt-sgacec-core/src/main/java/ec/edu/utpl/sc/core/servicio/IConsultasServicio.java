package ec.edu.utpl.sc.core.servicio;

import java.util.List;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.RolUsuario;
import ec.edu.utpl.sc.core.entity.ValorMaximoRubroSri;
import ec.edu.utpl.sc.core.util.Periodo;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IConsultasServicio {
	
	public List<CheckDownloadSri> obtenerChecksDownloadSri(Integer pEtapa) throws UtplException;
	
	public List<CheckDownloadSri> obtenerChecksDownloadSri(Integer pEtapa, Integer pTotalFilas) throws UtplException;
	
	public RolUsuario obtenerRolUsuario(String pUserName) throws UtplException;
	
	public List<Empresa> obtenerEmpresasUsuario(Long pIdUsuario) throws UtplException;
	
	public List<Periodo> getPeriodos() throws UtplException;
	
	public List<ValorMaximoRubroSri> getValoresMaximoRubroSri(String pPeriodo) throws UtplException;

}
