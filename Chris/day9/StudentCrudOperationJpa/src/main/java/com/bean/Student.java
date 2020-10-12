package com.bean;


public class Student {

	long rollno;
	String name;
	String email;
	String phone;
	
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

public Student() {

}
	
	public Student(Long Rollno, String name,String email, String phone) {
		this.rollno = Rollno;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	
	@Override
	public String toString() {
		return "Student [studentID=" + rollno + ", studentName=" + name + ",  emailID=" + email + ", PhoneNumber=" + phone + "]";
	}

	

}
