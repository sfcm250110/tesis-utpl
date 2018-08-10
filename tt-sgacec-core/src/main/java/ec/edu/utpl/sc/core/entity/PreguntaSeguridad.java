package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.utpl.sc.core.base.EntityBase;


/**
 * The persistent class for the utpl_pregunta_seg_tbl database table.
 * 
 */
@Entity
@Table(name="utpl_pregunta_seg")
@NamedQuery(name="PreguntaSeguridad.findAll", query="SELECT p FROM PreguntaSeguridad p")
public class PreguntaSeguridad extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="UTPL_PREGUNTA_SEG_IDPREGUNTASEGURIDAD_GENERATOR", sequenceName="PREGUNTA_SEG_SQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTPL_PREGUNTA_SEG_IDPREGUNTASEGURIDAD_GENERATOR")
	@Column(name="id_pregunta_seguridad")
	private Long idPreguntaSeguridad;

	@Column(name="pregunta_seguridad")
	private String preguntaSeguridad;

	public PreguntaSeguridad() {
	}

	public Long getIdPreguntaSeguridad() {
		return this.idPreguntaSeguridad;
	}

	public void setIdPreguntaSeguridad(Long idPreguntaSeguridad) {
		this.idPreguntaSeguridad = idPreguntaSeguridad;
	}

	public String getPreguntaSeguridad() {
		return this.preguntaSeguridad;
	}

	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

}