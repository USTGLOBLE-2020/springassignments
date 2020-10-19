package com.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.entity.Customerentity;



public interface repositoryimplementation extends  MongoRepository<Customerentity,String>
{

}
