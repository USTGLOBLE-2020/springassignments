package com.product.controller;

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

import com.product.entity.Product;
import com.product.exception.MessageNotFoundException;
import com.product.exception.ResourceNotFoundException;
import com.product.model.ProductModel;
import com.product.service.ProductService;




	@RestController
	@RequestMapping(value = ("/productapi"))
	public class ProductController {

		@Autowired
		private ProductService productService;
		
		private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
		
		@PostMapping(value = "/createproduct", consumes ="application/json", produces = "application/json")
		public ResponseEntity<ProductModel> customercreate(@Valid @RequestBody ProductModel productmodel)
				throws MethodArgumentNotValidException {
			
			
			ModelMapper modelMapper = new ModelMapper();
			Product	pentity = modelMapper.map(productmodel, Product.class);
	        Product productentity = productService.productCreate(pentity);
	        ProductModel responseproductmodel = new ProductModel();
	        modelMapper.map(productentity, responseproductmodel);
	        LOGGER.info("PRODUCT CREATED");
	        return new ResponseEntity<ProductModel>(responseproductmodel, HttpStatus.CREATED);
	       

			
		}

		@GetMapping("/getListOfProducts") 
		public ResponseEntity<List<ProductModel>> getAllCustomerDetails() 
		{
		ModelMapper modelMapper = new ModelMapper();
		List<Product> productlist = productService.getAllProductDetails();; 
		if (productlist.isEmpty()) {
		 throw new MessageNotFoundException("Productlist is empty");
		 }
		List<ProductModel> productmodellist =productlist.stream().map(e -> modelMapper.map(e, ProductModel.class)).collect(Collectors.toList());
	    LOGGER.info(" LISTED ALL PRODUCT");
		return ResponseEntity.ok().body(productmodellist); 
		  }
		 
		@GetMapping("/getProductDetailsById/{id}") 
		public ResponseEntity<ProductModel> getCustomerDetailsById(@PathVariable String id) 
				throws ResourceNotFoundException { 
			Optional<Product> productentity =productService.getProductDetailsById(id);
		if(productentity.isEmpty()) {
		throw new ResourceNotFoundException("No such Product exist"); 
		}
		ModelMapper modelMapper = new ModelMapper();
		ProductModel responseproductmodel = new ProductModel();
	    modelMapper.map(productentity.get(), responseproductmodel);
	    LOGGER.info("PRODUCT LISTED BY ID");
	    return new ResponseEntity<ProductModel>(responseproductmodel, HttpStatus.FOUND);
	   
		 }
		 
		 @PutMapping("/updateProductDetailsById") 
		 public ResponseEntity<ProductModel> updateCustomerDetailsById(@RequestBody ProductModel productmodel) throws ResourceNotFoundException{
			 ModelMapper modelMapper = new ModelMapper();
			 Product pentity= modelMapper.map(productmodel, Product.class);
			 Product productentity=productService.updateProductDetailsById(pentity);
			ProductModel responseproductmodel=modelMapper.map(productentity, ProductModel.class);
			LOGGER.info("PRODUCT UPDATED BY ID ");
		  return new ResponseEntity<>(responseproductmodel, HttpStatus.OK); 
		  
		  
		  }
		  
		 @DeleteMapping("/deleteProductDetailsById") 
		 public ResponseEntity<Object> deleteCustomerDetailsById(@RequestBody ProductModel productmodel) throws ResourceNotFoundException 
		 {
			 productService.deleteProductDetailsById(productmodel.getId());
			 LOGGER.info("PRODUCT DELETED BY ID ");
		  return new ResponseEntity<>("Product deleted", HttpStatus.NO_CONTENT);
		  
		  
		  }
		  
		  @DeleteMapping("/deleteAllProductDetails")
		  public ResponseEntity<Object> deleteAllCustomerDetails() 
		  { 
			  productService.deleteAllProductDetails();
			  LOGGER.info("ALL PRODUCT DELETED ");
			  return new ResponseEntity<>("Product deleted", HttpStatus.NO_CONTENT);
		  }
}
