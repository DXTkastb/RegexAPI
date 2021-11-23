package com.app.api;

import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.exception.ExceptionObj.ExceptionTemplateObject;
import com.app.regexcalc.RegexCalculator;
import com.app.results.RegResult;

@Controller
@RequestMapping("/")
public class RegexApi {

	private static final String message = "BAD-REQUEST 404";
	private static final String description = "Please Check URL";

	@Autowired
	RegexCalculator rexcalculator;

	@GetMapping(value = "expression")
	public ResponseEntity<RegResult> regexHandler(@RequestParam(value = "regex", required = true) String regex_String,
			@RequestParam(value = "string", required = true) String string) {

		ResponseEntity<RegResult> reg = null;
		RegResult regResult = null;

		try {

			regResult = rexcalculator.result(regex_String, string);

		} catch (PatternSyntaxException pException) {

			throw pException;

		} catch (Exception e) {
			throw e;
		}

		reg = new ResponseEntity<>(regResult, HttpStatus.OK);

		return reg;
	}

	@GetMapping("**")
	public ResponseEntity<String> notFoundHandler() {

		ResponseEntity<String> notFoundResponse = new ResponseEntity(new ExceptionTemplateObject(message, description),
				HttpStatus.BAD_REQUEST);

		return notFoundResponse;
	}

}
