package com.converter.csvtojson.exceptions;

public class CustomServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomServiceException(String message) {
		super(message);
	}

	public CustomServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
