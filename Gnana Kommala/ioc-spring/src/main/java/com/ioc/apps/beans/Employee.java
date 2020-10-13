package com.ioc.apps.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Employee {
	private int empId;
	private String empName;
	private String address;
	
	@Autowired
	private Salary salary;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public void showEmpdails() {
	System.out.println("Employee Id:::"+empId);
	System.out.println("Employee Name:::"+empName);
	System.out.println("Employee Address:::"+address);
	salary.setSalary(30000);
	System.out.println("Salary:::"+salary.getSalary());

}
}
