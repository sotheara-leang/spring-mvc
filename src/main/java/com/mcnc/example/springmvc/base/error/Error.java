package com.mcnc.example.springmvc.base.error;

import com.mcnc.example.springmvc.base.message.Translateable;

public interface Error extends Translateable {

	Enum<?> getErrorCode();
	
	ErrorType getErrorType();
}
