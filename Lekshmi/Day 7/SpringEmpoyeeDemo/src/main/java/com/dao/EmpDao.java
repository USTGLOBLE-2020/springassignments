package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.bean.Employee;

public interface EmpDao {
	
	//list the all records
	public List<Employee> getEmployees();

	public void update();

	public String createEmployeeDetails(Employee employee) throws SQLException;

	public String updateEmployeedetails(int id, String email_address) throws SQLException;

	public String deleteById(int id) throws SQLException;


	//public void save();

}
