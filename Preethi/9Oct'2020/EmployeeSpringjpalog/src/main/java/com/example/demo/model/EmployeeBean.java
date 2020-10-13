package com.example.demo.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class EmployeeBean implements Serializable  {
	
	private static final long serialVersionID= 1L;
	
	@Id
	private long employeeID;
	
	@NotNull(message = " Name is compulsory")
	private String employeeName;
	
	@NotNull(message = " Address is compulsory")
	private String employeeAddress;
	
	@NotEmpty
	@Indexed(unique=true)

	@NotNull(message = "Email is compulsory")
	private String employeeemailID;
	
	@NotEmpty
	private String employeesalary;

	
	public EmployeeBean() {
		
	}
	
	public EmployeeBean(String empName, String empAddr,String emailid, String empsalary) {
		this.employeeName = empName;
		this.employeeAddress = empAddr;
		this.employeeemailID = emailid;
		this.employeesalary = empsalary;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeemailID() {
		return employeeemailID;
	}

	public void setEmployeeemailID(String employeeemailID) {
		this.employeeemailID = employeeemailID;
	}

	public String getEmployeesalary() {
		return employeesalary;
	}

	public void setEmployeesalary(String employeesalary) {
		this.employeesalary = employeesalary;
	}

	@Override
	public String toString() {
		return "EmployeeBean [employeeID=" + employeeID + ", employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + ", employeeemailID=" + employeeemailID + ", employeesalary=" + employeesalary + "]";
	}


	
}
