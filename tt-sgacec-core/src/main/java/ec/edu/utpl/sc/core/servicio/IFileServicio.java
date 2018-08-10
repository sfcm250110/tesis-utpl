package ec.edu.utpl.sc.core.servicio;

import java.io.File;

import ec.edu.utpl.sc.core.util.UtplException;

public interface IFileServicio {
	
	public void uploadComprobanteXml(File pComprobanteXml) throws UtplException;
	
	public void uploadComprobantePdf(File pComprobantePdf) throws UtplException;

}
