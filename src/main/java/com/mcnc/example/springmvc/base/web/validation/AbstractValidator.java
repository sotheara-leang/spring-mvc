package com.mcnc.example.springmvc.base.web.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

/**
 * Abstract Validator
 * @author Sotheara
 *
 */
public abstract class AbstractValidator implements SmartValidator {

	@Override
	public void validate(Object target, Errors errors) {
		validate(target, errors, new Object[] {});
	}
}
