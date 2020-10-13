package com.Student.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.Student.bean.Student;

public interface StudentRepositoryrepo extends MongoRepository<Student, Long> {

}
