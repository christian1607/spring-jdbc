package pvt.auna.solben.model.api.response;

public class AuditResponse {

    private String idTransaccion;

    private String fechaTransaccion;

    private String codigoRespuesta;

    private String mensajeRespuesta;


    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    @Override
    public String toString() {
        return "AuditResponse{" +
                "idTransaccion='" + idTransaccion + '\'' +
                ", fechaTransaccion='" + fechaTransaccion + '\'' +
                ", codigoRespuesta='" + codigoRespuesta + '\'' +
                ", mensajeRespuesta='" + mensajeRespuesta + '\'' +
                '}';
    }
}
