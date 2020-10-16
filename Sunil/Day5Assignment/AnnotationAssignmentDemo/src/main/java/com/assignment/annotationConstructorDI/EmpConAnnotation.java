package com.assignment.annotationConstructorDI;

public class EmpConAnnotation {
	private String empName;
	private int empID;
	private double salary;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public EmpConAnnotation() {
		System.out.println("Default Constructor");
	}
	public EmpConAnnotation(String empName1, int empID1, double salary1) {
		this.empName = empName1;
		this.empID = empID1;
		this.salary = salary1;
	}
	void display() {
		System.out.println("Employee Name is "+empName+"\nEmployee ID is "+empID+"\nEmployee Salary is "+salary);
	}
}
