package org.tt.sgacec.web.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.tt.sgacec.web.util.JsfUtil;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.util.Constantes;

@FacesConverter(value = "empresaConverter", forClass = Empresa.class)
public class EmpresaConverter implements Converter {

	@SuppressWarnings(Constantes.UNCHECKED)
	@Override
	public Object getAsObject(FacesContext pFacesContext, UIComponent pUiComponent, String pIdEmpresa) {
		List<Empresa> empresas = (List<Empresa>) JsfUtil.getEvaluatedExpression(Constantes.USUARIO_DATAMANAGER_EMPRESAS_EL);

		for (Empresa empresa : empresas) {
			if (empresa.getIdEmpresa().equals(Long.valueOf(pIdEmpresa))) {
				return empresa;
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext pFacesContext, UIComponent pUiComponent, Object pEmpresa) {
		if (pEmpresa == null) {
			return null;
		}

		return String.valueOf(((Empresa) pEmpresa).getIdEmpresa());
	}

}
