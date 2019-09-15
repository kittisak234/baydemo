package com.org.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationApp {
	@Value("${encrypt.key}")
	public String ENCRYPT_KEY;
	
	@Value("${init.vector}")
	public String INIT_VECTOR;
}
