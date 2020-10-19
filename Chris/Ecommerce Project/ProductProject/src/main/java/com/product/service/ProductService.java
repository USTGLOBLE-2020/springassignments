package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;



public interface ProductService {
	public Product productCreate(Product pentity);

	public List<Product> getAllProductDetails();
	public Optional<Product> getProductDetailsById(String id);
	 
	public Product updateProductDetailsById(Product pentity) throws ResourceNotFoundException;
	public void deleteProductDetailsById(String string) throws ResourceNotFoundException;
	  
	public void deleteAllProductDetails();
}
