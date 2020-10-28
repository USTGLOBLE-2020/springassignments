package com.contact;

import com.address.Address;

public class ContactDetails {
	private String mobileNumber;
	private String alternateMobileNumber;
	private String landlineNumber;
	private String email;
	private Address address;
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAlternateMobileNumber() {
		return alternateMobileNumber;
	}
	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ContactDetails() {
		
	}
	public ContactDetails(String inpMobile, String inpAltMobile, String inpLandLine, String inpEmail, Address inpAddress) {
		this.mobileNumber = inpMobile;
		this.alternateMobileNumber = inpAltMobile;
		this.landlineNumber = inpLandLine;
		this.email = inpEmail;
		this.address = inpAddress;
	}
	@Override
	public String toString() {
		return "ContactDetails [mobileNumber=" + mobileNumber + ", alternateMobileNumber=" + alternateMobileNumber
				+ ", landlineNumber=" + landlineNumber + ", email=" + email + ", address=" + address + "]";
	}
}
