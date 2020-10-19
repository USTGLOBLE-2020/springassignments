package com.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Customermodel;
import com.bean.Productmodel;
import com.entity.Customerentity;
import com.entity.Productentity;
import com.globalexception.MessageNotFoundException;
import com.globalexception.ResourceNotFoundException;
import com.service.Customerservice;
import com.service.Productservice;

@RestController
@RequestMapping(value = ("/customerapi"))
public class Controller {

	@Autowired
	private Customerservice customerservice;
	
	private static final Logger LOGGER = LogManager.getLogger(Controller.class);

	
	@PostMapping(value = "/createcustomer", consumes ="application/json", produces = "application/json")
	public ResponseEntity<Customermodel> customercreate(@Valid @RequestBody Customermodel customermodel)
			throws MethodArgumentNotValidException {
		
		Customerentity centity = new Customerentity();
		ModelMapper modelMapper = new ModelMapper();
        centity = modelMapper.map(customermodel, Customerentity.class);
        Customerentity responsecentity = customerservice.customercreate(centity);
        Customermodel responsecustomermodel = new Customermodel();
        modelMapper.map(responsecentity, responsecustomermodel);
        LOGGER.info("CUSTOMER CREATED");
        return new ResponseEntity<Customermodel>(responsecustomermodel, HttpStatus.CREATED);
       

		
	}

	@GetMapping("/getListOfCustomers") 
	public ResponseEntity<List<Customermodel>> getAllCustomerDetails() 
	{
	ModelMapper modelMapper = new ModelMapper();
	List<Customerentity> customerlist = customerservice.getAllCustomerDetails(); 
	if (customerlist.isEmpty()) {
		LOGGER.warn("CUSTOMER LIST IS EMPTY");
	 throw new MessageNotFoundException("Customerlist is empty");
	 }
	List<Customermodel> customermodellist =customerlist.stream().map(e -> modelMapper.map(e, Customermodel.class)).collect(Collectors.toList());
	 return ResponseEntity.ok().body(customermodellist); 
	  }
	 
	@GetMapping("/getCustomerDetailsById/{id}") 
	public ResponseEntity<Customermodel> getCustomerDetailsById(@PathVariable String id) 
			throws ResourceNotFoundException { 
		Optional<Customerentity> customerentity =customerservice.getCustomerDetailsById(id);
	if(customerentity.isEmpty()) {
		LOGGER.warn("CUSTOMER DOESNOT EXIST");
	throw new ResourceNotFoundException("no such customer exist"); 
	}
	ModelMapper modelMapper = new ModelMapper();
	Customermodel responsecustomermodel = new Customermodel();
    modelMapper.map(customerentity.get(), responsecustomermodel);
    return new ResponseEntity<Customermodel>(responsecustomermodel, HttpStatus.FOUND);
   
	 }
	 
	 @PutMapping("/updateCustomerDetailsById") 
	 public ResponseEntity<Customermodel> updateCustomerDetailsById(@RequestBody Customermodel customermodel) throws ResourceNotFoundException{
		 ModelMapper modelMapper = new ModelMapper();
		Customerentity centity= modelMapper.map(customermodel, Customerentity.class);
		Customerentity customerentity=customerservice.updateCustomerDetailsById(centity);
		Customermodel responsecustomermodel=modelMapper.map(customerentity, Customermodel.class);
		LOGGER.info("CUSTOMER DETAILS UPDATED");
	  return new ResponseEntity<>(responsecustomermodel, HttpStatus.OK); 
	  
	  
	  }
	  
	 @DeleteMapping("/deleteCustomerDetailsById") 
	 public ResponseEntity<Object> deleteCustomerDetailsById(@RequestBody Customermodel customermodel) throws ResourceNotFoundException 
	 {
	  customerservice.deleteCustomerDetailsById(customermodel.getId());
	  LOGGER.info("CUSTOMER DETAILS DELETED");
	  return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
	  
	  
	  }
	  
	  @DeleteMapping("/deleteAllCustomerDetails")
	  public ResponseEntity<Object> deleteAllCustomerDetails() 
	  { 
		  customerservice.deleteAllCustomerDetails();
		  LOGGER.info("DELETED ALL CUSTOMER DETAILS");
		  return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
	  }
	  
	  
	  

			
		}
	  
	 

