package com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.entity.Customerentity;
import com.globalexception.ResourceNotFoundException;
import com.repository.repositoryimplementation;

@Service
public class serviceimplementation implements Customerservice{

	@Autowired
	private repositoryimplementation repository;
	
	@Override
	public Customerentity customercreate(Customerentity centity) {
		centity.setCreateddate(LocalDate.now());
		Customerentity customerresponse= repository.save(centity);
		return customerresponse;
		
	}
 @Override 
 public List<Customerentity> getAllCustomerDetails() 
 { 
	 List<Customerentity> customerlist=repository.findAll();
	 return customerlist; 
	 }
	 
	  @Override
	   public Optional<Customerentity> getCustomerDetailsById(String id) { 
	  	return repository.findById(id); 
	  	}
	  
	 @Override 
	 public Customerentity updateCustomerDetailsById(Customerentity customerentity)throws ResourceNotFoundException ,IllegalArgumentException
	 { 
	Customerentity customerresponse =repository.findById(customerentity.getId()) .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id"+customerentity.getId()));
	customerresponse.setEmail(customerentity.getEmail());
	customerresponse.setName(customerentity.getName());
	customerresponse.setPassword(customerentity.getPassword());
	return repository.save(customerresponse);

	  }
	  
	  @Override 
	  public void deleteCustomerDetailsById(String customerid) throws  ResourceNotFoundException ,IllegalArgumentException
	  { 
	Customerentity customer =repository.findById(customerid) .orElseThrow(() -> new  ResourceNotFoundException("Customer not found for this id :: " +	  customerid)); 
	repository.delete(customer); 
	
	}
	  
	  @Override 
	  public void deleteAllCustomerDetails() 
	  {
		  repository.deleteAll();
	  
	  }
	 
}
