package com.mcnc.example.springmvc.base.error.message;

import com.mcnc.example.springmvc.base.error.Error;

/**
 * Error message
 * @author Sotheara
 *
 */
public class ErrorMessage {

	private Error code;
	private int status;
	private String message;

	public Error getCode() {
		return code;
	}

	public void setCode(Error code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
		return "ErrorMessage [code=" + code + ", status=" + status + ", message=" + message + "]";
	}
}
