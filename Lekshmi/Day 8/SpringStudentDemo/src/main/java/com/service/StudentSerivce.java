package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Student;

public interface StudentSerivce {
	

	public List<Student> getStudents();

	public String createStudentDetails(Student student) throws SQLException;


	public String deleteById(int id) throws SQLException;

	public Student getStudents(int id) throws SQLException;

	public String updateStudentdetails(int id, String email_address) throws SQLException;

}
