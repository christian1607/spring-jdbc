package pvt.auna.solben.model.bean;

import java.io.Serializable;

public class MedicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5854800073507607570L;

	String codmed;
	String apepat;
	String apemat;
	String nommed;
	String cmptra;
	Integer rn;

	public String getCodmed() {
		return codmed;
	}

	public void setCodmed(String codmed) {
		this.codmed = codmed;
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

	public String getNommed() {
		return nommed;
	}

	public void setNommed(String nommed) {
		this.nommed = nommed;
	}

	public String getCmptra() {
		return cmptra;
	}

	public void setCmptra(String cmptra) {
		this.cmptra = cmptra;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}
	
	public String getApelNomb() {
		return this.apepat + " " + this.apemat + ", " + this.nommed;
	}

	@Override
	public String toString() {
		return "MedicoBean [codmed=" + codmed + ", apepat=" + apepat + ", apemat=" + apemat + ", nommed=" + nommed
				+ ", cmptra=" + cmptra + ", rn=" + rn + "]";
	}	

}
