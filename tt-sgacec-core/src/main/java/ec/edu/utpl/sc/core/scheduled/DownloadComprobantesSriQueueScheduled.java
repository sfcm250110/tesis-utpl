package ec.edu.utpl.sc.core.scheduled;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.gestor.IConsultasGestor;
import ec.edu.utpl.sc.core.queue.QueueServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Configuration
@EnableScheduling
public class DownloadComprobantesSriQueueScheduled {
	
	private static Logger log = Logger.getLogger(DownloadComprobantesSriQueueScheduled.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.CONSULTAS_GESTOR)
	private IConsultasGestor consultasGestor;

	@Scheduled(cron = Constantes.CRON_30S)
	public void sendCheckDownloadSri() {
		try {
			List<CheckDownloadSri> checksDownloadSri = consultasGestor.obtenerChecksDownloadSri(Constantes.REGISTRADO);
			
			if (null != checksDownloadSri && !checksDownloadSri.isEmpty()) {
				
				for (CheckDownloadSri checkDownloadSriTmp : checksDownloadSri) {
					String xml = XmlUtil.checkDownloadSriToStringXml(checkDownloadSriTmp);
					QueueServicio.send(xml, Constantes.QUEUE_DOWNLOAD_COMPROBANTES_SRI);
					
					CheckDownloadSri checkDownloadSriUpdate = new CheckDownloadSri();
					checkDownloadSriUpdate.setFechaProceso(new Date());
					checkDownloadSriUpdate.setEtapa(Constantes.SEND_QUEUE);
					checkDownloadSriUpdate.setIdCheckDownloadSriCrud(checkDownloadSriTmp.getIdCheckDownloadSri());
					crudDao.updateFields(checkDownloadSriUpdate);
				}
			}
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al enviar a la cola los comprobantes a descargar. Causa --> " + e);
		}
	}

}
