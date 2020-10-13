package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Student;
import com.dao.StudentDao;


@Service
public class StudentServiceImpl implements StudentSerivce {

	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {

		return studentDao.getAllStudents();
	}
	@Override
	public List<Student> getStudentById(int rollno) {

		return studentDao.getStudentById(rollno);
	}
	@Override
	public String createStudentDetails(Student student){
		return studentDao.createStudentDetails(student);
	}
	@Override
	public String updateStudentById(int rollno,String name,String email,String phone){
		 return studentDao.updateStudentById(rollno,name,email,phone);
	}
	@Override
	public String deleteByStudentId(int rollno){
		 return studentDao.deleteByStudentId(rollno);
	}
}
