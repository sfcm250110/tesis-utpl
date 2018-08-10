package ec.edu.utpl.sc.core.dao;

import java.util.List;

import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IComprobanteDao {
	
	public void create(ComprobanteEmpresa pComprobanteEmpresa, String pRucEmpresa) throws UtplException;
	
	public void update(String pSql, String pRucEmpresa) throws UtplException;
	
	public void delete(ComprobanteEmpresa pComprobanteEmpresa, String pRucEmpresa) throws UtplException;
	
	public ComprobanteEmpresa findOneRow(String pSql, String pRucEmpresa) throws UtplException;
	
	public List<ComprobanteEmpresa> findListRow(String pSql, String pRucEmpresa) throws UtplException;
	
	public void excuteFunction(String pFunctionName, String pRucEmpresa) throws UtplException;
	
	public List<AnexoGastoSri> findAnexosGastoSri(String pPeriodo, String pRucEmpresa) throws UtplException;

}
