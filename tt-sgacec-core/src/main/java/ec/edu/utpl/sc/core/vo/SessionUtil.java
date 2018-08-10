package ec.edu.utpl.sc.core.vo;

import java.util.HashMap;
import java.util.Map;

public class SessionUtil {

	private static Map<String, Object> objetosSession;

	static {
		objetosSession = new HashMap<String, Object>();
	}

	public static void addObjetoSession(String nombreObjecto, Object contenidoObjecto) {
		objetosSession.put(nombreObjecto, contenidoObjecto);
	}

	public static void removeObjetoSession(String nombreObjecto) {
		objetosSession.remove(nombreObjecto);
	}

	public static Object getObjetoSession(String nombreObjecto) {
		return objetosSession.get(nombreObjecto);
	}

	public static void resetObjetosSession() {
		objetosSession = new HashMap<String, Object>();
	}

}
