package ec.edu.utpl.sc.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

public class ExcelUtil implements Serializable {
	
	private static final long serialVersionUID = -5303171157390125126L;

	public static byte[] generateAnexoGasto(AnexoGasto pAnexoGastos) throws ParsePropertyException, InvalidFormatException, IOException {
		Map<String, AnexoGasto> anexosGastosXlsMap = new HashMap<String, AnexoGasto>();
		anexosGastosXlsMap.put(Constantes.XLS_MAP_ANEXO_GATOS, pAnexoGastos);
		
		InputStream anexoGastosTemplateInputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_CONSOLIDAR_ANEXO_GASTOS_XLS);
		XLSTransformer xlsTransformer = new XLSTransformer();
		Workbook workbook =  xlsTransformer.transformXLS(anexoGastosTemplateInputStream, anexosGastosXlsMap);
		
		return workbookToBytes(workbook);
	}
	
	public static byte[] generateAnexoGastoSri(List<AnexoGastoSri> pAnexosGastosSri) throws ParsePropertyException, InvalidFormatException, IOException {
		Map<String, List<AnexoGastoSri>> anexosGestosXlsMap = new HashMap<String, List<AnexoGastoSri>>();
		anexosGestosXlsMap.put(Constantes.XLS_MAP_ANEXOS_GATOS_SRI, pAnexosGastosSri);
		
		InputStream anexoGastosTemplateInputStream = LoadTempletesHelper.class.getClassLoader().getResourceAsStream(Constantes.PATH_PLANTILLA_ANEXOS_GASTOS_SRI_XLS);
		XLSTransformer xlsTransformer = new XLSTransformer();
		Workbook workbook =  xlsTransformer.transformXLS(anexoGastosTemplateInputStream, anexosGestosXlsMap);
		
		return workbookToBytes(workbook);
	}
	
	private static byte[] workbookToBytes(Workbook pWorkbook) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			pWorkbook.write(byteArrayOutputStream);
			
		} finally {
			byteArrayOutputStream.close();
		}
		
		byte[] bytes = byteArrayOutputStream.toByteArray();
		
		return bytes;
	}

}