package com.springboot.association.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.association.entity.Test;


@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

}
