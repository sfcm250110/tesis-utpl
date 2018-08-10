package ec.edu.utpl.sc.core.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

public class CodigoBarrasUtil implements Serializable {
	
	private static final long serialVersionUID = -4398736986349064117L;

	private static CodigoBarrasUtil codigoBarrasUtil;

	private CodigoBarrasUtil() {
	}

	public static CodigoBarrasUtil getInstancia() {
		if (codigoBarrasUtil == null) {
			codigoBarrasUtil = new CodigoBarrasUtil();
		}
		
		return codigoBarrasUtil;
	}

	public String generar(String pNumeroAutorizacion) throws BarcodeException, OutputException, IOException {
		String stringImage = Constantes.IMAGE_DATA_BASE_64;
		ByteArrayOutputStream byteArrayOutputStream = null;
		
		try {
			Barcode barcode = BarcodeFactory.createCode128B(pNumeroAutorizacion);
			barcode.setDrawingText(Boolean.FALSE);
			barcode.setBarWidth(Constantes.BARCODE_WIDTH);
			barcode.setBarHeight(Constantes.BARCODE_HEIGHT);
			
			byteArrayOutputStream = new ByteArrayOutputStream();
			BarcodeImageHandler.writePNG(barcode, byteArrayOutputStream);
			byteArrayOutputStream.flush();
			byte[] data = byteArrayOutputStream.toByteArray();
			stringImage = stringImage + Base64Util.codificarBytesBase64(data);
			
		} finally {
			byteArrayOutputStream.close();
		}
		
		return stringImage;
	}

}
