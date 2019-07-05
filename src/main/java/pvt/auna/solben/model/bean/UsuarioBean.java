package pvt.auna.solben.model.bean;

public class UsuarioBean {

	private Integer codAplicacion;
	private Integer codRol;
	private String codUsuarioCodRol;
	private int codUsuario;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombre;
	private String correo;
	private String numDocumento;
	private String usuario;

	public Integer getCodAplicacion() {
		return codAplicacion;
	}

	public void setCodAplicacion(Integer codAplicacion) {
		this.codAplicacion = codAplicacion;
	}

	public Integer getCodRol() {
		return codRol;
	}

	public void setCodRol(Integer codRol) {
		this.codRol = codRol;
	}

	public String getCodUsuarioCodRol() {
		return codUsuarioCodRol;
	}

	public void setCodUsuarioCodRol(String codUsuarioCodRol) {
		this.codUsuarioCodRol = codUsuarioCodRol;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "UsuarioBean [codAplicacion=" + codAplicacion + ", codRol=" + codRol + ", codUsuarioCodRol="
				+ codUsuarioCodRol + ", codUsuario=" + codUsuario + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", nombre=" + nombre + ", correo=" + correo
				+ ", numDocumento=" + numDocumento + ", usuario=" + usuario + "]";
	}

}
