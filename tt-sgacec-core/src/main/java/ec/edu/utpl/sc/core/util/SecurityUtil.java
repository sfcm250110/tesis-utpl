package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * https://www.mkyong.com/java/java-sha-hashing-example/
 * http://www.qualityinfosolutions.com/metodos-para-encriptar-y-desencriptar-en-java/
 * 
 * @author Santiago Cabrera M.
 *
 */
public class SecurityUtil implements Serializable {

	private static final long serialVersionUID = -4201086778057808939L;

	public static String encrypt(String pAlgorithm, String pSrcDesencrypt) throws UtplException {
		String passwordEncripted = null;
		
		try {
			if (null != pSrcDesencrypt) {
				MessageDigest messageDigest = MessageDigest.getInstance(pAlgorithm);
				messageDigest.update(pSrcDesencrypt.getBytes());
				byte data[] = messageDigest.digest();
				StringBuffer passwordEncriptedTmp = new StringBuffer();

				for (int contador = Constantes.I0; contador < data.length; contador++) {
					passwordEncriptedTmp.append(Integer.toString((data[contador] & 0xff) + 0x100, 16).substring(1));
				}
				
				passwordEncripted = passwordEncriptedTmp.toString();
			}

			return passwordEncripted;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	public static String encryptMd5Base64(String pSrcDesencrypt) throws UtplException {
		String base64Encrypted = null;
		
		try {
			if (null != pSrcDesencrypt) {
				MessageDigest messageDigest = MessageDigest.getInstance(Constantes.ALGORITHM_MD5);
				byte[] digestOfPassword = messageDigest.digest(Constantes.SECRET_KEY.getBytes(Constantes.ENCODING_UTF8));
				byte[] keyBytes = Arrays.copyOf(digestOfPassword, Constantes.I24);

				SecretKey key = new SecretKeySpec(keyBytes, Constantes.ALGORITHM_DESEDE);
				Cipher cipher = Cipher.getInstance(Constantes.ALGORITHM_DESEDE);
				cipher.init(Cipher.ENCRYPT_MODE, key);

				byte[] plainTextBytes = pSrcDesencrypt.getBytes(Constantes.ENCODING_UTF8);
				byte[] buf = cipher.doFinal(plainTextBytes);
				byte[] base64Bytes = Base64.encodeBase64(buf);
				base64Encrypted = new String(base64Bytes);
			}
			
			return base64Encrypted;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	public static String desencryptMd5Base64(String pSrcEncrypt) throws UtplException {
		String base64Encrypted = null;
		
		try {
			if (null != pSrcEncrypt) {
				byte[] message = Base64.decodeBase64(pSrcEncrypt.getBytes(Constantes.ENCODING_UTF8));
				MessageDigest messageDigest = MessageDigest.getInstance(Constantes.ALGORITHM_MD5);
				byte[] digestOfPassword = messageDigest.digest(Constantes.SECRET_KEY.getBytes(Constantes.ENCODING_UTF8));
				byte[] keyBytes = Arrays.copyOf(digestOfPassword, Constantes.I24);
				SecretKey key = new SecretKeySpec(keyBytes, Constantes.ALGORITHM_DESEDE);

				Cipher decipher = Cipher.getInstance(Constantes.ALGORITHM_DESEDE);
				decipher.init(Cipher.DECRYPT_MODE, key);

				byte[] plainText = decipher.doFinal(message);
				base64Encrypted = new String(plainText, Constantes.ENCODING_UTF8);
			}
			
			return base64Encrypted;

		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

	public static void main(String[] args) {
		try {
			String password = "12345";
			System.out.println(encrypt(Constantes.ALGORITHM_SHA_512, password));
			
			String encriptado = encryptMd5Base64(password);
	        System.out.println(encriptado);
	        String desencriptado = desencryptMd5Base64(encriptado);
	        System.out.println(desencriptado);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
