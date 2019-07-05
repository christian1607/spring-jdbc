package pvt.auna.solben.model.bean;

public class MenuOpcionBean {
	private Integer codOpcion;
	private Integer codMenu;
	private String  tipoOpcion;
	private String  nombreCorto;
	private String  nombreLargo;
	private String  flagAsignacion;
	
	public Integer getCodMenu() {
		return codMenu;
	}
	public void setCodMenu(Integer codMenu) {
		this.codMenu = codMenu;
	}
	public Integer getCodOpcion() {
		return codOpcion;
	}
	public void setCodOpcion(Integer codOpcion) {
		this.codOpcion = codOpcion;
	}
	public String getTipoOpcion() {
		return tipoOpcion;
	}
	public void setTipoOpcion(String tipoOpcion) {
		this.tipoOpcion = tipoOpcion;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	public String getFlagAsignacion() {
		return flagAsignacion;
	}
	public void setFlagAsignacion(String flagAsignacion) {
		this.flagAsignacion = flagAsignacion;
	}
}
