package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmpDao;

@Service
public class EmplserviceIml implements EmpSerivce {

	@Autowired
	EmpDao empDao;

	@Override
	public List<Employee> getEmployee() {

		return empDao.getEmployees();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		 empDao.update();
	}

	@Override
	public String createEmployeeDetails(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return empDao.createEmployeeDetails(employee);
	}

	@Override
	public String updateEmployeedetails(int id, String email_address) throws SQLException {
		// TODO Auto-generated method stub
		return empDao.updateEmployeedetails(id,email_address);
	}

	@Override
	public String deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return empDao.deleteById(id);
	}
	
	
	


	/*
	 * @Override public void save() { // TODO Auto-generated method stub
	 * empDao.save(); }
	 */

}
