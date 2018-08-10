package ec.edu.utpl.sc.core.gestor.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.CheckDownloadSri;
import ec.edu.utpl.sc.core.entity.Empresa;
import ec.edu.utpl.sc.core.gestor.IDownloadSriGestor;
import ec.edu.utpl.sc.core.gestor.ISeleniumGestor;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.DateUtil;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.DOWNLOAD_SRI_GESTOR)
public class DownloadSriGestor implements IDownloadSriGestor {
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.SELENIUM_GESTOR)
	private ISeleniumGestor seleniumGestor;

	@Override
	public void registrarFechaDownloadSri(Empresa pEmpresa) throws UtplException {
		try {
			Date fechaActualMenosDosDias = DateUtil.restarDiasFecha(new Date(), Constantes.I2);
			
			// Se verifica la descarga solo hasta dos dias menos del dia actual
			if (DateUtil.esFechaMenorIgual(pEmpresa.getFechaDownload(), fechaActualMenosDosDias)) {
				CheckDownloadSri checkDownloadSri = seleniumGestor.obtenerTotalComprobantesSri(pEmpresa.getRuc(), pEmpresa.getClaveSri(), DateUtil.obtenerDateFindSri(pEmpresa.getFechaDownload()));
				checkDownloadSri.setRuc(pEmpresa.getRuc());
				checkDownloadSri.setFechaProceso(new Date());
				checkDownloadSri.setFechaDownload(pEmpresa.getFechaDownload());
				
				Map<String, String> parameterValues = new HashMap<String, String>();
				parameterValues.put(ConstantesDb.PARAM_RUC, pEmpresa.getRuc());
				parameterValues.put(ConstantesDb.PARAM_FECHA_DOWNLOAD, DateUtil.parseToDateString(pEmpresa.getFechaDownload(), Constantes.YYYY_MM_DD));
				String sql = DaoUtil.buildSqlParameters(ConstantesDb.CHECK_DOWNLOAD_SRI_FECHA_DOWNLOAD_EJBQL, parameterValues);
				CheckDownloadSri checkDownloadSriFind = crudDao.findOneRow(CheckDownloadSri.class, sql);
				
				if (checkDownloadSriFind == null) {
					crudDao.create(checkDownloadSri);
					
				} else {
					checkDownloadSri.setIdCheckDownloadSri(checkDownloadSriFind.getIdCheckDownloadSri());
					crudDao.update(checkDownloadSri);
				}				
			}
			
			if (DateUtil.esFechaMenor(pEmpresa.getFechaDownload(), fechaActualMenosDosDias)) {
				pEmpresa.setFechaDownload(DateUtil.sumarDiasFecha(pEmpresa.getFechaDownload(), Constantes.I1));
				pEmpresa.setIdEmpresaCrud(pEmpresa.getIdEmpresa());
				crudDao.updateFields(pEmpresa);
				
			} else if (DateUtil.esFechaMayor(pEmpresa.getFechaDownload(), fechaActualMenosDosDias)) {
				pEmpresa.setFechaDownload(DateUtil.sumarDiasFecha(pEmpresa.getFechaDownload(), Constantes.I1));
				pEmpresa.setIdEmpresaCrud(pEmpresa.getIdEmpresa());
				crudDao.updateFields(pEmpresa);
			}
			
		} catch (Exception e) {
			throw new UtplException(e);
			
		}
	}

}
