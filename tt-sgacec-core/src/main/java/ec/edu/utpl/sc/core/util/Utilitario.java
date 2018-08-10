package ec.edu.utpl.sc.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.fusesource.hawtbuf.ByteArrayInputStream;

import ec.edu.utpl.sc.core.entity.Rol;

public class Utilitario implements Serializable {
	
	private static final long serialVersionUID = 4792013223600003243L;
	
	private static final Utilitario instance = new Utilitario();

	private Utilitario() {
	}

	public static Utilitario getIntance() {
		return instance;
	}
	
	@SuppressWarnings(Constantes.RESOURCE)
	public byte[] fileToByteArray(File archivo) {
		try {
			InputStream inputStream = new FileInputStream(archivo);
			byte[] contenido = new byte[(int) archivo.length()];
			inputStream.read(contenido);

			return contenido;

		} catch (FileNotFoundException e) {
			return null;

		} catch (IOException e) {
			return null;
		}
	}

	@SuppressWarnings(Constantes.RESOURCE)
	public File byteToFile(String nombreArchivo, byte[] contenido) {
		try {
			File archivo = new File(nombreArchivo);
			FileOutputStream fos = new FileOutputStream(archivo);
			fos.write(contenido);

			return archivo;

		} catch (FileNotFoundException e) {
			return null;

		} catch (IOException e) {
			return null;
		}
	}

	public Date editarTiempoEnFecha(Date fecha, int hora, int minutos, int segundos) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.set(Calendar.HOUR_OF_DAY, hora);
		calendar.set(Calendar.MINUTE, minutos);
		calendar.set(Calendar.SECOND, segundos);

		return calendar.getTime();
	}

	public String generarClaveTemporal() {
		String claveTemporal = Constantes.SPACE_BLANK;
		Random random = new SecureRandom();

		for (int contador = Constantes.I0; contador < Constantes.I5; contador++) {
			int index = (int) (random.nextDouble() * Constantes.UNIVERSO_PASSWORD.length());
			claveTemporal = claveTemporal + Constantes.UNIVERSO_PASSWORD.substring(index, index + Constantes.I1);
		}

		return claveTemporal.trim();
	}
	
	public String getStringFromInputStream(InputStream pInputStream, Boolean pSaltoLinea) throws IOException {
		StringBuilder contenidoString = null;
		BufferedReader bufferedReader = null;

		try {
			contenidoString = new StringBuilder();
			bufferedReader = new BufferedReader(new InputStreamReader(pInputStream));
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				contenidoString.append(line);
				if (pSaltoLinea) {
					contenidoString.append(Constantes.BREAK_LINE);
				}
			}

		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}

		return contenidoString.toString();
	}
	
	public Boolean isUserInRole(Rol pRol, String... nombresRol) {
		Boolean rendered = Boolean.FALSE;
		
		for (String nombreRol : nombresRol) {
			if (pRol.getNombreRol().equals(nombreRol)) {
				rendered = Boolean.TRUE;
				break;
			}
		}
		
		return rendered;
	}
	
	public static Boolean validarCampoNotNull(Object pObjecto) {
		if (pObjecto == null) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}

	public static Boolean validarCampoNotNull(Object... pObjectos) {
		Boolean campoNotNull = Boolean.TRUE;

		for (Object objecto : pObjectos) {
			if (objecto == null) {
				campoNotNull = Boolean.FALSE;
				break;
			}
		}

		return campoNotNull;
	}

	public static Boolean validarCampoNotVacio(Object pObjecto) {
		if (Constantes.SPACE_BLANK.equals(pObjecto)) {
			return Boolean.FALSE;
			
		} else {
			return Boolean.TRUE;
		}
	}
	
	public static byte[] imageToByte(File file) throws IOException {
		FileInputStream fileInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];

			for (int readNum; (readNum = fileInputStream.read(buffer)) != Constantes.I1M;) {
				byteArrayOutputStream.write(buffer, Constantes.I0, readNum);
			}

			return byteArrayOutputStream.toByteArray();
			
		} finally {
			fileInputStream.close();
		}
	}
	
	public static String extractDigits(String pSrc) {
		StringBuilder digit = new StringBuilder();

		for (int contador = Constantes.I0; contador < pSrc.length(); contador++) {
			char caracter = pSrc.charAt(contador);

			if (Character.isDigit(caracter)) {
				digit.append(caracter);
			}
		}

		return digit.toString();
	}
	
	public static Double extractQuantity(String pSrc) throws ParseException {
		Double quantity = Constantes.D0;
		StringBuilder digit = new StringBuilder();

		for (int contador = Constantes.I0; contador < pSrc.length(); contador++) {
			char caracter = pSrc.charAt(contador);

			if (Character.isDigit(caracter) || Constantes.C_DOT == caracter || Constantes.C_COMMA == caracter) {
				digit.append(caracter);
			}
		}
		
		quantity = parseToDouble(digit.toString());

		return quantity;
	}
	
	public static Number parseQuantity(StringBuilder pSrc) throws ParseException {
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator(Constantes.C_COMMA);
		decimalFormatSymbols.setGroupingSeparator(Constantes.C_DOT);
		
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
		decimalFormat.setParseBigDecimal(Boolean.TRUE);
		decimalFormat.setMaximumFractionDigits(Constantes.I2);
		Number value = decimalFormat.parse(pSrc.toString());

		return value;
	}
	
	public static Double parseToDouble(String pSrc) {
		Double valueDouble = null;
		
		try {
			Locale locale = Locale.getDefault();
			NumberFormat numberFormat = DecimalFormat.getInstance(locale);
			Number number = numberFormat.parse(pSrc);
			valueDouble = number.doubleValue();
			
		 } catch (ParseException e) {
			 try {
				 String valueWithDot = pSrc.replaceAll(Constantes.COMMA, Constantes.DOT);
				 valueDouble = Double.valueOf(valueWithDot);
				 
			} catch (Exception ex) {
				valueDouble = null;
			}
		 }
		
		return valueDouble;
	}
	
	public static byte[] getBytesToPath(String pPath) throws IOException {
		byte[] contentBytes = Files.readAllBytes(Paths.get(pPath));

		return contentBytes;
	}
	
	public static InputStream bytesToInputStream(String pPath) throws IOException {
		byte[] contentBytes = getBytesToPath(pPath);
		InputStream inputStream = new ByteArrayInputStream(contentBytes);

		return inputStream;
	}
	
	public static String formatLengthMaxFiel(Object pData, int pLengthMax) {
		String data = null;
		
		if (pData == null) {
			data = Constantes.NULL;
			
		} else {
			data = pData.toString().length() > pLengthMax ? pData.toString().substring(Constantes.I0, pLengthMax) : pData.toString();
		}
		
		return data;
	}
	
	public static String stackTraceToString(Exception pException) {
		StringWriter stringWriter = new StringWriter();
		pException.printStackTrace(new PrintWriter(stringWriter));
		String printStackTrace = stringWriter.toString();
		
		return printStackTrace;
	}

}
