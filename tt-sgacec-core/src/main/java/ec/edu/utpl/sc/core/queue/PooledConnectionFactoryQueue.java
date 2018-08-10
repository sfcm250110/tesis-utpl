package ec.edu.utpl.sc.core.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;

import ec.edu.utpl.sc.core.util.Constantes;

public class PooledConnectionFactoryQueue {
	
	private static final int maximumActive = 10;
	private static final int maxSessioCon = 500;
	private static PooledConnectionFactory pcFactory = null;
	private static final PooledConnectionFactoryQueue instance = new PooledConnectionFactoryQueue();
	private static final String url = "failover:(tcp://" + Constantes.JMS_IP + ":" + Constantes.JMS_PUERTO + ")?randomize=false&maxReconnectDelay=" + Constantes.JMS_RECONEXION_DELAY;
	
	private PooledConnectionFactoryQueue() {
	}
	
	public static PooledConnectionFactoryQueue getInstance() {
		if (pcFactory == null) {
			ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
			activeMQConnectionFactory.setUserName(Constantes.JMS_USUARIO);
			activeMQConnectionFactory.setPassword(Constantes.JMS_CLAVE);
			activeMQConnectionFactory.setBrokerURL(url);
			activeMQConnectionFactory.setAlwaysSyncSend(Boolean.FALSE);
			activeMQConnectionFactory.setUseAsyncSend(Boolean.FALSE);
			activeMQConnectionFactory.setCopyMessageOnSend(Boolean.FALSE);
			activeMQConnectionFactory.setOptimizeAcknowledge(Boolean.TRUE);
			activeMQConnectionFactory.setOptimizedMessageDispatch(Boolean.FALSE);
			
			pcFactory = new PooledConnectionFactory(activeMQConnectionFactory);
			pcFactory.setMaxConnections(maximumActive);
			pcFactory.setIdleTimeout(Constantes.I0);
			pcFactory.setMaximumActiveSessionPerConnection(maxSessioCon);
		}
		
		return instance;
	}
	
	public PooledConnectionFactory getPooledConnectionFactory() {
		return pcFactory;
	}
	
	@Override
	protected void finalize() throws Throwable {
		pcFactory.stop();
		super.finalize();
	}

}
