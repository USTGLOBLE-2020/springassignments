package com.service;

import java.util.List;

import com.model.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public List<Student> getStudentByID(int id);
	public String createStudent(Student student);
	public String updateStudent(int id, String email_address,String phoneNumber);
	public String deleteStudentbyId(int id);
	public String deleteStudents();
}
