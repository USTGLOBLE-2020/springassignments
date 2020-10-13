package com.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Student.bean.Student;
import com.Student.service.StudentService;



@RestController
@RequestMapping(value=("/api"))
public class Controller {
	
	@Autowired
	private StudentService studentservice;
	
	
	@GetMapping("/student-details")
	public List<Student> getAllStudentDetails()
	{
		return studentservice.getAllStudentDetails();
		
	}
	@GetMapping("student-byid/{id}")
	public List<Student> getStudentDetailsById(@PathVariable int id){
	return studentservice.getStudentDetailsById(id);
	}
	
	@PostMapping("/student-create")
	public String createStudent(@RequestBody Student student){
		
		return studentservice.createStudent(student);
	}
	
	/**
	 * @param id
	 * @param
	 * http://localhost:8080/api/student-update?id=3&email_address=test@yahoo.com
	 * @return
	 */
	@PutMapping("/student-update")
	public String updateStudentDetails(@RequestParam int id,@RequestParam String email_address){
		
		return studentservice.updateStudent(id,email_address);
		
	}
	@DeleteMapping("/student-delete/{id}")
	public String deleteEmployeebyId(@PathVariable int id){
		
		return studentservice.deleteEmployeebyId(id);
	

	}

}
