package pvt.auna.solben.model.api.response;

import java.io.Serializable;

public class ListPacienteResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long itemPac;
	private Long codigoPac;
	private String nombrePac;
	
	public Long getItemPac() {
		return itemPac;
	}
	public void setItemPac(Long itemPac) {
		this.itemPac = itemPac;
	}
	public Long getCodigoPac() {
		return codigoPac;
	}
	public void setCodigoPac(Long codigoPac) {
		this.codigoPac = codigoPac;
	}
	public String getNombrePac() {
		return nombrePac;
	}
	public void setNombrePac(String nombrePac) {
		this.nombrePac = nombrePac;
	}
	
	
}
