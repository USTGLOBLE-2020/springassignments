package com.Student.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.Student.bean.Student;



@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Long>
{
	
	
	}
