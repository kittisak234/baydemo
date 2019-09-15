package com.org.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloController {
	
	@GetMapping(value = "/v1/demo/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String sayHello() {
		return "Hello World";
	}
}
