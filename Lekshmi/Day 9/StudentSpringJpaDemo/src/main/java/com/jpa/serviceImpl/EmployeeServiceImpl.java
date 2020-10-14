package com.jpa.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.jpa.model.Employee;
import com.jpa.repository.EmpoyeeRepository;
import com.jpa.service.EmployeeService;

/**
 * @author U65617
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	private final EmpoyeeRepository employeeRepository;

	public EmployeeServiceImpl(EmpoyeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	
	@Override
	public Employee save(Employee employeeModel) {
		return employeeRepository.save(employeeModel);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		employeeRepository.deleteById(id);
	}


}
