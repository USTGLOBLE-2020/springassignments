package com.entity;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name="customer")

public class Customerentity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String type;
	private String name;
	private String email;
	private String password;
	private LocalDate createddate;
	private LocalDate accessdate;
	private LocalDate modifieddate;
	public Customerentity() {
        this.id = UUID.randomUUID().toString();
    }
	
	public String getId() {
		return id;
	}

	

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public LocalDate getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDate createddate) {
		this.createddate = createddate;
	}

	public LocalDate getAccessdate() {
		return accessdate;
	}

	public void setAccessdate(LocalDate accessdate) {
		this.accessdate = accessdate;
	}

	public LocalDate getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(LocalDate modifieddate) {
		this.modifieddate = modifieddate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", type=" + type + ", name=" + name + ", email=" + email + ", password="
				+ password + ", createddate=" + createddate + ", accessdate=" + accessdate + ", modifieddate="
				+ modifieddate + "]";
	}
	
	
	
	
	

}
