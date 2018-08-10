package ec.edu.utpl.sc.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.utpl.sc.core.base.EntityBase;


/**
 * The persistent class for the utpl_usuario_empresa database table.
 * 
 */
@Entity
@Table(name="utpl_usuario_empresa")
@NamedQuery(name="UsuarioEmpresa.findAll", query="SELECT e FROM UsuarioEmpresa e")
public class UsuarioEmpresa extends EntityBase implements Serializable {
	
	private static final long serialVersionUID = -4061516454062695147L;
	
	private Long idUsuarioEmpresa;
	private Usuario usuario;
	private Empresa empresa;
	
	@Id
	@SequenceGenerator(name="UTPL_USUEMP_IDUSUEMP_GENERATOR", sequenceName="USUARIO_EMPRESA_SQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UTPL_USUEMP_IDUSUEMP_GENERATOR")
	@Column(name="ID_USU_EMP")
	public Long getIdUsuarioEmpresa() {
		return idUsuarioEmpresa;
	}

	public void setIdUsuarioEmpresa(Long idUsuarioEmpresa) {
		this.idUsuarioEmpresa = idUsuarioEmpresa;
	}

	@OneToOne()
	@JoinColumn(name = "ID_USUARIO")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToOne()
	@JoinColumn(name = "ID_EMPRESA")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}