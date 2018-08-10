package ec.edu.utpl.sc.core.gestor;

import java.io.File;

import ec.edu.utpl.sc.core.util.UtplException;

public interface IFileGestor {
	
	public void uploadComprobanteXml(File pComprobanteXml) throws UtplException;
	
	public void uploadComprobantePdf(File pComprobantePdf) throws UtplException;

}
