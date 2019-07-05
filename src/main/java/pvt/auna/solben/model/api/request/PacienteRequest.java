package pvt.auna.solben.model.api.request;

public class PacienteRequest {

	private String ini;
	private String fin;
	private String tipoBus;
	private String codafir;
	private String tipdoc;
	private String numdoc;
	private String apepat;
	private String apemat;
	private String nombr1;
	private String vigencia;

	
	public String getIni() {
		return ini;
	}


	public void setIni(String ini) {
		this.ini = ini;
	}


	public String getFin() {
		return fin;
	}


	public void setFin(String fin) {
		this.fin = fin;
	}


	public String getTipoBus() {
		return tipoBus;
	}


	public void setTipoBus(String tipoBus) {
		this.tipoBus = tipoBus;
	}


	public String getCodafir() {
		return codafir;
	}


	public void setCodafir(String codafir) {
		this.codafir = codafir;
	}


	public String getTipdoc() {
		return tipdoc;
	}


	public void setTipdoc(String tipdoc) {
		this.tipdoc = tipdoc;
	}


	public String getNumdoc() {
		return numdoc;
	}


	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}


	public String getApepat() {
		return apepat;
	}


	public void setApepat(String apepat) {
		this.apepat = apepat;
	}


	public String getApemat() {
		return apemat;
	}


	public void setApemat(String apemat) {
		this.apemat = apemat;
	}


	public String getNombr1() {
		return nombr1;
	}


	public void setNombr1(String nombr1) {
		this.nombr1 = nombr1;
	}


	public String getVigencia() {
		return vigencia;
	}


	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}


	@Override
	public String toString() {
		return "PacienteRequest [ini=" + ini + ", fin=" + fin + ", tipoBus="
				+ tipoBus + ", codafir=" + codafir + ", tipdoc=" + tipdoc + ", numdoc="
				+ numdoc + ", apepat=" + apepat + ", apemat=" + apemat + ", nombr1=" + nombr1 + ", vigencia=" + vigencia +"]";
	}

}
