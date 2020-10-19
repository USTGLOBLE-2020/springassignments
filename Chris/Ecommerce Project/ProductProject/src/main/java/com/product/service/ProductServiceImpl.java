package com.product.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.entity.Product;
import com.product.exception.ResourceNotFoundException;
import com.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product productCreate(Product pentity) {
		Product productresponse= productRepository.save(pentity);
		return productresponse;
	} 
 @Override 
 public List<Product> getAllProductDetails()
 { 
	 List<Product> productlist=productRepository.findAll();
	 return productlist; 
	 }
	 
	  @Override
	  public Optional<Product> getProductDetailsById(String id) { 
	  	return productRepository.findById(id); 
	  	}
	  
	 @Override 
	 public Product updateProductDetailsById(Product pentity) throws ResourceNotFoundException
	 { 
		 Product productresponse =productRepository.findById(pentity.getId()) .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id"+pentity.getId()));
		 productresponse.setProduct_name(pentity.getProduct_name());
		 productresponse.setProduct_description(pentity.getProduct_description());
		 productresponse.setProduct_price(pentity.getProduct_price());
		 productresponse.setProduct_size(pentity.getProduct_size());
		 productresponse.setProduct_color(pentity.getProduct_color());
	return productRepository.save(productresponse);

	  }
	  
	  @Override 
	  public void deleteProductDetailsById(String productid) throws ResourceNotFoundException
	  { 
		  Product product =productRepository.findById(productid) .orElseThrow(() -> new  ResourceNotFoundException("Product not found for this id :: " +	  productid)); 
		  productRepository.delete(product); 
	
	}
	  @Override 
		public void deleteAllProductDetails()
	  {
		  productRepository.deleteAll();
	  
	  } 
	 		
	}