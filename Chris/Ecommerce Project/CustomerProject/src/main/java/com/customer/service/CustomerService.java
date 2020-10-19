package com.customer.service;

import java.util.List;
import java.util.Optional;

import com.customer.entity.Customer;
import com.customer.exception.ResourceNotFoundException;

public interface CustomerService {
	public Customer customercreate(Customer centity);

	public List<Customer> getAllCustomerDetails();
	public Optional<Customer> getCustomerDetailsById(String id);
	 
	public Customer updateCustomerDetailsById(Customer customer) throws ResourceNotFoundException;
	public void deleteCustomerDetailsById(String string) throws ResourceNotFoundException;
	  
	public void deleteAllCustomerDetails();
}
