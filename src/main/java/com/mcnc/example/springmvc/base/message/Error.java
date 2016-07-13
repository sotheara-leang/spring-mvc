package com.mcnc.example.springmvc.base.message;

public interface Error {

	Enum<?> getErrorCode();
	
	boolean isSystemError();
	
	boolean isBussinessError();
}
