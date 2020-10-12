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
@RequestMapping(value=("/employee"))
public class Controller {
	
	// inject dependecy service
	@Autowired
	private  EmpSerivce empSerivce;
	
	/**
	 * @return         alt+shift+j for java doc
	 */
	@GetMapping("/getAllEmployees")
	public List<Employee> allEmployee(){
	
		return empSerivce.getEmployee();	
	
	}
	
	@GetMapping("getEmployeeByID/{id}")
	public List<Employee> getEmployeeByID(@PathVariable int id) {
		return empSerivce.getEmployeeByID(id);
	}

	@PostMapping("createEmployee")
	public String createEmployeeDetails(@RequestBody Employee employee){
		
		return empSerivce.createEmployee(employee);
	}
		
	
	@PutMapping("updateEmployee")
	public String updateEmployeeDetails(@RequestParam int id,@RequestParam String email_address){
		
		return empSerivce.updateEmployee(id,email_address);
		
	}
	@DeleteMapping("deleteEmployee/{id}")
	public String deleteEmployeebyId(@PathVariable int id){
		
		return empSerivce.deleteEmployeebyId(id);
	

	}
	
	
	
	
	
	

}
