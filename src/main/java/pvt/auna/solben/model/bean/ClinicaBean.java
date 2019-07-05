package pvt.auna.solben.model.bean;

import java.io.Serializable;

public class ClinicaBean implements Serializable {

	private static final long serialVersionUID = 2207806125324722584L;

	private String codcli;
	private String nomcli;
	private Integer rn;

	public ClinicaBean() {
	}

	public String getCodcli() {
		return codcli;
	}

	public void setCodcli(String codcli) {
		this.codcli = codcli;
	}

	public String getNomcli() {
		return nomcli;
	}

	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	@Override
	public String toString() {
		return "ClinicaBean [codcli=" + codcli + ", nomcli=" + nomcli + ", rn=" + rn + "]";
	}

}
