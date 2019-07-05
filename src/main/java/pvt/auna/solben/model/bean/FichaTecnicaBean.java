package pvt.auna.solben.model.bean;

import java.io.Serializable;
import java.util.Date;

public class FichaTecnicaBean implements Serializable {

	private static final long serialVersionUID = -2668785997106168708L;
	private Integer codMac;
	private Integer codFichaTecnica;
	private String codVersion;
	private String nombreArchivo;
	private Date fechaIniVigencia;
	private Date fechaFinVigencia;
	private Integer codEstado;
	private String estado;

	public Integer getCodMac() {
		return codMac;
	}

	public void setCodMac(Integer codMac) {
		this.codMac = codMac;
	}

	public Integer getCodFichaTecnica() {
		return codFichaTecnica;
	}

	public void setCodFichaTecnica(Integer codFichaTecnica) {
		this.codFichaTecnica = codFichaTecnica;
	}

	public String getCodVersion() {
		return codVersion;
	}

	public void setCodVersion(String codVersion) {
		this.codVersion = codVersion;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Date getFechaIniVigencia() {
		return fechaIniVigencia;
	}

	public void setFechaIniVigencia(Date fechaIniVigencia) {
		this.fechaIniVigencia = fechaIniVigencia;
	}

	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public Integer getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Integer codEstado) {
		this.codEstado = codEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "FichaTecnicaBean [codMac=" + codMac + ", codFichaTecnica=" + codFichaTecnica + ", codVersion="
				+ codVersion + ", nombreArchivo=" + nombreArchivo + ", fechaIniVigencia=" + fechaIniVigencia
				+ ", fechaFinVigencia=" + fechaFinVigencia + ", codEstado=" + codEstado + ", estado=" + estado + "]";
	}

}
