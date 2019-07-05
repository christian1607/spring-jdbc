package pvt.auna.solben.model.api.response;


import java.util.ArrayList;

public class ResponseOnc {

	private AudiResponse audiResponse;

	private ArrayList<?> dataList;

	private Integer total;

	public AudiResponse getAudiResponse() {
		return audiResponse;
	}

	public void setAudiResponse(AudiResponse audiResponse) {
		this.audiResponse = audiResponse;
	}

	public ArrayList<?> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<?> dataList) {
		this.dataList = dataList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ResponseOnc [audiResponse=" + audiResponse + ", dataList=" + dataList + "]";
	}
	
	
	
}
