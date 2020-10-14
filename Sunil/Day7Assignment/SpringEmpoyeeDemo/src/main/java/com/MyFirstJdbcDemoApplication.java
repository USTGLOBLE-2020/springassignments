package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@ComponentScan("com.*")


public class MyFirstJdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstJdbcDemoApplication.class, args);
	}

}
