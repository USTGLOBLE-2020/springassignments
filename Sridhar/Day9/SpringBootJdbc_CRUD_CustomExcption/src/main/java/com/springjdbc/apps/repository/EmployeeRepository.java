package com.springjdbc.apps.repository;

import java.util.List;

import com.springjdbc.apps.model.Employee;

public interface EmployeeRepository {
    int save(Employee emp);
    int update(Employee student);
    int deleteById(Long id);
    List<Employee> findAll();
   
}
