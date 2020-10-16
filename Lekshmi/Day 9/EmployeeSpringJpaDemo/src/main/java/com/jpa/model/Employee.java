package com.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@NotBlank
    @Email(message = "Please enter a valid e-mail address")
	@Column(name = "emailID")
	private String emailID;
	
	@Column(name = "salary")
	private Long salary;

	@Column(name = "DOB")
	private Date DOB;
	
	public Employee() {
		
	}

	public Employee(long id, @NotBlank(message = "Name is mandatory") String name, String address,
			@NotBlank @Email(message = "Please enter a valid e-mail address") String emailID, Long salary, Date dOB) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.emailID = emailID;
		this.salary = salary;
		DOB = dOB;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	



	

	
}
