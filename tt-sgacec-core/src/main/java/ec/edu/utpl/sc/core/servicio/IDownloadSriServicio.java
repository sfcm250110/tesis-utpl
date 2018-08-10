package ec.edu.utpl.sc.core.servicio;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IDownloadSriServicio {
	
	public void registrarFechaDownloadSri(Empresa pEmpresa) throws UtplException;

}
