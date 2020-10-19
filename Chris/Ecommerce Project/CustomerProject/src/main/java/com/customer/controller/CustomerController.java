package com.customer.controller;

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

import com.customer.entity.Customer;
import com.customer.exception.MessageNotFoundException;
import com.customer.exception.ResourceNotFoundException;
import com.customer.model.CustomerModel;
import com.customer.service.CustomerService;
import com.product.controller.ProductController;



@RestController
@RequestMapping(value = ("/customerapi"))
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);	
	
	@PostMapping(value = "/createcustomer", consumes ="application/json", produces = "application/json")
	public ResponseEntity<CustomerModel> customercreate(@Valid @RequestBody CustomerModel customermodel)
			throws MethodArgumentNotValidException {
		
		Customer centity = new Customer();
		ModelMapper modelMapper = new ModelMapper();
        centity = modelMapper.map(customermodel, Customer.class);
        Customer responsecentity = customerService.customercreate(centity);
        CustomerModel responsecustomermodel = new CustomerModel();
        modelMapper.map(responsecentity, responsecustomermodel);
        LOGGER.info("CUSTOMER ADDED SUCCESSFULLY");
        return new ResponseEntity<CustomerModel>(responsecustomermodel, HttpStatus.CREATED);
       

		
	}

	@GetMapping("/getListOfCustomers") 
	public ResponseEntity<List<CustomerModel>> getAllCustomerDetails() 
	{
	ModelMapper modelMapper = new ModelMapper();
	List<Customer> customerlist = customerService.getAllCustomerDetails(); 
	if (customerlist.isEmpty()) {
	 throw new MessageNotFoundException("Customerlist is empty");
	 }
	List<CustomerModel> customermodellist =customerlist.stream().map(e -> modelMapper.map(e, CustomerModel.class)).collect(Collectors.toList());
	 LOGGER.info("CUSTOMER LISTED SUCCESSFULLY");
	return ResponseEntity.ok().body(customermodellist); 
	  }
	 
	@GetMapping("/getCustomerDetailsById/{id}") 
	public ResponseEntity<CustomerModel> getCustomerDetailsById(@PathVariable String id) 
			throws ResourceNotFoundException { 
		Optional<Customer> customerentity =customerService.getCustomerDetailsById(id);
	if(customerentity.isEmpty()) {
	throw new ResourceNotFoundException("no such customer exist"); 
	}
	ModelMapper modelMapper = new ModelMapper();
	CustomerModel responsecustomermodel = new CustomerModel();
    modelMapper.map(customerentity.get(), responsecustomermodel);
    LOGGER.info("CUSTOMER LISTED BY ID");
    return new ResponseEntity<CustomerModel>(responsecustomermodel, HttpStatus.FOUND);
   
	 }
	 
	 @PutMapping("/updateCustomerDetailsById") 
	 public ResponseEntity<CustomerModel> updateCustomerDetailsById(@RequestBody CustomerModel customermodel) throws ResourceNotFoundException{
		 ModelMapper modelMapper = new ModelMapper();
		Customer centity= modelMapper.map(customermodel, Customer.class);
		Customer customerentity=customerService.updateCustomerDetailsById(centity);
		CustomerModel responsecustomermodel=modelMapper.map(customerentity, CustomerModel.class);
		LOGGER.info("CUSTOMER UPDATED BY ID");
	  return new ResponseEntity<>(responsecustomermodel, HttpStatus.OK); 
	  
	  
	  }
	  
	 @DeleteMapping("/deleteCustomerDetailsById") 
	 public ResponseEntity<Object> deleteCustomerDetailsById(@RequestBody CustomerModel customermodel) throws ResourceNotFoundException 
	 {
		 customerService.deleteCustomerDetailsById(customermodel.getId());
	  return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
	  
	  
	  }
	  
	  @DeleteMapping("/deleteAllCustomerDetails")
	  public ResponseEntity<Object> deleteAllCustomerDetails() 
	  { 
		  customerService.deleteAllCustomerDetails();
		  return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
	  }
	  
	 
}