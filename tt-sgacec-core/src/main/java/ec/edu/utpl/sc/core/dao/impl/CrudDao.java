package ec.edu.utpl.sc.core.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.utpl.sc.core.base.EntityBase;
import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.UtplException;

@SuppressWarnings(Constantes.DEPRECATION)
@Repository(Constantes.CRUD_DAO)
public class CrudDao implements ICrudDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Crear un objeto del modelo
	 * 
	 * @param pEntity Clase del modelo
	 */
	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	@Transactional
	public <T extends EntityBase> T create(T pEntity) throws UtplException {
		pEntity = (T) sessionFactory.getCurrentSession().merge(pEntity);
		
		return pEntity;
	}

	/**
	 * Actualiza un objeto del modelo
	 * 
	 * @param pEntity Clase del modelo
	 */
	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	@Transactional
	public <T extends EntityBase> T update(T pEntity) throws UtplException {
		pEntity = (T) sessionFactory.getCurrentSession().merge(pEntity);
		
		return pEntity;
	}
	
	/**
	 * Actualiza un objeto del modelo
	 * 
	 * @param pEntity Clase del modelo
	 */
	@Override
	@Transactional
	public <T extends EntityBase> Integer updateFields(T pEntity) throws UtplException {
		try {
			StringBuilder updateSql = new StringBuilder();
			updateSql.append(Constantes.DML_UPDATE);
			updateSql.append(Constantes.SPACE_BLANK);
			updateSql.append(pEntity.getClass().getSimpleName());
			updateSql.append(Constantes.SPACE_BLANK);
			updateSql.append(Constantes.DML_SET);
			updateSql.append(Constantes.SPACE_BLANK);
			updateSql.append(DaoUtil.getFieldsUpdate(pEntity));
			updateSql.append(Constantes.SPACE_BLANK);
			updateSql.append(Constantes.DML_WHERE);
			updateSql.append(Constantes.SPACE_BLANK);
			updateSql.append(DaoUtil.getFieldsWhere(pEntity));
			
			Query query = sessionFactory.getCurrentSession().createQuery(updateSql.toString());
			
			return query.executeUpdate();
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	/**
	 * Elimina un objeto del modelo
	 * 
	 * @param pEntity Clase del modelo
	 */
	@Override
	@Transactional
	public <T extends EntityBase> void delete(T pEntity) throws UtplException {
		sessionFactory.getCurrentSession().delete(pEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public EntityBase find(EntityBase pEntity) throws UtplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public EntityBase find(EntityBase pEntity, String... pPropiedades) throws UtplException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Recupera una lista de objetos del modelo de acuerdo a una lista de criterios no excluyentes
	 * 
	 * @param atributos Mapeo atributo / valor
	 * @return Lista con los objetos encontrados
	 */
	@Override
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Boolean pFilter) throws UtplException {
		List<T> entidades = null;
		
		try {
			Criteria criteria = DaoUtil.getFindCriteria(sessionFactory, pEntity, pFilter);
			entidades = (List<T>) criteria.list();

		} catch (Exception e) {
			throw new UtplException(e);
			
		}

		return entidades;
	}

	/**
	 * Recupera una lista de objetos del modelo de acuerdo a una lista de criterios no excluyentes
	 * 
	 * @param atributos Mapeo atributo / valor
	 * @return Lista con los objetos encontrados
	 */
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> List<T> findForCriteria(Map<String, Object> pAtributos, T pEntity, Boolean pFilter) throws UtplException {
		List<T> entities = null;
		
		try {
			Criteria criteria = DaoUtil.getFindCriteria(sessionFactory, pEntity, pFilter);

			if (!pAtributos.isEmpty()) {
				Set<String> key = pAtributos.keySet();

				for (Object clave : key) {
					
					if (pAtributos.get(clave).toString().indexOf(Constantes.PORCENTAJE) >= 0) {
						criteria.add(Expression.like(clave + Constantes.STRING_EMPTY, pAtributos.get(clave)));
						
					} else if (pAtributos.get(clave).toString().trim().equalsIgnoreCase(Constantes.NULL)) {
						criteria.add(Expression.isNull(clave + Constantes.STRING_EMPTY));
						
					} else if (pAtributos.get(clave).toString().trim().equalsIgnoreCase(Constantes.NOT_NULL)) {
						criteria.add(Expression.isNotNull(clave + Constantes.STRING_EMPTY));
						
					} else {
						criteria.add(Expression.eq(clave + Constantes.STRING_EMPTY, pAtributos.get(clave)));						
					}
				}
			}

			entities = (List<T>) criteria.list();

		} catch (Exception e) {
			throw new UtplException(e);
			
		}

		return entities;
	}

	/**
	 * Recupera solo un objeto del modelo, con un solo criterio de busqueda
	 * 
	 * @param pEntity
	 * @return Objeto del modelo encontrado
	 * @throws UtplException En caso de ocurrir un error en el proceso de busqueda
	 */
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> T findOneRow(T pEntity, Boolean pFilter) throws UtplException {
		try {
			Criteria criteria = DaoUtil.getFindCriteria(sessionFactory, pEntity, pFilter);
			criteria = pFilter ? DaoUtil.getFieldsQuery(pEntity, criteria) : criteria;
			T entidadRecuperada = (T) criteria.uniqueResult();
			
			return entidadRecuperada;
				
		} catch (Exception e) {
			throw new UtplException("[findOneRow(pEntity)]: " + pEntity.getClass().getName(), e);
		}
	}

	/**
	 * Recupera una lista de objetos del modelo mediante una consulta sql nativa
	 * 
	 * @param pSqlNative
	 * @return Lista de objetos del modelo
	 * @throws UtplException En caso de ocurrir un error en el proceso de busqueda
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Object> findNativeSql(String pSqlNative) throws UtplException {
		try {
			//TODO:
			return null;
			
		} catch (Exception e) {
			throw new UtplException("[findNativeSql(pSqlNative)]: " + pSqlNative, e);
			
		}
	}

	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> List<T> findSqlEjb(String pSqlEjb) throws UtplException {
		Query query = sessionFactory.getCurrentSession().createQuery(pSqlEjb);
		List<T> filas = query.list();
		
		return filas;
	}
	
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public List<Object> findSqlEjbObject(String pSqlEjb) throws UtplException {
		Query query = sessionFactory.getCurrentSession().createQuery(pSqlEjb);
		List<Object> filas = query.list();
		
		return filas;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Map<String, Object>> findSqlNativeCriteria(String pSqlNative, Map<String, Object> pCriteriaSql) throws UtplException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> List<T> findSqlEjbIn(String pEjbql, String pPropiedadIn, List<Integer> pListIn) throws UtplException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> T findOneRow(Class<T> pClassEntity, String pSql) throws UtplException {
		try {
			List<T> rows = findListRow(pClassEntity, pSql);
			T row = null;
			
			if (rows != null && !rows.isEmpty()) {
				row = rows.get(Constantes.I0);
			}
			
			return row;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> List<T> findListRow(Class<T> pClassEntity, String pSql) throws UtplException {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(pSql);
			query.setResultTransformer(Transformers.aliasToBean(pClassEntity));
			List<T> rows = query.list();
			
			return rows;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> T findOneRowNative(Class<T> pClassEntity, String pSql) throws UtplException {
		try {
			List<T> rows = findListRowNative(pClassEntity, pSql);
			T row = null;
			
			if (rows != null && !rows.isEmpty()) {
				row = rows.get(Constantes.I0);
			}
			
			return row;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public <T extends EntityBase> List<T> findListRowNative(Class<T> pClassEntity, String pSql) throws UtplException {
		try {
			SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(pSql);
			sqlQuery.setResultTransformer(Transformers.aliasToBean(pClassEntity));
			
			List<String> scalars = DaoUtil.getFieldsScalar(pSql);
			for (String scalar : scalars) {
				sqlQuery.addScalar(scalar);
			}
			
			List<T> rows = sqlQuery.list();
			
			return rows;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Transactional
	@Override
	public Integer updateNativeQuery(String pSqlQueryNative) throws UtplException {
		try {
			Integer rows = sessionFactory.getCurrentSession().createSQLQuery(pSqlQueryNative).executeUpdate();
			
			return rows;
			
		} catch (Exception e) {
			throw new UtplException("updateNativeQuery(pSqlQueryNative): " + pSqlQueryNative, e);
			
		}
	}
	
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	@Override
	public <T> List<T> findListClassRowNative(Class<T> pClass, String pSql) throws UtplException {
		try {
			SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(pSql);
			sqlQuery.setResultTransformer(Transformers.aliasToBean(pClass));
			
			List<String> scalars = DaoUtil.getFieldsScalar(pSql);
			for (String scalar : scalars) {
				sqlQuery.addScalar(scalar);
			}
			
			List<T> rows = sqlQuery.list();
			
			return rows;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	/**
	 * Recupera una lista de objetos del modelo de acuerdo a una lista de criterios no excluyentes de manera ordenada
	 * 
	 * @param atributos Mapeo atributo / valor
	 * @return Lista con los objetos encontrados
	 */
	@Override
	@SuppressWarnings(Constantes.UNCHECKED)
	@Transactional(readOnly = true)
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Integer pTypeOrder, String pFieldOrder, Boolean pFilter) throws UtplException {
		List<T> entidades = null;
		
		try {
			Criteria criteria = DaoUtil.getFindCriteria(sessionFactory, pEntity, pFilter);
			
			if (Constantes.TYPE_ORDER_ASC.equals(pTypeOrder)) {
				criteria.addOrder(Order.asc(pFieldOrder));
				
			} else if (Constantes.TYPE_ORDER_DESC.equals(pTypeOrder)) {
				criteria.addOrder(Order.desc(pFieldOrder));
			}
			
			entidades = (List<T>) criteria.list();

		} catch (Exception e) {
			throw new UtplException(e);
			
		}

		return entidades;
	}

}
