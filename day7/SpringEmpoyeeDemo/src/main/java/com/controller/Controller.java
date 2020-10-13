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

import com.bean.Employee;
import com.service.EmpSerivce;


@RestController
@RequestMapping(value=("/api"))
public class Controller {
	
	// inject dependecy service
	@Autowired
	private  EmpSerivce empSerivce;
	
	
	@GetMapping("employee-list")
	public List<Employee> allEmployee(){
	
		return empSerivce.getEmployee();
	}
		
		
		@GetMapping("employee-bydid/{id}")
		public List<Employee> getEmplyeeDetailsById(@PathVariable int id){
		return empSerivce.getEmplyeeDetailsById(id);
	
	}
	
		
		@PostMapping("employee-create")
		public String createEmployeeDetails(@RequestBody Employee employee){
			
			return empSerivce.createEmployee(employee);
		}
			
		
	
		@PutMapping("employee-update")
		public String updateEmployeeDetails(@RequestParam int id,@RequestParam String email_address){
			
			return empSerivce.updateEmployee(id,email_address);
			
		}
		@DeleteMapping("employee-delete/{id}")
		public String deleteEmployeebyId(@PathVariable int id){
			
			return empSerivce.deleteEmployeebyId(id);
		
	
		}
	
}