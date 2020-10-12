package com.demo.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DisplayNameUsingDI displayName = (DisplayNameUsingDI)appContext.getBean("displayNameDI");
		displayName.display();
	}

}
