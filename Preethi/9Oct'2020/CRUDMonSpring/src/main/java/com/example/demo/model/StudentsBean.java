package com.example.demo.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
public class StudentsBean implements Serializable  {
	
	private static final long serialVersionID= 1L;
	
	@Id
	private long studentID;
	
	@NotNull(message = "Student Name is compulsory")
	private String studentName;
	
	@NotNull(message = "Student Address is compulsory")
	private String studentAddress;
	
	@NotEmpty
	@NotNull(message = "Email  is compulsory")
	private String emailID;
	
	@NotEmpty
	private String rollNumber;

	
	public StudentsBean() {
		
	}
	
	public StudentsBean(String StudName, String studentAddr,String emailid, String rollNumber) {
		this.studentName = StudName;
		this.studentAddress = studentAddr;
		this.emailID = emailid;
		this.rollNumber = rollNumber;
	}

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "StudentsBean [studentID=" + studentID + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", emailID=" + emailID + ", rollNumber=" + rollNumber + "]";
	}


	
}
