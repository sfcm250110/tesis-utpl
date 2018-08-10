package ec.edu.utpl.sc.core.gestor.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.entity.RolUsuario;
import ec.edu.utpl.sc.core.entity.ValorMaximoRubroSri;
import ec.edu.utpl.sc.core.gestor.IConsultasGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.DateUtil;
import ec.edu.utpl.sc.core.util.Periodo;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.CONSULTAS_GESTOR)
public class ConsultasGestor implements IConsultasGestor {
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Override
	public List<CheckDownloadSri> obtenerChecksDownloadSri(Integer pEtapa) throws UtplException {
		Map<String, String> parameterValues = new HashMap<String, String>();
		parameterValues.put(ConstantesDb.PARAM_ETAPA, pEtapa.toString());
		List<Object> checksDownloadSriObject = crudDao.findSqlEjbObject(DaoUtil.buildSqlParameters(ConstantesDb.CHECK_DOWNLOAD_SRI_ETAPA_EJBQL, parameterValues));
		List<CheckDownloadSri> checksDownloadSri = null;
		
		if (checksDownloadSriObject != null && !checksDownloadSriObject.isEmpty()) {
			checksDownloadSri = new ArrayList<CheckDownloadSri>();
			
			for (Object checkDownloadSriObject : checksDownloadSriObject) {
				Object[] checkDownloadSriObjectArray = (Object[]) checkDownloadSriObject;
				
				CheckDownloadSri checkDownloadSri = new CheckDownloadSri();
				checkDownloadSri.setIdCheckDownloadSri(Long.parseLong(checkDownloadSriObjectArray[Constantes.I0].toString()));
				checkDownloadSri.setRuc(checkDownloadSriObjectArray[Constantes.I1].toString());
				checkDownloadSri.setFechaDownload(DateUtil.parseStringToDate(checkDownloadSriObjectArray[Constantes.I2].toString(), Constantes.YYYY_MM_DD));
				
				checksDownloadSri.add(checkDownloadSri);
			}
		}
		
		return checksDownloadSri;
	}

	@Override
	public List<CheckDownloadSri> obtenerChecksDownloadSri(Integer pEtapa, Integer pTotalFilas) throws UtplException {
		Map<String, String> parameterValues = new HashMap<String, String>();
		parameterValues.put(ConstantesDb.PARAM_ETAPA, pEtapa.toString());
		parameterValues.put(ConstantesDb.PARAM_TOTAL_FILAS, pTotalFilas.toString());
		List<Object> checksDownloadSriObject = crudDao.findSqlEjbObject(DaoUtil.buildSqlParameters(ConstantesDb.CHECK_DOWNLOAD_SRI_EJBQL, parameterValues));
		List<CheckDownloadSri> checksDownloadSri = null;
		
		if (checksDownloadSriObject != null && !checksDownloadSriObject.isEmpty()) {
			checksDownloadSri = new ArrayList<CheckDownloadSri>();
			
			for (Object checkDownloadSriObject : checksDownloadSriObject) {
				Object[] checkDownloadSriObjectArray = (Object[]) checkDownloadSriObject;
				
				CheckDownloadSri checkDownloadSri = new CheckDownloadSri();
				checkDownloadSri.setIdCheckDownloadSri(Long.parseLong(checkDownloadSriObjectArray[Constantes.I0].toString()));
				checkDownloadSri.setRuc(checkDownloadSriObjectArray[Constantes.I1].toString());
				checkDownloadSri.setFechaDownload(DateUtil.parseStringToDate(checkDownloadSriObjectArray[Constantes.I2].toString(), Constantes.YYYY_MM_DD));
				
				checksDownloadSri.add(checkDownloadSri);
			}
		}
		
		return checksDownloadSri;
	}

	@Override
	public RolUsuario obtenerRolUsuario(String pUserName) throws UtplException {
		try {
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_USER_NAME, pUserName);
			List<RolUsuario> rolesUsuario = crudDao.findSqlEjb(DaoUtil.buildSqlParameters(ConstantesDb.ROL_USUARIO_EJBQL, parameterValues));
			RolUsuario rolUsuario = null;
			
			if (rolesUsuario != null && !rolesUsuario.isEmpty()) {
				rolUsuario = rolesUsuario.get(Constantes.I0);
			}
			
			return rolUsuario;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public void changeKey(String pUserName, String pClave) throws UtplException {
		try {
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_USER_NAME, pUserName);
			parameterValues.put(ConstantesDb.PARAM_CLAVE_UNO, pClave);
			
			crudDao.updateNativeQuery(DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_NQ_CLAVE_USUARIO, parameterValues));
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<Empresa> obtenerEmpresasUsuario(Long pIdUsuario) throws UtplException {
		try {
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_ID_USUARIO, pIdUsuario.toString());
			List<Empresa> empresas = crudDao.findSqlEjb(DaoUtil.buildSqlParameters(ConstantesDb.EMPRESAS_USUARIO_EJBQL, parameterValues));
			
			return empresas;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<Periodo> getPeriodos() throws UtplException {
		try {
			List<Periodo> periodos = new ArrayList<Periodo>();
			List<ValorMaximoRubroSri> valoresMaximoRubroSri = crudDao.findListRow(ValorMaximoRubroSri.class, ConstantesDb.GET_PERIODOS);
			
			if (null != valoresMaximoRubroSri && !valoresMaximoRubroSri.isEmpty()) {
				
				for (ValorMaximoRubroSri valorMaximoRubroSri : valoresMaximoRubroSri) {
					Periodo periodo = new Periodo();
					periodo.setName(valorMaximoRubroSri.getPeriodo());
					periodo.setValue(valorMaximoRubroSri.getPeriodo());
					periodos.add(periodo);
				}
			}
			
			return periodos;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<ValorMaximoRubroSri> getValoresMaximoRubroSri(String pPeriodo) throws UtplException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("Select v.idValorMaximoRubroSri As idValorMaximoRubroSri, v.rubro As rubro, periodo As periodo, v.valor As valor, v.estado As estado, v.fechaRegistro As fechaRegistro, v.fechaModificacion As fechaModificacion ");
			sql.append("From ValorMaximoRubroSri v ");
			sql.append("Where 1 = 1 ");
			
			if (null != pPeriodo && !pPeriodo.isEmpty()) {
				sql.append("And v.periodo = '").append(pPeriodo).append("' ");
			}
			
			sql.append("Order By v.periodo, v.rubro ");
			
			List<ValorMaximoRubroSri> valoresMaximoRubroSri = crudDao.findListRow(ValorMaximoRubroSri.class, sql.toString());
			
			return valoresMaximoRubroSri;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
