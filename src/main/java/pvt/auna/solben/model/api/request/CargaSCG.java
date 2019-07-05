package pvt.auna.solben.model.api.request;

public class CargaSCG {

    private String codScgSolben;

    private String codCgSolben;

    private String codClinica;

    private String nombreAfiliado;

    private String codAfiPaciente;

    private String desPlan;

    private String codDiagnostico;

    private String desProcedimiento;

    private String cmpMedico;

    private String medico;

    private String fecHospInicio;

    private String fecHospFin;

    private String fecCgSolben;

    private Integer codTipoCgSolben;

    private Integer codEstadoScg;

    private Integer claseScg;

    private String validadoPor;

    private Double totalPresupuesto;


    public String getCodScgSolben() {
        return codScgSolben;
    }

    public void setCodScgSolben(String codScgSolben) {
        this.codScgSolben = codScgSolben;
    }

    public String getCodCgSolben() {
        return codCgSolben;
    }

    public void setCodCgSolben(String codCgSolben) {
        this.codCgSolben = codCgSolben;
    }

    public String getCodClinica() {
        return codClinica;
    }

    public void setCodClinica(String codClinica) {
        this.codClinica = codClinica;
    }

    public String getNombreAfiliado() {
        return nombreAfiliado;
    }

    public void setNombreAfiliado(String nombreAfiliado) {
        this.nombreAfiliado = nombreAfiliado;
    }

    public String getCodAfiPaciente() {
        return codAfiPaciente;
    }

    public void setCodAfiPaciente(String codAfiPaciente) {
        this.codAfiPaciente = codAfiPaciente;
    }

    public String getDesPlan() {
        return desPlan;
    }

    public void setDesPlan(String desPlan) {
        this.desPlan = desPlan;
    }

    public String getCodDiagnostico() {
        return codDiagnostico;
    }

    public void setCodDiagnostico(String codDiagnostico) {
        this.codDiagnostico = codDiagnostico;
    }

    public String getDesProcedimiento() {
        return desProcedimiento;
    }

    public void setDesProcedimiento(String desProcedimiento) {
        this.desProcedimiento = desProcedimiento;
    }

    public String getCmpMedico() {
        return cmpMedico;
    }

    public void setCmpMedico(String cmpMedico) {
        this.cmpMedico = cmpMedico;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
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

    public String getFecCgSolben() {
        return fecCgSolben;
    }

    public void setFecCgSolben(String fecCgSolben) {
        this.fecCgSolben = fecCgSolben;
    }

    public Integer getCodTipoCgSolben() {
        return codTipoCgSolben;
    }

    public void setCodTipoCgSolben(Integer codTipoCgSolben) {
        this.codTipoCgSolben = codTipoCgSolben;
    }

    public Integer getCodEstadoScg() {
        return codEstadoScg;
    }

    public void setCodEstadoScg(Integer codEstadoScg) {
        this.codEstadoScg = codEstadoScg;
    }

    public Integer getClaseScg() {
        return claseScg;
    }

    public void setClaseScg(Integer claseScg) {
        this.claseScg = claseScg;
    }

    public String getValidadoPor() {
        return validadoPor;
    }

    public void setValidadoPor(String validadoPor) {
        this.validadoPor = validadoPor;
    }

    public Double getTotalPresupuesto() {
        return totalPresupuesto;
    }

    public void setTotalPresupuesto(Double totalPresupuesto) {
        this.totalPresupuesto = totalPresupuesto;
    }


    @Override
    public String toString() {
        return "CargaSCG{" +
                "codScgSolben='" + codScgSolben + '\'' +
                ", codCgSolben='" + codCgSolben + '\'' +
                ", codClinica='" + codClinica + '\'' +
                ", nombreAfiliado='" + nombreAfiliado + '\'' +
                ", codAfiPaciente='" + codAfiPaciente + '\'' +
                ", desPlan='" + desPlan + '\'' +
                ", codDiagnostico='" + codDiagnostico + '\'' +
                ", desProcedimiento='" + desProcedimiento + '\'' +
                ", cmpMedico='" + cmpMedico + '\'' +
                ", medico='" + medico + '\'' +
                ", fecHospInicio='" + fecHospInicio + '\'' +
                ", fecHospFin='" + fecHospFin + '\'' +
                ", fecCgSolben='" + fecCgSolben + '\'' +
                ", codTipoCgSolben=" + codTipoCgSolben +
                ", codEstadoScg=" + codEstadoScg +
                ", claseScg=" + claseScg +
                ", validadoPor='" + validadoPor + '\'' +
                ", totalPresupuesto=" + totalPresupuesto +
                '}';
    }
}
