package com.XMLBasedDIConstructor.Assignment;

public class EmployeeSetterDI {
	private int eid;
	private String name;
	private double salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	void display() {
		System.out.println("Id is "+eid+"\nEmp name is "+name+"\nSalary is"+salary);
	}
}
