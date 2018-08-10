package ec.edu.utpl.sc.core.gestor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.ParametroGeneral;
import ec.edu.utpl.sc.core.gestor.IParametroGeneralGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.vo.SessionUtil;

@Repository(Constantes.PARAMETRO_GENERAL_GESTOR)
public class ParametroGeneralGestor implements IParametroGeneralGestor {
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;

	@Override
	public String obtenerValorParametroGeneral(String pNombre) throws UtplException {
		try {
			String valor = (String) SessionUtil.getObjetoSession(pNombre);
			
			if (valor == null) {
				ParametroGeneral parametroGeneral = new ParametroGeneral();
				parametroGeneral.setValorCrud(Constantes.TYPE_S_SELECT);
				parametroGeneral.setNombre(pNombre);
				parametroGeneral = crudDao.findOneRow(parametroGeneral, Boolean.TRUE);
				
				if (parametroGeneral != null) {
					valor = parametroGeneral.getValor();
					SessionUtil.addObjetoSession(pNombre, valor);
				}
			}
			
			return valor;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
