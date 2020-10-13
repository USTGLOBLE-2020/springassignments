package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class StudentApplicationMain {
	
			public static void main(String[] args) {
				SpringApplication.run(StudentApplicationMain.class, args);
			}
	}

