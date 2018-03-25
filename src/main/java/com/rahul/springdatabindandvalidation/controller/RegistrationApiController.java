package com.rahul.springdatabindandvalidation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.springdatabindanddvalidation.custom.MyCustomDateEditor;
import com.rahul.springdatabindanddvalidation.model.ValidateRegistration;

@RestController
public class RegistrationApiController {


	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		// binder.setDisallowedFields(new String[] { "age" });

		SimpleDateFormat inSdf2 = new SimpleDateFormat("dd-MM-yyyy");
		// binder.registerCustomEditor(Date.class, "dob", new
		// CustomDateEditor(inSdf2, false)); to use spring provided custom date
		// editor
		binder.registerCustomEditor(Date.class, "dob", new MyCustomDateEditor()); // to
																					// use
																					// user
																					// defined
																					// custom
																					// editor

	}

	/**
	 * Rest api method  
	 * @param registration
	 * @return
	 */
	@RequestMapping(value = "/apiregister.do", method = RequestMethod.POST)
	@ResponseBody
	public String registration(@Valid @RequestBody ValidateRegistration registration) {
		return registration.toString();
	}


}
