package com.assignment.annotationConstructorDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorMainApp {
	public static void main(String[] args) {
		ApplicationContext appCon = new AnnotationConfigApplicationContext(EmpConAnnotationConfig.class);
		EmpConAnnotation empCon = (EmpConAnnotation)appCon.getBean(EmpConAnnotation.class);
		empCon.setEmpID(100);
		empCon.setEmpName("Sunil");
		empCon.setSalary(200000);
		empCon.display();
	}
}