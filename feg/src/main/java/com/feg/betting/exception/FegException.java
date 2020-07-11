package com.feg.betting.exception;

public class FegException extends Exception{

	public FegException() {
		super();
	}

	public FegException(String message, Throwable cause) {
		super(message, cause);
	}

	public FegException(String message) {
		super(message);
	}

	public FegException(Throwable cause) {
		super(cause);
	}

}
