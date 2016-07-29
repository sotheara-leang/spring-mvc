package com.mcnc.example.springmvc.base.error.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.mcnc.example.springmvc.base.error.Error;
import com.mcnc.example.springmvc.base.error.SystemError;

/**
 * Form error message
 * @author Sotheara
 *
 */
public class FormErrorMessage extends ErrorMessage {

	@JacksonXmlElementWrapper(localName = "errors")
	@JacksonXmlProperty(localName = "error")
	private List<FormElementError> errors = new ArrayList<FormElementError>();
	
	@Override
	public Error getCode() {
		return SystemError.SYS400;
	}

	@Override
	public int getStatus() {
		return HttpStatus.BAD_REQUEST.value();
	}

	public List<FormElementError> getErrors() {
		return errors;
	}

	public void setErrors(List<FormElementError> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "FormErrorMessage [errors=" + errors + "]";
	}
}
