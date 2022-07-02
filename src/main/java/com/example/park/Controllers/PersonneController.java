package com.example.park.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.park.Repository.PersonneRepository;
import com.example.park.entities.Personne;

@RestController
public class PersonneController {
	
	@Autowired
	PersonneRepository personneRepo;
	
	@GetMapping("/GetAll")
	public List<Personne> getAllPersonne() {
		return personneRepo.findAll();
	}
	
	
	@GetMapping("/GetOne/{id}")
	public Optional<Personne> getOnePersonne(@PathVariable Long id) {
		Optional<Personne> p =  personneRepo.findById(id);
		return p;
	}
	
	@GetMapping("/GetNom/{nom}")
	public Personne getPersonneByNom(@PathVariable String nom) {
		Personne p =  personneRepo.findByNom(nom);
		return p;
	}
	
	
	@PreAuthorize("ADMIN")
	@GetMapping("/FilteredPersonne")
	public List<Personne> getPersonneFiltred() {
		List<Personne> p =  personneRepo.FindPersonnegraterthantree();
		return p;
	}
	
	@GetMapping("/notAuthorized")
	public void handleExeption() {
		System.out.println("do not have acces");
	}
	

	@PostMapping("/AddPersonne")
	public void AddPersonne(@RequestBody Personne p) {
		personneRepo.save(p);
	}
}
