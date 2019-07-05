package pvt.auna.solben.model.api.request;

import java.io.Serializable;

public class GrupoDiagnosticoRequest implements Serializable {

	private static final long serialVersionUID = 2036742340917032899L;

	private Integer registroInicio;
	private Integer registroFin;
	private Integer tipoBusqueda;
	private String codigoGrupoDiagnostico;
	private String nombreGrupoDiagnostico;

	public GrupoDiagnosticoRequest() {
	}

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

	public String getCodigoGrupoDiagnostico() {
		return codigoGrupoDiagnostico;
	}

	public void setCodigoGrupoDiagnostico(String codigoGrupoDiagnostico) {
		this.codigoGrupoDiagnostico = codigoGrupoDiagnostico;
	}

	public String getNombreGrupoDiagnostico() {
		return nombreGrupoDiagnostico;
	}

	public void setNombreGrupoDiagnostico(String nombreGrupoDiagnostico) {
		this.nombreGrupoDiagnostico = nombreGrupoDiagnostico;
	}

	@Override
	public String toString() {
		return "GrupoDiagnosticoRequest [registroInicio=" + registroInicio + ", registroFin=" + registroFin
				+ ", tipoBusqueda=" + tipoBusqueda + ", codigoGrupoDiagnostico=" + codigoGrupoDiagnostico
				+ ", nombreGrupoDiagnostico=" + nombreGrupoDiagnostico + "]";
	}

}
