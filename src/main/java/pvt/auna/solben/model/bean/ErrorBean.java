package pvt.auna.solben.model.bean;

public class ErrorBean {
	
	private String type;
	private String message;

	public ErrorBean(String type, String message) {
		this.type = type;
		this.message = message == null || message.isEmpty() ? "An unknown error occurred" : message;
	}

	public ErrorBean(Exception exception) {
		this(exception.getClass().getSimpleName(), exception.getMessage());
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}
}
