package shopping.response;

public class LoginResponse {
	
	private String message;
	private int status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LoginResponse(String message, int i) {
		this.message = message;
		this.status = i;
	}
	
	

}
