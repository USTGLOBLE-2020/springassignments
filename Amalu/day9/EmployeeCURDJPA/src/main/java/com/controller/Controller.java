package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
//import java.util.logging.Logger;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;

import com.dao.ResourceRepository;
import com.globalexception.MessageNotFoundException;
import com.globalexception.ResourceNotFoundException;




@RestController
@RequestMapping(value=("/api"))
public class Controller {
	
	
	@Autowired
	private  ResourceRepository emprepo;
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);
	
	
	/**
	 * @return
	 */
	@GetMapping("employee-list")
	public List<Employee> allEmployee(){
	
		List<Employee> emplist =emprepo.findAll();
		if(emplist.isEmpty())
		{
			LOGGER.info("Employee list is empty");
			throw new MessageNotFoundException("Employee list is empty");
		}
		else
		{
		
		LOGGER.info("Employee details ::"+emplist);
		}

		return emplist; 
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
		Employee employee = emprepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
		
	}
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		LOGGER.info("Inserted data into Employee Table");
		return emprepo.save(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = emprepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmail(employeeDetails.getEmail());
		employee.setAddress(employeeDetails.getAddress());
		employee.setDateofbirth(employeeDetails.getDateofbirth());
		employee.setName(employeeDetails.getName());
		employee.setId(employee.getId());
		final Employee updatedEmployee = emprepo.save(employee);
		LOGGER.info("Updated employee details of id "+employeeId);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
			throws ResourceNotFoundException {
		Employee employee = emprepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		emprepo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		LOGGER.info("Employee with id "+employeeId+" has been deleted");
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
		
		
	
	}
		
