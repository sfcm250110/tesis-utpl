package ec.edu.utpl.sc.core.servicio.test.config;

import java.util.logging.Logger;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class LoggerWatcher extends TestWatcher {
	
	private final static Logger log = Logger.getLogger(LoggerWatcher.class.getName()); 
	
	/**
	 * Metodo que me permite emitir un mensaje de log al iniciar un test
	 */
	@Override
	protected void starting(final Description desc) {
		log.info("Starting: " + desc.getClassName() + " method: " + desc.getMethodName());
	}

	/**
	 * Metodo que me permite emitir un mensaje de log al presentarse un error en el test
	 */
	@Override
	protected void failed(final Throwable error, final Description desc) {
		log.info("Failed: " + desc.getMethodName() + " " + error.getMessage());
	}

	/**
	 * Metodo que me permite emitir un mensaje de log al terminar satisfactoriamente un test
	 */
	@Override
	protected void succeeded(final Description desc) {
		log.info("Success: " + desc.getMethodName());
	}

	/**
	 * Metodo que me permite emitir un mensaje de log al terminar un test
	 */
	@Override
	protected void finished(final Description desc) {
		log.info("Finished: " + desc.getClassName() + " method: " + desc.getMethodName());
	}
}