package com.controller.controller;

import java.util.List;
import java.util.Optional;

import com.repository.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.student.StudentService;
import com.bean.student.Student;
import com.exception.student.ResourceNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//import com.spring.datajpa.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);

	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studentsList = studentRepository.findAll();
		LOGGER.info("Student details ::"+studentsList);
		return new ResponseEntity<>(studentsList, HttpStatus.OK);
	}
	
	@GetMapping("/getStudentByID/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable long id) throws Exception {
		Student student = studentRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
		return ResponseEntity.ok().body(student);
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			LOGGER.info("Student data saved");
			Student studentEntity = studentRepository.save(
					new Student(student.getId(),student.getName(), 
							student.getAddress(), 
							student.getEmail(),
							student.getRoll_Num()));
			return new ResponseEntity<>(studentEntity, HttpStatus.CREATED);
		} catch(Exception e) {
			LOGGER.error("Exception occurred: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {
		Optional<Student> studentEntity = studentRepository.findById(id);
		if (studentEntity.isPresent()) {
			Student stud = studentEntity.get();
			stud.setName(student.getName());
			stud.setAddress(student.getAddress());
			stud.setEmail(student.getEmail());
			stud.setRoll_Num(student.getRoll_Num());
			LOGGER.info("Updated student id::"+id);
			return new ResponseEntity<>(studentRepository.save(stud), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteStudentByID/{id}")
	public ResponseEntity deleteStudentByID(@PathVariable long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			LOGGER.info("Student with id "+id+" has been deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}