package pvt.auna.solben.model.api.request;

public class ClinicaRequest {

	private Integer ini;
	private Integer fin;
	private Integer tipoBus;
	private String codcli;
	private String nomcli;
	
	public Integer getIni() {
		return ini;
	}
	public void setIni(Integer ini) {
		this.ini = ini;
	}
	public Integer getFin() {
		return fin;
	}
	public void setFin(Integer fin) {
		this.fin = fin;
	}
	public Integer getTipoBus() {
		return tipoBus;
	}
	public void setTipoBus(Integer tipoBus) {
		this.tipoBus = tipoBus;
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
	
	@Override
	public String toString() {
		return "ClinicaRequest [ini=" + ini + ", fin=" + fin + ", tipoBus=" + tipoBus + ", codcli=" + codcli
				+ ", nomcli=" + nomcli + "]";
	}	
	
}
