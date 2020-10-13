package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity  
@Table(name="address107")  
public class CompanyAddress {  
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private long companyId;    
    private String companyName;
     
//   @OneToOne(cascade=CascadeType.ALL)  
   
   private Set<Employee> employee=new  HashSet<>();
  
    public long getCompanyId() {
	return companyId;
}
public void setCompanyId(long companyId) {
	this.companyId = companyId;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public Set<Employee> getEmployee() {
	return employee;
}
public void setEmployee(Set<Employee> employee) {
	this.employee = employee;
}
	
    public  CompanyAddress() {
}
    public CompanyAddress(String companyName) {
    	super();
    	this.companyName = companyName;  
    }
	
}