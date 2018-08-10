package ec.edu.utpl.sc.core.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.edu.utpl.sc.core.gestor.IAnexoGastoGestor;
import ec.edu.utpl.sc.core.servicio.IAnexoGastoServicio;
import ec.edu.utpl.sc.core.util.AnexoGasto;
import ec.edu.utpl.sc.core.util.AnexoGastoSri;
import ec.edu.utpl.sc.core.util.Constantes;
import ec.edu.utpl.sc.core.util.UtplException;

@Service(Constantes.ANEXO_GASTO_SERVICIO)
public class AnexoGastoServicio implements IAnexoGastoServicio {
	
	@Autowired
	@Qualifier(Constantes.ANEXO_GASTO_GESTOR)
	private IAnexoGastoGestor anexoGastoGestor;

	@Override
	public AnexoGasto generateAnexoGastos(AnexoGasto pAnexoGasto) throws UtplException {
		return anexoGastoGestor.generateAnexoGastos(pAnexoGasto);
	}

	@Override
	public void consolidarAnexoGastos(AnexoGasto pAnexoGasto) throws UtplException {
		anexoGastoGestor.consolidarAnexoGastos(pAnexoGasto);
	}

	@Override
	public List<AnexoGastoSri> generateAnexoGastosSri(String pRuc, String pPeriodo) throws UtplException {
		return anexoGastoGestor.generateAnexoGastosSri(pRuc, pPeriodo);
	}

}
