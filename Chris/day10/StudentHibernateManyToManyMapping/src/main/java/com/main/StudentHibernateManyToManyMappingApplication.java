package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entity.Answer;
import entity.Question;
import repository.QuestionRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class StudentHibernateManyToManyMappingApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(StudentHibernateManyToManyMappingApplication.class, args);
	}
	 @Autowired private QuestionRepository questionRepository;
		
		
	@Override
	public void run(String... args) throws Exception 
	{
		Question question=new Question("what is java"); 
		Question question1=new Question("what is servlet"); 
		Answer answer1 =new Answer("java is a platform","james");
		Answer answer2=new Answer("servlet is a technology","mary");
		
		question.getAnswer().add(answer1);
		question.getAnswer().add(answer2);

		answer1.getQuestion().add(question);
		answer2.getQuestion().add(question);
		
		answer1.getQuestion().add(question1);
		question1.getAnswer().add(answer1);
		
		
		this.questionRepository.save(question);
		this.questionRepository.save(question1);
		
	}
}
