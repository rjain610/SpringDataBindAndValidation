package com.rahul.springdatabindanddvalidation.custom;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * To create <i>custom validator</i> class must implement <b>ConstraintValidator<{YourInterface}, DataType> </b>
 * @author rahul
 *
 */
public class DateValidator implements ConstraintValidator<MyCustomDateValidatorInterface, Date> {

	@Override
	public void initialize(MyCustomDateValidatorInterface arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Date arg0, ConstraintValidatorContext arg1) {
		Calendar cal = Calendar.getInstance();
		int todayYear = cal.get(Calendar.YEAR);
		cal.setTime(arg0);
		int year = cal.get(Calendar.YEAR);
		if(todayYear - year > 18) {
			return true;
		} else {
			return false;
		}
	}

}
