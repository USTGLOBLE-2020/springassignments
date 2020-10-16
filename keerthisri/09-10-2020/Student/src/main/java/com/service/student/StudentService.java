package com.service.student;

import org.springframework.http.ResponseEntity;

import com.bean.student.Student;

public interface StudentService {

	Object saveStudent(Student student) throws Exception;
	
}
