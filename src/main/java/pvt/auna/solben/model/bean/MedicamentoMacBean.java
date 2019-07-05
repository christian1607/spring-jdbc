package pvt.auna.solben.model.bean;

import java.io.Serializable;

public class MedicamentoMacBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public long codMac;
	public String nameMac;
	public String descripcionMac;
	public String tipo;
	public String fechaInscripcion;
	public String usuarioInscripcion;
	public String fechaInicioVig;
	public String fechaFinVig;
	public String estado;
	
	public MedicamentoMacBean() {}
	
	public long getCodMac() {
		return codMac;
	}
	public void setCodMac(long codMac) {
		this.codMac = codMac;
	}
	public String getNameMac() {
		return nameMac;
	}
	public void setNameMac(String nameMac) {
		this.nameMac = nameMac;
	}
	public String getDescripcionMac() {
		return descripcionMac;
	}
	public void setDescripcionMac(String descripcionMac) {
		this.descripcionMac = descripcionMac;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public String getUsuarioInscripcion() {
		return usuarioInscripcion;
	}
	public void setUsuarioInscripcion(String usuarioInscripcion) {
		this.usuarioInscripcion = usuarioInscripcion;
	}
	public String getFechaInicioVig() {
		return fechaInicioVig;
	}
	public void setFechaInicioVig(String fechaInicioVig) {
		this.fechaInicioVig = fechaInicioVig;
	}
	public String getFechaFinVig() {
		return fechaFinVig;
	}
	public void setFechaFinVig(String fechaFinVig) {
		this.fechaFinVig = fechaFinVig;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "MedicamenteMacBean [codMac=" + codMac + ", nameMac=" + nameMac + ", descripcionMac=" + descripcionMac
				+ ", tipo=" + tipo + ", fechaInscripcion=" + fechaInscripcion + ", usuarioInscripcion="
				+ usuarioInscripcion + ", fechaInicioVig=" + fechaInicioVig + ", fechaFinVig=" + fechaFinVig
				+ ", estado=" + estado + "]";
	}
}
