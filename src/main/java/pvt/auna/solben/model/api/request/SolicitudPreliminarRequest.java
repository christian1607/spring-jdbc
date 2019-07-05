package pvt.auna.solben.model.api.request;

import java.io.Serializable;

public class SolicitudPreliminarRequest implements Serializable {

	private static final long serialVersionUID = -8022474255483626723L;

	private String codScgSolben;

	private String codClinica;

	private String codAfiPaciente;

	private Integer edadPaciente;

	private String desContratante;

	private String desPlan;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String fecAfiliacion;

	private String codDiagnostico;

	private String cmpMedico;

	private String medicoTratantePrescriptor;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String fecReceta;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String fecQuimio;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String fecHospInicio;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String fecHospFin;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String fecScgSolben;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private String horaScgSolben;

	private String tipoScgSolben;

	private String codEstadoScg;

	private String descMedicamento;

	private String descEsquema;

	private Double totalPresupuesto;

	private String descProcedimiento;

	private String personContacto;

	private String obsClinica;

	private Integer indValida;

	private String txDatoAdic1;

	private String txDatoAdic2;

	private String txDatoAdic3;
	//private String codGrpDiag;


	public String getCodScgSolben() {
		return codScgSolben;
	}

	public void setCodScgSolben(String codScgSolben) {
		this.codScgSolben = codScgSolben;
	}

	public String getCodClinica() {
		return codClinica;
	}

	public void setCodClinica(String codClinica) {
		this.codClinica = codClinica;
	}

	public String getCodAfiPaciente() {
		return codAfiPaciente;
	}

	public void setCodAfiPaciente(String codAfiPaciente) {
		this.codAfiPaciente = codAfiPaciente;
	}

	public Integer getEdadPaciente() {
		return edadPaciente;
	}

	public void setEdadPaciente(Integer edadPaciente) {
		this.edadPaciente = edadPaciente;
	}

	public String getDesContratante() {
		return desContratante;
	}

	public void setDesContratante(String desContratante) {
		this.desContratante = desContratante;
	}

	public String getDesPlan() {
		return desPlan;
	}

	public void setDesPlan(String desPlan) {
		this.desPlan = desPlan;
	}

	public String getFecAfiliacion() {
		return fecAfiliacion;
	}

	public void setFecAfiliacion(String fecAfiliacion) {
		this.fecAfiliacion = fecAfiliacion;
	}

	public String getCodDiagnostico() {
		return codDiagnostico;
	}

	public void setCodDiagnostico(String codDiagnostico) {
		this.codDiagnostico = codDiagnostico;
	}

	public String getCmpMedico() {
		return cmpMedico;
	}

	public void setCmpMedico(String cmpMedico) {
		this.cmpMedico = cmpMedico;
	}

	public String getMedicoTratantePrescriptor() {
		return medicoTratantePrescriptor;
	}

	public void setMedicoTratantePrescriptor(String medicoTratantePrescriptor) {
		this.medicoTratantePrescriptor = medicoTratantePrescriptor;
	}

	public String getFecReceta() {
		return fecReceta;
	}

	public void setFecReceta(String fecReceta) {
		this.fecReceta = fecReceta;
	}

	public String getFecQuimio() {
		return fecQuimio;
	}

	public void setFecQuimio(String fecQuimio) {
		this.fecQuimio = fecQuimio;
	}

	public String getFecHospInicio() {
		return fecHospInicio;
	}

	public void setFecHospInicio(String fecHospInicio) {
		this.fecHospInicio = fecHospInicio;
	}

	public String getFecHospFin() {
		return fecHospFin;
	}

	public void setFecHospFin(String fecHospFin) {
		this.fecHospFin = fecHospFin;
	}

	public String getFecScgSolben() {
		return fecScgSolben;
	}

	public void setFecScgSolben(String fecScgSolben) {
		this.fecScgSolben = fecScgSolben;
	}

	public String getHoraScgSolben() {
		return horaScgSolben;
	}

