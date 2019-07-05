package pvt.auna.solben.model.bean;

import java.io.Serializable;

public class DiagnosticoBean implements Serializable {
	
	private static final long serialVersionUID = 3722299091506751180L;
	
	private String codigo;
	private String diagnostico;
	private Integer rn;
	private GrupoDiagnosticoBean grupo;

	public DiagnosticoBean() {
	}

	public DiagnosticoBean(String codigo, String diagnostico, Integer rn, GrupoDiagnosticoBean grupo) {
		this.codigo = codigo;
		this.diagnostico = diagnostico;
		this.rn = rn;
		this.grupo = grupo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	public GrupoDiagnosticoBean getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDiagnosticoBean grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "DiagnosticoBean [codigo=" + codigo + ", diagnostico=" + diagnostico + ", rn=" + rn + ", grupo=" + grupo
				+ "]";
	}
}
