package beans;

public class ResponseModel {
	private int status;
	private String message;
	
	public ResponseModel() {
		
	}
	/**
	 * 
	 * @param status of the responseModel
	 * @param message of the responseModel
	 */
	public ResponseModel(int status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * @return status of the responseModel
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message of the responseModel
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
