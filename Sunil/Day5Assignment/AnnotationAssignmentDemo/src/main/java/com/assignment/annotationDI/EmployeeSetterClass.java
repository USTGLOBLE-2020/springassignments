package com.assignment.annotationDI;

public class EmployeeSetterClass {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	void display() {
		System.out.println("Display name "+name);
	}
}
