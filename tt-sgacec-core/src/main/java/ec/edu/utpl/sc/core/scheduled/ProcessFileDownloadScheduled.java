package ec.edu.utpl.sc.core.scheduled;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ec.edu.utpl.sc.core.gestor.IFileGestor;
import ec.edu.utpl.sc.core.gestor.IParametroGeneralGestor;
import ec.edu.utpl.sc.core.util.Constantes;

@Configuration
@EnableScheduling
public class ProcessFileDownloadScheduled {
	
	private static Logger log = Logger.getLogger(ProcessFileDownloadScheduled.class);

	@Autowired
	@Qualifier(Constantes.FILE_GESTOR)
	private IFileGestor fileGestor;
	
	@Autowired
	@Qualifier(Constantes.PARAMETRO_GENERAL_GESTOR)
	private IParametroGeneralGestor parametroGeneralGestor;

	@Scheduled(cron = Constantes.CRON_30M)
	public void processComprobantesXml() {
		try {
			String pathDirProcess = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_PROCESS_CHROME);
			DirectoryStream<Path> filesDirectoryProcess = Files.newDirectoryStream(Paths.get(pathDirProcess), Constantes.TODO_XML);
			
	        for (Path pathComprobanteXml : filesDirectoryProcess) {
	        	fileGestor.uploadComprobanteXml(pathComprobanteXml.toFile());
	        }
			
	        filesDirectoryProcess.close();
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al procesar los comprobantes XML. Causa --> " + e);
		}
	}
	
	@Scheduled(cron = Constantes.CRON_30M)
	public void processComprobantesPdf() {
		try {
			String pathDirProcess = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_PROCESS_CHROME);
			DirectoryStream<Path> filesDirectoryProcess = Files.newDirectoryStream(Paths.get(pathDirProcess), Constantes.TODO_PDF);
			
	        for (Path pathComprobantePdf : filesDirectoryProcess) {
	        	fileGestor.uploadComprobantePdf(pathComprobantePdf.toFile());
	        }
			
	        filesDirectoryProcess.close();
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al procesar los comprobantes PDF. Causa --> " + e);
		}
	}

}
