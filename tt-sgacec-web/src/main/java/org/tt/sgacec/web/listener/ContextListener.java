package org.tt.sgacec.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import ec.edu.utpl.sc.core.util.FwUtplFactory;

public class ContextListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(ContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			FwUtplFactory.getIntance().getGenericoService().initApplication();
			log.info("Contexto de spring framework inicializado exitosamente");

		} catch (Exception e) {
			log.error("Error al inicializar el contexto de spring framework. Causa --> " + e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

}
