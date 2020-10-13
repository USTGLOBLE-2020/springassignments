package com.spring.datajpa.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.spring.datajpa.model.EmployeeData;

public interface EmployeeDataRepository extends MongoRepository<EmployeeData, Long> {
	List<EmployeeData> findByEmpName(String empName);
}
