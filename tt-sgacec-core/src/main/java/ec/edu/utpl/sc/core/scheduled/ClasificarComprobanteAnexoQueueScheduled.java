package ec.edu.utpl.sc.core.scheduled;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ec.edu.utpl.sc.core.dao.IComprobanteDao;
import ec.edu.utpl.sc.core.gestor.IComprobanteEmpresaGestor;
import ec.edu.utpl.sc.core.queue.QueueServicio;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Configuration
@EnableScheduling
public class ClasificarComprobanteAnexoQueueScheduled {
	
	private static Logger log = Logger.getLogger(ClasificarComprobanteAnexoQueueScheduled.class);
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_EMPRESA_GESTOR)
	private IComprobanteEmpresaGestor comprobanteEmpresaGestor;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_DAO)
	private IComprobanteDao comprobanteDao;

	@Scheduled(cron = Constantes.CRON_30S)
	public void sendComprobantesClasificar() {
		try {
			List<ComprobanteEmpresa> comprobantesEmpresa = comprobanteEmpresaGestor.getComprobantesEmpresaClasificarAnexo();
			
			if (null != comprobantesEmpresa && !comprobantesEmpresa.isEmpty()) {
				
				for (ComprobanteEmpresa comprobanteEmpresa : comprobantesEmpresa) {
					String xml = XmlUtil.comprobanteEmpresaToStringXml(comprobanteEmpresa);
					QueueServicio.send(xml, Constantes.QUEUE_CLASIFICAR_COMPROBANTES_ANEXO);
					
					Map<String, String> parameterValues = new HashMap<String, String>();
					parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.SEND_QUEUE.toString());
					parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
					String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_CLASIFICAR, parameterValues);
					comprobanteDao.update(sql, comprobanteEmpresa.getRuc());
				}
			}
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al enviar a la cola los comprobantes a descargar. Causa --> " + e);
		}
	}

}
