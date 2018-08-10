package ec.edu.utpl.sc.core.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.gestor.IHttpGestor;
import ec.edu.utpl.sc.core.servicio.IHttpServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.HTTP_SERVICIO)
public class HttpServicio implements IHttpServicio {
	
	@Autowired
	@Qualifier(Constantes.HTTP_GESTOR)
	private IHttpGestor httpGestor;

	@Override
	public InfoRucSri downloadInfoRucSri(String pRucEmisor) throws UtplException {
		return httpGestor.downloadInfoRucSri(pRucEmisor);
	}

}
