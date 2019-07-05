package pvt.auna.solben.model.bean;

import java.io.Serializable;

public class GrupoDiagnosticoBean implements Serializable{
	
	private static final long serialVersionUID = 3218697643454345534L;
	
	String codigo;
	String descripcion;
	Integer rn;
	
	public GrupoDiagnosticoBean() {}
	
	public GrupoDiagnosticoBean(String codigo, String descripcion, Integer rn){
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.rn = rn;
	}
	

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

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}
	
	@Override
	public String toString() {
		return "GrupoDiagnostico{"
				+ "codigo=" + codigo + ","
				+ "descripcion=" + descripcion + ","
				+ "rn=" + rn
				+ "}";
	}
}
