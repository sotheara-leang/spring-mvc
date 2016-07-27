package com.mcnc.example.springmvc.base.error.message;

import java.util.Date;

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
	private Date date = new Date();

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
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ErrorMessage [code=" + code + ", status=" + status + ", message=" + message + ", date=" + date + "]";
	}
}
