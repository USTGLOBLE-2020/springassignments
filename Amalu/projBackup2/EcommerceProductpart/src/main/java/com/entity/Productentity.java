package com.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="product")
public class Productentity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	
	private String product_name;
	
	private String  product_description;
	
	private String  product_price;
	
	private String product_size;
	
	private String  product_color;
	public Productentity() {
        this.id = UUID.randomUUID().toString();
    }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_size() {
		return product_size;
	}
	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	@Override
	public String toString() {
		return "Productentity [id=" + id + ", product_name=" + product_name + ", product_description="
				+ product_description + ", product_price=" + product_price + ", product_size=" + product_size
				+ ", product_color=" + product_color + "]";
	}
	

}
