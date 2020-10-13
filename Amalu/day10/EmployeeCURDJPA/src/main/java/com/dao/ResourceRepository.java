package com.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.bean.Employee;


@EnableMongoRepositories
public interface ResourceRepository extends MongoRepository<Employee, Integer> {

}
