package com.rahul.springdatabindandvalidation.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rahul.springdatabindanddvalidation.custom.MyCustomDateEditor;
import com.rahul.springdatabindanddvalidation.model.Registration;
import com.rahul.springdatabindanddvalidation.model.ValidateRegistration;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	MessageSource messageSource;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/form2", method = RequestMethod.GET)
	public String form2(Model model) {
		return "validateregistration";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form( Model model) {
		return "register";
	}
	
	/**
	 * To register custom databinder etc
	 * @param binder
	 */
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] { "age" });

		SimpleDateFormat inSdf2 = new SimpleDateFormat("dd-MM-yyyy");
		// binder.registerCustomEditor(Date.class, "dob", new
		// CustomDateEditor(inSdf2, false)); to use spring provided custom date editor
		binder.registerCustomEditor(Date.class, "dob", new MyCustomDateEditor()); // to use user defined custom editor

	}
	/**
	 * Data binding controller
	 * @param registration
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("register1") Registration registration, BindingResult result) {
		if (result.hasErrors()) {
			// if error stay on same page
			ModelAndView mv = new ModelAndView("register"); // returns reigster.jsp
			return mv;
			
		} else {
			// if success move to next page
			ModelAndView mv = new ModelAndView("success"); //returns success.jsp
			return mv;

		}
		
	}
	/**
	 * Data bindind and validation example
	 * @param registration
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/validateregister.do", method = RequestMethod.POST)
	public ModelAndView validateRegister(@Valid @ModelAttribute("validateregistration1") ValidateRegistration validateRegistration, BindingResult result) {
		if (result.hasErrors()) {
			// if error stay on same page
			ModelAndView mv = new ModelAndView("validateregistration"); // returns validateregistration.jsp
			return mv;
			
		} else {
			// if success move to next page
			ModelAndView mv = new ModelAndView("success"); //returns success.jsp
			return mv;

		}

	}
	

}
