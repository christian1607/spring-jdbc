package pvt.auna.solben.model.api.response;

import java.util.List;

public class SolbenRegistraCartaGarResponse {

    private AuditResponse auditResponse;

    private List<RegistroSCG> listaRegistroSCG;

    public AuditResponse getAuditResponse() {
        return auditResponse;
    }

    public void setAuditResponse(AuditResponse auditResponse) {
        this.auditResponse = auditResponse;
    }


    public List<RegistroSCG> getListaRegistroSCG() {
        return listaRegistroSCG;
    }

    public void setListaRegistroSCG(List<RegistroSCG> listaRegistroSCG) {
        this.listaRegistroSCG = listaRegistroSCG;
    }
}
