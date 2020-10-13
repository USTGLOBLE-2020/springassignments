package com.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bean.Employee;


@EnableMongoRepositories
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
