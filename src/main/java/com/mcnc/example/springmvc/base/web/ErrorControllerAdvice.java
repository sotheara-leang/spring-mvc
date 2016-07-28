package com.mcnc.example.springmvc.base.web;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mcnc.example.springmvc.base.error.SystemError;
import com.mcnc.example.springmvc.base.error.message.ErrorMessage;
import com.mcnc.example.springmvc.base.error.message.ErrorMessageBuilder;
import com.mcnc.example.springmvc.base.error.message.FormElementError;
import com.mcnc.example.springmvc.base.error.message.FormErrorMessage;
import com.mcnc.example.springmvc.base.exception.BusinessException;

/**
 * Error Controller Advice
 * @author Sotheara
 *
 */
@ControllerAdvice
public class ErrorControllerAdvice {

	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Handle resource not found
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle404(NoHandlerFoundException ex, Model model, Locale locale) {
		ErrorMessage errorMessage = new ErrorMessageBuilder()
				.code(SystemError.SYS404)
				.status(HttpStatus.NOT_FOUND.value())
				.message(messageSource.getMessage(SystemError.SYS404.getMessageCode(), null, locale))
				.build();
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "error/404";
	}
			
	/**
	 * Handle business login error
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BusinessException.class)
	public String handleBusiness(BusinessException ex, Model model, Locale locale) {
		ErrorMessage errorMessage = new ErrorMessageBuilder()
				.code(ex.getError())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(messageSource.getMessage(ex.getError().getMessageCode(), null, locale))
				.build();
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "error/500";
	}
	
	/**
	 * Handle request parameters error
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleRequestParameterError(MethodArgumentNotValidException ex, Model model, Locale locale) {
		FormErrorMessage errorMessage = new FormErrorMessage();
		errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(messageSource.getMessage(SystemError.SYS400.getMessageCode(), null, locale));
		
		// Prepare form element error
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		for (FieldError error : errors) {
			FormElementError ele = new FormElementError();
			ele.setField(error.getField());
			ele.setMessage(error.getDefaultMessage());
			errorMessage.getErrors().add(ele);
		}
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "error/400";
	}
	
	/**
	 * Handle other exception
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleOtherError(Model model, Exception ex) {
		ErrorMessage errorMessage = new ErrorMessageBuilder()
				.code(SystemError.SYS500)
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage())
				.build();
		
		model.addAttribute("errorMessage", errorMessage);
		
		return "error/500";
	}
}
