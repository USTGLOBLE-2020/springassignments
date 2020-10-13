package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Employee;

public interface EmpSerivce {
	
	// view the list of records get salary
	public List<Employee> getEmployee();

	public void update();

	

	public String createEmployeeDetails(Employee employee) throws SQLException;

	public String updateEmployeedetails(int id, String email_address) throws SQLException;

	public String deleteById(int id) throws SQLException;

	//public void save();

}
