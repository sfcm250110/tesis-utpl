package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public final class Base64Util implements Serializable {
	
	private static final long serialVersionUID = 6488967574104392710L;

	private Base64Util() {
	}

	public static String encodeStringBase64(final String pData) {
		try {
			return new String(Base64.encodeBase64(pData.getBytes(Constantes.CODIFICACION_UTF8)), Constantes.CODIFICACION_UTF8);
		
		} catch (UnsupportedEncodingException e) {
			return new String(Base64.encodeBase64(pData.getBytes()));
		}
	}

	public static String encodeBytesBase64(final byte[] pData) {
		try {
			return new String(Base64.encodeBase64(pData), Constantes.CODIFICACION_UTF8);
			
		} catch (UnsupportedEncodingException e) {
			return new String(Base64.encodeBase64(pData));
		}
	}

	public static byte[] decodeStringBase64(final String pData) {
		try {
			return Base64.decodeBase64(pData.getBytes(Constantes.CODIFICACION_UTF8));
			
		} catch (UnsupportedEncodingException e) {
			return Base64.decodeBase64(pData.getBytes());
		}
	}

	public static String decodeBase64(final String pData)  {
		try {
			return new String(Base64.decodeBase64(pData.getBytes(Constantes.CODIFICACION_UTF8)), Constantes.CODIFICACION_UTF8);
			
		} catch (UnsupportedEncodingException e) {
			return new String(Base64.decodeBase64(pData.getBytes()));
		}
	}
	
	public static String codificarBytesBase64(final byte[] data) {
		try {
			return new String(Base64.encodeBase64(data), Constantes.CODIFICACION_UTF8);
			
		} catch (UnsupportedEncodingException e) {
			return new String(Base64.encodeBase64(data));
		}
	}
	
	public static String decodificarBase64(final String cadenaBase64)  {
		try {
			return new String(Base64.decodeBase64(cadenaBase64.getBytes(Constantes.CODIFICACION_UTF8)), Constantes.CODIFICACION_UTF8);
			
		} catch (UnsupportedEncodingException e) {
			return new String(Base64.decodeBase64(cadenaBase64.getBytes()));
		}
	}

}
