package com.XMLBasedDIConstructor.Assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.XMLBasedDIConstructor.Assignment.EmployeeSetterDI;

public interface EmployeeMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appCon = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeSetterDI empSetterID = (EmployeeSetterDI)appCon.getBean("setterEmployee");
		empSetterID.display();
	}
}
