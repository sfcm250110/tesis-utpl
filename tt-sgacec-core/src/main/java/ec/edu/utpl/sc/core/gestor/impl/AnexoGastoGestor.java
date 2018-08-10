package ec.edu.utpl.sc.core.gestor.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.utpl.sc.core.dao.IComprobanteDao;
import ec.edu.utpl.sc.core.dao.ICrudDao;
import ec.edu.utpl.sc.core.entity.ComprobanteFisico;
import ec.edu.utpl.sc.core.gestor.IAnexoGastoGestor;
import ec.edu.utpl.sc.core.gestor.IComprobanteGestor;
import ec.edu.utpl.sc.core.util.AnexoGasto;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.Comprobante;
import ec.edu.utpl.sc.core.util.ComprobanteEmpresa;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.ConstantesDb;
import ec.edu.utpl.sc.core.util.DaoUtil;
import ec.edu.utpl.sc.core.util.DateUtil;
import ec.edu.utpl.sc.core.util.UtplException;

@Repository(Constantes.ANEXO_GASTO_GESTOR)
public class AnexoGastoGestor implements IAnexoGastoGestor {
	
	@Autowired
	@Qualifier(Constantes.CRUD_DAO)
	private ICrudDao crudDao;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_GESTOR)
	private IComprobanteGestor comprobanteGestor;
	
	@Autowired
	@Qualifier(Constantes.COMPROBANTE_DAO)
	private IComprobanteDao comprobanteDao;

	@Override
	public AnexoGasto generateAnexoGastos(AnexoGasto pAnexoGasto) throws UtplException {
		try {
			// Procesar los comprobantes fisicos
			AnexoGasto anexoGastosFisico = getAnexoGastosFisico(pAnexoGasto.getRuc(), pAnexoGasto.getPeriodo());
			
			// Procesar los comprobantes electronicos
			AnexoGasto anexoGastoElectronico = getAnexoGastosElectronico(pAnexoGasto.getRuc(), pAnexoGasto.getPeriodo(), Boolean.TRUE);
			
			// Consolidar los comprobantes fisicos y electronicos
			AnexoGasto anexoGasto = getAnexoGastos(pAnexoGasto, anexoGastosFisico, anexoGastoElectronico);
			
			return anexoGasto;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	private AnexoGasto getAnexoGastosFisico(String pRuc, String pPeriodo) throws UtplException {
		AnexoGasto anexoGasto = new AnexoGasto();
		List<ComprobanteFisico> comprobantesFisicosFind = comprobanteGestor.getComprobantesFisicoAnexo(pRuc, pPeriodo);
		List<Comprobante> comprobantesFisicos = new ArrayList<Comprobante>();
		List<Comprobante> comprobantesSinClasificar = new ArrayList<Comprobante>();
		
		BigDecimal vivienda = new BigDecimal(Constantes.I0);
		BigDecimal educacion = new BigDecimal(Constantes.I0);
		BigDecimal alimentacion = new BigDecimal(Constantes.I0);
		BigDecimal vestimenta = new BigDecimal(Constantes.I0);
		BigDecimal salud = new BigDecimal(Constantes.I0);
		BigDecimal sinClasificar = new BigDecimal(Constantes.I0);
		BigDecimal totalAnexo = new BigDecimal(Constantes.I0);
		
		for (ComprobanteFisico comprobanteFisico : comprobantesFisicosFind) {
			Comprobante comprobante = new Comprobante();
			comprobante.setTipo(Constantes.LBL_FISICO);
			comprobante.setRucEmisor(comprobanteFisico.getRucEmisor());
			comprobante.setRazonSocialEmisor(comprobanteFisico.getRazonSocialEmisor());
			comprobante.setNumeroComprobante(comprobanteFisico.getEstablecimiento() + comprobanteFisico.getPuntoEmision() + comprobanteFisico.getSecuencial());
			comprobante.setFechaEmision(DateUtil.parseToDateString(comprobanteFisico.getFechaEmision(), Constantes.YYYY_MM_DD));
			comprobante.setBaseImponible(comprobanteFisico.getBaseImponible());
			comprobante.setVivienda(comprobanteFisico.getVivienda());
			comprobante.setEducacion(comprobanteFisico.getEducacion());
			comprobante.setAlimentacion(comprobanteFisico.getAlimentacion());
			comprobante.setVestimenta(comprobanteFisico.getVestimenta());
			comprobante.setSalud(comprobanteFisico.getSalud());
			
			if (comprobanteFisico.getClasificado()) {
				vivienda = vivienda.add(new BigDecimal(comprobanteFisico.getVivienda()));
				educacion = educacion.add(new BigDecimal(comprobanteFisico.getEducacion()));
				alimentacion = alimentacion.add(new BigDecimal(comprobanteFisico.getAlimentacion()));
				vestimenta = vestimenta.add(new BigDecimal(comprobanteFisico.getVestimenta()));
				salud = salud.add(new BigDecimal(comprobanteFisico.getSalud()));
				comprobantesFisicos.add(comprobante);
				
			} else {
				sinClasificar = sinClasificar.add(new BigDecimal(comprobanteFisico.getBaseImponible()));
				comprobantesSinClasificar.add(comprobante);
			}
		}
		
		totalAnexo = totalAnexo.add(new BigDecimal(vivienda.doubleValue())).add(new BigDecimal(educacion.doubleValue())).add(new BigDecimal(alimentacion.doubleValue())).add(new BigDecimal(vestimenta.doubleValue())).add(new BigDecimal(salud.doubleValue())).add(new BigDecimal(sinClasificar.doubleValue()));
		
		anexoGasto.setVivienda(vivienda.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setEducacion(educacion.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setAlimentacion(alimentacion.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setVestimenta(vestimenta.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setSalud(salud.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setSinClasificar(sinClasificar.doubleValue());
		anexoGasto.setTotalAnexo(totalAnexo.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setComprobantesClasificados(comprobantesFisicos);
		anexoGasto.setComprobantesSinClasificar(comprobantesSinClasificar);
		
		return anexoGasto;
	}
	
	private AnexoGasto getAnexoGastosElectronico(String pRuc, String pPeriodo, Boolean isGenerate) throws UtplException {
		AnexoGasto anexoGasto = new AnexoGasto();
		
		BigDecimal vivienda = new BigDecimal(Constantes.I0);
		BigDecimal educacion = new BigDecimal(Constantes.I0);
		BigDecimal alimentacion = new BigDecimal(Constantes.I0);
		BigDecimal vestimenta = new BigDecimal(Constantes.I0);
		BigDecimal salud = new BigDecimal(Constantes.I0);
		BigDecimal sinClasificar = new BigDecimal(Constantes.I0);
		BigDecimal totalAnexo = new BigDecimal(Constantes.I0);
		
		List<Comprobante> comprobantesElectronicos = new ArrayList<Comprobante>();
		List<Comprobante> comprobantesSinClasificar = new ArrayList<Comprobante>();
		
		if (isGenerate) {
			List<ComprobanteEmpresa> comprobantesEmpresa = comprobanteGestor.getComprobantesEmpresaAnexo(pRuc, pPeriodo);
			
			for (ComprobanteEmpresa comprobanteEmpresa : comprobantesEmpresa) {
				Comprobante comprobante = new Comprobante();
				comprobante.setTipo(Constantes.LBL_ELECTRONICO);
				comprobante.setRucEmisor(comprobanteEmpresa.getRucEmisor());
				comprobante.setRazonSocialEmisor(comprobanteEmpresa.getRazonSocialEmisor());
				comprobante.setNumeroComprobante(comprobanteEmpresa.getEstablecimiento() + comprobanteEmpresa.getPuntoEmision() + comprobanteEmpresa.getSecuencial());
				comprobante.setFechaEmision(DateUtil.parseToDateString(comprobanteEmpresa.getFechaEmision(), Constantes.YYYY_MM_DD));
				comprobante.setBaseImponible(comprobanteEmpresa.getBaseImponible().doubleValue());
				comprobante.setVivienda(comprobanteEmpresa.getVivienda().doubleValue());
				comprobante.setEducacion(comprobanteEmpresa.getEducacion().doubleValue());
				comprobante.setAlimentacion(comprobanteEmpresa.getAlimentacion().doubleValue());
				comprobante.setVestimenta(comprobanteEmpresa.getVestimenta().doubleValue());
				comprobante.setSalud(comprobanteEmpresa.getSalud().doubleValue());
				
				if (comprobanteEmpresa.getClasificado()) {
					vivienda = vivienda.add(comprobanteEmpresa.getVivienda());
					educacion = educacion.add(comprobanteEmpresa.getEducacion());
					alimentacion = alimentacion.add(comprobanteEmpresa.getAlimentacion());
					vestimenta = vestimenta.add(comprobanteEmpresa.getVestimenta());
					salud = salud.add(comprobanteEmpresa.getSalud());
					comprobantesElectronicos.add(comprobante);
					
				} else {
					sinClasificar = sinClasificar.add(comprobanteEmpresa.getBaseImponible());
					comprobantesSinClasificar.add(comprobante);
				}
			}
			
			totalAnexo = totalAnexo.add(new BigDecimal(vivienda.doubleValue())).add(new BigDecimal(educacion.doubleValue())).add(new BigDecimal(alimentacion.doubleValue())).add(new BigDecimal(vestimenta.doubleValue())).add(new BigDecimal(salud.doubleValue())).add(new BigDecimal(sinClasificar.doubleValue()));
		}
		
		anexoGasto.setVivienda(vivienda.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setEducacion(educacion.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setAlimentacion(alimentacion.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setVestimenta(vestimenta.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setSalud(salud.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setSinClasificar(sinClasificar.doubleValue());
		anexoGasto.setTotalAnexo(totalAnexo.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		anexoGasto.setComprobantesClasificados(comprobantesElectronicos);
		anexoGasto.setComprobantesSinClasificar(comprobantesSinClasificar);
		
		
		return anexoGasto;
	}
	
	private AnexoGasto getAnexoGastos(AnexoGasto pAnexoGasto, AnexoGasto pAnexoGastosFisico, AnexoGasto pAnexoGastoElectronico) throws UtplException {
		List<Comprobante> comprobantesClasificados = new ArrayList<Comprobante>();
		List<Comprobante> comprobantesSinClasificar = new ArrayList<Comprobante>();
		
		BigDecimal vivienda = new BigDecimal(pAnexoGastosFisico.getVivienda()).add(new BigDecimal(pAnexoGastoElectronico.getVivienda()));
		BigDecimal educacion = new BigDecimal(pAnexoGastosFisico.getEducacion()).add(new BigDecimal(pAnexoGastoElectronico.getEducacion()));
		BigDecimal alimentacion = new BigDecimal(pAnexoGastosFisico.getAlimentacion()).add(new BigDecimal(pAnexoGastoElectronico.getAlimentacion()));
		BigDecimal vestimenta = new BigDecimal(pAnexoGastosFisico.getVestimenta()).add(new BigDecimal(pAnexoGastoElectronico.getVestimenta()));
		BigDecimal salud = new BigDecimal(pAnexoGastosFisico.getSalud()).add(new BigDecimal(pAnexoGastoElectronico.getSalud()));
		BigDecimal sinClasificar = new BigDecimal(pAnexoGastosFisico.getSinClasificar()).add(new BigDecimal(pAnexoGastoElectronico.getSinClasificar()));
		BigDecimal totalAnexo = new BigDecimal(pAnexoGastosFisico.getTotalAnexo()).add(new BigDecimal(pAnexoGastoElectronico.getTotalAnexo()));
		
		comprobantesClasificados.addAll(pAnexoGastosFisico.getComprobantesClasificados());
		comprobantesClasificados.addAll(pAnexoGastoElectronico.getComprobantesClasificados());
		comprobantesSinClasificar.addAll(pAnexoGastosFisico.getComprobantesSinClasificar());
		comprobantesSinClasificar.addAll(pAnexoGastoElectronico.getComprobantesSinClasificar());
		
		pAnexoGasto.setVivienda(vivienda.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pAnexoGasto.setEducacion(educacion.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pAnexoGasto.setAlimentacion(alimentacion.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pAnexoGasto.setVestimenta(vestimenta.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pAnexoGasto.setSalud(salud.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pAnexoGasto.setSinClasificar(sinClasificar.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pAnexoGasto.setTotalAnexo(totalAnexo.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pAnexoGasto.setComprobantesClasificados(comprobantesClasificados);
		pAnexoGasto.setComprobantesSinClasificar(comprobantesSinClasificar);
		
		return pAnexoGasto;
	}

	@Override
	public void consolidarAnexoGastos(AnexoGasto pAnexoGasto) throws UtplException {
		try {
			List<Comprobante> comprobantes = new ArrayList<Comprobante>();
			comprobantes.addAll(pAnexoGasto.getComprobantesSinClasificar());
			comprobantes.addAll(pAnexoGasto.getComprobantesClasificados());
			
			for (Comprobante comprobante : comprobantes) {
				Double vivienda = Constantes.D0;
				Double educacion = Constantes.D0;
				Double alimentacion = Constantes.D0;
				Double vestimenta = Constantes.D0;
				Double salud = Constantes.D0;
				Boolean clasificado = Boolean.FALSE;
				
				if (comprobante.getVivienda() != null && !Constantes.D0.equals(comprobante.getVivienda())) {
					vivienda = comprobante.getVivienda();
				}
				
				if (comprobante.getEducacion() != null && !Constantes.D0.equals(comprobante.getEducacion())) {
					educacion = comprobante.getEducacion();
				}
				
				if (comprobante.getAlimentacion() != null && !Constantes.D0.equals(comprobante.getAlimentacion())) {
					alimentacion = comprobante.getAlimentacion();
				}
				
				if (comprobante.getVestimenta() != null && !Constantes.D0.equals(comprobante.getVestimenta())) {
					vestimenta = comprobante.getVestimenta();
				}
				
				if (comprobante.getSalud() != null && !Constantes.D0.equals(comprobante.getSalud())) {
					salud = comprobante.getSalud();
				}
				
				if (!Constantes.D0.equals(vivienda) || !Constantes.D0.equals(educacion) || !Constantes.D0.equals(alimentacion) || !Constantes.D0.equals(vestimenta) || !Constantes.D0.equals(salud)) {
					clasificado = Boolean.TRUE;
				}
				
				String establecimiento = comprobante.getNumeroComprobante().substring(Constantes.I0, Constantes.I3);
				String puntoEmision = comprobante.getNumeroComprobante().substring(Constantes.I3, Constantes.I6);
				String secuencial = comprobante.getNumeroComprobante().substring(Constantes.I6, comprobante.getNumeroComprobante().length());
				
				Map<String, String> parameterValues = new HashMap<String, String>();
				parameterValues.put(ConstantesDb.PARAM_CLASIFICADO, clasificado.toString());
				parameterValues.put(ConstantesDb.PARAM_VIVIENDA, vivienda.toString());
				parameterValues.put(ConstantesDb.PARAM_EDUCACION, educacion.toString());
				parameterValues.put(ConstantesDb.PARAM_ALIMENTACION, alimentacion.toString());
				parameterValues.put(ConstantesDb.PARAM_VESTIMENTA, vestimenta.toString());
				parameterValues.put(ConstantesDb.PARAM_SALUD, salud.toString());
				parameterValues.put(ConstantesDb.PARAM_RUC_EMISOR, comprobante.getRucEmisor());
				parameterValues.put(ConstantesDb.PARAM_ESTABLECIMIENTO, establecimiento);
				parameterValues.put(ConstantesDb.PARAM_PUNTO_EMISION, puntoEmision);
				parameterValues.put(ConstantesDb.PARAM_SECUENCIAL, secuencial);
				
				if (Constantes.LBL_ELECTRONICO.equals(comprobante.getTipo())) {
					String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_RE_CLASIFICADO, parameterValues);
					comprobanteDao.update(sql, pAnexoGasto.getRuc());
					
				} else if (Constantes.LBL_FISICO.equals(comprobante.getTipo())) {
					String sql = DaoUtil.buildSqlParameters(ConstantesDb.UPDATE_COMPROBANTE_RE_CLASIFICADO_FISICO, parameterValues);
					crudDao.updateNativeQuery(sql);
				}
			}
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}
	
	@Override
	public List<AnexoGastoSri> generateAnexoGastosSri(String pPeriodo, String pRucEmpresa) throws UtplException {
		try {
			List<AnexoGastoSri> anexosGastoSri = new ArrayList<AnexoGastoSri>();
			
			// Procesar los comprobantes fisicos
			List<AnexoGastoSri> anexosGastoSriFisicos = comprobanteGestor.findAnexosGastoSri(pPeriodo);
			
			// Procesar los comprobantes electronicos
			//TODO:List<AnexoGastoSri> anexosGastoSriElectronicos = comprobanteDao.findAnexosGastoSri(pPeriodo, pRucEmpresa);
			
			anexosGastoSri.addAll(anexosGastoSriFisicos);
			//TODO:anexosGastoSri.addAll(anexosGastoSriElectronicos);
			
			return anexosGastoSri;
			
		} catch (Exception e) {
			throw new UtplException(e);
		}
	}

}
