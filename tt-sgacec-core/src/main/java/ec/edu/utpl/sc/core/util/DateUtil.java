package ec.edu.utpl.sc.core.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil implements Serializable {
	
	private static final long serialVersionUID = 3751206929657222196L;

	public static Date parseStringToDate(String pDateInString, String pFormat) {
		SimpleDateFormat formatter = new SimpleDateFormat(pFormat);
		Date fecha = null;

        try {
        	fecha = formatter.parse(pDateInString);

        } catch (ParseException e) {
        	fecha = null;
        }
        
        return fecha;
	}
	
	public static DateFindSri obtenerDateFindSri(Date pFecha) {
		DateFindSri dateFindSri = new DateFindSri();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pFecha);
		
		dateFindSri.setAnio(String.valueOf(calendar.get(Calendar.YEAR)));
		dateFindSri.setMes(obtenerMes(calendar.get(Calendar.MONTH)));
		dateFindSri.setDia(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        
        return dateFindSri;
	}
	
	public static String obtenerMes(int pMes) {
		String mes = null;
		
		if (Constantes.ENERO.equals(pMes)) {
			mes = Constantes.LBL_ENERO;
		} else
			
		if (Constantes.FEBRERO.equals(pMes)) {
			mes = Constantes.LBL_FEBRERO;
		} else
			
		if (Constantes.MARZO.equals(pMes)) {
			mes = Constantes.LBL_MARZO;
		} else
			
		if (Constantes.ABRIL.equals(pMes)) {
			mes = Constantes.LBL_ABRIL;
		} else
			
		if (Constantes.MAYO.equals(pMes)) {
			mes = Constantes.LBL_MAYO;
		} else
			
		if (Constantes.JUNIO.equals(pMes)) {
			mes = Constantes.LBL_JUNIO;
		} else
			
		if (Constantes.JULIO.equals(pMes)) {
			mes = Constantes.LBL_JULIO;
		} else
			
		if (Constantes.AGOSTO.equals(pMes)) {
			mes = Constantes.LBL_AGOSTO;
		} else
			
		if (Constantes.SEPTIEMBRE.equals(pMes)) {
			mes = Constantes.LBL_SEPTIEMBRE;
		} else
		
		if (Constantes.OCTUBRE.equals(pMes)) {
			mes = Constantes.LBL_OCTUBRE;
		} else
			
		if (Constantes.NOVIEMBRE.equals(pMes)) {
			mes = Constantes.LBL_NOVIEMBRE;
		} else
			
		if (Constantes.DICIEMBRE.equals(pMes)) {
			mes = Constantes.LBL_DICIEMBRE;
		}
		
		return mes;
	}
	
	public static Date sumarDiasFecha(Date pFecha, int pDias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pFecha);
		calendar.add(Calendar.DAY_OF_YEAR, pDias);

		return calendar.getTime();
	}
	
	public static Date restarDiasFecha(Date pFecha, int pDias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pFecha);
		calendar.add(Calendar.DAY_OF_YEAR, -pDias);

		return calendar.getTime();
	}
	
	public static Boolean esFechaMayor(Date pFechaMenor, Date pFechaMayor) {
		Boolean esFechaMayor = Boolean.FALSE;
		
		pFechaMenor = DateUtil.parseStringToDate(DateUtil.parseToDateString(pFechaMenor, Constantes.YYYY_MM_DD), Constantes.YYYY_MM_DD);
		pFechaMayor = DateUtil.parseStringToDate(DateUtil.parseToDateString(pFechaMayor, Constantes.YYYY_MM_DD), Constantes.YYYY_MM_DD);
		
		// Return value is greater than 0 , if Date is after the date argument.
		if (pFechaMayor.compareTo(pFechaMenor) > Constantes.I0) {
			esFechaMayor = Boolean.TRUE;
        }
        
        return esFechaMayor;
	}
	
	public static Boolean esFechaIgual(Date pFechaUno, Date pFechaDos) {
		Boolean esFechaIgual = Boolean.FALSE;
		
		// Return value is 0 if both dates are equal
		if (pFechaUno.compareTo(pFechaDos) == Constantes.I0) {
			esFechaIgual = Boolean.TRUE;
        }
        
        return esFechaIgual;
	}
	
	public static Boolean esFechaMenor(Date pFechaMenor, Date pFechaMayor) {
		Boolean esFechaMenor = Boolean.FALSE;
		
		pFechaMenor = DateUtil.parseStringToDate(DateUtil.parseToDateString(pFechaMenor, Constantes.YYYY_MM_DD), Constantes.YYYY_MM_DD);
		pFechaMayor = DateUtil.parseStringToDate(DateUtil.parseToDateString(pFechaMayor, Constantes.YYYY_MM_DD), Constantes.YYYY_MM_DD);
		
		// Return value is less than 0, if Date is before the date argument.
		if (pFechaMenor.compareTo(pFechaMayor) < Constantes.I0) {
			esFechaMenor = Boolean.TRUE;
        }
        
        return esFechaMenor;
	}
	
	public static Boolean esFechaMenorIgual(Date pFechaMenor, Date pFechaMayor) {
		Boolean esFechaMenorIgual = Boolean.FALSE;
		
		pFechaMenor = DateUtil.parseStringToDate(DateUtil.parseToDateString(pFechaMenor, Constantes.YYYY_MM_DD), Constantes.YYYY_MM_DD);
		pFechaMayor = DateUtil.parseStringToDate(DateUtil.parseToDateString(pFechaMayor, Constantes.YYYY_MM_DD), Constantes.YYYY_MM_DD);
		
		// Return value is less than 0, if Date is before the date argument
		if ((pFechaMenor.compareTo(pFechaMayor) < Constantes.I0) || (pFechaMenor.compareTo(pFechaMayor) == Constantes.I0)) {
			esFechaMenorIgual = Boolean.TRUE;
        }
        
        return esFechaMenorIgual;
	}
	
	public static String parseToDateString(Date pDate, String pFormat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pFormat);
		String fechaString = simpleDateFormat.format(pDate);
        
        return fechaString;
	}

}