package com.spring.datajpa.controller;

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

import com.spring.datajpa.exception.ResourceNotFoundException;
import com.spring.datajpa.model.StudentModel;
import com.spring.datajpa.repository.StudentRepository;

@RestController
@RequestMapping("/StudentAPI")
public class StudentController {
	private static final Logger LOGGER = LogManager.getLogger(StudentController.class);

	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/insertStudentdata")
	public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel studentModel) {
		try {
			LOGGER.info("Inserted data into Student Table");
			StudentModel studModel = studentRepository.save(
					new StudentModel(studentModel.getStudentName(), 
							studentModel.getStudentAddress(), 
							studentModel.getEmailID(),
							studentModel.getRollNumber(),
							studentModel.getDob()));
			return new ResponseEntity<>(studModel, HttpStatus.CREATED);
		} catch(Exception e) {
			LOGGER.error("Exception occurred: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentModel>> getAllStudents() {
		List<StudentModel> studModelList = studentRepository.findAll();
		LOGGER.info("Student details ::"+studModelList);
		return new ResponseEntity<>(studModelList, HttpStatus.OK);
	}
	
	
	@GetMapping("/getStudentByID/{id}")
	public ResponseEntity<StudentModel> getStudentByID(@PathVariable long id) throws Exception {
		StudentModel studModel = studentRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
		return ResponseEntity.ok().body(studModel);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<StudentModel> updateStudent(@PathVariable long id, @RequestBody StudentModel studentModel) {
		Optional<StudentModel> studModel = studentRepository.findById(id);
		if (studModel.isPresent()) {
			StudentModel student = studModel.get();
			student.setStudentName(studentModel.getStudentName());
			student.setStudentAddress(studentModel.getStudentAddress());
			student.setEmailID(studentModel.getEmailID());
			student.setRollNumber(studentModel.getRollNumber());
			student.setDob(studentModel.getDob());

			LOGGER.info("Updated student details of id "+id);
			return new ResponseEntity<>(studentRepository.save(studentModel), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/deleteStudentByID/{id}")
	public ResponseEntity deleteStudentByID(@PathVariable long id) {
		Optional<StudentModel> studentID = studentRepository.findById(id);
		if(studentID.isPresent()) {
			studentRepository.deleteById(id);
			LOGGER.info("Student with id "+id+" has been deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
