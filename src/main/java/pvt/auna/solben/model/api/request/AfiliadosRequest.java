package pvt.auna.solben.model.api.request;

import java.io.Serializable;

public class AfiliadosRequest implements Serializable {

	private static final long serialVersionUID = -5753026412752114563L;

	Integer ini;
	Integer fin;
	String codafir;

	public AfiliadosRequest() {
	}

	public AfiliadosRequest(String codafir) {
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

	@Override
	public String toString() {
		return "AfiliadosRequest [ini=" + ini + ", fin=" + fin + ", codafir=" + codafir + "]";
	}

}
