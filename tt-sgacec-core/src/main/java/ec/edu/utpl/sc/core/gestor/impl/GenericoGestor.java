package ec.edu.utpl.sc.core.gestor.impl;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.gestor.IGenericoGestor;
import ec.edu.utpl.sc.core.gestor.IParametroGeneralGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.LoadTempletesHelper;
import ec.edu.utpl.sc.core.util.Utilitario;
import ec.edu.utpl.sc.core.util.UtplException;
import ec.edu.utpl.sc.core.vo.SessionUtil;

@Repository(Constantes.GENERICO_GESTOR)
public class GenericoGestor implements IGenericoGestor {
	
	@Autowired
	@Qualifier(Constantes.PARAMETRO_GENERAL_GESTOR)
	private IParametroGeneralGestor parametroGeneralGestor;

	@Override
	public void initApplication() throws UtplException {
		parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_CHROME_WEBDRIVER);
		loadTempletesEmail();
	}
	
	private void loadTempletesEmail() throws UtplException {
		try {
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_EMAIL_REGISTRO_RECUPERACION_CLAVE) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_REGISTRO_RECUPERACION_CLAVE_HTML);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_EMAIL_REGISTRO_RECUPERACION_CLAVE, Utilitario.getIntance().getStringFromInputStream(inputStream, Boolean.FALSE));
			}
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_EMAIL_ERROR_PROCESAR_SRI) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_ERROR_PROCESAR_SRI_HTML);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_EMAIL_ERROR_PROCESAR_SRI, Utilitario.getIntance().getStringFromInputStream(inputStream, Boolean.FALSE));
			}
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_FACTURA_CSS) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_FACTURA_CSS);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_FACTURA_CSS, Utilitario.getIntance().getStringFromInputStream(inputStream, Boolean.FALSE));
			}
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_FACTURA_XSL) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_FACTURA_XSL);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_FACTURA_XSL, IOUtils.toString(inputStream));
			}
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_XHTML2FO) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_XHTML2FO);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_XHTML2FO, IOUtils.toString(inputStream));
			}
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_COMPROBANTE_FISICO_XML) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_COMPROBANTE_FISICO_XML);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_COMPROBANTE_FISICO_XML, IOUtils.toString(inputStream));
			}
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_CONSOLIDADR_ANEXO_GASTOS_XLS) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_CONSOLIDAR_ANEXO_GASTOS_XLS);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_CONSOLIDADR_ANEXO_GASTOS_XLS, IOUtils.toString(inputStream));
			}
			
			if (SessionUtil.getObjetoSession(Constantes.ID_SESSION_PLANTILLA_CONSOLIDADR_ANEXO_GASTOS_XML) == null) {
				InputStream inputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_CONSOLIDAR_ANEXO_GASTOS_XML);
				SessionUtil.addObjetoSession(Constantes.ID_SESSION_PLANTILLA_CONSOLIDADR_ANEXO_GASTOS_XML, IOUtils.toString(inputStream));
			}
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
