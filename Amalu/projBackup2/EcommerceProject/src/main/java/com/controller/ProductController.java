package com.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.bean.Customermodel;
import com.bean.Productmodel;
import com.entity.Customerentity;
import com.entity.Productentity;
import com.globalexception.MessageNotFoundException;
import com.globalexception.ResourceNotFoundException;
import com.service.Customerservice;
import com.service.Productservice;

@RestController
@RequestMapping(value = ("/productapi"))
public class ProductController {

	@Autowired
	private Productservice productservice;
	
	@PostMapping(value = "/createproduct", consumes ="application/json", produces = "application/json")
	public ResponseEntity<Productmodel> createproduct(@Valid @RequestBody Productmodel productmodel)
			throws MethodArgumentNotValidException {
		System.out.println("enetering product create");
		Productentity pentity = new Productentity();
		ModelMapper modelMapper = new ModelMapper();
        pentity = modelMapper.map(productmodel, Productentity.class);
        Productentity responsecentity = productservice.productcreate(pentity);
        Productmodel responseproductmodel = new Productmodel();
        modelMapper.map(responsecentity, responseproductmodel);
        return new ResponseEntity<Productmodel>(responseproductmodel, HttpStatus.CREATED);
       

		
	}
	 
	 @GetMapping(value = "/getProductDetailsById/{id}", consumes ="application/json", produces = "application/json")
	 public ResponseEntity<Productmodel> getProductDetailsById(@PathVariable String id) 
				throws ResourceNotFoundException { 
			Optional<Productentity> productentity =productservice.getProductDetailsById(id);
		if(productentity.isEmpty()) {
		throw new ResourceNotFoundException("no such product exist"); 
		}
		ModelMapper modelMapper = new ModelMapper();
		Productmodel responseproductmodel = new Productmodel();
	    modelMapper.map(productentity.get(), responseproductmodel);
	    return new ResponseEntity<Productmodel>(responseproductmodel, HttpStatus.FOUND);
	   
		 }
	 @GetMapping("/getListOfproducts") 
		public ResponseEntity<List<Productmodel>> getListOfproducts() 
		{
		ModelMapper modelMapper = new ModelMapper();
		List<Productentity> productlist = productservice.getListOfproducts(); 
		if (productlist.isEmpty()) {
		 throw new MessageNotFoundException("Productlist is empty");
		 }
		List<Productmodel> productmodellist =productlist.stream().map(e -> modelMapper.map(e, Productmodel.class)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(productmodellist); 
		  }
	 
}
