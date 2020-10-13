package com.Student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.Student.Repository.StudentRepository;
import com.Student.bean.Student;
import com.Student.globalexception.MessageNotFoundException;
import com.Student.globalexception.ResourceNotFoundException;





@RestController
@RequestMapping(value = ("/api"))
public class Controller {

	@Autowired
	private StudentRepository studentrepository;
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);

	@GetMapping("/student-details")
	public ResponseEntity<List<Student>> getAllStudentDetails() {
		List<Student> studentlist = studentrepository.findAll();
		if (studentlist.isEmpty()) {
			LOGGER.info("Student list is empty");
			throw new MessageNotFoundException("Student list is empty");
		}
		LOGGER.info("Student details ::"+studentlist);
		return ResponseEntity.ok().body(studentlist);
	}

	@GetMapping("student-byid/{id}")
	public ResponseEntity<Student> getStudentDetailsById(@PathVariable Long id) throws ResourceNotFoundException {
		Optional<Student> student = studentrepository.findById(id);
		if (student.isEmpty()) {
			throw new ResourceNotFoundException("Student list is empty");
		}
			
			return ResponseEntity.ok().body(student.get());
			}
		
		

	

	@PostMapping("/student")
	public ResponseEntity<Student> createEmployee(@Valid @RequestBody Student student) {
		LOGGER.info("Inserted data into student Table");
		return ResponseEntity.ok().body(student);
	}

	@PutMapping("/student-update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
			@Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentrepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

		student.setEmailid(studentDetails.getEmailid());
		student.setId(studentDetails.getId());
		student.setName(studentDetails.getName());
		student.setPhonenumber(studentDetails.getPhonenumber());
		final Student updatedstudent = studentrepository.save(student);
		LOGGER.info("Student employee details of id "+studentId);
		return ResponseEntity.ok(updatedstudent);
	}
	 
	@DeleteMapping("/student/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
			throws ResourceNotFoundException {
		Student student = studentrepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));

		studentrepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		LOGGER.info("Student with id "+studentId+" has been deleted");
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	}
