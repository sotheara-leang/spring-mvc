package com.mcnc.example.springmvc.base.web.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

/**
 * Abstract Validator
 * @author Sotheara
 *
 */
public abstract class AbstractValidator implements SmartValidator {

	/**
	 * Default validation
	 */
	@Override
	public void validate(Object target, Errors errors) {}
	
	/**
	 * Validation with hints
	 */
	@Override
	public void validate(Object target, Errors errors, Object... validationHints) {}
}
