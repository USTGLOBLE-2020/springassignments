package MainPack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {    
      
 @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int addressId;    
private String address; 
private int pincode; 
@OneToOne(targetEntity=Employee.class)
private Employee employee; 
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
   
  
public int getAddressId() {  
    return addressId;  
}  
public void setAddressId(int addressId) {  
    this.addressId = addressId;  
}  

public int getPincode() {  
    return pincode;  
}  
public void setPincode(int pincode) {  
    this.pincode = pincode;  
}  
public Employee getEmployee() {  
    return employee;  
}  
public void setEmployee(Employee employee) {  
    this.employee = employee;  
}    
}