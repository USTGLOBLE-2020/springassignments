package com.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customer.entity.Customer;

public interface CustomerRepository extends  MongoRepository<Customer,String>{


}
