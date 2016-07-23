package com.mcnc.example.springmvc.base.error;

public enum BusinessError implements Error {
	
	COMP100("error.company.duplicate.name");
	
	final String messageCode;

	BusinessError(String messageCode) {
		this.messageCode = messageCode;
	}
	
	@Override
	public String getMessageCode() {
		return messageCode;
	}

	@Override
	public Enum<?> getErrorCode() {
		return this;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.BUSINESS;
	}
}
