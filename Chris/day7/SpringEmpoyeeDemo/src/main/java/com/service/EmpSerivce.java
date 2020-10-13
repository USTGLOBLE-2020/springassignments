package com.service;

import java.util.List;

import com.bean.Employee;

public interface EmpSerivce {
	
	// view the list of records get salary
	public List<Employee> getAllEmployee();
	public List<Employee> getEmployeeById(int id);
	public String createEmployeeDetails(Employee employee);
	public String updateEmployeeById(int id,String first_name,String last_name,String email_address);
	public String deleteByEmployeeId(int id);
}
