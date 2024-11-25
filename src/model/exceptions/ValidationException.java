package model.exceptions;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Getter
	private Map<String, String> errors = new HashMap<>();
	
	public ValidationException(String msg) {
		super(msg);
	}
	
	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage);
	}
}
