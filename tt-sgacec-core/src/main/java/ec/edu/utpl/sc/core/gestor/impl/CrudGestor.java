package ec.edu.utpl.sc.core.gestor.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.base.EntityBase;
import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.gestor.ICrudGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.CRUD_GESTOR)
public class CrudGestor implements ICrudGestor {
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;

	@Override
	public <T extends EntityBase> void create(T pEntity) throws UtplException {
		crudDao.create(pEntity);
	}

	@Override
	public <T extends EntityBase> void update(T pEntity) throws UtplException {
		crudDao.update(pEntity);
	}

	@Override
	public <T extends EntityBase> void delete(T pEntity) throws UtplException {
		crudDao.delete(pEntity);
	}

	@Override
	public EntityBase find(EntityBase pEntity) throws UtplException {
		return crudDao.find(pEntity);
	}

	@Override
	public EntityBase find(EntityBase pEntity, String... pPropiedades) throws UtplException {
		return crudDao.find(pEntity, pPropiedades);
	}

	@Override
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Boolean pFilter) throws UtplException {
		return crudDao.findForCriteria(pEntity, pFilter);
	}

	@Override
	public <T extends EntityBase> List<T> findForCriteria(Map<String, Object> pAtributos, T pEntity, Boolean pFilter) throws UtplException {
		return crudDao.findForCriteria(pAtributos, pEntity, pFilter);
	}

	@Override
	public <T extends EntityBase> T findOneRow(T pEntity, Boolean pFilter) throws UtplException {
		return crudDao.findOneRow(pEntity, pFilter);
	}

	@Override
	public List<Object> findNativeSql(String pSqlNative) throws UtplException {
		return crudDao.findNativeSql(pSqlNative);
	}

	@Override
	public <T extends EntityBase> List<T> findSqlEjb(String pSqlEjb) throws UtplException {
		return crudDao.findSqlEjb(pSqlEjb);
	}

	@Override
	public List<Object> findSqlEjbObject(String pSqlEjb) throws UtplException {
		return crudDao.findSqlEjbObject(pSqlEjb);
	}

	@Override
	public List<Map<String, Object>> findSqlNativeCriteria(String pSqlNative, Map<String, Object> pCriteriaSql) throws UtplException {
		return crudDao.findSqlNativeCriteria(pSqlNative, pCriteriaSql);
	}

	@Override
	public <T extends EntityBase> List<T> findSqlEjbIn(String ejbql, String pPropiedadIn, List<Integer> pListIn) throws UtplException {
		return crudDao.findSqlEjbIn(ejbql, pPropiedadIn, pListIn);
	}

	@Override
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Integer pTypeOrder, String pFieldOrder, Boolean pFilter) throws UtplException {
		return crudDao.findForCriteria(pEntity, pTypeOrder, pFieldOrder, pFilter);
	}

}
