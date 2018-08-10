package ec.edu.utpl.sc.core.util;

import java.io.File;
import java.io.Serializable;

public class FileUtil implements Serializable {

	private static final long serialVersionUID = 6147018586865276965L;

	public static File getResourceFile(String pNameFile) {
		return new File(FileUtil.class.getClassLoader().getResource(pNameFile).getFile());
	}
}
