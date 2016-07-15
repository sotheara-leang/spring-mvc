package com.mcnc.example.springmvc.web.rest;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.example.springmvc.company.Company;

@RestController
@RequestMapping("companies")
public class CompanyRestController {

	@RequestMapping(method = RequestMethod.POST)
	public String createCompany(@Valid @RequestBody Company company, BindingResult result) {
		 if (result.hasErrors()) {
			 return "error";
		 } else {
			 return "success";
		 }
	}
}
