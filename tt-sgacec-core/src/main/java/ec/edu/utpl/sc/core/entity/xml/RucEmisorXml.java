package ec.edu.utpl.sc.core.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ec.edu.utpl.sc.core.util.Constantes;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = Constantes.SPACE_BLANK, propOrder = { "rucEmisor" })
@XmlRootElement(name = "RucEmisorXml")
public class RucEmisorXml {

	@XmlElement(name = "rucEmisor", required = true)
	protected String rucEmisor;

	public String getRucEmisor() {
		return rucEmisor;
	}

	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}

}