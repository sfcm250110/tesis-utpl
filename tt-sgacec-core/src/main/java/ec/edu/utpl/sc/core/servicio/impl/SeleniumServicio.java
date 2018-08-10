package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.gestor.ISeleniumGestor;
import ec.edu.utpl.sc.core.servicio.ISeleniumServicio;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.DateFindSri;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.SELENIUM_SERVICIO)
public class SeleniumServicio implements ISeleniumServicio {
	
	@Autowired
	@Qualifier(Constantes.SELENIUM_GESTOR)
	private ISeleniumGestor seleniumGestor;

	@Override
	public CheckDownloadSri obtenerTotalComprobantesSri(String pUsuarioSri, String pClaveSri, DateFindSri pDateFindSri) throws UtplException {
		return seleniumGestor.obtenerTotalComprobantesSri(pUsuarioSri, pClaveSri, pDateFindSri);
	}
	
	@Override
	public List<ComprobanteEmpresa> downloadComprobantesSri(String pUsuarioSri, String pClaveSri, DateFindSri pDateFindSri, Boolean pXmlPdf) throws UtplException {
		return seleniumGestor.downloadComprobantesSri(pUsuarioSri, pClaveSri, pDateFindSri, pXmlPdf);
	}

}
