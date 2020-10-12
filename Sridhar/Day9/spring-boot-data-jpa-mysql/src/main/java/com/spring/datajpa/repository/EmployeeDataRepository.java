package com.spring.datajpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.datajpa.model.EmployeeData;

public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Long> {
	List<EmployeeData> findByEmpName(String empName);
}
