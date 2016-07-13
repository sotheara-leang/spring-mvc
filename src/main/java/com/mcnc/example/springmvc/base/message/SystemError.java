package com.mcnc.example.springmvc.base.message;

public enum SystemError implements Error, Translateable {
	
	SYS400("error.system.400"),
	SYS404("error.system.404"),
	SYS500("error.system.500");
	
	final String messageCode;

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
	public boolean isSystemError() {
		return true;
	}

	@Override
	public boolean isBussinessError() {
		return false;
	}
}
