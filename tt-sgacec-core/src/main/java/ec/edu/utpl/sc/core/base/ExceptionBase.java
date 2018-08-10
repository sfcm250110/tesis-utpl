package ec.edu.utpl.sc.core.base;

import org.apache.log4j.Logger;

import ec.edu.utpl.sc.core.util.Constantes;

public class ExceptionBase extends Exception {
	
	private static final long serialVersionUID = -9213665212098793154L;

	protected static Logger logger = Logger.getLogger(ExceptionBase.class);

	protected String mensaje = null;
	protected String codigoErrorMensaje = null;
	public Exception exception;
	
	public ExceptionBase() {
		super();
	}
	
	public ExceptionBase(String pMessage) {
		super(pMessage);
		this.mensaje = pMessage;
		insertarError();
	}
	
	public ExceptionBase(Exception pException) {
		super(pException);
		this.mensaje = pException.getMessage();
		this.exception = pException;
		insertarError();
	}
	
	/**
	 * Creates a new ServiceManagerException wrapping another exception, and with a detail message.
	 * 
	 * @param pMessage the detail message.
	 * @param pException the wrapped exception.
	 */
	public ExceptionBase(String pMessage, Exception pException) {
		super(pMessage, pException);
		this.exception = pException;
		insertarError();
		return;
	}

	/**
	 * Crea un error detectado en la forma de exception (mensaje, exception)
	 * Cuando recibe solo (exception) omite la insercion.
	 */
	public void insertarError() {
		StringBuffer salida = new StringBuffer();
		String msg = null;
		Throwable throwable = this;

		while (throwable.getCause() != null) {
			throwable = throwable.getCause();
		}
		
		msg = throwable.getMessage();
		for (StackTraceElement te : throwable.getStackTrace()) {
			salida.append(te.toString() + Constantes.BREAK_LINE);
			
			if (throwable.getMessage() != null) {
				msg = throwable.getMessage();
			}
		}

		if (codigoErrorMensaje == null) {
			if (throwable.getMessage() != null) {
				codigoErrorMensaje = throwable.getMessage();
				
			} else {
				codigoErrorMensaje = throwable.getClass().getName();
			}
		}
		
		if (msg != null && msg.length() > 0) {
			mensaje = msg;
			
		} else {
			mensaje = throwable.getClass().getName();
		}
	}

	@Override
	public String getMessage() {
		if (mensaje != null) {
			return mensaje;
			
		} else {
			return super.getMessage();
		}
	}
}
