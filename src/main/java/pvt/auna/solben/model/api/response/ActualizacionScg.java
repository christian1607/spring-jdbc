package pvt.auna.solben.model.api.response;

public class ActualizacionScg {

    private String codScgSolben
            ;
    private String codSolEval;

    private String txDatoAdic1;

    private String txDatoAdic2;

    private String txDatoAdic3;

    public String getCodScgSolben() {
        return codScgSolben;
    }

    public void setCodScgSolben(String codScgSolben) {
        this.codScgSolben = codScgSolben;
    }

    public String getCodSolEval() {
        return codSolEval;
    }

    public void setCodSolEval(String codSolEval) {
        this.codSolEval = codSolEval;
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
        return "ActualizacionScg{" +
                "codScgSolben='" + codScgSolben + '\'' +
                ", codSolEval='" + codSolEval + '\'' +
                ", txDatoAdic1='" + txDatoAdic1 + '\'' +
                ", txDatoAdic2='" + txDatoAdic2 + '\'' +
                ", txDatoAdic3='" + txDatoAdic3 + '\'' +
                '}';
    }
}
