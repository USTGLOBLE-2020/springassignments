package com.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.datajpa.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long>{

}
