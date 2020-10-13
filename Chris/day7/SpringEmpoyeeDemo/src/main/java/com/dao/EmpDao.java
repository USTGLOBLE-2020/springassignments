package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmpDao {
	
	//list the all records
	public List<Employee> getAllEmployee();
	public List<Employee> getEmployeesById(int id);
	public String createEmployeeDetails(Employee employee);
	public String updateEmployeeById(int id,String first_name,String last_name,String email_address);
	public String deleteByEmployeeId(int id);
	

}
