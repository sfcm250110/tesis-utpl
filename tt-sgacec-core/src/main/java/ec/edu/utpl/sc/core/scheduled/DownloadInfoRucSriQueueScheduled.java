package ec.edu.utpl.sc.core.scheduled;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.InfoRucSri;
import ec.edu.utpl.sc.core.gestor.IComprobanteEmpresaGestor;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.queue.QueueServicio;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Configuration
@EnableScheduling
public class DownloadInfoRucSriQueueScheduled {
	
	private static Logger log = Logger.getLogger(DownloadInfoRucSriQueueScheduled.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.EMPRESA_GESTOR)
	private IEmpresaGestor empresaGestor;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_EMPRESA_GESTOR)
	private IComprobanteEmpresaGestor comprobanteEmpresaGestor;

	@Scheduled(cron = Constantes.CRON_1M)
	public void sendRucEmisorDownloadSri() {
		try {
			List<InfoRucSri> infoRucsSri = empresaGestor.getInfoRucsSri();
			List<String> rucEmisores = comprobanteEmpresaGestor.getRucEmisoresByEmpresa();
			
			if (null != rucEmisores && !rucEmisores.isEmpty()) {
				
				for (String rucEmisor : rucEmisores) {
					if (!isInfoRucDownloadSri(infoRucsSri, rucEmisor)) {
						String xml = XmlUtil.rucEmisorToStringXml(rucEmisor);
						QueueServicio.send(xml, Constantes.QUEUE_DOWNLOAD_RUC_EMISOR_SRI);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al enviar a la cola los ruc de los emisores a descargar del Sri. Causa --> " + e);
		}
	}
	
	private Boolean isInfoRucDownloadSri(List<InfoRucSri> pInfoRucsSri, String pRucEmisor) {
		Boolean isInfoRucDownloadSri = Boolean.FALSE;
		
		if (pInfoRucsSri != null && !pInfoRucsSri.isEmpty()) {
			
			for (InfoRucSri infoRucSri : pInfoRucsSri) {
				if (pRucEmisor.equals(infoRucSri.getRuc())) {
					isInfoRucDownloadSri = Boolean.TRUE;
				}
			}
		}
		
		return isInfoRucDownloadSri;
		
	}

}
