package com.app.api;

import java.util.regex.PatternSyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.regexcalc.RegexCalculator;

@RestController
@RequestMapping("/")
public class RegexApi {
	
	public static final String NOTFOUND="Incorrect Request: Please Check Request URL";

	@Autowired
	RegexCalculator rexcalculator;


}
