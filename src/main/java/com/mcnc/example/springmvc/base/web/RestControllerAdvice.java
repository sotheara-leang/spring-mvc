package com.mcnc.example.springmvc.base.web;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.mcnc.example.springmvc.base.error.SystemError;
import com.mcnc.example.springmvc.base.error.message.ErrorMessage;
import com.mcnc.example.springmvc.base.error.message.ErrorMessageBuilder;
import com.mcnc.example.springmvc.base.error.message.FormElementError;
import com.mcnc.example.springmvc.base.error.message.FormErrorMessage;
import com.mcnc.example.springmvc.base.exception.BusinessException;

/**
 * Rest controller advice
 * @author Sotheara
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class RestControllerAdvice {

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
	public @ResponseBody ErrorMessage handle404(NoHandlerFoundException ex, Locale locale) {
		return new ErrorMessageBuilder()
				.code(SystemError.SYS404)
				.status(HttpStatus.NOT_FOUND.value())
				.message(messageSource.getMessage(SystemError.SYS404.getMessageCode(), null, locale))
				.build();
	}
			
	/**
	 * Handle business login error
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BusinessException.class)
	public @ResponseBody Object handleBusiness(BusinessException ex, Locale locale, HttpServletRequest request, HttpServletResponse response) {
		
		return new ErrorMessageBuilder()
				.code(ex.getError())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(messageSource.getMessage(ex.getError().getMessageCode(), null, locale))
				.build();
	}
	
	/**
	 * Handle request parameters error
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody FormErrorMessage handleRequestParameterError(MethodArgumentNotValidException ex, Locale locale) {
		FormErrorMessage errorMsg = new FormErrorMessage();
		errorMsg.setStatus(HttpStatus.BAD_REQUEST.value());
		errorMsg.setMessage(messageSource.getMessage(SystemError.SYS400.getMessageCode(), null, locale));
		
		// Prepare form element error
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		for (FieldError error : errors) {
			FormElementError ele = new FormElementError();
			ele.setField(error.getField());
			ele.setMessage(error.getDefaultMessage());
			errorMsg.getErrors().add(ele);
		}
		
		return errorMsg;
	}
	
	/**
	 * Handle other exception
	 * @param ex
	 * @param locale
	 * @return
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ErrorMessage handleOtherError(Exception ex) {
		return new ErrorMessageBuilder()
				.code(SystemError.SYS500)
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage())
				.build();
	}
}
