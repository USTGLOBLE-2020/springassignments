package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Student;
import com.dao.StudentDao;

@Service
public class StudentserviceIml implements StudentSerivce {

	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getStudents() {

		return studentDao.getStudents();
	}

	@Override
	public String createStudentDetails(Student student) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.createStudentDetails(student);
	}

	
	@Override
	public String deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.deleteById(id);
	}

	@Override
	public Student getStudents(int id) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.getStudents(id);
	}

	@Override
	public String updateStudentdetails(int id, String email_address) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.updateStudentdetails(id, email_address);
	}

}
