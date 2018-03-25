package com.rahul.springdatabindanddvalidation.model;

import java.util.Date;
import java.util.List;

public class Registration {
	
	private String name;
	private int age;
	private Date dob;
	private Address address;
	private String nick;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
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
		return "Registration [name=" + name + ", age=" + age + ", dob=" + dob + ", address=" + address + ", languages="
				+ languages + "]";
	}
	
	
	

}
