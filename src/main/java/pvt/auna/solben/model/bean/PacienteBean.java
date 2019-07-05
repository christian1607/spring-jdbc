package pvt.auna.solben.model.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PacienteBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7964684318993998635L;
	
	String codafir;
	String nombr1;
	String nombr2;
	String apepat;
	String apemat;
	Integer edaafi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	Date fecnac;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	Date fecact;

	String pgrfeccon;
	String tipafi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	Date fecbaj;

	String emaafi;
	String proafi;
	String tipdoc;
	String dirafi;
	String telafi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	Date fecren;

	String espaci;
	String numdoc;
	String celafi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	Date fecafi;

	String catafi;
	String disafi;
	String refafi;
	String sexafi;
	String gruafi;
	String estafi;
	Integer rn;

	String ApelNomb;

	public PacienteBean() {	}

	public String getCodafir() {
		return codafir;
	}

	public void setCodafir(String codafir) {
		this.codafir = codafir;
	}

	public String getNombr1() {
		return nombr1;
	}

	public void setNombr1(String nombr1) {
		this.nombr1 = nombr1;
	}

	public String getNombr2() {
		return nombr2;
	}

	public void setNombr2(String nombr2) {
		this.nombr2 = nombr2;
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

	public Integer getEdaafi() {
		return edaafi;
	}

	public void setEdaafi(Integer edaafi) {
		this.edaafi = edaafi;
	}

	public Date getFecnac() {
		return fecnac;
	}

	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}

	public Date getFecact() {
		return fecact;
	}

	public void setFecact(Date fecact) {
		this.fecact = fecact;
	}

	public String getPgrfeccon() {
		return pgrfeccon;
	}

	public void setPgrfeccon(String pgrfeccon) {
		this.pgrfeccon = pgrfeccon;
	}

	public String getTipafi() {
		return tipafi;
	}

	public void setTipafi(String tipafi) {
		this.tipafi = tipafi;
	}

	public Date getFecbaj() {
		return fecbaj;
	}

	public void setFecbaj(Date fecbaj) {
		this.fecbaj = fecbaj;
	}

	public String getEmaafi() {
		return emaafi;
	}

	public void setEmaafi(String emaafi) {
		this.emaafi = emaafi;
	}

	public String getProafi() {
		return proafi;
	}

	public void setProafi(String proafi) {
		this.proafi = proafi;
	}

	public String getTipdoc() {
		return tipdoc;
	}

	public void setTipdoc(String tipdoc) {
		this.tipdoc = tipdoc;
	}

	public String getDirafi() {
		return dirafi;
	}

	public void setDirafi(String dirafi) {
		this.dirafi = dirafi;
	}

	public String getTelafi() {
		return telafi;
	}

	public void setTelafi(String telafi) {
		this.telafi = telafi;
	}

	public Date getFecren() {
		return fecren;
	}

	public void setFecren(Date fecren) {
		this.fecren = fecren;
	}

	public String getEspaci() {
		return espaci;
	}

	public void setEspaci(String espaci) {
		this.espaci = espaci;
	}

	public String getNumdoc() {
		return numdoc;
	}

	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}

	public String getCelafi() {
		return celafi;
	}

	public void setCelafi(String celafi) {
		this.celafi = celafi;
	}

	public Date getFecafi() {
		return fecafi;
	}

	public void setFecafi(Date fecafi) {
		this.fecafi = fecafi;
	}

	public String getCatafi() {
		return catafi;
	}

	public void setCatafi(String catafi) {
		this.catafi = catafi;
	}

	public String getDisafi() {
		return disafi;
	}

	public void setDisafi(String disafi) {
		this.disafi = disafi;
	}

	public String getRefafi() {
		return refafi;
	}

	public void setRefafi(String refafi) {
		this.refafi = refafi;
	}

	public String getSexafi() {
		return sexafi;
	}

	public void setSexafi(String sexafi) {
		this.sexafi = sexafi;
	}

	public String getGruafi() {
		return gruafi;
	}

	public void setGruafi(String gruafi) {
		this.gruafi = gruafi;
	}

	public String getEstafi() {
		return estafi;
	}

	public void setEstafi(String estafi) {
		this.estafi = estafi;
	}

	public Integer getRn() {
		return rn;
	}

	public void setRn(Integer rn) {
		this.rn = rn;
	}

	public String getApelNomb() {
		return this.apepat + " " + this.apemat + ", " + this.nombr1 + ((this.nombr2 != null) ? " " + this.nombr2 : "");
	}

}
