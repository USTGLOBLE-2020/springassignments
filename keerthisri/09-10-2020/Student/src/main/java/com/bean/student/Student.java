package com.bean.student;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
	
	private static final long serialVersionID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "roll_Num")
	private String roll_Num;
	
	//private Date dob;
	
	public Student() {
		
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
	public void setId(Long id) {
		this.id = id;
	}
	public Student(Long id, String name, String address, String email, String roll_Num) {
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.roll_Num = roll_Num;
	}
	
	/*
	 * public Date getDob() { return dob; } public void setDob(Date dob) { this.dob
	 * = dob; }
	 */
	
	
}
