package com.repository.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.student.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	List<Student> findAll();
}
