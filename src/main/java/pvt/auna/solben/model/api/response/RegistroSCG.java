package pvt.auna.solben.model.api.response;

import java.math.BigDecimal;

public class RegistroSCG {

    private String codScgSolben;

    private String codCgSolben;

    private String codReg;

    private String fecReg;

    private BigDecimal codResultado;

    private String msgResultado;


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

    public String getCodReg() {
        return codReg;
    }

    public void setCodReg(String codReg) {
        this.codReg = codReg;
    }

    public String getFecReg() {
        return fecReg;
    }

    public void setFecReg(String fecReg) {
        this.fecReg = fecReg;
    }

    public BigDecimal getCodResultado() {
        return codResultado;
    }

    public void setCodResultado(BigDecimal codResultado) {
        this.codResultado = codResultado;
    }

    public String getMsgResultado() {
        return msgResultado;
    }

    public void setMsgResultado(String msgResultado) {
        this.msgResultado = msgResultado;
    }
}
