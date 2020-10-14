package com.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import entity.Answer;
import entity.Question;
import repository.AnswerRepository;
import repository.QuestionRepository;


@SpringBootApplication
public class StudentHibernateOneToManyMappingApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(StudentHibernateOneToManyMappingApplication.class, args);
	}
	
	 @Autowired private QuestionRepository questionRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		Question question=new Question("what is java"); 
		Answer answer1 =new Answer("java is a platform","james");
		Answer answer2=new Answer("java is a programming language","mary");
		
		question.getAnswers().add(answer1);
		question.getAnswers().add(answer2);

		
		this.questionRepository.save(question);
		
	}
}
