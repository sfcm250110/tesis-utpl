package ec.edu.utpl.sc.core.util;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class QueueUtil implements Serializable {
	
	private static final long serialVersionUID = -4170066396462640394L;

	public static String getMensajeString(Message pMessage) throws JMSException {
		if (pMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) pMessage;
			
			return textMessage.getText();
		}
		
		return null;
	}
}