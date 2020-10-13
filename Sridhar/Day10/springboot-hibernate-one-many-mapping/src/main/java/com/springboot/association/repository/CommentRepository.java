package com.springboot.association.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.association.entity.Course;

@Repository
public interface CommentRepository extends JpaRepository<Course, Long>{

}
