package com.rahul.springdatabindanddvalidation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * To create Custom Annotation
 * @author rahul
 *
 */
@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomDateValidatorInterface {

	String message() default "Date of Birth does not meet the criteria age above 18";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}