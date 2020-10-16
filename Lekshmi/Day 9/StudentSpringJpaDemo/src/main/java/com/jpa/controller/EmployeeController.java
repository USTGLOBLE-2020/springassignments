package com.jpa.controller;

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

import com.jpa.exception.ResourceNotFoundException;
import com.jpa.model.Employee;
import com.jpa.service.EmployeeService;

/**
 * @author U65617
 *
 */
/**
 * @author U65617
 *
 */
/**
 * @author U65617
 *
 */
/**
 * @author U65617
 *
 */
/**
 * @author U65617
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	
	@Autowired
	private EmployeeService employeeService;
	
	// create a new employee
	@PostMapping("/create")
	public ResponseEntity<Employee> createStudent(@RequestBody Employee employeeModel) {
		
		try {
			LOGGER.info("Inserted data into employee Table");
			Employee employee = employeeService.save(employeeModel);
					
			return new ResponseEntity<>(employee, HttpStatus.CREATED);
		} catch(Exception e) {
			LOGGER.error("Exception occurred: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//list of employee
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employeeList = employeeService.findAll();
		LOGGER.info("employee details ::"+employeeList);
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	//list employee by id
	@GetMapping("/getAllEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id) throws Exception {
		Employee employee = employeeService.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("employee not found for this id :: " + id));
		return ResponseEntity.ok().body(employee);
	}
	
	//update employee by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeModel) {
		Optional<Employee> empModel = employeeService.findById(id);
		if (empModel.isPresent()) {
			Employee student = empModel.get();
			student.setName(employeeModel.getName());
			student.setAddress(employeeModel.getAddress());
			student.setEmailID(employeeModel.getEmailID());
			student.setSalary(employeeModel.getSalary());
			student.setDOB(employeeModel.getDOB());

			LOGGER.info("Updated employee  "+id);
			return new ResponseEntity<>(employeeService.save(employeeModel), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//delete employee by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployeeByID(@PathVariable long id) {
		Optional<Employee> empId = employeeService.findById(id);
		if(empId.isPresent()) {
			employeeService.deleteById(id);
			LOGGER.info("Employee "+id+" successfully deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
