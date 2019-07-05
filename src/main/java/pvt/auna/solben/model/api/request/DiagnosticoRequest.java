package pvt.auna.solben.model.api.request;

public class DiagnosticoRequest {

	private Integer registroInicio;
	private Integer registroFin;
	private Integer tipoBusqueda;
	private String codigoDiagnostico;
	private String nombreDiagnostico;
	
	public Integer getRegistroInicio() {
		return registroInicio;
	}
	public void setRegistroInicio(Integer registroInicio) {
		this.registroInicio = registroInicio;
	}
	public Integer getRegistroFin() {
		return registroFin;
	}
	public void setRegistroFin(Integer registroFin) {
		this.registroFin = registroFin;
	}
	public Integer getTipoBusqueda() {
		return tipoBusqueda;
	}
	public void setTipoBusqueda(Integer tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}
	public String getCodigoDiagnostico() {
		return codigoDiagnostico;
	}
	public void setCodigoDiagnostico(String codigoDiagnostico) {
		this.codigoDiagnostico = codigoDiagnostico;
	}
	public String getNombreDiagnostico() {
		return nombreDiagnostico;
	}
	public void setNombreDiagnostico(String nombreDiagnostico) {
		this.nombreDiagnostico = nombreDiagnostico;
	}
	
	@Override
	public String toString() {
		return "DiagnosticoRequest [registroInicio=" + registroInicio + ", registroFin=" + registroFin
				+ ", tipoBusqueda=" + tipoBusqueda + ", codigoDiagnostico=" + codigoDiagnostico + ", nombreDiagnostico="
				+ nombreDiagnostico + "]";
	}
	
}
