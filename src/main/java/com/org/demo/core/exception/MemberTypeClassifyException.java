package com.org.demo.core.exception;

public class MemberTypeClassifyException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 244723663311144913L;
	private String code;
	private String message;
	
	public MemberTypeClassifyException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
