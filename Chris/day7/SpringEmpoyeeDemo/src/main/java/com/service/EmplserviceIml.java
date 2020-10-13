package com.service;

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
	public List<Employee> getAllEmployee() {

		return empDao.getAllEmployee();
	}
	@Override
	public List<Employee> getEmployeeById(int id) {

		return empDao.getEmployeesById(id);
	}
	@Override
	public String createEmployeeDetails(Employee employee){
		return empDao.createEmployeeDetails(employee);
	}
	@Override
	public String updateEmployeeById(int id,String first_name,String last_name,String email_address){
		 return empDao.updateEmployeeById(id,first_name,last_name.email_address);
	}
	@Override
	public String deleteByEmployeeId(int id){
		 return empDao.deleteByEmployeeId(id);
	}
}
