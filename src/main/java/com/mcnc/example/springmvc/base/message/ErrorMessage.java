package com.mcnc.example.springmvc.base.message;

public class ErrorMessage {

	private Error error;
	private String status;
	private String message;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
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

	@Override
	public String toString() {
		return "ErrorMessage [error=" + error + ", status=" + status + ", message=" + message + "]";
	}
}
