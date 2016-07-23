package com.mcnc.example.springmvc.base.error;

import com.mcnc.example.springmvc.base.message.Translateable;

/**
 * Error
 * @author Sotheara
 *
 */
public interface Error extends Translateable {

	Enum<?> getErrorCode();
	
	ErrorType getErrorType();
}
