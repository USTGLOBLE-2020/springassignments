package com.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.student.Student;
import com.repository.student.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Object saveStudent(Student student) throws Exception {
		Student studentEntity = new Student();
			studentEntity.setId(student.getId());
			studentEntity.setName(student.getName());
			studentEntity.setEmail(student.getEmail());
			studentEntity.setAddress(student.getAddress());
			studentEntity.setRoll_Num(student.getRoll_Num());
			// studentEntity.setDob(student.getDob());
			studentRepository.save(studentEntity);
			return "SUCCESS";
	}

}
