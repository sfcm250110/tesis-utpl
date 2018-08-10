package ec.edu.utpl.sc.core.gestor;

import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IHttpGestor {

	public InfoRucSri downloadInfoRucSri(String pRucEmisor) throws UtplException;

}
