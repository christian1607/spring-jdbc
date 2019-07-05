package pvt.auna.solben.model.api.response;

public class RegistroSolPreliminar {

    private String codScgSolben;

    private String codSolPre;

    private String fecSolPre;

    private String horaSolPre;


    public String getCodScgSolben() {
        return codScgSolben;
    }

    public void setCodScgSolben(String codScgSolben) {
        this.codScgSolben = codScgSolben;
    }

    public String getCodSolPre() {
        return codSolPre;
    }

    public void setCodSolPre(String codSolPre) {
        this.codSolPre = codSolPre;
    }

    public String getFecSolPre() {
        return fecSolPre;
    }

    public void setFecSolPre(String fecSolPre) {
        this.fecSolPre = fecSolPre;
    }

    public String getHoraSolPre() {
        return horaSolPre;
    }

    public void setHoraSolPre(String horaSolPre) {
        this.horaSolPre = horaSolPre;
    }

    @Override
    public String toString() {
        return "RegistroSolPreliminar{" +
                "codScgSolben='" + codScgSolben + '\'' +
                ", codSolPre='" + codSolPre + '\'' +
                ", fecSolPre='" + fecSolPre + '\'' +
                ", horaSolPre='" + horaSolPre + '\'' +
                '}';
    }
}
