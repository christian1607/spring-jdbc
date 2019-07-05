package pvt.auna.solben.model.bean;

public class ResultadoBasalBean {

	private String descripcion;
	private String resultado;
	private String fecha;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "resultadoBasalBean [descripcion=" + descripcion + ", resultado=" + resultado + ", fecha=" + fecha + "]";
	}
	
	
}
