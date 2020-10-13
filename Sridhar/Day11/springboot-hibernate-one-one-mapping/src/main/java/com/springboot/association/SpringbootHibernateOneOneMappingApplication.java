package com.springboot.association;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.association.entity.Gender;
import com.springboot.association.entity.User;
import com.springboot.association.entity.UserProfile;
import com.springboot.association.repository.UserProfileRepository;
import com.springboot.association.repository.UserRepository;

@SpringBootApplication
public class SpringbootHibernateOneOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneOneMappingApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// user object
		User user = new User();
		user.setName("Sreedhar");
		user.setEmail("java@gmail.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("HYDERABAD");
		userProfile.setBirthOfDate(LocalDate.of(1994, 03, 24));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("9871234565");
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userRepository.save(user);
	}

}
