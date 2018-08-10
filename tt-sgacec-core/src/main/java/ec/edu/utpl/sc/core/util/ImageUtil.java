package ec.edu.utpl.sc.core.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public final class ImageUtil implements Serializable {
	
	private static final long serialVersionUID = -4030635650250043199L;
	
	private static ImageUtil imageUtil;
	
	private static Map<String, String> imagesSession;

	private ImageUtil() {
	}

	public static ImageUtil getInstancia() {
		if (imageUtil == null) {
			imageUtil = new ImageUtil();
			imagesSession = new HashMap<String, String>();
		}
		
		return imageUtil;
	}
	
	public static void addImageSession(String pNombreImage, String pStringImage) {
		imagesSession.put(pNombreImage, pStringImage);
	}
	
	public static String getImageSession(String pNombreImage) {
		return imagesSession.get(pNombreImage);
	}
	
	public static void removeImageSession(String pNombreImage) {
		imagesSession.remove(pNombreImage);
	}
	
	public static void resetImagesSession() {
		imagesSession = new HashMap<String, String>();
	}
	
	public static int sizeImagesSession() {
		return imagesSession.size();
	}
	
	public String generateNotFoundUtpl() throws IOException {
		String stringImage = getImageSession(Constantes.ID_SESSION_IMAGE_NOT_FOUND_UTPL);
		
		if (stringImage == null) {
			stringImage = Constantes.IMAGE_BASE64_NOT_FOUND_UTPL;
			addImageSession(Constantes.ID_SESSION_IMAGE_NOT_FOUND_UTPL, stringImage);
		}
		
		return stringImage;
	}
	
	public String generar(String pNombreImage) throws IOException {
		String stringImage = getImageSession(pNombreImage);
		
		if (stringImage == null) {
			String pathNameImage = Constantes.PATH_DIR_IMAGES + pNombreImage;
			File imageFile = new File(pathNameImage);			
			BufferedImage bufferedImage = ImageIO.read(imageFile);
			String image = null;

			if (bufferedImage != null) {
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, Constantes.TYPE_PNG_ONLY, byteArrayOutputStream);
				byte[] data = byteArrayOutputStream.toByteArray();
				image = Base64Util.codificarBytesBase64(data);
			}
			
			stringImage = Constantes.IMAGE_DATA_BASE_64 + image;
			addImageSession(pNombreImage, stringImage);
		}
		
		return stringImage;
	}
	
	public static void main(String[] args) {
		try {
			String nombreImage = Constantes.NAME_IMAGE_NOT_FOUND_UTPL;
			System.out.print(ImageUtil.getInstancia().generar(nombreImage));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
