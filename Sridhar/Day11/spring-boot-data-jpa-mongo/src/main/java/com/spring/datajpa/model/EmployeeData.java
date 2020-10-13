package com.spring.datajpa.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.*;

/**
 * @author Sridhar rayana
 * Calls for Employee details entity Class 
 */
@Document (collection = "employeedetails")
public class EmployeeData{

	
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@NotEmpty(message = "Employee name must not be empty")
	@Size(min = 4, message = "Name should have atleast 4 characters")
	
	private String empName;
	@NotEmpty(message = "Employee salary must not be empty")
	private String empSal;
	@NotEmpty(message = "Address name must not be empty")
	@Size(min = 4, message = "Address should have atleast 4 characters")
	private String address;
	// @NotEmpty(message = "Email must not be empty")
	// @Email(message = "Email must be a valid email address")
	private String email;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull
	@Past
	private Date birthDay;

	public EmployeeData() {

	}

	public EmployeeData(long id, String empName, String empSal, String address, String email, Date birthDay) {
		super();
		this.id = id;
		this.empName = empName;
		this.empSal = empSal;
		this.address = address;
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSal() {
		return empSal;
	}

	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeData [id=" + id + ", empName=" + empName + ", empSal=" + empSal + ", address=" + address + "]";
	}

}
