package com.example.park.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.park.Repository.PersonneRepository;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class SecurityRepository {

	@Autowired
	PersonneRepository personneRepo;
	
	@GetMapping("/notAuthorized")
	public void handleExeption() {
		System.out.println("do not have acces");
	}
	
	@GetMapping("/")
	public String home() {
		 return "Connected";
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/login")
	public ModelAndView  login() {
		return new ModelAndView("login.html");
	}
	
	
	@GetMapping("/logout")
	public ModelAndView  logout(HttpServletRequest repuest) {
//		request.logout();
		return new ModelAndView("login.html");
	}
}
