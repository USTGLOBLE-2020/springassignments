package com.example.demo.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentMon;


@Repository
public interface StudentMonRepository extends MongoRepository <StudentMon, Integer> {


	
}
