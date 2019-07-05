package pvt.auna.solben.model.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.NumberFormat;

public class InfoSolbenBean implements Serializable {

	private static final long serialVersionUID = 2757647011582860549L;

	String codSolben;
	String nroSCGSolben;
	Integer codEstadoSolben;
	String estadoSCGSolben;
	Date fecSCGSolben;
	String horaSCGSolben;
	Integer codTipoSolben;
	String tipoSolben;
	String codClinica;
	String clinica;
	String cmpMedico;
	String medicoTratante;
	Date fechaReceta;
	Date fechaQuimio;
	Date hospitalDesde;
	Date hospitalHasta;
	Date fechaHospitalInicio;
	Date fechaHospitalFin;
	String medicamentos;
	String esquemaQuimio;
	String personaContacto;

	@NumberFormat(pattern = "#,###,###,###.##")
	Double totalPresupuesto;
	String codAfiliado;
	String paciente;
	String sexoPaciente;
	Date fechaAfiliado;
	String nroCartaGarantia;
	Integer edad;
	String codGrupoDiagnostico;
	String grupoDiagnostico;
	String codDiagnostico;
	String diagnostico;
	String cie10;
	String contratante;
	String plan;
	String estadoClinico;
	String tnm;
	String observacion;
	Integer codEstadoPre;
	String estadoSolPre;
	Integer codMac;
	String descripCodMac;
	String descripcionMac;
	Integer estadoSolEva;
	String descripEstadoSolEva;

	public String getCodSolben() {
		return codSolben;
	}

	public void setCodSolben(String codSolben) {
		this.codSolben = codSolben;
	}

	public String getNroSCGSolben() {
		return nroSCGSolben;
	}

	public void setNroSCGSolben(String nroSCGSolben) {
		this.nroSCGSolben = nroSCGSolben;
	}

	public Integer getCodEstadoSolben() {
		return codEstadoSolben;
	}

	public void setCodEstadoSolben(Integer codEstadoSolben) {
		this.codEstadoSolben = codEstadoSolben;
	}

	public String getEstadoSCGSolben() {
		return estadoSCGSolben;
	}

	public void setEstadoSCGSolben(String estadoSCGSolben) {
		this.estadoSCGSolben = estadoSCGSolben;
	}

	public Date getFecSCGSolben() {
		return fecSCGSolben;
	}

	public void setFecSCGSolben(Date fecSCGSolben) {
		this.fecSCGSolben = fecSCGSolben;
	}

	public String getHoraSCGSolben() {
		return horaSCGSolben;
	}

	public void setHoraSCGSolben(String horaSCGSolben) {
		this.horaSCGSolben = horaSCGSolben;
	}

	public Integer getCodTipoSolben() {
		return codTipoSolben;
	}

	public void setCodTipoSolben(Integer codTipoSolben) {
		this.codTipoSolben = codTipoSolben;
	}

	public String getTipoSolben() {
		return tipoSolben;
	}

	public void setTipoSolben(String tipoSolben) {
		this.tipoSolben = tipoSolben;
	}

	public String getCodClinica() {
		return codClinica;
	}

