package com.mcnc.example.springmvc.base.error.message;

import com.mcnc.example.springmvc.base.error.Error;

/**
 * Error message builder
 * @author Sotheara
 *
 */
public class ErrorMessageBuilder {

	private ErrorMessage message = new ErrorMessage();
	
	public ErrorMessageBuilder code(Error code) {
		this.message.setCode(code);
		return this;
	}

	public ErrorMessageBuilder status(int status) {
		this.message.setStatus(status);
		return this;
	}

	public ErrorMessageBuilder message(String message) {
		this.message.setMessage(message);
		return this;
	}
	
	public ErrorMessage build() {
		return message;
	}
}
