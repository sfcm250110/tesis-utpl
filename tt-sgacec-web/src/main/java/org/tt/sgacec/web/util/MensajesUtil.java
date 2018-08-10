package org.tt.sgacec.web.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * <b>Clase para recuperar los mensajes del archivo de propiedades</b>
 * 
 * @author scabrera
 * @version $Revision: 1.0 $
 *          <p>
 *          [$Author: scabrera $, $Date: Oct 01, 2015 $]
 *          </p>
 */
public class MensajesUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String BUNDLE_NAME = "i18n";
	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * Permite obtener un valor string (key)
	 * 
	 * @param key
	 * @throws MissingResourceException
	 */
	public static String getString(String key) throws MissingResourceException {
		return RESOURCE_BUNDLE.getString(key);
	}

	/**
	 * Permite obtener un valor Integer (key)
	 * 
	 * @param key
	 * @throws MissingResourceException
	 */
	public static Integer getInteger(String key) throws MissingResourceException {
		return Integer.valueOf(RESOURCE_BUNDLE.getString(key));
	}

	/**
	 * Obtiene un mensaje del archivo de internacionalizaci&oacute;n con ciertos par&aacute;metros de relleno
	 * 
	 * @param key
	 *            Clave del archivo de internacionalizaci&oacute;n
	 * @param parameters
	 *            Par&aacute;metros de relleno
	 * @return Mensaje obtenido desde el archivo de internacionalizaci&oacute;n con los par&aacute;metros establecidos
	 */
	public static String getString(final String key, final String... parameters) {
		try {
			final MessageFormat formatter = new MessageFormat(RESOURCE_BUNDLE.getString(key), RESOURCE_BUNDLE.getLocale());
			return formatter.format(parameters);
			
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}