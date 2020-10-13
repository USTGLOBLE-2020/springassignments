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
import com.example.demo.model.StudentMon;
import com.example.demo.model.repository.StudentMonRepository;

@RestController
@RequestMapping("/api")
public class StudentMonController {

	@Autowired
	private StudentMonRepository repository;
	
	private static final Logger LOGGER = LogManager.getLogger(StudentMonController.class);
	
	/*
	  Creating and saving the students
	  */
	@PostMapping("/addStudents")
	public ResponseEntity<StudentMon> createStudent(@RequestBody StudentMon student)
	{
		try {
			StudentMon stud = repository.save(
					new StudentMon(student.getId(),student.getName(),student.getStudentAddress(), student.getEmail(),
							student.getMobileNumber()));
			LOGGER.info("Inserted data into Student Table");
							
			return new ResponseEntity<>(stud, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Listing
	 */	
		@GetMapping("/listAll")
		public ResponseEntity<List<StudentMon>> getAllStudents() {
			List<StudentMon> studModelList = repository.findAll();
			if(studModelList.isEmpty())
			{
				LOGGER.info("Employee list is empty");
			}
			return new ResponseEntity<>(studModelList, HttpStatus.OK);
		}
		
				
		/* View selected row using id */
		
		@GetMapping("/getStudentByID/{id}")
		public ResponseEntity<StudentMon> getStudentByID(@PathVariable Integer id) throws Exception {
			StudentMon studModel = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
			return ResponseEntity.ok().body(studModel);
		}
		
		/* update */
		@PutMapping("/updateStudent/{id}")
		public ResponseEntity<StudentMon> updateStudent(@PathVariable Integer id, @RequestBody StudentMon studentModel) {
			Optional<StudentMon> studModel = repository.findById(id);
			if (studModel.isPresent()) {
				StudentMon student = studModel.get();
				student.setId(studentModel.getId());
				student.setName(studentModel.getName());
				student.setStudentAddress(studentModel.getStudentAddress());
				student.setEmail(studentModel.getEmail());
				student.setMobileNumber(studentModel.getMobileNumber());
				LOGGER.info("Updated employee details of id "+id);
				return new ResponseEntity<>(repository.save(studentModel), HttpStatus.OK);
			} else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		/* Delete by ID */
		@DeleteMapping("/deleteStudentByID/{id}")
		public ResponseEntity deleteStudentByID(@PathVariable Integer id) {
			Optional<StudentMon> studentID = repository.findById(id);
			if(studentID.isPresent()) {
				repository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
