package com.spring.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringBootDataJpaApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootDataJpaApplication.class);

	public static void main(String[] args) {

		LOGGER.info("Spring boot stand alone class");
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

}
