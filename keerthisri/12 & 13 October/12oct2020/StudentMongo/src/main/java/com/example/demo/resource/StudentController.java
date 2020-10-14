package com.example.demo.resource;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.model.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);
	
	/*
	  Creating and saving the students
	  */
	@PostMapping("/saveStudent")
	public ResponseEntity<StudentMon> saveStudent(@RequestBody Student student)
	{
		try {
			Student stud = repository.save(
					new Student(student.getId(),student.getStudName(),student.getStudAddress(), student.getEmail(),
							student.getMobileNumber()));
			LOGGER.info("Saved Student data");	
			return new ResponseEntity<>(stud, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Listing
	 */	
		@GetMapping("/listStudents")
		public ResponseEntity<List<Student>> getAllStudents() {
			List<Student> studentsList = repository.findAll();
			if(studentsList.isEmpty())
			{
				LOGGER.info("Employee list is empty");
			}
			return new ResponseEntity<>(studentsList, HttpStatus.OK);
		}
		
				
		/* View selected row using id */
		
		@GetMapping("/getStudentByID/{id}")
		public ResponseEntity<Student> getStudentByID(@PathVariable Integer id) throws Exception {
			Student student = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
			return ResponseEntity.ok().body(student);
		}
		
		/* update */
		@PutMapping("/updateStudent/{id}")
		public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
			Optional<StudentMon> studentList = repository.findById(id);
			if (studentList.isPresent()) {
				StudentMon student = studentList.get();
				student.setId(student.getId());
				student.setName(student.getName());
				student.setStudentAddress(student.getStudentAddress());
				student.setEmail(student.getEmail());
				student.setMobileNumber(student.getMobileNumber());
				LOGGER.info("Updated employee details of id "+id);
				return new ResponseEntity<>(repository.save(student), HttpStatus.OK);
			} else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		/* Delete by ID */
		@DeleteMapping("/deleteStudentByID/{id}")
		public ResponseEntity deleteStudentByID(@PathVariable Integer id) {
			Optional<StudentMon> student = repository.findById(id);
			if(student.isPresent()) {
				repository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
