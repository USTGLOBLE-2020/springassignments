package com.controller;

import java.sql.SQLException;
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

/**
 * @author U65617
 *
 */
@RestController
@RequestMapping(value = ("/api"))
public class Controller {

	// inject dependecy service
	@Autowired
	private EmpSerivce empSerivce;

	/**
	 * @return alt+shift+j for java doc
	 */
	@GetMapping("employee-list")
	public List<Employee> allEmployee() {

		return empSerivce.getEmployee();

	}


	
	
	// api for create new employee
	@PostMapping("employee-create")
	public String createEmployeeDetails(@RequestBody Employee employee) throws SQLException {

		return empSerivce.createEmployeeDetails(employee);
	}

	// add api for update employe details

	@PutMapping("employee-udpate")
	public String updateEmployeedetails(@RequestParam int id,@RequestParam String email_address) throws SQLException{

		return empSerivce.updateEmployeedetails(id,email_address);
	}

	// add api for delete

	@DeleteMapping("employee-delete/{id}")
	public String deleteById(@PathVariable int id) throws SQLException{
		
		return empSerivce.deleteById(id);
	

	}

	

}
