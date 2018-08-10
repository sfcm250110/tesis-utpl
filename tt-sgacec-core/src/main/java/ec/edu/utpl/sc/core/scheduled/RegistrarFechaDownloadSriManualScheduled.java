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
import ec.edu.utpl.sc.core.gestor.IAdmGestor;
import ec.edu.utpl.sc.core.gestor.IConsultasGestor;
import ec.edu.utpl.sc.core.queue.QueueServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Configuration
@EnableScheduling
public class RegistrarFechaDownloadSriManualScheduled {
	
	private static Logger log = Logger.getLogger(RegistrarFechaDownloadSriManualScheduled.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.CONSULTAS_GESTOR)
	private IConsultasGestor consultasGestor;
	
	@Autowired
	@Qualifier(Constantes.ADM_GESTOR)
	private IAdmGestor admGestor;

	@Scheduled(cron = Constantes.CRON_30S)
	public void registrarFechaDownloadSriManual() {
		try {
			// Descargar las fechas del Sri que se han enviado a procesar manualmente, por la pagina web
			List<CheckDownloadSri> checksDownloadSri = consultasGestor.obtenerChecksDownloadSri(Constantes.PRE_PROCESADO);
			
			if (null != checksDownloadSri && !checksDownloadSri.isEmpty()) {
				
				for (CheckDownloadSri checkDownloadSriTmp : checksDownloadSri) {
					String xml = XmlUtil.checkDownloadSriToStringXml(checkDownloadSriTmp);
					QueueServicio.send(xml, Constantes.QUEUE_DOWNLOAD_FECHA_SRI_ANEXO);
					
					CheckDownloadSri checkDownloadSriUpdate = new CheckDownloadSri();
					checkDownloadSriUpdate.setFechaProceso(new Date());
					checkDownloadSriUpdate.setEtapa(Constantes.SEND_QUEUE);
					checkDownloadSriUpdate.setIdCheckDownloadSriCrud(checkDownloadSriTmp.getIdCheckDownloadSri());
					crudDao.updateFields(checkDownloadSriUpdate);
				}
			}
			
			
		} catch (Exception e) {
			String mensajeUsuario = "Error al registrar la fecha download Sri Manual";
			
			log.error(mensajeUsuario + Constantes.MSJ_ERROR_CUASA + e);
			admGestor.registerErrorSistema(e, Constantes.MODULO_CORE, Constantes.NIVEL_ERROR, mensajeUsuario);
		}
	}

}
