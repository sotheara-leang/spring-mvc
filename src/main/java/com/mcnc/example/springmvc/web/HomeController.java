package com.mcnc.example.springmvc.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mcnc.example.springmvc.base.error.BusinessError;
import com.mcnc.example.springmvc.base.exception.BusinessException;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletResponse response) {
		throw new BusinessException(BusinessError.COMP100);
	}
}
