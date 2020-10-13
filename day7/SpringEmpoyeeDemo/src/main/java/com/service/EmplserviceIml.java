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
	public List<Employee> getEmployee() {

		return empDao.getEmployees();
	}

	
	@Override
	public List<Employee> getEmplyeeDetailsById(int id) {
		// TODO Auto-generated method stub
		return empDao.getEmplyeeDetailsId(id);
	}

	@Override
	public String createEmployee(Employee employee) {
		return empDao.createEmployee(employee);
		
	}

	@Override
	public String updateEmployee(int id, String email_address) {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(id,email_address);
	}

	@Override
	public String deleteEmployeebyId(int id) {
		// TODO Auto-generated method stub
		return empDao.deleteEmployeebyId(id);
	}
	
}
