package com.jpa.service;


import java.util.List;
import java.util.Optional;

import com.jpa.model.Employee;

public interface EmployeeService {

	public Employee save(Employee employeeModel);

	public List<Employee> findAll();

	public Optional<Employee> findById(long id);

	public void deleteById(long id);


	

}
