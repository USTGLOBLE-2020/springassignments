package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="StudentMon")
public class StudentMon implements java.io.Serializable
 {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String studentAddress;
	
	private String mobileNumber;
	
	
	public StudentMon(Integer id, String name, String email, String studentAddress, String mobileNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.studentAddress = studentAddress;
		this.mobileNumber = mobileNumber;
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
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "StudentMon [id=" + id + ", name=" + name + ", email=" + email + ", studentAddress=" + studentAddress
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	
	
	
}
