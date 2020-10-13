package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import model.Student;
@EnableMongoRepositories
public interface StudentRepository extends MongoRepository<Student, Long>{

}

