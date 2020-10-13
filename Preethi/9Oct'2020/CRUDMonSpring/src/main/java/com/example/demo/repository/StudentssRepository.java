package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StudentsBean;
@Repository
public interface StudentssRepository extends MongoRepository<StudentsBean, Long>{

	
}

