package ec.edu.utpl.sc.core.servicio.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.gestor.IFileGestor;
import ec.edu.utpl.sc.core.servicio.IFileServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.FILE_SERVICIO)
public class FileServicio implements IFileServicio {
	
	@Autowired
	@Qualifier(Constantes.FILE_GESTOR)
	private IFileGestor fileGestor;

	@Override
	public void uploadComprobanteXml(File pComprobanteXml) throws UtplException {
		fileGestor.uploadComprobanteXml(pComprobanteXml);
	}

	@Override
	public void uploadComprobantePdf(File pComprobantePdf) throws UtplException {
		fileGestor.uploadComprobantePdf(pComprobantePdf);
	}	

}
