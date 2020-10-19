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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.Productmodel;

import com.entity.Productentity;
import com.globalexception.MessageNotFoundException;
import com.globalexception.ResourceNotFoundException;
import com.service.Productservice;

@RestController
@RequestMapping(value = ("/productapi"))
public class ProductController {

	@Autowired
	private Productservice productservice;
	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
	
	@PostMapping(value = "/createproduct", consumes ="application/json", produces = "application/json")
	public ResponseEntity<Productmodel> createproduct(@Valid @RequestBody Productmodel productmodel)
			throws MethodArgumentNotValidException {
		
		Productentity pentity = new Productentity();
		ModelMapper modelMapper = new ModelMapper();
        pentity = modelMapper.map(productmodel, Productentity.class);
        Productentity responsecentity = productservice.productcreate(pentity);
        Productmodel responseproductmodel = new Productmodel();
        modelMapper.map(responsecentity, responseproductmodel);
        LOGGER.info("PRODUCT CREATED");
        return new ResponseEntity<Productmodel>(responseproductmodel, HttpStatus.CREATED);
       

		
	}
	 
	 @GetMapping(value = "/getProductDetailsById/{id}", consumes ="application/json", produces = "application/json")
	 public ResponseEntity<Productmodel> getProductDetailsById(@PathVariable String id) 
				throws ResourceNotFoundException { 
			Optional<Productentity> productentity =productservice.getProductDetailsById(id);
		if(productentity.isEmpty()) {
			LOGGER.warn("PRODUCT DOESNOT EXIST");
		throw new ResourceNotFoundException("no such product exist"); 
		}
		ModelMapper modelMapper = new ModelMapper();
		Productmodel responseproductmodel = new Productmodel();
	    modelMapper.map(productentity.get(), responseproductmodel);
	    LOGGER.info("PRODUCT FOUND");
	    return new ResponseEntity<Productmodel>(responseproductmodel, HttpStatus.FOUND);
	   
		 }
	 @GetMapping("/getListOfproducts") 
		public ResponseEntity<List<Productmodel>> getListOfproducts() 
		{
		ModelMapper modelMapper = new ModelMapper();
		List<Productentity> productlist = productservice.getListOfproducts(); 
		if (productlist.isEmpty()) {
			LOGGER.warn("PRODUCTLIST IS EMPTY");
		 throw new MessageNotFoundException("Productlist is empty");
		 }
		List<Productmodel> productmodellist =productlist.stream().map(e -> modelMapper.map(e, Productmodel.class)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(productmodellist); 
		  }
	 
}
