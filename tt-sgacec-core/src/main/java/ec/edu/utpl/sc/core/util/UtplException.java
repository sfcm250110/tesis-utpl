package ec.edu.utpl.sc.core.util;

import ec.edu.utpl.sc.core.base.ExceptionBase;

public class UtplException extends ExceptionBase {
	
	private static final long serialVersionUID = -8877082151455687732L;

	public UtplException(Exception pException) {
		super(pException);
	}

	public UtplException(String pMessage) {
		super(pMessage);
	}	
	
	public UtplException(String pMessage, Exception pException) {
		super(pMessage, pException);
	}	

}
