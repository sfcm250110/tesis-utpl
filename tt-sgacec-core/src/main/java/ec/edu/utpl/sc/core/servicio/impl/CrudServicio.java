package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.base.EntityBase;
import ec.edu.utpl.sc.core.gestor.ICrudGestor;
import ec.edu.utpl.sc.core.servicio.ICrudServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.CRUD_SERVICIO)
public class CrudServicio implements ICrudServicio {
	
	@Autowired
	@Qualifier(Constantes.CRUD_GESTOR)
	private ICrudGestor crudGestor;

	@Override
	public <T extends EntityBase> void create(T pEntity) throws UtplException {
		crudGestor.create(pEntity);
	}

	@Override
	public <T extends EntityBase> void update(T pEntity) throws UtplException {
		crudGestor.update(pEntity);
	}

	@Override
	public <T extends EntityBase> void delete(T pEntity) throws UtplException {
		crudGestor.delete(pEntity);
	}

	@Override
	public EntityBase find(EntityBase pEntity) throws UtplException {
		return crudGestor.find(pEntity);
	}

	@Override
	public EntityBase find(EntityBase pEntity, String... pPropiedades) throws UtplException {
		return crudGestor.find(pEntity, pPropiedades);
	}

	@Override
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Boolean pFilter) throws UtplException {
		return crudGestor.findForCriteria(pEntity, pFilter);
	}

	@Override
	public <T extends EntityBase> List<T> findForCriteria(Map<String, Object> pAtributos, T pEntity, Boolean pFilter) throws UtplException {
		return crudGestor.findForCriteria(pAtributos, pEntity, pFilter);
	}

	@Override
	public <T extends EntityBase> T findOneRow(T pEntity, Boolean pFilter) throws UtplException {
		return crudGestor.findOneRow(pEntity, pFilter);
	}

	@Override
	public List<Object> findNativeSql(String pSqlNative) throws UtplException {
		//TODO:
		return null;
	}

	@Override
	public <T extends EntityBase> List<T> findSqlEjb(String pSqlEjb) throws UtplException {
		return crudGestor.findSqlEjb(pSqlEjb);
	}

	@Override
	public List<Object> findSqlEjbObject(String pSqlEjb) throws UtplException {
		return crudGestor.findSqlEjbObject(pSqlEjb);
	}

	@Override
	public List<Map<String, Object>> findSqlNativeCriteria(String pSqlNative, Map<String, Object> pCriteriaSql) throws UtplException {
		//TODO:return crudGestor.findNativeSql(pSqlNative, pCriteriaSql);
		return null;
	}

	@Override
	public <T extends EntityBase> List<T> findSqlEjbIn(String ejbql, String pPropiedadIn, List<Integer> pListIn) throws UtplException {
		return crudGestor.findSqlEjbIn(ejbql, pPropiedadIn, pListIn);
	}

	@Override
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Integer pTypeOrder, String pFieldOrder, Boolean pFilter) throws UtplException {
		return crudGestor.findForCriteria(pEntity, pTypeOrder, pFieldOrder, pFilter);
	}

}
