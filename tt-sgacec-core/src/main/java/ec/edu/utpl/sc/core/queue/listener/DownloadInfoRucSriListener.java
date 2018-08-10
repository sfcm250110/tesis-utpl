package ec.edu.utpl.sc.core.queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

import ec.edu.utpl.sc.core.util.FwUtplFactory;
import ec.edu.utpl.sc.core.util.QueueUtil;

public class DownloadInfoRucSriListener implements MessageListener {

	private static Logger log = Logger.getLogger(DownloadInfoRucSriListener.class);

	@Override
	public void onMessage(Message pMessage) {
		String messageXml = null;
		
		try {
			messageXml = QueueUtil.getMensajeString(pMessage);
			FwUtplFactory.getIntance().getEmpresaService().downloadInfoRucSri(messageXml);
			
		} catch (JMSException e) {
			// TODO: Guadar error en db
			log.error("Error al procesar el mensaje de la cola los comprobantes a descargar. Causa --> " + e);
		}

	}

}
