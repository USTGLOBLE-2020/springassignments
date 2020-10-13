package com.service;

import java.util.List;

import com.bean.Student;


public interface StudentSerivce {
	
	//list the all student
	public List<Student> getAllStudents();
	//list the all student by id
	public List<Student> getStudentById(int rollno);
	//add new student
	public String createStudentDetails(Student student);
	//update student details
	public String updateStudentById(int rollno,String name,String email,String phone);
	//delete student by id
	public String deleteByStudentId(int rollno);
}
