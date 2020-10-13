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
import com.example.demo.model.EmployeeMon;
import com.example.demo.model.repository.EmployeeMonRepository;

@RestController
@RequestMapping("/api")
public class EmployeeMonController {

	@Autowired
	private EmployeeMonRepository repository;
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeMonController.class);

	/*
	  Creating and saving the Employee
	  */
	@PostMapping("/addEmployee")
	public ResponseEntity<EmployeeMon> createEmployee(@RequestBody EmployeeMon employee)
	{
		try {
			EmployeeMon stud = repository.save(
					new EmployeeMon(employee.getId(),employee.getName(),employee.getAddress(), employee.getEmail(),
							employee.getSalary()));
			LOGGER.info("Inserted data into  Table");
			return new ResponseEntity<>(stud, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	 * Listing
	 */	
		@GetMapping("/listAll")
		public ResponseEntity<List<EmployeeMon>> getAllEmployee() {
			List<EmployeeMon> list = repository.findAll();
			if(list.isEmpty())
			{
				LOGGER.info(" list is empty");
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		
				
		/* View selected row using id */
		
		@GetMapping("/getEmployeeByID/{id}")
		public ResponseEntity<EmployeeMon> getEmployeeByID(@PathVariable Integer id) throws Exception {
			EmployeeMon model = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
			return ResponseEntity.ok().body(model);
		}
		
		/* update */
		@PutMapping("/updateEmployee/{id}")
		public ResponseEntity<EmployeeMon> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeMon model) {
			Optional<EmployeeMon> empModel = repository.findById(id);
			if (empModel.isPresent()) {
				EmployeeMon emp = empModel.get();
				emp.setId(model.getId());
				emp.setName(model.getName());
				emp.setAddress(model.getAddress());
				emp.setEmail(model.getEmail());
				emp.setSalary(model.getSalary());
				LOGGER.info("Updated  details of id "+id);

				return new ResponseEntity<>(repository.save(model), HttpStatus.OK);
			} else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		/* Delete by ID */
		@DeleteMapping("/deleteByID/{id}")
		public ResponseEntity deleteByID(@PathVariable Integer id) {
			Optional<EmployeeMon> empId = repository.findById(id);
			if(empId.isPresent()) {
				repository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
