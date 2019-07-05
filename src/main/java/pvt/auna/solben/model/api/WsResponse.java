package pvt.auna.solben.model.api;


import pvt.auna.solben.model.api.response.AudiResponse;

public class WsResponse {

	private AudiResponse audiResponse;
    private Object data;

   public AudiResponse getAudiResponse() {
        return audiResponse;
    }
    public void setAudiResponse(AudiResponse audiResponse) {
        this.audiResponse = audiResponse;
    }
    public Object getData() {
       return data;
   }
   public void setData(Object data) {
       this.data = data;
   }

   @Override
   public String toString() {
       return "Response [audiResponse=" + audiResponse + ", data=" + data + "]";
   }
   
}
