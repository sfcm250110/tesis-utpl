package ec.edu.utpl.sc.core.gestor;

import java.util.List;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.DateFindSri;
import ec.edu.utpl.sc.core.util.UtplException;

public interface ISeleniumGestor {
	
	public CheckDownloadSri obtenerTotalComprobantesSri(String pUsuarioSri, String pClaveSri, DateFindSri pDateFindSri) throws UtplException;
	
	public List<ComprobanteEmpresa> downloadComprobantesSri(String pUsuarioSri, String pClaveSri, DateFindSri pDateFindSri, Boolean pXmlPdf) throws UtplException;

}
