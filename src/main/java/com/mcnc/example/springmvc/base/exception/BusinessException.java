package com.mcnc.example.springmvc.base.exception;

import com.mcnc.example.springmvc.base.error.Error;
import com.mcnc.example.springmvc.base.error.SystemError;

/**
 * Business exception
 * @author Sotheara
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3844253134460323396L;
	
	private Error error = SystemError.SYS500;

	public BusinessException() {}
	
	public BusinessException(Error error) {
		this.error = error;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "BusinessException [error=" + error + "]";
	}
}
