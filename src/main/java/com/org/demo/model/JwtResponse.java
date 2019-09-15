package com.org.demo.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = 7157841377632785495L;
	
	private final String jwttoken;
	
	public JwtResponse(String jwttoken) {
	this.jwttoken = jwttoken;
	}
	public String getToken() {
	return this.jwttoken;
	}
}