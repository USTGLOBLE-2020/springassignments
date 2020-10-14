package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="Student")
public class Student implements java.io.Serializable
 {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private String studName;
	
	private String email;
	
	private String studAddress;
	
	private String mobileNumber;
	
	
	public Employee(Integer id, String studName, String email, String studAddress, String mobileNumber) {
		super();
		this.id = id;
		this.studName = studName;
		this.email = email;
		this.studAddress = studAddress;
		this.mobileNumber = mobileNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
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
