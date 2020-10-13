package com.controller;


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

import com.bean.Student;
import com.exception.ResourceNotFoundException;
import com.repository.StudentRepository;



@RestController
@RequestMapping("/Student")
public class Controller {
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);

	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/insert")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			LOGGER.info("Inserted data into Student Table");
			Student stud= studentRepository.save(
					new Student(student.getRollno(),
							student.getName(),
							student.getEmail(),
							student.getPhone()));
			return new ResponseEntity<>(stud, HttpStatus.CREATED);
			
		} catch(Exception e) {
			LOGGER.error("Exception occurred: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> studList = studentRepository.findAll();
		LOGGER.info("Student details ::"+studList);
		return new ResponseEntity<>(studList, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewStudentByRollno/{rollno}")
	public ResponseEntity<Student> getStudentByID(@PathVariable long rollno
) throws Exception {
		Student stud = studentRepository.findById(rollno)
		.orElseThrow(() -> new ResourceNotFoundException("Student not found for this rollno :: " + rollno));
		return ResponseEntity.ok().body(stud);
	}

	@PutMapping("/updateStudentByRollno/{rollno}")
	public ResponseEntity<Student> updateStudent(@PathVariable long rollno, @RequestBody Student student) {
		Optional<Student> stud = studentRepository.findById(rollno);
		if (stud.isPresent()) {
			Student student1 = stud.get();
			student1.setRollno(student.getRollno());
			student1.setName(student.getName());
			student1.setEmail(student.getEmail());
			student1.setPhone(student.getPhone());

			LOGGER.info("Updated student details of rollno"+rollno);
			return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/deleteStudentByRollno/{rollno}")
	public ResponseEntity deleteStudentByID(@PathVariable long rollno) {
		Optional<Student> studentID = studentRepository
				.findById(rollno);
		if(studentID.isPresent()) {
			studentRepository.deleteById(rollno);
			LOGGER.info("Student with rollno"+ " "+rollno+" has been deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
