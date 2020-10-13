package com.springboot.association;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springboot.association.entity.Hospital;
import com.springboot.association.entity.Test;
import com.springboot.association.repository.HospiRepository;

@SpringBootApplication
public class SpringbootHibernateManyToManyMappingApplication implements CommandLineRunner{

	@Autowired
	private HospiRepository hospiRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateManyToManyMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hospital hsp1 = new Hospital("Icon","KPHB Colony");
		Hospital hsp2 = new Hospital("Maxcure","Ameerpet");
		
		Test springBoot = new Test("BP test",LocalDate.of( 1985 , 1 , 1 ));
		Test springBoot1 = new Test("endoscopy",LocalDate.of( 2005 , 11 , 8 ));
		
		
		hsp1.getTests().add(springBoot);
		hsp1.getTests().add(springBoot1);
		
		springBoot.getHs().add(hsp1);
		springBoot1.getHs().add(hsp1);
		
		springBoot.getHs().add(hsp2);
		hsp2.getTests().add(springBoot);
		
		
		this.hospiRepository.save(hsp1);
		this.hospiRepository.save(hsp2);
		
	}

}
