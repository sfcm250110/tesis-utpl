package ec.edu.utpl.sc.core.dao;

import java.util.List;
import java.util.Map;

import ec.edu.utpl.sc.core.base.EntityBase;
import ec.edu.utpl.sc.core.util.UtplException;

public interface ICrudDao {
	
	public <T extends EntityBase> T create(T pEntity) throws UtplException;
	
	public <T extends EntityBase> T update(T pEntity) throws UtplException;
	
	public <T extends EntityBase> Integer updateFields(T pEntity) throws UtplException;
	
	public <T extends EntityBase> void delete(T pEntity) throws UtplException;
	
	public EntityBase find(EntityBase pEntity) throws UtplException;
	
	public EntityBase find(EntityBase pEntity, String... pPropiedades) throws UtplException;
	
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Boolean pFilter) throws UtplException;
	
	public <T extends EntityBase> List<T> findForCriteria(Map<String, Object> pAtributos, T pEntity, Boolean pFilter) throws UtplException;
	
	public <T extends EntityBase> T findOneRow(T pEntity, Boolean pFilter) throws UtplException;
	
	public List<Object> findNativeSql(String pSqlNative) throws UtplException;
	
	public <T extends EntityBase> List<T> findSqlEjb(String pSqlEjb) throws UtplException;
	
	public List<Object> findSqlEjbObject(String pSqlEjb) throws UtplException;
	
	public List<Map<String, Object>> findSqlNativeCriteria(String pSqlNative, Map<String, Object> pCriteriaSql) throws UtplException;
	
	public <T extends EntityBase> List<T> findSqlEjbIn(String ejbql, String pPropiedadIn, List<Integer> pListIn) throws UtplException;
	
	public <T extends EntityBase> T findOneRow(Class<T> pClassEntity, String pSql) throws UtplException;
	
	public <T extends EntityBase> List<T> findListRow(Class<T> pClassEntity, String pSql) throws UtplException;
	
	public <T extends EntityBase> T findOneRowNative(Class<T> pClassEntity, String pSql) throws UtplException;
	
	public <T extends EntityBase> List<T> findListRowNative(Class<T> pClassEntity, String pSql) throws UtplException;
	
	public Integer updateNativeQuery(String pSqlQueryNative) throws UtplException;
	
	public <T> List<T> findListClassRowNative(Class<T> pClass, String pSql) throws UtplException;
	
	public <T extends EntityBase> List<T> findForCriteria(T pEntity, Integer pTypeOrder, String pFieldOrder, Boolean pFilter) throws UtplException;

}
