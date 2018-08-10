package ec.edu.utpl.sc.core.servicio.test.config;

import org.junit.Rule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ec.edu.utpl.sc.core.util.Constantes;

@SuppressWarnings(Constantes.DEPRECATION)
@ContextConfiguration(locations = { Constantes.CLASSPATH_SPRING_CONFIG })
@TransactionConfiguration(transactionManager = Constantes.TRANSACTION_MANAGER, defaultRollback = true)
public class CommonSpringConfigTest {

	@Rule
	public LoggerWatcher loggerWatcher = new LoggerWatcher();

	protected CommonSpringConfigTest() {
		// Constructor vacio para que esta clase no sea instanciada
	}
}
