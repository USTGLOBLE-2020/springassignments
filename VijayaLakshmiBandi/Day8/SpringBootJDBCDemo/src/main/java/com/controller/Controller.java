package com.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.service.StudentService;

@RestController
@RequestMapping(value="/Students")
public class Controller {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/getAllStudents")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value="/getStudentByID/{id}",method=RequestMethod.GET)
	public List<Student> getStudentByID(@PathVariable int id) {
		return studentService.getStudentByID(id);
	}
	
	@RequestMapping(value="/insertStudent", method=RequestMethod.POST)
	public String createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@RequestMapping(value="/updateStudent",method=RequestMethod.PUT)
	public String updateStudent(@QueryParam("id") int id,@QueryParam("emailAddress") String email_address,@QueryParam("phoneNumber") String phoneNumber) {
		return studentService.updateStudent(id, email_address, phoneNumber);
	}
	
	@RequestMapping(value = "/deleteStudentByID/{id}",method=RequestMethod.DELETE)
	public String deleteStudentbyId(@PathVariable int id) {
		return studentService.deleteStudentbyId(id);
	}
	
	@RequestMapping(value = "/deleteStudents",method=RequestMethod.DELETE)
	public String deleteStudent() {
		return studentService.deleteStudents();
	}
	
}
