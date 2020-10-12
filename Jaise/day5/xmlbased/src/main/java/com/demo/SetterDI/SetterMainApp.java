package com.demo.SetterDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appCon = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		SetterDI setter = (SetterDI) appCon.getBean("displayData");
		setter.display();
	}

}
