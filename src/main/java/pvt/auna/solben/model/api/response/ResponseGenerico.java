package pvt.auna.solben.model.api.response;



import java.util.ArrayList;

public class ResponseGenerico {

	private AudiResponse audiResponse;
	private ArrayList<?> dataList;

	public ResponseGenerico() {	}

	public ResponseGenerico(AudiResponse audiResponse, ArrayList<Object> dataList) {
		this.audiResponse = audiResponse;
		this.dataList = dataList;
	}

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

	@Override
	public String toString() {
		return "ResponseGenerico [audiResponse=" + audiResponse + ", dataList=" + dataList + "]";
	}
}
