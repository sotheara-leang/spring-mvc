package com.mcnc.example.springmvc.base.error.message;

/**
 * Form element error
 * @author Sotheara
 *
 */
public class FormElementError {
	
	private String field;
	private String message;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FormElementError [field=" + field + ", message=" + message + "]";
	}
}
