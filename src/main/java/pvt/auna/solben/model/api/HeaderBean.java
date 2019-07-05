package pvt.auna.solben.model.api;

public class HeaderBean {

	private String idTransaccion;
	private String fechaTransaccion;


	public HeaderBean() {
	}

	public HeaderBean(String idTransaccion, String fechaTransaccion) {
		super();
		this.idTransaccion = idTransaccion;
		this.fechaTransaccion = fechaTransaccion;
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

	@Override
	public String toString() {
		return "HeaderBean [idTransaccion=" + idTransaccion + ", fechaTransaccion="
				+ fechaTransaccion + "]";
	}
}
