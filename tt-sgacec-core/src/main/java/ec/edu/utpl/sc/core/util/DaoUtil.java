package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import ec.edu.utpl.sc.core.base.EntityBase;

@SuppressWarnings(Constantes.DEPRECATION)
public class DaoUtil implements Serializable {

	private static final long serialVersionUID = 7181865586066720668L;

	public static <T extends EntityBase> Criteria getFindCriteria(SessionFactory pSessionFactory, T pEntity, Boolean pFilter) throws UtplException {
		try {
			Criteria criteria = pSessionFactory.getCurrentSession().createCriteria(pEntity.getClass());

			for (Field fieldEntity : pEntity.getClass().getDeclaredFields()) {
				String fieldName = fieldEntity.getName();
				Field fieldEntidad = pEntity.getClass().getDeclaredField(fieldName);
				fieldEntidad.setAccessible(Boolean.TRUE);
				Object valueField = fieldEntidad.get(pEntity);
				
				if (pFilter) {
					if (!fieldName.equals(Constantes.SERIAL_VERSION_UID) && !fieldName.equals(Constantes.HASH_VALUE) && !fieldName.contains(Constantes.FIELD_ID) && !fieldName.contains(Constantes.FIELD_PART_CRUD) && valueField != null) {
						criteria.add(Expression.eq(fieldName, valueField));
					}
					
				} else {
					if (!fieldName.equals(Constantes.SERIAL_VERSION_UID) && !fieldName.equals(Constantes.HASH_VALUE) && valueField != null && !fieldName.contains(Constantes.FIELD_ID)) {
						criteria.add(Expression.eq(fieldName, valueField));
					}
				}
			}

			return criteria;

		} catch (Exception e) {
			throw new UtplException("[getFindCriteria(pEntity)]: " + pEntity.getClass().getName(), e);
		}
	}
	
	public static <T extends EntityBase> Criteria getFieldsQuery(T pEntity, Criteria pCriteria) throws UtplException {
		try {
			ProjectionList projectionList = Projections.projectionList();
			
			for (Field fieldEntity : pEntity.getClass().getDeclaredFields()) {
				String fieldName = fieldEntity.getName();
				Field fieldEntidad = pEntity.getClass().getDeclaredField(fieldName);
				fieldEntidad.setAccessible(Boolean.TRUE);
				Object valueField = fieldEntidad.get(pEntity);

				if (!fieldName.equals(Constantes.SERIAL_VERSION_UID) && !fieldName.equals(Constantes.HASH_VALUE) && fieldName.contains(Constantes.FIELD_PART_CRUD) && valueField != null) {
					int finish = fieldName.indexOf(Constantes.FIELD_PART_CRUD);
					String field = fieldName.substring(Constantes.I0, finish);
					projectionList.add(Projections.property(field), field);
				}
			}
			
			pCriteria.setProjection(projectionList);
			pCriteria.setResultTransformer(Transformers.aliasToBean(pEntity.getClass()));

			return pCriteria;

		} catch (Exception e) {
			throw new UtplException("[getFieldsQuery(pEntity, pCriteria)]: " + pEntity.getClass().getName(), e);
		}
	}
	
	public static <T extends EntityBase> String getFieldsUpdate(T pEntity) throws UtplException {
		String fieldsUpdate = null;
		
		try {
			for (Field fieldEntity : pEntity.getClass().getDeclaredFields()) {
				String fieldName = fieldEntity.getName();
				Field fieldEntidad = pEntity.getClass().getDeclaredField(fieldName);
				fieldEntidad.setAccessible(Boolean.TRUE);
				Object valueField = fieldEntidad.get(pEntity);
				Class<?> typeField = fieldEntity.getType();
				
				if (!fieldName.equals(Constantes.SERIAL_VERSION_UID) && !fieldName.equals(Constantes.HASH_VALUE) && !fieldName.contains(Constantes.FIELD_ID) && valueField != null && !fieldName.contains(Constantes.FIELD_PART_CRUD)) {
					
					if (fieldsUpdate == null) {
						fieldsUpdate = fieldName + Constantes.IGUAL + obtenerValueField(typeField.getSimpleName(), valueField) + Constantes.COMA;
						
					} else {
						fieldsUpdate = fieldsUpdate + fieldName + Constantes.IGUAL + obtenerValueField(typeField.getSimpleName(), valueField) + Constantes.COMA;
					}
				}
			}
			
			fieldsUpdate = fieldsUpdate.substring(Constantes.I0, fieldsUpdate.length() - Constantes.I1);

		} catch (Exception e) {
			throw new UtplException("[getFieldsUpdate(pEntity)]: " + pEntity.getClass().getName(), e);
		}
		
		return fieldsUpdate;
	}
	
