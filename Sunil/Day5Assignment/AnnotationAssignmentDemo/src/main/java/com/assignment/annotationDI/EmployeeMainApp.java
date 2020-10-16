package com.assignment.annotationDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.assignment.annotationDI.EmployeeSetterClass;
import com.assignment.annotationDI.EmployeeConfig;

public class EmployeeMainApp {
	public static void main(String [] args)
	{
		ApplicationContext appCon = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeSetterClass emp = (EmployeeSetterClass)appCon.getBean(EmployeeSetterClass.class);
		emp.setName("Sunil");
		emp.display();
	}
}