package com.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.datajpa.exception.RecordNotFoundException;
import com.spring.datajpa.model.EmployeeData;
import com.spring.datajpa.repository.EmployeeDataRepository;

/**
 * @author sridhar rayana
 * This controller used to Employee CRUD operations
 */
@RestController
@Validated
@RequestMapping("/api")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeDataRepository employeeDataRepository;

	/**
	 * @param empname
	 * @return List<EmployeeData> empdata
	 */
	@GetMapping("/allemployees")
	public ResponseEntity<List<EmployeeData>> getAllEmpdata(@RequestParam(required = false) String empname) {
		List<EmployeeData> empdata = new ArrayList<EmployeeData>();
		if (empname == null)
			employeeDataRepository.findAll().forEach(empdata::add);
		else
			employeeDataRepository.findByEmpName(empname).forEach(empdata::add);
		if (empdata.isEmpty()) {
			LOGGER.error("Error level log message from get call getAllEmpdata()");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		LOGGER.info("Employee details getting");
		return new ResponseEntity<>(empdata, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return EmployeeData empdata
	 */
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeData> getEmployeeById(@PathVariable("id") long id) {
		Optional<EmployeeData> empdata = employeeDataRepository.findById(id);
		if (empdata.isPresent()) {
			LOGGER.info("Employee details getting based on empid");
			return new ResponseEntity<>(empdata.get(), HttpStatus.OK);
		} else {
			LOGGER.error("Error level log message from get call getEmployeeById()");
			throw new RecordNotFoundException("Record not found");
		}
	}

	/**
	 * @param employee
	 * @return EmployeeData empdata
	 */
	@PostMapping("/createEmp")
	public ResponseEntity<EmployeeData> createEmployee(@Valid @RequestBody EmployeeData employee) {
		try {
			EmployeeData empdata = employeeDataRepository.save(new EmployeeData(employee.getId(), employee.getEmpName(),
					employee.getEmpSal(), employee.getAddress(), employee.getEmail(), employee.getBirthDay()));
			LOGGER.info("Employee created");
			return new ResponseEntity<>(empdata, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error("Error level log message from create call createEmployee()");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param id
	 * @param employee
	 * @return EmployeeData empData1 
	 */
	@PutMapping("/upadateEmployee/{id}")
	public ResponseEntity<EmployeeData> updateEmployee(@PathVariable("id") long id,
			@RequestBody EmployeeData employee) {
		Optional<EmployeeData> empdata = employeeDataRepository.findById(id);
		if (empdata.isPresent()) {
			EmployeeData empData1 = empdata.get();
			empData1.setEmpName(employee.getEmpName());
			empData1.setEmpSal(employee.getEmpSal());
			empData1.setAddress(employee.getAddress());
			return new ResponseEntity<>(employeeDataRepository.save(empData1), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param id
	 * @return HttpStatus
	 */
	@DeleteMapping("/deleteEmployeeByid/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
		try {
			employeeDataRepository.deleteById(id);
			LOGGER.info("Employee Record deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			LOGGER.info("No Employee Record found to deleted");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @return HttpStatus
	 */
	@DeleteMapping("/deleteAllemployees")
	public ResponseEntity<HttpStatus> deleteAllEmployees() {
		try {
			employeeDataRepository.deleteAll();

			LOGGER.info("All Employee records deleted");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			LOGGER.error("Error level log message from Post call deleteAllEmployees()");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
