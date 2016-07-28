package com.mcnc.example.springmvc.base.util;

import org.springframework.validation.Errors;

/**
 * 
 * @author sotheara.leang
 *
 */
public class ValidationUtils extends org.springframework.validation.ValidationUtils {

	/**
	 * 
	 * @param errors
	 * @param field
	 * @param errorCode
	 */
	public static void rejectIfEmpty(Errors errors, String field) {
		rejectIfEmpty(errors, field, null, MessageUtils.getMessage("validation.field.require"));
	}
	
	/**
	 * 
	 * @param errors
	 * @param field
	 */
	public static void rejectIfEmptyOrWhitespace(Errors errors, String field) {
		rejectIfEmptyOrWhitespace(errors, field, null, MessageUtils.getMessage("validation.field.require"));
	}
}
