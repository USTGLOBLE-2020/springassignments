package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.employee.repository.EmployeeRepository;

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

import com.employee.bean.Employee;




@RestController
@RequestMapping("/api")
public class EmployeeController {
private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/*
	 * @Autowired StudentService studentService;
	 */
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> empsList = employeeRepository.findAll();
		LOGGER.info("Student details ::"+empsList);
		return new ResponseEntity<>(empsList, HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeByID/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id) throws Exception {
		Employee employee = employeeRepository.findById(id)
		.orElseThrow(() -> new Exception("Student not found for this id :: " + id));
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		try {
			LOGGER.info("Student data saved");
			Employee empEntity = employeeRepository.save(
					new Employee(employee.getId(),employee.getName(), 
							employee.getAddress(), 
							employee.getEmail(),
							employee.getRoll_Num()));
			return new ResponseEntity<>(empEntity, HttpStatus.CREATED);
		} catch(Exception e) {
			LOGGER.error("Exception occurred: "+e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		Optional<Employee> empEntity = employeeRepository.findById(id);
		if (empEntity.isPresent()) {
			Employee emp = empEntity.get();
			emp.setName(employee.getName());
			emp.setAddress(employee.getAddress());
			emp.setEmail(employee.getEmail());
			emp.setRoll_Num(employee.getRoll_Num());
			LOGGER.info("Updated student id::"+id);
			return new ResponseEntity<>(employeeRepository.save(emp), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteEmployeeByID/{id}")
	public ResponseEntity deleteEmployeeByID(@PathVariable long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.deleteById(id);
			LOGGER.info("Employee "+id+" has been deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
