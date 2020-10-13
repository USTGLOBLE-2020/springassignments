package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="emp107")  
public class Employee {    
     @Id  
     @GeneratedValue(strategy=GenerationType.AUTO)    
private long employeeId;    
private String name,email;    
@ManyToOne(cascade=CascadeType.ALL)  

private CompanyAddress companyAddress;

  
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
 
public long getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(long employeeId) {
	this.employeeId = employeeId;
}
public CompanyAddress getCompanyAddress() {
	return companyAddress;
}
public void setCompanyAddress(CompanyAddress companyAddress) {
	this.companyAddress = companyAddress;
}
public  Employee() { 
} 
public Employee(String name,String email) {
	super();
	this.name = name;  
	this.email = email;   
}
} 


