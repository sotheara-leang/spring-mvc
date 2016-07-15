package com.mcnc.example.springmvc.company;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8981097005217607429L;
	private Integer id;
	
	@Size(min = 3, max = 8, message = "{validation.company.name}")
	private String name;
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
