package pvt.auna.solben.model.bean;

import java.io.Serializable;

public class MedicamentoMac implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long codMac;
	private String codMacVch;
	private String descripcion;
	public Long getCodMac() {
		return codMac;
	}
	public void setCodMac(Long codMac) {
		this.codMac = codMac;
	}
	public String getCodMacVch() {
		return codMacVch;
	}
	public void setCodMacVch(String codMacVch) {
		this.codMacVch = codMacVch;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
