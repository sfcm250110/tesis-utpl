package org.tt.sgacec.web.util;

import java.io.Serializable;
import java.math.BigDecimal;

import org.primefaces.model.chart.PieChartModel;

import ec.edu.utpl.sc.core.util.AnexoGasto;
import ec.edu.utpl.sc.core.util.Constantes;

/**
 * 
 * @author Santiago Cabrera M.
 * @revision $Revision: 1.0 $
 */
public final class GraphicsUtil implements Serializable {
	
	private static final long serialVersionUID = -4407172472870568920L;
	
	private static final GraphicsUtil instance = new GraphicsUtil();

	private GraphicsUtil() {
	}

	public static GraphicsUtil getIntance() {
		return instance;
	}
	
	public PieChartModel generatePieChartModel(String pTitle, String pCategoryInit, String pCategoryFinal, Double pValueMaximo, Double pValueTipoGasto) {
		PieChartModel pieChartModel = new PieChartModel();
		
		pieChartModel.set(pCategoryInit, new BigDecimal(pValueMaximo).setScale(Constantes.I2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pieChartModel.set(pCategoryFinal, new BigDecimal(pValueTipoGasto).setScale(Constantes.I2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		
		pieChartModel.setTitle(pTitle);
		pieChartModel.setShowDataLabels(Boolean.TRUE);
		pieChartModel.setDataLabelFormatString(Constantes.LABEL_FORMAT_CHAR_F1);
		pieChartModel.setLegendPosition(Constantes.LEGEND_POSITION_E_CHAR);
		pieChartModel.setDiameter(Constantes.DIAMETER_CHAR_110);
		
		return pieChartModel;
	}
	
	public PieChartModel generateAnexoGastoPieChartModel(AnexoGasto pAnexoGasto) {
		PieChartModel pieChartModel = new PieChartModel();
		
		pieChartModel.set(Constantes.LBL_ALIMENTACION, new BigDecimal(pAnexoGasto.getAlimentacion()).setScale(Constantes.I2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pieChartModel.set(Constantes.LBL_VESTIMENTA, new BigDecimal(pAnexoGasto.getVestimenta()).setScale(Constantes.I2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pieChartModel.set(Constantes.LBL_EDUCACION, new BigDecimal(pAnexoGasto.getEducacion()).setScale(Constantes.I2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pieChartModel.set(Constantes.LBL_SALUD, new BigDecimal(pAnexoGasto.getSalud()).setScale(Constantes.I2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		pieChartModel.set(Constantes.LBL_VIVIENDA, new BigDecimal(pAnexoGasto.getVivienda()).setScale(Constantes.I2, BigDecimal.ROUND_HALF_EVEN).doubleValue());
		
		pieChartModel.setTitle(Constantes.LBL_ANEXO_GASTOS);
		pieChartModel.setShowDataLabels(Boolean.TRUE);
		pieChartModel.setDataLabelFormatString(Constantes.LABEL_FORMAT_CHAR_F1);
		pieChartModel.setLegendPosition(Constantes.LEGEND_POSITION_E_CHAR);
		pieChartModel.setDiameter(Constantes.DIAMETER_CHAR_110);
		
		return pieChartModel;
	}
	
}