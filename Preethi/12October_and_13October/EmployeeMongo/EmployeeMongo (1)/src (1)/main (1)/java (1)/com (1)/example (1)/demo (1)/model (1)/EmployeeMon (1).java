package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="EmployeeMon")
public class EmployeeMon implements java.io.Serializable
 {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String address;
	
	private String salary;
	
	
	public EmployeeMon(Integer id, String name, String email, String address, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeMon [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", salary=" + salary + "]";
	}
	
	
	
	
}
