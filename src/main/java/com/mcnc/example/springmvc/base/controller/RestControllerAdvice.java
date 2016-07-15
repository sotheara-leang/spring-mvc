package com.mcnc.example.springmvc.base.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public String handleValidationException(MethodArgumentNotValidException ex) {
		return "";
	}
}
