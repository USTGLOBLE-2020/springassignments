package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.entity.Productentity;

public interface Productrepositoryimplementation extends  MongoRepository<Productentity,String>
{

}
