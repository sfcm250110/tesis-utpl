package ec.edu.utpl.sc.core.servicio;

import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IHttpServicio {

	public InfoRucSri downloadInfoRucSri(String pRucEmisor) throws UtplException;

}
