package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import entity.CompanyAddress;
import entity.Employee;
import repository.CompanyAddressRepository;
import repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeHibernateManyToOneMappingApplication implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeHibernateManyToOneMappingApplication.class, args);
	}
@Autowired 
private CompanyAddressRepository addressRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee("CHRIS","chris@ust-global.com");
		Employee employee1=new Employee("MARIA","maria@ust-global.com");
		
CompanyAddress address=new CompanyAddress("UST GLOBAL");
address.getEmployee().add(employee);
address.getEmployee().add(employee1);
		
		this.addressRepository.save(address);
		
	}
}
