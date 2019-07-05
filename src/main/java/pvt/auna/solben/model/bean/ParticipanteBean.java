package pvt.auna.solben.model.bean;

public class ParticipanteBean {	
	
	private Integer codParticipante;
	private Integer codUsuario;
	private Integer estadoParticipante;
	private String cmpMedico;
	private String nombreFirma;
	private String codGrpDiag;
	
	public Integer getCodParticipante() {
		return codParticipante;
	}
	public void setCodParticipante(Integer codParticipante) {
		this.codParticipante = codParticipante;
	}
	public Integer getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}
	public Integer getEstadoParticipante() {
		return estadoParticipante;
	}
	public void setEstadoParticipante(Integer estadoParticipante) {
		this.estadoParticipante = estadoParticipante;
	}
	public String getCmpMedico() {
		return cmpMedico;
	}
	public void setCmpMedico(String cmpMedico) {
		this.cmpMedico = cmpMedico;
	}
	public String getNombreFirma() {
		return nombreFirma;
	}
	public void setNombreFirma(String nombreFirma) {
		this.nombreFirma = nombreFirma;
	}
	public String getCodGrpDiag() {
		return codGrpDiag;
	}
	public void setCodGrpDiag(String codGrpDiag) {
		this.codGrpDiag = codGrpDiag;
	}
	@Override
	public String toString() {
		return "ParticipanteBean [codParticipante=" + codParticipante + ", codUsuario=" + codUsuario
				+ ", estadoParticipante=" + estadoParticipante + ", cmpMedico=" + cmpMedico + ", nombreFirma="
				+ nombreFirma + ", codGrpDiag=" + codGrpDiag + "]";
	}
	


}
