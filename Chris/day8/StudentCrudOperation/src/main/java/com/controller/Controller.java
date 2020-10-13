package com.controller;

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

import com.bean.Student;
import com.dao.StudentDao;
import com.service.StudentSerivce;


	@RestController
	@RequestMapping(value=("/student"))
	public class Controller {
		
		// inject dependecy service
		@Autowired
		private  StudentSerivce studentSerivce;
		
		@Autowired
		private  StudentDao studentDao;
		
		/**
		 * @return         alt+shift+j for java doc
		 */
		@GetMapping("/viewAll")
		public List<Student> getAllStudents(){
		
			return studentSerivce.getAllStudents();	
		
		}
		/**
		 * @return         
		 */
		@GetMapping("/viewById/{id}")
		public List<Student> getStudentById(int rollno){
		
			return studentSerivce.getStudentById(rollno);	
		
		}
		/**
		 * @return        
		 */
		@PostMapping("add/")
		public String createStudentDetails(@RequestBody Student student){
			
			return studentSerivce.createStudentDetails(student);
		}
			
		
		
		/**
		 * @param name
		 * @param email
		 * @param phone
		 * @return
		 */
		@PutMapping("update/{id}")
		public String updateStudentById(@PathVariable int rollno,@RequestParam String name,@RequestParam String email,@RequestParam String phone){
			
			return studentSerivce.updateStudentById(rollno,name,email,phone);
			
		}
		@DeleteMapping("delete/{id}")
		public String deleteByStudentId(@PathVariable int rollno){
			
			return studentSerivce.deleteByStudentId(rollno);
		

		}

}
