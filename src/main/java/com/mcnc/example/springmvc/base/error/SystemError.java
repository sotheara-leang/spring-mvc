package com.mcnc.example.springmvc.base.error;

public enum SystemError implements Error {
	
	SYS400("error.system.400"),
	SYS404("error.system.404"),
	SYS500("error.system.500");
	
	private final String messageCode;

	SystemError(String messageCode) {
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
		return ErrorType.SYSTEM;
	}
}
