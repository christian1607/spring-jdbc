package pvt.auna.solben.model.api.response;

public class SolbenRegistrarResponse {

    private AuditResponse auditResponse;

    private RegistroSolPreliminar registroSolPreliminar;


    public AuditResponse getAuditResponse() {
        return auditResponse;
    }

    public void setAuditResponse(AuditResponse auditResponse) {
        this.auditResponse = auditResponse;
    }

    public RegistroSolPreliminar getRegistroSolPreliminar() {
        return registroSolPreliminar;
    }

    public void setRegistroSolPreliminar(RegistroSolPreliminar registroSolPreliminar) {
        this.registroSolPreliminar = registroSolPreliminar;
    }

    @Override
    public String toString() {
        return "SolbenRegistrarResponse{" +
                "auditResponse=" + auditResponse +
                ", registroSolPreliminar=" + registroSolPreliminar +
                '}';
    }
}
