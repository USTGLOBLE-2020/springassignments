package com.service;

import java.util.List;
import java.util.Optional;


import com.entity.Customerentity;
import com.globalexception.ResourceNotFoundException;

public interface Customerservice {

	public Customerentity customercreate(Customerentity centity);

	public List<Customerentity> getAllCustomerDetails();
	public Optional<Customerentity> getCustomerDetailsById(String id);
	 
	public Customerentity updateCustomerDetailsById(Customerentity customerentity) throws ResourceNotFoundException;
	public void deleteCustomerDetailsById(String string) throws ResourceNotFoundException;
	  
	public void deleteAllCustomerDetails();
	 

	
		
		
	

}
