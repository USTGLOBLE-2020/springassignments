package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.Productentity;
import com.respository.Productrepositoryimplementation;



@Service
public class Productserviceimplementation implements Productservice{

	@Autowired
	private Productrepositoryimplementation repository;
	
	@Override
	public Productentity productcreate(Productentity pentity) {
		Productentity productresponse= repository.save(pentity);
		return productresponse;
	}

	@Override
	public Optional<Productentity> getProductDetailsById(String id) {

		 Optional<Productentity> productlist=repository.findById(id);
		 return productlist;
	}

	@Override
	public List<Productentity> getListOfproducts() {
		List<Productentity> productlist=repository.findAll();
		 return productlist; 
	}

}
