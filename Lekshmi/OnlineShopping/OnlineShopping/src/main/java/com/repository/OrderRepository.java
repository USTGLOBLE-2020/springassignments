package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Order;

public interface OrderRepository extends MongoRepository<Order, Long>{

}
