package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.Address;
import com.model.Employee;

public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  

		SessionFactory factory=meta.getSessionFactoryBuilder().build();  
		Session session=factory.openSession();  

		Transaction t=session.beginTransaction();    

		Employee emp1=new Employee(); 
		emp1.setName("Vijaya");
		emp1.setEmail("vijaya@gmail.com");

		Address address1=new Address();    
		address1.setAddressLine1("Sobha Dream Acres");    
		address1.setCity("Bangalore");    
		address1.setState("KN");    
		address1.setCountry("India");    
		address1.setPincode(560087);    
		emp1.setAddress(address1);  


		Employee emp2=new Employee();  
		emp2.setName("Bandi");  
		emp2.setEmail("bandi@gmail.com");  

		Address address2=new Address();    
		address2.setAddressLine1("Sobha Dream Series");    
		address2.setCity("Bangalore");    
		address2.setState("KN");    
		address2.setCountry("India");    
		address2.setPincode(560017);    

		emp2.setAddress(address2);  

		session.persist(emp1);    
		session.persist(emp2);  
		t.commit();    

		session.close();    
		System.out.println("success");  

	}

}
