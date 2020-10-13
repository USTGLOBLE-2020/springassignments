package com.springboot.association;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.association.entity.Course;
import com.springboot.association.entity.Student;
import com.springboot.association.repository.StudentRepository;

@SpringBootApplication
public class SpringbootHibernateOneManyMappingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneManyMappingApplication.class, args);
	}

	@Autowired
	private StudentRepository stuRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Student student = new Student("Sreedhar","sreedhar@gmail.com");
		Course course1 = new Course("java");
		Course course2 = new Course("spring");
		Course course3 = new Course("hibernate");
		
		student.getCourses().add(course1);
		student.getCourses().add(course2);
		student.getCourses().add(course3);
		
		this.stuRepository.save(student);
	}
}
