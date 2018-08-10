package ec.edu.utpl.sc.core.gestor;

import java.util.List;

import ec.edu.utpl.sc.core.util.AnexoGasto;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.UtplException;

public interface IAnexoGastoGestor {
	
	public AnexoGasto generateAnexoGastos(AnexoGasto pAnexoGasto) throws UtplException;
	
	public void consolidarAnexoGastos(AnexoGasto pAnexoGasto) throws UtplException;
	
	public List<AnexoGastoSri> generateAnexoGastosSri(String pPeriodo, String pRucEmpresa) throws UtplException;

}
