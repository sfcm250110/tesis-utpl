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
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.queue.QueueServicio;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.XmlUtil;

@Configuration
@EnableScheduling
public class DownloadComprobantesSriWsQueueScheduled {
	
	private static Logger log = Logger.getLogger(DownloadComprobantesSriWsQueueScheduled.class);
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_DAO)
	private IComprobanteDao comprobanteDao;
	
	@Autowired
	@Qualifier(Constantes.EMPRESA_GESTOR)
	private IEmpresaGestor empresaGestor;

	@Scheduled(cron = Constantes.CRON_30S)
	public void sendComprobanteEmpresaSri() {
		try {
			List<Empresa> empresas = empresaGestor.obtenerEmpresasActiva();
			
			if (empresas != null && !empresas.isEmpty()) {
				for (Empresa empresa : empresas) {
					List<ComprobanteEmpresa> comprobantesEmpresa = comprobanteDao.findListRow(ConstantesDb.COMPROBANTES_EMPRESA_REGISTRADO, empresa.getRuc());
					
					if (comprobantesEmpresa != null && !comprobantesEmpresa.isEmpty()) {
						
						for (ComprobanteEmpresa comprobanteEmpresa : comprobantesEmpresa) {
							String xml = XmlUtil.comprobanteEmpresaToStringXml(comprobanteEmpresa);
							QueueServicio.send(xml, Constantes.QUEUE_DOWNLOAD_COMPROBANTES_WS_SRI);
							
							Map<String, String> parameterValues = new HashMap<String, String>();
							parameterValues.put(ConstantesDb.PARAM_NUMERO_AUTORIZACION, comprobanteEmpresa.getNumeroAutorizacion());
							parameterValues.put(ConstantesDb.PARAM_ESTADO, Constantes.SEND_QUEUE.toString());
							String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_ESTADO, parameterValues);
							comprobanteDao.update(sql, comprobanteEmpresa.getRuc());
						}
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al enviar a la cola los comprobantes a descargar ws. Causa --> " + e);
		}
	}

}
