package com.employee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{
	
	private static final long serialVersionID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "roll_Num", nullable = false)
	private String roll_Num;
	
	//private Date dob;
	
	public Employee() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoll_Num() {
		return roll_Num;
	}

	public void setRoll_Num(String roll_Num) {
		this.roll_Num = roll_Num;
	}

	public Employee(Long id, String name, String address, String email, String roll_Num) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.roll_Num = roll_Num;
	}
	
	
	
}
