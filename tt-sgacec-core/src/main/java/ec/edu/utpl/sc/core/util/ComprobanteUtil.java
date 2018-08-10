package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

public class ComprobanteUtil implements Serializable {
	
	private static final long serialVersionUID = 7260738605524626593L;

	public static String getSrcDownload(Boolean pDownloadWeb) {
		String srcDownload = Constantes.SRC_WS;
		
		if (pDownloadWeb) {
			srcDownload = Constantes.SRC_WEB;
		}
		
		return srcDownload;
	}

}
