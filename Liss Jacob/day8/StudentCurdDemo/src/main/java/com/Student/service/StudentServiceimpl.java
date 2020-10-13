package com.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.bean.Student;
import com.Student.dao.StudentDao;
@Service
public class StudentServiceimpl implements StudentService {

	@Autowired
	StudentDao studentdao;
	
	@Override
	public List<Student> getAllStudentDetails() {
		
		return studentdao.getAllStudentDetails();
	}

	@Override
	public String createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentdao.createStudent(student);
	}

	@Override
	public List<Student> getStudentDetailsById(int id) {
		// TODO Auto-generated method stub
		return studentdao.getStudentDetailsById(id);
	}

	@Override
	public String updateStudent(int id, String email_address) {
		// TODO Auto-generated method stub
		return studentdao.updateStudent(id,email_address);
	}

	@Override
	public String deleteEmployeebyId(int id) {
		// TODO Auto-generated method stub
		return studentdao.deleteEmployeebyId(id);
	}

}
