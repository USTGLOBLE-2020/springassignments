package com.assignments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controller","com.repository", "com.service", "com.model"})
public class SpringBootJdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcDemoApplication.class, args);
	}

}
