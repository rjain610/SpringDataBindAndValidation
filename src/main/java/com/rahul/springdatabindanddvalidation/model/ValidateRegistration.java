package com.rahul.springdatabindanddvalidation.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.rahul.springdatabindanddvalidation.custom.MyCustomDateValidatorInterface;

public class ValidateRegistration {
	
	@NotNull
	@NotEmpty
	@Size(min = 2)
	@Pattern(regexp = "^[A-z]+$")
	private String name;
	@Range(min = 18, max = 50)
	private int age;
	@NotNull
	@MyCustomDateValidatorInterface
	private Date dob;
	@Valid
	private ValidateAddress address;
	private String nick;
	@NotNull
	@Size(min=1)
	private List<String> languages;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public ValidateAddress getAddress() {
		return address;
	}
	public void setAddress(ValidateAddress address) {
		this.address = address;
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "ValidateRegistration [name=" + name + ", age=" + age + ", dob=" + dob + ", address=" + address
				+ ", nick=" + nick + ", languages=" + languages + "]";
	}
	
	
	
	

}
