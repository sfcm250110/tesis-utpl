package ec.edu.utpl.sc.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ParameterMode;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.sc.core.dao.IComprobanteDao;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.COMPROBANTE_DAO)
public class ComprobanteDao implements IComprobanteDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void create(ComprobanteEmpresa pComprobanteEmpresa, String pRucEmpresa) throws UtplException {
		try {
			String sql = DaoUtil.buildSqlTableEmpresa(ConstantesDb.INSERT_COMPROBANTE_XML, pRucEmpresa);
			
			Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setParameter("pClaveAcceso", pComprobanteEmpresa.getClaveAcceso());
			query.setParameter("pEstablecimiento", pComprobanteEmpresa.getEstablecimiento());
			query.setParameter("pFechaAutorizacion", pComprobanteEmpresa.getFechaAutorizacion());
			query.setParameter("pFechaEmision", pComprobanteEmpresa.getFechaEmision());
			query.setParameter("pFechaRegistro", pComprobanteEmpresa.getFechaRegistro());
			query.setParameter("pFila", pComprobanteEmpresa.getFila());
			query.setParameter("pNumeroAutorizacion", pComprobanteEmpresa.getNumeroAutorizacion());
			query.setParameter("pPuntoEmision", pComprobanteEmpresa.getPuntoEmision());
			query.setParameter("pRazonSocialEmisor", pComprobanteEmpresa.getRazonSocialEmisor());
			query.setParameter("pRucEmisor", pComprobanteEmpresa.getRucEmisor());
			query.setParameter("pSecuencial", pComprobanteEmpresa.getSecuencial());
			query.setParameter("pTipo", pComprobanteEmpresa.getTipo());
			query.setParameter("pTipoEmision", pComprobanteEmpresa.getTipoEmision());
			query.setParameter("pRuc", pRucEmpresa);
			query.setParameter("pEstado", Constantes.REGISTRADO);
			query.setParameter("pSrc", pComprobanteEmpresa.getSrc());
			query.setParameter("pClasificado", pComprobanteEmpresa.getClasificado());
			query.executeUpdate();
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@Transactional
	@Override
	public void update(String pSql, String pRucEmpresa) throws UtplException {
		try {
			pSql = DaoUtil.buildSqlTableEmpresa(pSql, pRucEmpresa);
			Query query = sessionFactory.getCurrentSession().createSQLQuery(pSql);
			query.executeUpdate();
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	@Override
	public void delete(ComprobanteEmpresa pComprobanteEmpresa, String pRucEmpresa) throws UtplException {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public ComprobanteEmpresa findOneRow(String pSql, String pRucEmpresa) throws UtplException {
		try {
			List<ComprobanteEmpresa> comprobantesEmpresa = findListRow(pSql, pRucEmpresa);
			ComprobanteEmpresa comprobanteEmpresa = null;
			
			if (comprobantesEmpresa != null && !comprobantesEmpresa.isEmpty()) {
				comprobanteEmpresa = comprobantesEmpresa.get(Constantes.I0);
			}
			
			return comprobanteEmpresa;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public List<ComprobanteEmpresa> findListRow(String pSql, String pRucEmpresa) throws UtplException {
		try {
			pSql = DaoUtil.buildSqlTableEmpresa(pSql, pRucEmpresa);
			
			SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(pSql);
			sqlQuery.setResultTransformer(Transformers.aliasToBean(ComprobanteEmpresa.class));
			
			List<String> scalars = DaoUtil.getFieldsScalar(pSql);
			for (String scalar : scalars) {
				sqlQuery.addScalar(scalar);
			}
			
			List<ComprobanteEmpresa> comprobantesEmpresa = sqlQuery.list();
			
			return comprobantesEmpresa;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	@Transactional
	public void excuteFunction(String pFunctionName, String pRucEmpresa) throws UtplException {
		try {
			ProcedureCall procedureCall = sessionFactory.getCurrentSession().createStoredProcedureCall(pFunctionName);
			procedureCall.registerParameter(ConstantesDb.PARAM_FUNCTION_RUC, String.class, ParameterMode.IN).bindValue(pRucEmpresa);
			procedureCall.getOutputs();
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public List<AnexoGastoSri> findAnexosGastoSri(String pPeriodo, String pRucEmpresa) throws UtplException {
		try {
			Map<String, String> parameterValues = new HashMap<String, String>();
			parameterValues.put(ConstantesDb.PARAM_PERIODO, pPeriodo.toString());
			
			String sql = DaoUtil.buildSqlParameters(ConstantesDb.ANEXO_GASTOS_ELECTRONICO, parameterValues);
			sql = DaoUtil.buildSqlTableEmpresa(sql, pRucEmpresa);
			
			SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
			sqlQuery.setResultTransformer(Transformers.aliasToBean(AnexoGastoSri.class));
			
			List<String> scalars = DaoUtil.getFieldsScalar(sql);
			for (String scalar : scalars) {
				sqlQuery.addScalar(scalar);
			}
			
			List<AnexoGastoSri> anexosGastoSri = sqlQuery.list();
			
			return anexosGastoSri;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
