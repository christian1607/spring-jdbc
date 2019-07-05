package pvt.auna.solben.model.api.request;

import java.io.Serializable;

public class ListaPacienteRequest implements Serializable {

	private static final long serialVersionUID = -2603125059611974844L;

	private Integer ini;
	private Integer fin;
	private String codafir;
	private String tipdoc;
	private String numdoc;
	private String apepat;
	private String apemat;
	private String nombr1;

	public ListaPacienteRequest() {
	}

	public ListaPacienteRequest(String codafir) {
		this.codafir = codafir;
	}

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

	@Override
	public String toString() {
		return "ListaPacienteRequest [ini=" + ini + ", fin=" + fin + ", codafir=" + codafir + ", tipdoc=" + tipdoc
				+ ", numdoc=" + numdoc + ", apepat=" + apepat + ", apemat=" + apemat + ", nombr1=" + nombr1 + "]";
	}

}
