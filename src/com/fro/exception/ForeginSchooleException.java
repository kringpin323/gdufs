package com.fro.exception;

public class ForeginSchooleException extends Exception{

	public ForeginSchooleException() {
		
	}
	
	private String message;

	public ForeginSchooleException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
