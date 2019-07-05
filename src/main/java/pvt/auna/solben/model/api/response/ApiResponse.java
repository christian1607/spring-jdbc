package pvt.auna.solben.model.api.response;

public class ApiResponse extends  Object{

    String status;
    String message;
    Object response;

    public ApiResponse() {
    }

    public ApiResponse(String status, String message, Object response) {
    	this.status = status;
        this.message = message;
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

}
