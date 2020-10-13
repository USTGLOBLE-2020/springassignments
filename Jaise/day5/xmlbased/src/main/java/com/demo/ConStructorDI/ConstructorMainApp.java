package com.demo.ConStructorDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorMainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DisplayNameUsingConstructorDI displayName = (DisplayNameUsingConstructorDI)appContext.getBean("displayNameConstructor");
				displayName.sampleDemo();
	}

}
