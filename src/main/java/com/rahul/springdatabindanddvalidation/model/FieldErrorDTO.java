package com.rahul.springdatabindanddvalidation.model;
/**
 * Class to hold  field level error message
 * @author rahul
 *
 */
public class FieldErrorDTO {
	private String field;
	private String message;
	public FieldErrorDTO(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
