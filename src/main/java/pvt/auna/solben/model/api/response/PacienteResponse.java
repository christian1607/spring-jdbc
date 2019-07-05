package pvt.auna.solben.model.api.response;



import java.util.List;

public class PacienteResponse {

	private List<ListPacienteResponse> paciente;
	private Long   codigoResultado;
	private String mensageResultado;
	
	public List<ListPacienteResponse> getPaciente() {
		return paciente;
	}
	public void setPaciente(List<ListPacienteResponse> paciente) {
		this.paciente = paciente;
	}
	public Long getCodigoResultado() {
		return codigoResultado;
	}
	public void setCodigoResultado(Long codigoResultado) {
		this.codigoResultado = codigoResultado;
	}
	public String getMensageResultado() {
		return mensageResultado;
	}
	public void setMensageResultado(String mensageResultado) {
		this.mensageResultado = mensageResultado;
	}
}