	public static <T extends EntityBase> String getFieldsWhere(T pEntity) throws UtplException {
		String fieldsWhere = Constantes.DML_WHERE_DEFAULT + Constantes.SPACE_BLANK + Constantes.DML_AND + Constantes.SPACE_BLANK;
		
		try {
			for (Field fieldEntity : pEntity.getClass().getDeclaredFields()) {
				String fieldName = fieldEntity.getName();
				Field fieldEntidad = pEntity.getClass().getDeclaredField(fieldName);
				fieldEntidad.setAccessible(Boolean.TRUE);
				Object valueField = fieldEntidad.get(pEntity);
				Class<?> typeField = fieldEntity.getType();

				if (!fieldName.equals(Constantes.SERIAL_VERSION_UID) && !fieldName.equals(Constantes.HASH_VALUE) && fieldName.contains(Constantes.FIELD_PART_CRUD) && valueField != null) {
					int finish = fieldName.indexOf(Constantes.FIELD_PART_CRUD);
					String field = fieldName.substring(Constantes.I0, finish);
					fieldsWhere = fieldsWhere + field + Constantes.IGUAL + obtenerValueField(typeField.getSimpleName(), valueField) + Constantes.SPACE_BLANK + Constantes.DML_AND + Constantes.SPACE_BLANK;
				}
			}
			
			fieldsWhere = fieldsWhere.substring(Constantes.I0, fieldsWhere.length() - Constantes.I5);

		} catch (Exception e) {
			throw new UtplException("[getFieldsWhere(pEntity)]: " + pEntity.getClass().getName(), e);
		}
		
		return fieldsWhere;
	}
	
	private static String obtenerValueField(String pSimpleName, Object pValueField) {
		String valueField = null;
		
		if (String.class.getSimpleName().equals(pSimpleName) || Date.class.getSimpleName().equals(pSimpleName)) {
			valueField = Constantes.COMILLA_SIMPLE + pValueField + Constantes.COMILLA_SIMPLE;
			
		} else {
			valueField = pValueField.toString();
		}
		
		return valueField;
	}
	
	public static String buildSqlParameters(String pSql, Map<String, String> pParameterValues) {
		Set<String> parameterKeys = pParameterValues.keySet();
		
		for (String parameterKey : parameterKeys) {
			String parameterValue = pParameterValues.get(parameterKey);
			pSql = pSql.replace(parameterKey, parameterValue);
		}

		return pSql;
	}
	
	public static String buildSqlTableEmpresa(String pSql, String pRucEmpresa) {
		pSql = pSql.replace(ConstantesDb.TABLE_UTPL_COMPROBANTE, ConstantesDb.TABLE_UTPL_COMPROBANTE + Constantes.GUION_BAJO + pRucEmpresa);

		return pSql;
	}
	
	public static Integer getNumberColumns(String pSql) {
		//TODO:
		int beginIndex = pSql.indexOf(ConstantesDb.LABEL_SELECT);
		int endIndex = pSql.indexOf(ConstantesDb.LABEL_FROM);
		String columns = pSql.substring(beginIndex, endIndex);
		String[] columnsArray = columns.split(Constantes.COMA);
		Integer numberColumns = columnsArray.length;

		return numberColumns;
	}
	
	public static List<String> getFieldsScalar(String pSql) {
		int beginIndex = ConstantesDb.LABEL_SELECT.length() + Constantes.I1;
		int endIndex = pSql.indexOf(ConstantesDb.LABEL_FROM) - Constantes.I1;
		String fields = pSql.substring(beginIndex, endIndex);
		String[] fieldsObj = fields.split(Constantes.COMA);
		List<String> scalars = new ArrayList<String>();
		
		for (int contador = Constantes.I0; contador < fieldsObj.length; contador++) {
			String field = fieldsObj[contador].trim();
			String[] fieldObj = field.split(ConstantesDb.LABEL_AS);
			scalars.add(fieldObj[Constantes.I1].trim());
		}
		
		return scalars;
	}

}
