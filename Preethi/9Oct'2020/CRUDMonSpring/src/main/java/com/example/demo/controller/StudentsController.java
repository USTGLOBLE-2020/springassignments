package com.example.demo.controller;


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
import com.example.demo.model.StudentsBean;
import com.example.demo.repository.StudentssRepository;

@RestController
@RequestMapping("/StudentCrud")
public class StudentsController {
	private static final Logger LOGGER = LogManager.getLogger(StudentsController.class);

	@Autowired
	StudentssRepository studentRepository;
	
	//adding
	@PostMapping("/addStudentdata")
	public ResponseEntity<StudentsBean> createStudent(@RequestBody StudentsBean studentModel) {
		try {
			LOGGER.info("Added Student data");
			StudentsBean studModel = studentRepository.save(
					new StudentsBean(studentModel.getStudentName(), studentModel.getStudentAddress(), studentModel.getEmailID(),
							studentModel.getRollNumber()));
							
			return new ResponseEntity<>(studModel, HttpStatus.CREATED);
		} catch(Exception e) {
			LOGGER.error("Exception occurred: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//listing
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentsBean>> getAllStudents() {
		List<StudentsBean> studModelList = studentRepository.findAll();
		LOGGER.info("List of Student details ::"+studModelList);
		return new ResponseEntity<>(studModelList, HttpStatus.OK);
	}
	
	//view
	@GetMapping("/getStudentByID/{id}")
	public ResponseEntity<StudentsBean> getStudentByID(@PathVariable long id) throws Exception {
		StudentsBean studModel = studentRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
		return ResponseEntity.ok().body(studModel);
	}
	
	//update
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<StudentsBean> updateStudent(@PathVariable long id, @RequestBody StudentsBean studentModel) {
		Optional<StudentsBean> studModel = studentRepository.findById(id);
		if (studModel.isPresent()) {
			StudentsBean student = studModel.get();
			student.setStudentName(studentModel.getStudentName());
			student.setStudentAddress(studentModel.getStudentAddress());
			student.setEmailID(studentModel.getEmailID());
			student.setRollNumber(studentModel.getRollNumber());

			LOGGER.info("Updated student details of id "+id);
			return new ResponseEntity<>(studentRepository.save(studentModel), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete
	@DeleteMapping("/deleteStudentByID/{id}")
	public ResponseEntity deleteStudentByID(@PathVariable long id) {
		Optional<StudentsBean> studentID = studentRepository.findById(id);
		if(studentID.isPresent()) {
			studentRepository.deleteById(id);
			LOGGER.info("Student with id "+id+" has been deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
