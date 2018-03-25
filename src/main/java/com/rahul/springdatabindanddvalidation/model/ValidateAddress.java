package com.rahul.springdatabindanddvalidation.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidateAddress {

	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[A-z]+$")
	private String city;
	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[A-z]+$")
	private String state;
	
	@Size(min = 5, max = 6)
	private String pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
