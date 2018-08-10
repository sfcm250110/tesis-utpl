package ec.edu.utpl.sc.core.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.gestor.IParametroGeneralGestor;
import ec.edu.utpl.sc.core.servicio.IParametroGeneralServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.PARAMETRO_GENERAL_SERVICIO)
public class ParametroGeneralServicio implements IParametroGeneralServicio {
	
	@Autowired
	@Qualifier(Constantes.PARAMETRO_GENERAL_GESTOR)
	private IParametroGeneralGestor parametroGeneralGestor;

	@Override
	public String obtenerValorParametroGeneral(String pNombre) throws UtplException {
		return parametroGeneralGestor.obtenerValorParametroGeneral(pNombre);
	}	

}
