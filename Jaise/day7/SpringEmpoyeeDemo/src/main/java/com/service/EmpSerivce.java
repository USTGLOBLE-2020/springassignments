package com.service;

import java.util.List;

import com.bean.Employee;

public interface EmpSerivce {
	
	// view the list of records get salary
	public List<Employee> getEmployee();
	public List<Employee> getEmployeeByID(int id);
	public String createEmployee(Employee employee);
	public String updateEmployee(int id, String email_address);
	public String deleteEmployeebyId(int id);
}
