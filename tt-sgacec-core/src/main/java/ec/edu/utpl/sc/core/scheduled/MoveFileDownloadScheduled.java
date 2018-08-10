package ec.edu.utpl.sc.core.scheduled;

import java.io.File;
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

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.gestor.IParametroGeneralGestor;
import ec.edu.utpl.sc.core.util.Constantes;

@Configuration
@EnableScheduling
public class MoveFileDownloadScheduled {
	
	private static Logger log = Logger.getLogger(MoveFileDownloadScheduled.class);
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.PARAMETRO_GENERAL_GESTOR)
	private IParametroGeneralGestor parametroGeneralGestor;

	@Scheduled(cron = Constantes.CRON_30M)
	public void moveComprobantesXml() {
		try {
			String pathDirDownload = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_DOWNLOAD_CHROME);
			String pathDirProcess = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_PROCESS_CHROME);
			
			// Mover mas comprobantes cuando no existan comprobantes por procesar en el directorio de proceso
			DirectoryStream<Path> directoryXmlEmpty = Files.newDirectoryStream(Paths.get(pathDirProcess), Constantes.TODO_XML);
			
			if (!directoryXmlEmpty.iterator().hasNext()) {
				DirectoryStream<Path> filesDirectoryDownload = Files.newDirectoryStream(Paths.get(pathDirDownload), Constantes.TODO_XML);
				
		        for (Path comprobanteMove : filesDirectoryDownload) {
		            String destino = pathDirProcess + File.separatorChar + comprobanteMove.getFileName().toString();
		            Files.move(comprobanteMove, Paths.get(destino));
		        }
				
		        filesDirectoryDownload.close();
			}
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al mover los comprobantes xml para procesar. Causa --> " + e);
		}
	}
	
	@Scheduled(cron = Constantes.CRON_30M)
	public void moveComprobantesPdf() {
		try {
			String pathDirDownload = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_DOWNLOAD_CHROME);
			String pathDirProcess = parametroGeneralGestor.obtenerValorParametroGeneral(Constantes.SESSION_PG_PATH_DIR_PROCESS_CHROME);
			
			// Mover mas comprobantes cuando no existan comprobantes por procesar en el directorio de proceso 
			DirectoryStream<Path> directoryPdfEmpty = Files.newDirectoryStream(Paths.get(pathDirProcess), Constantes.TODO_PDF);
			
			if (!directoryPdfEmpty.iterator().hasNext()) {
				DirectoryStream<Path> filesDirectoryDownload = Files.newDirectoryStream(Paths.get(pathDirDownload), Constantes.TODO_PDF);
				
		        for (Path comprobanteMove : filesDirectoryDownload) {
		            String destino = pathDirProcess + File.separatorChar + comprobanteMove.getFileName().toString();
		            Files.move(comprobanteMove, Paths.get(destino));
		        }
				
		        filesDirectoryDownload.close();
			}
			
		} catch (Exception e) {
			// TODO: Guadar error en db
			log.error("Error al mover los comprobantes pdf para procesar. Causa --> " + e);
		}
	}

}
