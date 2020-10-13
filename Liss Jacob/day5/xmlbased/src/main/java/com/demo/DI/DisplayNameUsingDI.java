package com.demo.DI;

public class DisplayNameUsingDI {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	void display() {
		System.out.println("Name is "+name);
	}
}