	public void setCodClinica(String codClinica) {
		this.codClinica = codClinica;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public String getCmpMedico() {
		return cmpMedico;
	}

	public void setCmpMedico(String cmpMedico) {
		this.cmpMedico = cmpMedico;
	}

	public String getMedicoTratante() {
		return medicoTratante;
	}

	public void setMedicoTratante(String medicoTratante) {
		this.medicoTratante = medicoTratante;
	}

	public Date getFechaReceta() {
		return fechaReceta;
	}

	public void setFechaReceta(Date fechaReceta) {
		this.fechaReceta = fechaReceta;
	}

	public Date getFechaQuimio() {
		return fechaQuimio;
	}

	public void setFechaQuimio(Date fechaQuimio) {
		this.fechaQuimio = fechaQuimio;
	}

	public Date getHospitalDesde() {
		return hospitalDesde;
	}

	public void setHospitalDesde(Date hospitalDesde) {
		this.hospitalDesde = hospitalDesde;
	}

	public Date getHospitalHasta() {
		return hospitalHasta;
	}

	public void setHospitalHasta(Date hospitalHasta) {
		this.hospitalHasta = hospitalHasta;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getEsquemaQuimio() {
		return esquemaQuimio;
	}

	public void setEsquemaQuimio(String esquemaQuimio) {
		this.esquemaQuimio = esquemaQuimio;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public Double getTotalPresupuesto() {
		return totalPresupuesto;
	}

	public void setTotalPresupuesto(Double totalPresupuesto) {
		this.totalPresupuesto = totalPresupuesto;
	}

	public String getCodAfiliado() {
		return codAfiliado;
	}

	public void setCodAfiliado(String codAfiliado) {
		this.codAfiliado = codAfiliado;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public Date getFechaAfiliado() {
		return fechaAfiliado;
	}

	public void setFechaAfiliado(Date fechaAfiliado) {
		this.fechaAfiliado = fechaAfiliado;
	}

	public String getNroCartaGarantia() {
		return nroCartaGarantia;
	}

	public void setNroCartaGarantia(String nroCartaGarantia) {
		this.nroCartaGarantia = nroCartaGarantia;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCodGrupoDiagnostico() {
		return codGrupoDiagnostico;
	}

	public void setCodGrupoDiagnostico(String codGrupoDiagnostico) {
		this.codGrupoDiagnostico = codGrupoDiagnostico;
	}

	public String getGrupoDiagnostico() {
		return grupoDiagnostico;
	}

	public void setGrupoDiagnostico(String grupoDiagnostico) {
		this.grupoDiagnostico = grupoDiagnostico;
	}

	public String getCodDiagnostico() {
		return codDiagnostico;
	}

	public void setCodDiagnostico(String codDiagnostico) {
		this.codDiagnostico = codDiagnostico;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getCie10() {
		return cie10;
	}

	public void setCie10(String cie10) {
		this.cie10 = cie10;
	}

	public String getContratante() {
		return contratante;
	}

	public void setContratante(String contratante) {
		this.contratante = contratante;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getEstadoClinico() {
		return estadoClinico;
	}

	public void setEstadoClinico(String estadoClinico) {
		this.estadoClinico = estadoClinico;
	}

	public String getTnm() {
		return tnm;
	}

	public void setTnm(String tnm) {
		this.tnm = tnm;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getCodEstadoPre() {
		return codEstadoPre;
	}

	public void setCodEstadoPre(Integer codEstadoPre) {
		this.codEstadoPre = codEstadoPre;
	}

	public String getEstadoSolPre() {
		return estadoSolPre;
	}

	public void setEstadoSolPre(String estadoSolPre) {
		this.estadoSolPre = estadoSolPre;
	}

	public Date getFechaHospitalInicio() {
		return fechaHospitalInicio;
	}

	public void setFechaHospitalInicio(Date fechaHospitalInicio) {
		this.fechaHospitalInicio = fechaHospitalInicio;
	}

	public Date getFechaHospitalFin() {
		return fechaHospitalFin;
	}

	public void setFechaHospitalFin(Date fechaHospitalFin) {
		this.fechaHospitalFin = fechaHospitalFin;
	}

	public Integer getCodMac() {
		return codMac;
	}

	public void setCodMac(Integer codMac) {
		this.codMac = codMac;
	}

	public String getDescripCodMac() {
		return descripCodMac;
	}

	public void setDescripCodMac(String descripCodMac) {
		this.descripCodMac = descripCodMac;
	}

	public String getDescripcionMac() {
		return descripcionMac;
	}

	public void setDescripcionMac(String descripcionMac) {
		this.descripcionMac = descripcionMac;
	}

	public Integer getEstadoSolEva() {
		return estadoSolEva;
	}

	public void setEstadoSolEva(Integer estadoSolEva) {
		this.estadoSolEva = estadoSolEva;
	}

	public String getDescripEstadoSolEva() {
		return descripEstadoSolEva;
	}

	public void setDescripEstadoSolEva(String descripEstadoSolEva) {
		this.descripEstadoSolEva = descripEstadoSolEva;
	}

	public String getSexoPaciente() {
		return sexoPaciente;
	}

	public void setSexoPaciente(String sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}

}
