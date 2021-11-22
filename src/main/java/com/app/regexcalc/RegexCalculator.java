package com.app.regexcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class RegexCalculator {
	
	
	public boolean regex(String regex_String, String string) {
		
		Pattern pattern=Pattern.compile(regex_String);
		Matcher match=pattern.matcher(string);
		
		
		return match.matches();
	}

}
