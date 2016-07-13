package com.mcnc.example.springmvc.base.message;

public enum BusinessError implements Error, Translateable {
	
	COMPANY_DUPLICATE_NAME("error.company.duplicate.name");
	
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
	public boolean isSystemError() {
		return false;
	}

	@Override
	public boolean isBussinessError() {
		return true;
	}	
}
