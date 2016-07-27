package com.mcnc.example.springmvc.company;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.mcnc.example.springmvc.base.web.validation.AbstractValidator;
import com.mcnc.example.springmvc.base.web.validation.DefaultValidation;

public class CompanyValidator extends AbstractValidator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Company.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors, Object... validationHints) {
		Class<?> validation = (Class<?>) validationHints[0];
		
		if (DefaultValidation.CREATE.class.isAssignableFrom(validation)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "Need name");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", null, "Need address");
			
		} else if (DefaultValidation.UPDATE.class.isAssignableFrom(validation)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "Need name");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", null, "Need address");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", null, "Need id");
		}
	}
}
