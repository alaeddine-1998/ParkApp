package com.example.park;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.park.Controllers.PersonneController;
import com.example.park.Service.UserService;
import com.example.park.entities.Personne;
import com.example.park.entities.Role;
import com.example.park.entities.User;

@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true , securedEnabled = true)
public class ParkAppApplication  {
	@Autowired
	private PersonneController personneRepo;

	public static void main(String[] args) {
		SpringApplication.run(ParkAppApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		
		return args-> {
			
			
//			personneRepo.AddPersonne(new Personne(Long.valueOf(5), "hamouda", "lamba", "mp@gmail.Com"));
//			personneRepo.AddPersonne(new Personne(Long.valueOf(6), "aziz", "daoui", "daoui@gmail.Com"));
//			personneRepo.AddPersonne(new Personne(Long.valueOf(6), "saida", "waca", "waca@gmail.Com"));
//			//delete all user 
//			userService.deleteAllRole();
//			userService.deleteAllUser();
			
			
			//Create users and roles
//			userService.saveRole(new Role(null, "ADMIN"));
//			userService.saveRole(new Role(null, "USER"));
//			
//			userService.saveUser(new User(null, "Alae wassif", "alae", "123", new ArrayList<>()));
//			userService.saveUser(new User(null, "Rachid wassif", "rachid", "123", new ArrayList<>()));
//			
//			userService.addRoleToUser("alae","ADMIN");
//			userService.addRoleToUser("rachid","USER");
		};
	}
	
	
	
//	 @Bean
//	    public BCryptPasswordEncoder passwordEncoder() {
//	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//	        return bCryptPasswordEncoder;
//	    }
	
	

}
