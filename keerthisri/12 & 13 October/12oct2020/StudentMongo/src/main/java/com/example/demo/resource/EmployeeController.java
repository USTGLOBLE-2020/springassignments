package com.example.demo.resource;

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
import com.example.demo.model.Employee;
import com.example.demo.model.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepository;
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
	
	/*
	  Creating and saving the Employee
	  */
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		try {
			Employee emp = empRepository.save(
					new Employee(employee.getId(),employee.getName(),employee.getEmpAddress(), employee.getEmail(),
							employee.getSalary()));
			LOGGER.info("Employee data saved");
							
			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Listing
	 */	
		@GetMapping("/listEmployees")
		public ResponseEntity<List<Employee>> getAllEmployees() {
			List<Employee> empList = empRepository.findAll();
			if(list.isEmpty())
			{
				LOGGER.info("Employee list is empty");
			}
			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
		
				
		/* View selected row using id */
		
		@GetMapping("/getEmployeeByID/{id}")
		public ResponseEntity<EmployeeMon> getEmployeeByID(@PathVariable Integer id) throws Exception {
			Employee employee = empRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found :: " + id));
			return ResponseEntity.ok().body(employee);
		}
		
		/* update */
		@PutMapping("/updateEmployee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
			Optional<EmployeeMon> empModel = empRepository.findById(id);
			if (empModel.isPresent()) {
				EmployeeMon emp = empModel.get();
				emp.setId(employee.getId());
				emp.setName(employee.getName());
				emp.setAddress(employee.getAddress());
				emp.setEmail(employee.getEmail());
				emp.setSalary(employee.getSalary());
				LOGGER.info("Updated employee details "+id);
				return new ResponseEntity<>(repository.save(emp), HttpStatus.OK);
			} else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		/* Delete by ID */
		@DeleteMapping("/deleteByID/{id}")
		public ResponseEntity deleteByID(@PathVariable Integer id) {
			Optional<Employee> emp = repository.findById(id);
			if(emp.isPresent()) {
				repository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
