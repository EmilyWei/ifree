package com.mittop.ifree;

public class IfreeException extends Exception {

	public IfreeException() {
	}

	public IfreeException(String message) {
		super(message);
	}

	public IfreeException(Throwable cause) {
		super(cause);
	}

	public IfreeException(String message, Throwable cause) {
		super(message, cause);
	}

	
	int level;
}
