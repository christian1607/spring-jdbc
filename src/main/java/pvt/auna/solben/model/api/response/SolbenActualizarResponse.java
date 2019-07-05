package pvt.auna.solben.model.api.response;

public class SolbenActualizarResponse {

    private AuditResponse auditResponse;

    private ActualizacionScg actualizacionSCG;


    public AuditResponse getAuditResponse() {
        return auditResponse;
    }

    public void setAuditResponse(AuditResponse auditResponse) {
        this.auditResponse = auditResponse;
    }

    public ActualizacionScg getActualizacionSCG() {
        return actualizacionSCG;
    }

    public void setActualizacionSCG(ActualizacionScg actualizacionSCG) {
        this.actualizacionSCG = actualizacionSCG;
    }


    @Override
    public String toString() {
        return "SolbenActualizarResponse{" +
                "auditResponse=" + auditResponse +
                ", actualizacionSCG=" + actualizacionSCG +
                '}';
    }
}
