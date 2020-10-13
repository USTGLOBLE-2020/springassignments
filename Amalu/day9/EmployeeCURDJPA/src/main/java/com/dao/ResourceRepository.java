package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bean.Employee;


@EnableJpaRepositories
public interface ResourceRepository extends JpaRepository<Employee, Integer> {

}
