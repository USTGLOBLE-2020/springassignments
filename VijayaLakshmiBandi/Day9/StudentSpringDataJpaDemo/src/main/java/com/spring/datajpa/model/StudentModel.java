package com.spring.datajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentID")
	private long studentID;
	
	@Column(name = "studentName")
	private String studentName;
	
	@Column(name = "studentAddress")
	private String studentAddress;
	
	@Column(name = "emailID")
	private String emailID;
	
	@Column(name = "rollNumber")
	private String rollNumber;

	@Column(name = "dob")
	private String dob;
	
	public StudentModel() {
		
	}
	
	public StudentModel(String StudName, String studentAddr,String emailid, String rollNumber,String dob) {
		this.studentName = StudName;
		this.studentAddress = studentAddr;
		this.emailID = emailid;
		this.rollNumber = rollNumber;
		this.dob = dob;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "StudentModel [studentID=" + studentID + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", emailID=" + emailID + ", rollNumber=" + rollNumber + ", dob=" + dob + "]";
	}

	
}
