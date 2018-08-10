package ec.edu.utpl.sc.core.scheduled;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.gestor.IDownloadSriGestor;
import ec.edu.utpl.sc.core.gestor.IEmpresaGestor;
import ec.edu.utpl.sc.core.util.Constantes;

@Configuration
@EnableScheduling
public class RegistrarFechaDownloadSriScheduled {
	
	private static Logger log = Logger.getLogger(RegistrarFechaDownloadSriScheduled.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.EMPRESA_GESTOR)
	private IEmpresaGestor empresaGestor;
	
	@Autowired
	@Qualifier(Constantes.DOWNLOAD_SRI_GESTOR)
	private IDownloadSriGestor downloadSriGestor;
	
	//TODO:
	@Scheduled(cron = Constantes.CRON_5H)
	//@Scheduled(cron = Constantes.CRON_30S)
	public void registrarFechaDownloadSri() {
		try {
			// Descargar solo cuando la empresa se encuentra activa
			List<Empresa> empresas = empresaGestor.obtenerEmpresasActiva();
			
			if (empresas != null && !empresas.isEmpty()) {
				for (Empresa empresa : empresas) {
					
					// Descargar solo cuando el usuario se encuentra activo
					if (empresaGestor.usuarioEmpresaActivo(empresa.getIdEmpresa())) {
						downloadSriGestor.registrarFechaDownloadSri(empresa);
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al registrar la fecha download Sri. Causa --> " + e);
		}
	}

}
