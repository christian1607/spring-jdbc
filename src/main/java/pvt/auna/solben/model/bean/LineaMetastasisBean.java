package pvt.auna.solben.model.bean;

public class LineaMetastasisBean {
	
	
	private String lineaMetastasis;
	private String lugarMetastasis;
	
	public String getLineaMetastasis() {
		return lineaMetastasis;
	}
	public void setLineaMetastasis(String lineaMetastasis) {
		this.lineaMetastasis = lineaMetastasis;
	}
	public String getLugarMetastasis() {
		return lugarMetastasis;
	}
	public void setLugarMetastasis(String lugarMetastasis) {
		this.lugarMetastasis = lugarMetastasis;
	}
	
	@Override
	public String toString() {
		return "LineaMetastasisBean [lineaMetastasis=" + lineaMetastasis + ", lugarMetastasis=" + lugarMetastasis + "]";
	}
	
	
	
}
