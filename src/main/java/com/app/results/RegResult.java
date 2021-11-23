package com.app.results;

import java.util.List;

import lombok.Data;

@Data
public class RegResult {

	public boolean match;
	public List<String> matchingGroups;

	public RegResult() {

	}

}
