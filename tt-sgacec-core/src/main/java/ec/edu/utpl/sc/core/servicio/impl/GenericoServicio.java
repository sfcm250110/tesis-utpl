package ec.edu.utpl.sc.core.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.gestor.IGenericoGestor;
import ec.edu.utpl.sc.core.servicio.IGenericoServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.GENERICO_SERVICIO)
public class GenericoServicio implements IGenericoServicio {
	
	@Autowired
	@Qualifier(Constantes.GENERICO_GESTOR)
	private IGenericoGestor genericoGestor;

	@Override
	public void initApplication() throws UtplException {
		genericoGestor.initApplication();
	}

}
