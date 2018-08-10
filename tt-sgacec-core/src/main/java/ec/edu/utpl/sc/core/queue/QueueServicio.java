package ec.edu.utpl.sc.core.queue;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import ec.edu.utpl.sc.core.util.UtplException;

public final class QueueServicio {

	private QueueServicio() {
	}

	public static void send(String pMensaje, String pQueue) throws UtplException {
		Connection connection;
		Session session;
		Queue queue;
		MessageProducer producer;
		
		if (pMensaje != null) {
			try {
				connection = PooledConnectionFactoryQueue.getInstance().getPooledConnectionFactory().createConnection();
				session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
				queue = session.createQueue(pQueue);
				producer = session.createProducer(queue);
				producer.setDeliveryMode(DeliveryMode.PERSISTENT);
				connection.start();
				TextMessage textMessage = session.createTextMessage(pMensaje);
				producer.send(textMessage);
				producer.close();
				session.close();
				connection.close();

			} catch (Exception e) {
				throw new UtplException(e);
			}
		}
	}

}
