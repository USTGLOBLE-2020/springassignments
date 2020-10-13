package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmpDao {
	
	//list the all records
	public List<Employee> getEmployees();
	public List<Employee> getEmployeeByID(int id);
	public String createEmployee(Employee employee);
	public String updateEmployee(int id, String email_address);
	public String deleteEmployeebyId(int id);
}
