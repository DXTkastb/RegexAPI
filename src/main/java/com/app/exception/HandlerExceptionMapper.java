package com.app.exception;

import java.util.regex.PatternSyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.exception.ExceptionObj.ExceptionTemplateObject;

@ControllerAdvice
public class HandlerExceptionMapper {

	public static final String INCORRECT_PATTERN = "INCORRECT_PATTERN";
	public static final String INCORRECT_MESSAGE = "PatternSyntaxException Occured!";

	@ExceptionHandler(PatternSyntaxException.class)
	public ResponseEntity<ExceptionTemplateObject> exceptionHandler1() {

		ResponseEntity<ExceptionTemplateObject> ex = new ResponseEntity(
				new ExceptionTemplateObject(INCORRECT_PATTERN, INCORRECT_MESSAGE), HttpStatus.NOT_ACCEPTABLE);

		return ex;

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Some Error Occured!")
	public String exceptionHandler2() {
		return "500";
	}

}
