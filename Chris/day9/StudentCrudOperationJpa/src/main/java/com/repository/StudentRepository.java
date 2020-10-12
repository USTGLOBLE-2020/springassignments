package com.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Student;
public interface StudentRepository extends JpaRepository<Student, Long>{

}
