package com.mcnc.example.springmvc.company;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mcnc.example.springmvc.AbstractTestCase;

public class TestCompanyController extends AbstractTestCase {

	@Test
	public void testCreateCompany() throws JsonProcessingException, Exception {
		Company company = new Company();
		company.setName("13");
		company.setAddress("Address");
		mockMvc.perform(post("/api/companies")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(company)))
			.andDo(print());
	}
	
	@Test
	public void testUpdateCompany() throws JsonProcessingException, Exception {
		Company company = new Company();
		company.setName("13");
		mockMvc.perform(put("/api/companies")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(company)))
			.andDo(print());
	}
	
	@Test
	public void testGetHomePage() throws JsonProcessingException, Exception {
		mockMvc.perform(get("/"))
			.andDo(print());
	}
}
