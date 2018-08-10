package ec.edu.utpl.sc.core.gestor;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IDownloadSriGestor {
	
	public void registrarFechaDownloadSri(Empresa pEmpresa) throws UtplException;

}
