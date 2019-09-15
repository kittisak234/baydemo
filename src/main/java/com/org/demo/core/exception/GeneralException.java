package com.org.demo.core.exception;

public class GeneralException extends RuntimeException {
	private static final long serialVersionUID = -2449218620962757549L;
	
	public GeneralException(Exception e) {
		super(e);
	}
}
