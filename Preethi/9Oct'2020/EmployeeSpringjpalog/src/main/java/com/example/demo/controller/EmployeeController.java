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
import com.example.demo.model.EmployeeBean;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	//saving employee details
	@PostMapping("/add")
	public ResponseEntity<EmployeeBean> createStudent(@RequestBody EmployeeBean employeebean) {
		try {
			LOGGER.info("Added Employee data");
			EmployeeBean employee = employeeRepository.save(
					new EmployeeBean(employeebean.getEmployeeName(),
							employeebean.getEmployeeemailID(),
							employeebean.getEmployeeAddress(),
							employeebean.getEmployeesalary()));
							
			return new ResponseEntity<>(employee, HttpStatus.CREATED);
		} catch(Exception e) {
			LOGGER.error("Exception occurred: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//listing 
	@GetMapping("/listAll")
	public ResponseEntity<List<EmployeeBean>> listAll() {
		List<EmployeeBean> employeeList = employeeRepository.findAll();
		LOGGER.info("List of Employee details ::"+employeeList);
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	//view
	@GetMapping("/getById/{id}")
	public ResponseEntity<EmployeeBean> getById(@PathVariable long id) throws Exception {
		EmployeeBean employeebean = employeeRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(employeebean);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeBean> update(@PathVariable long id, @RequestBody EmployeeBean employeebean) {
		Optional<EmployeeBean> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			EmployeeBean emp = employee.get();
			emp.setEmployeeName(employeebean.getEmployeeName());
			emp.setEmployeeemailID(employeebean.getEmployeeemailID());
			emp.setEmployeeAddress(employeebean.getEmployeeAddress());
			emp.setEmployeesalary(employeebean.getEmployeesalary());

			LOGGER.info("Updated  details of id "+id);
			return new ResponseEntity<>(employeeRepository.save(employeebean), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable long id) {
		Optional<EmployeeBean> employeeID = employeeRepository.findById(id);
		if(employeeID.isPresent()) {
			employeeRepository.deleteById(id);
			LOGGER.info("Employee with id "+id+" has been deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
