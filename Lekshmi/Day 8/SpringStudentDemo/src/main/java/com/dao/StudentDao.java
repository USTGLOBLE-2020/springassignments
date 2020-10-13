package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.Student;

public interface StudentDao {

	// list the all records
	public List<Student> getStudents();

	public Student getStudents(int id) throws SQLException;

	public String createStudentDetails(Student student) throws SQLException;

	public String deleteById(int id) throws SQLException;

	public String updateStudentdetails(int id, String email_address) throws SQLException;

}
