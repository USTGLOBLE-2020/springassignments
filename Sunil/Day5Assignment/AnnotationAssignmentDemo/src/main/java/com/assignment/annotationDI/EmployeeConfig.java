package com.assignment.annotationDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
	  @Bean 
	   public EmployeeSetterClass displayEmpName(){
	      return new EmployeeSetterClass();
	   }
}
