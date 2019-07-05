package pvt.auna.solben.model.api.response;

public class AudiResponse {

	private String idTransaccion;
	private String fechaTransaccion;
	private String codigoRespuesta;
	private String mensajeRespuesta;

	public AudiResponse(String idTransaccion, String fechaTransaccion) {
		this.idTransaccion = idTransaccion;
		this.fechaTransaccion = fechaTransaccion;
	}

	public AudiResponse(String idTransaccion, String fechaTransaccion, String codigoRespuesta,
			String mensajeRespuesta) {
		this.idTransaccion = idTransaccion;
		this.fechaTransaccion = fechaTransaccion;
		this.codigoRespuesta = codigoRespuesta;
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public AudiResponse() {
	}

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
		return "AudiResponse [idTransaccion=" + idTransaccion + ", fechaTransaccion=" + fechaTransaccion
				+ ", codigoRespuesta=" + codigoRespuesta + ", mensajeRespuesta=" + mensajeRespuesta + "]";
	}


}
