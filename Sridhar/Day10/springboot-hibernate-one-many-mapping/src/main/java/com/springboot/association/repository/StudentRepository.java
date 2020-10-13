package com.springboot.association.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.association.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
