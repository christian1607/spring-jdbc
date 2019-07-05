package pvt.auna.solben.model.bean;

import java.io.Serializable;
import java.util.Date;

public class SolicitudPreliminar implements Serializable {

    private static final long serialVersionUID = -8022474255483626723L;

    private Integer cod_sol_pre;
    private String estado_sol_pre;
    private Integer id_scg_solben;
    private Date fec_sol_pre;
    private Integer id_mac;

    public Integer getCod_sol_pre() {
        return cod_sol_pre;
    }

    public void setCod_sol_pre(Integer cod_sol_pre) {
        this.cod_sol_pre = cod_sol_pre;
    }

    public String getEstado_sol_pre() {
        return estado_sol_pre;
    }

    public void setEstado_sol_pre(String estado_sol_pre) {
        this.estado_sol_pre = estado_sol_pre;
    }

    public Integer getId_scg_solben() {
        return id_scg_solben;
    }

    public void setId_scg_solben(Integer id_scg_solben) {
        this.id_scg_solben = id_scg_solben;
    }

    public Date getFec_sol_pre() {
        return fec_sol_pre;
    }

    public void setFec_sol_pre(Date fec_sol_pre) {
        this.fec_sol_pre = fec_sol_pre;
    }

    public Integer getId_mac() {
        return id_mac;
    }

    public void setId_mac(Integer id_mac) {
        this.id_mac = id_mac;
    }
}
