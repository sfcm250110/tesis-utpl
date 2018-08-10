package ec.edu.utpl.sc.core.vo;

import java.io.Serializable;

public class AnioVo implements Serializable {

	private static final long serialVersionUID = 8039962628143666918L;

	private String codigo;
	private String descripcion;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("AnioVo --> ");
		stringBuilder.append("[");
		stringBuilder.append("codigo: ");
		stringBuilder.append(getCodigo());
		stringBuilder.append(", descripcion: ");
		stringBuilder.append(getDescripcion());
		stringBuilder.append("]");

		return stringBuilder.toString();
	}

}
