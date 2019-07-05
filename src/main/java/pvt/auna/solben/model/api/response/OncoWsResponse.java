package pvt.auna.solben.model.api.response;

import pvt.auna.solben.model.api.response.AudiResponse;

public class OncoWsResponse {
	
	private AudiResponse audiResponse;

	private Object dataList;

	public AudiResponse getAudiResponse() {
		return audiResponse;
	}

	public void setAudiResponse(AudiResponse audiResponse) {
		this.audiResponse = audiResponse;
	}

	public Object getDataList() {
		return dataList;
	}

	public void setDataList(Object dataList) {
		this.dataList = dataList;
	}
}
