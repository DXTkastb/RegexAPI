package com.app.regexcalc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.app.results.RegResult;

@Service
public class RegexCalculator {
	
	
	

	public RegResult result(String rSTR,String str) {
		
		RegResult rr=new RegResult();
		Pattern p=patternGetter(rSTR);
		
		Matcher m=matcher(p,str);
		boolean isMatch=m.matches();
		if(isMatch==true) {
		rr.setMatch(isMatch);
		rr.setMatchingGroups(regexGroupMatcher(m));}
		else {
			
			rr.setMatch(false);
			rr.setMatchingGroups(null);
		}
		
		return rr;
	}
	
	
	public Pattern patternGetter(String regex_String) {
		
		return Pattern.compile(regex_String);
		
	}
	
	public Matcher matcher(Pattern pattern,String string) {
		
		return pattern.matcher(string);
		
	}
	
	
	
	public List<String> regexGroupMatcher(Matcher m){
		
		ArrayList<String> matchingStringGroups=new ArrayList();
		
		int groups=m.groupCount();
		
		while(groups>-1) {
			matchingStringGroups.add("group "+groups+" : "+m.group(groups));
			--groups;
		}
		
		return matchingStringGroups;
		
		
		
	}
	

}