	public void setHoraScgSolben(String horaScgSolben) {
		this.horaScgSolben = horaScgSolben;
	}

	public String getTipoScgSolben() {
		return tipoScgSolben;
	}

	public void setTipoScgSolben(String tipoScgSolben) {
		this.tipoScgSolben = tipoScgSolben;
	}

	public String getCodEstadoScg() {
		return codEstadoScg;
	}

	public void setCodEstadoScg(String codEstadoScg) {
		this.codEstadoScg = codEstadoScg;
	}

	public String getDescMedicamento() {
		return descMedicamento;
	}

	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
	}

	public String getDescEsquema() {
		return descEsquema;
	}

	public void setDescEsquema(String descEsquema) {
		this.descEsquema = descEsquema;
	}

	public Double getTotalPresupuesto() {
		return totalPresupuesto;
	}

	public void setTotalPresupuesto(Double totalPresupuesto) {
		this.totalPresupuesto = totalPresupuesto;
	}

	public String getDescProcedimiento() {
		return descProcedimiento;
	}

	public void setDescProcedimiento(String descProcedimiento) {
		this.descProcedimiento = descProcedimiento;
	}

	public String getPersonContacto() {
		return personContacto;
	}

	public void setPersonContacto(String personContacto) {
		this.personContacto = personContacto;
	}

	public String getObsClinica() {
		return obsClinica;
	}

	public void setObsClinica(String obsClinica) {
		this.obsClinica = obsClinica;
	}

	public Integer getIndValida() {
		return indValida;
	}

	public void setIndValida(Integer indValida) {
		this.indValida = indValida;
	}

	public String getTxDatoAdic1() {
		return txDatoAdic1;
	}

	public void setTxDatoAdic1(String txDatoAdic1) {
		this.txDatoAdic1 = txDatoAdic1;
	}

	public String getTxDatoAdic2() {
		return txDatoAdic2;
	}

	public void setTxDatoAdic2(String txDatoAdic2) {
		this.txDatoAdic2 = txDatoAdic2;
	}

	public String getTxDatoAdic3() {
		return txDatoAdic3;
	}

	public void setTxDatoAdic3(String txDatoAdic3) {
		this.txDatoAdic3 = txDatoAdic3;
	}

	@Override
	public String toString() {
		return "SolicitudPreliminarRequest{" +
				"codScgSolben='" + codScgSolben + '\'' +
				", codClinica='" + codClinica + '\'' +
				", codAfiPaciente='" + codAfiPaciente + '\'' +
				", edadPaciente=" + edadPaciente +
				", desContratante='" + desContratante + '\'' +
				", desPlan='" + desPlan + '\'' +
				", fecAfiliacion='" + fecAfiliacion + '\'' +
				", codDiagnostico='" + codDiagnostico + '\'' +
				", cmpMedico='" + cmpMedico + '\'' +
				", medicoTratantePrescriptor='" + medicoTratantePrescriptor + '\'' +
				", fecReceta='" + fecReceta + '\'' +
				", fecQuimio='" + fecQuimio + '\'' +
				", fecHospInicio='" + fecHospInicio + '\'' +
				", fecHospFin='" + fecHospFin + '\'' +
				", fecScgSolben='" + fecScgSolben + '\'' +
				", horaScgSolben='" + horaScgSolben + '\'' +
				", tipoScgSolben='" + tipoScgSolben + '\'' +
				", codEstadoScg='" + codEstadoScg + '\'' +
				", descMedicamento='" + descMedicamento + '\'' +
				", descEsquema='" + descEsquema + '\'' +
				", totalPresupuesto=" + totalPresupuesto +
				", descProcedimiento='" + descProcedimiento + '\'' +
				", personContacto='" + personContacto + '\'' +
				", obsClinica='" + obsClinica + '\'' +
				", indValida=" + indValida +
				", txDatoAdic1='" + txDatoAdic1 + '\'' +
				", txDatoAdic2='" + txDatoAdic2 + '\'' +
				", txDatoAdic3='" + txDatoAdic3 + '\'' +
				'}';
	}
}
