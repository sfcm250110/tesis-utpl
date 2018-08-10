package ec.edu.utpl.sc.core.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.gestor.IDownloadSriGestor;
import ec.edu.utpl.sc.core.servicio.IDownloadSriServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.DOWNLOAD_SRI_SERVICIO)
public class DownloadSriServicio implements IDownloadSriServicio {
	
	@Autowired
	@Qualifier(Constantes.DOWNLOAD_SRI_GESTOR)
	private IDownloadSriGestor downloadSriGestor;

	@Override
	public void registrarFechaDownloadSri(Empresa pEmpresa) throws UtplException {
		downloadSriGestor.registrarFechaDownloadSri(pEmpresa);
	}	

}
