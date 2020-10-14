package com.main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entity.Student;
import entity.StudentGender;
import entity.StudentProfile;
import repository.StudentRepository;

@SpringBootApplication
public class StudentHibernateOneToOneMappingApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(StudentHibernateOneToOneMappingApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// student  object
		Student student=new Student();
		student.setName("chris");
		student.setEmail("chris@gmail.com");
		student.setPhone("8921385157");
		
		StudentProfile studentProfile=new StudentProfile();
		studentProfile.setBirthOfDate(LocalDate.of(1994,12, 22));
		studentProfile.setStudentGender(StudentGender.FEMALE);
		
		student.setStudentProfile(studentProfile);
		studentProfile.setStudent(student);
		
		studentRepository.save(student);
	}
}
