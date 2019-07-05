package pvt.auna.solben.model.api.request;

public class ActualizarSolPrelimRequest {

    private String codScgSolben;

    private String codAfiPaciente;

    private Integer codEstadoScg;

    private Integer tipoOperacion;

    private String nroCg;

    private String fecCg;

    private String txDatoAdic1;

    private String txDatoAdic2;

    private String txDatoAdic3;


    public String getCodScgSolben() {
        return codScgSolben;
    }

    public void setCodScgSolben(String codScgSolben) {
        this.codScgSolben = codScgSolben;
    }

    public String getCodAfiPaciente() {
        return codAfiPaciente;
    }

    public void setCodAfiPaciente(String codAfiPaciente) {
        this.codAfiPaciente = codAfiPaciente;
    }

    public Integer getCodEstadoScg() {
        return codEstadoScg;
    }

    public void setCodEstadoScg(Integer codEstadoScg) {
        this.codEstadoScg = codEstadoScg;
    }

    public Integer getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Integer tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getNroCg() {
        return nroCg;
    }

    public void setNroCg(String nroCg) {
        this.nroCg = nroCg;
    }

    public String getFecCg() {
        return fecCg;
    }

    public void setFecCg(String fecCg) {
        this.fecCg = fecCg;
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
        return "ActualizarSolPrelimRequest{" +
                "codScgSolben='" + codScgSolben + '\'' +
                ", codAfiPaciente='" + codAfiPaciente + '\'' +
                ", codEstadoScg=" + codEstadoScg +
                ", tipoOperacion=" + tipoOperacion +
                ", nroCg='" + nroCg + '\'' +
                ", fecCg='" + fecCg + '\'' +
                ", txDatoAdic1='" + txDatoAdic1 + '\'' +
                ", txDatoAdic2='" + txDatoAdic2 + '\'' +
                ", txDatoAdic3='" + txDatoAdic3 + '\'' +
                '}';
    }
}
