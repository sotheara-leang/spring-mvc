package com.mcnc.example.springmvc.web.rest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.example.springmvc.base.web.validation.Validation;
import com.mcnc.example.springmvc.company.Company;
import com.mcnc.example.springmvc.company.CompanyValidator;

@RestController
@RequestMapping("companies")
public class CompanyRestController {
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new CompanyValidator());
    }

	@RequestMapping(method = RequestMethod.POST)
	public void create(@Validated({Validation.CREATE.class}) @RequestBody Company company) {

	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void update(@Validated({Validation.UPDATE.class}) @RequestBody Company company) {

	}
}
