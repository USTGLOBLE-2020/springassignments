package com.customer.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.customer.entity.Customer;
import com.customer.exception.ResourceNotFoundException;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer customercreate(Customer centity) {
		centity.setCreateddate(LocalDate.now());
		Customer customerresponse= customerRepository.save(centity);
		return customerresponse;
		
	}
 @Override 
 public List<Customer> getAllCustomerDetails() 
 { 
	 List<Customer> customerlist=customerRepository.findAll();
	 return customerlist; 
	 }
	 
	  @Override
	   public Optional<Customer> getCustomerDetailsById(String id) { 
	  	return customerRepository.findById(id); 
	  	}
	  
	 @Override 
	 public Customer updateCustomerDetailsById(Customer customerentity)throws ResourceNotFoundException ,IllegalArgumentException
	 { 
	Customer customerresponse =customerRepository.findById(customerentity.getId()) .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id"+customerentity.getId()));
	customerresponse.setEmail(customerentity.getEmail());
	customerresponse.setName(customerentity.getName());
	customerresponse.setPassword(customerentity.getPassword());
	return customerRepository.save(customerresponse);

	  }
	  
	  @Override 
	  public void deleteCustomerDetailsById(String customerid) throws  ResourceNotFoundException ,IllegalArgumentException
	  { 
	Customer customer =customerRepository.findById(customerid) .orElseThrow(() -> new  ResourceNotFoundException("Customer not found for this id :: " +	  customerid)); 
	customerRepository.delete(customer); 
	
	}
	  
	  @Override 
	  public void deleteAllCustomerDetails() 
	  {
		  customerRepository.deleteAll();
	  
	  }
}