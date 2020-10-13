package com.Student.dao;

import java.util.List;

import com.Student.bean.Student;

public interface StudentDao {

	public List<Student> getAllStudentDetails();

	public String createStudent(Student student);

	public List<Student> getStudentDetailsById(int id);

	public String updateStudent(int id, String email_address);

	public String deleteEmployeebyId(int id);

}
