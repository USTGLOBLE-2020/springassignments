package com.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Student;
import com.repository.StudentRepository;

@org.springframework.stereotype.Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.getAllStudents();
	}
	@Override
	public List<Student> getStudentByID(int id) {
		return studentRepo.getStudentByID(id);
	}
	@Override
	public String createStudent(Student student) {
		return studentRepo.createStudent(student);
	}
	@Override
	public String updateStudent(int id, String emailAddress,String phoneNumber) {
		return studentRepo.updateStudent(id, emailAddress, phoneNumber);
	}

	@Override
	public String deleteStudentbyId(int id) {
		return studentRepo.deleteStudentbyId(id);
	}
	
	@Override
	public String deleteStudents() {
		return studentRepo.deleteStudents();
	}
}
