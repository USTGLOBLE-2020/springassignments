package com.user;

import com.contact.ContactDetails;

public class User {
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", contactDetail=" + contactDetail + "]";
	}
	private String name;
	private String password;
	private ContactDetails contactDetail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ContactDetails getContactDetail() {
		return contactDetail;
	}
	public void setContactDetail(ContactDetails contactDetail) {
		this.contactDetail = contactDetail;
	}
	public User() {
		
	}
	public User(String inpName, String inpPassword, ContactDetails contact) {
		this.name = inpName;
		this.password = inpPassword;
		this.contactDetail = contact;
	}
}
