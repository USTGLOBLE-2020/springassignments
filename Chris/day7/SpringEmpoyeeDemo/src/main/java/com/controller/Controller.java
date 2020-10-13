package com.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bean.Employee;
import com.dao.EmpDao;
import com.service.EmpSerivce;

@RestController
@RequestMapping(value=("/employee"))
public class Controller {
	
	// inject dependecy service
	@Autowired
	private  EmpSerivce empSerivce;
	
	@Autowired
	private  EmpDao empDao;
	
	/**
	 * @return         alt+shift+j for java doc
	 */
	@GetMapping("/viewAll")
	public List<Employee> getAllEmployee(){
	
		return empSerivce.getAllEmployee();	
	
	}
	/**
	 * @return         
	 */
	@GetMapping("/viewById/{id}")
	public List<Employee> getEmployeeById(int id){
	
		return empSerivce.getEmployeeById(id);	
	
	}
	/**
	 * @return        
	 */
	@PostMapping("add/")
	public String createEmployeeDetails(@RequestBody Employee employee){
		
		return empSerivce.createEmployeeDetails(employee);
	}
		
	
	
	/**
	 * @param first_name
	 * @param last_name
	 * @param email_address
	 * @return
	 */
	@PutMapping("update/{id}")
	public String updateEmployeeDetails(@PathVariable int id,@RequestParam String first_name,@RequestParam String last_name,@RequestParam String email_address){
		
		return empSerivce.updateEmployeeById(id,first_name,last_name,email_address);
		
	}
	@DeleteMapping("delete/{id}")
	public String deleteEmployeebyId(@PathVariable int id){
		
		return empSerivce.deleteByEmployeeId(id);
	

	}


}
