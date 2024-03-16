package com.devsuperior.demo.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO extends CustomErrorDTO {
	
	private List<FieldMessageDTO> errors = new ArrayList<>();
	
	public ValidationErrorDTO(Instant timestmap, Integer status, String error, String path) {
		super(timestmap, status, error, path);	
	}

	public List<FieldMessageDTO> getErrors() {
		return errors;
	}
	
	public void addError (String fieldName, String message) {
		errors.removeIf(x -> x.getFieldName().equals(fieldName));
		errors.add(new FieldMessageDTO(fieldName, message));
	}

}
