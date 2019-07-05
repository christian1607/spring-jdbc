package pvt.auna.solben.model.api.request;

import java.io.Serializable;

public class MedicoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2032145815844060362L;

	private Integer ini;
	private Integer fin;
	private Integer tipo;
	private String codigoMed;
	private String apellidoPat;
	private String apellidoMat;
	private String nombres;
	private String codcmp;
	private String total;

	public MedicoRequest() {
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getCodigoMed() {
		return codigoMed;
	}

	public void setCodigoMed(String codigoMed) {
		this.codigoMed = codigoMed;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCodcmp() {
		return codcmp;
	}

	public void setCodcmp(String codcmp) {
		this.codcmp = codcmp;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "MedicoRequest [ini=" + ini + ", fin=" + fin + ", tipo=" + tipo + ", codigoMed=" + codigoMed
				+ ", apellidoPat=" + apellidoPat + ", apellidoMat=" + apellidoMat + ", nombres=" + nombres + ", cmp="
				+ codcmp + ", total=" + total + "]";
	}

}
