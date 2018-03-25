package com.rahul.springdatabindandvalidation.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rahul.springdatabindanddvalidation.model.ValidationErrorDTO;
/**
 * Common error handler for all controller
 * @author rahul
 *
 */
@ControllerAdvice // to use this annotation we must have Spring 3.2.x+
public class RestHandler {
	
	@Autowired
	MessageSource messageSource; // to get user defined messages from message.properties file

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors(); // to get all field errors

		return processFieldErrors(fieldErrors);
	}
	/**
	 * Method to bind field error in our custom error dto along with a message
	 * @param fieldErrors
	 * @return
	 */
	private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		ValidationErrorDTO dto = new ValidationErrorDTO();

		for (FieldError fieldError : fieldErrors) {
			 String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
		
			dto.addFieldError(fieldError.getField(), localizedErrorMessage);
		}

		return dto;
	}
	/**]
	 * Getting custom error messages based on localisation
	 * @param fieldError
	 * @return
	 */
	private String resolveLocalizedErrorMessage(FieldError fieldError) {
        String localizedErrorMessage = messageSource.getMessage(fieldError, null);
 
        //If the message was not found, return the most accurate field error code instead.
        //You can remove this check if you prefer to get the default error message.
       /* if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            localizedErrorMessage = fieldErrorCodes[0];
        }*/
        return localizedErrorMessage;
        }
 
	
	
      
}
