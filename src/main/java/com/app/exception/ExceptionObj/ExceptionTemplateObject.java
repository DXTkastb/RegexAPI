package com.app.exception.ExceptionObj;

import lombok.Data;

@Data
public class ExceptionTemplateObject {

	public String message;
	public String description;

	public ExceptionTemplateObject(String mes, String des) {
		super();
		this.message = mes;
		this.description = des;
	}

}
