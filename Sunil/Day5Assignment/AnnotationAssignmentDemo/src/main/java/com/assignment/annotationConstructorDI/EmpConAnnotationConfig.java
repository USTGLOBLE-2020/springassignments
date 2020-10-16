package com.assignment.annotationConstructorDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpConAnnotationConfig {
	@Bean
	public EmpConAnnotation empConfig() {
		return new EmpConAnnotation();
	}
}	