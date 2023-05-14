package com.example.park.Controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.park.Repository.PersonneRepository;
import com.example.park.Service.PersonneService;
import com.example.park.entities.Personne;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonneController {
	
	@Autowired
	PersonneRepository personneRepo;
	
	@Autowired
	private PersonneService personneService;
	
	@GetMapping("/GetAll")
//	@PostAuthorize("hasAuthority('ADMIN')")
	public List<Personne> getAllPersonne() {
		return (List<Personne>) personneRepo.findAll();
	}
	
	@GetMapping("/GetAllPage")
	public Page<Personne> getAllPWithPagination(@RequestParam(defaultValue = "0") Integer pageNo,
												@RequestParam(defaultValue = "30") Integer pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Personne> pagedResult = personneRepo.findAll(paging);
		return pagedResult;
	}
	
	@GetMapping("/GetAllPageOP2")
	public Page<Personne> getAllPWithPaginationOPtion2(@RequestParam(value = "page" , defaultValue = "0") Integer pageNo,
												@RequestParam(value = "size" ,defaultValue = "4") Integer pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Personne> pagedResult = personneRepo.findAll(paging);
		return pagedResult;
	}

	@GetMapping("/GetOne/{id}")
//	@PostAuthorize(hasA)
	public Optional<Personne> getOnePersonne(@PathVariable Long id) {
		Optional<Personne> p =  personneRepo.findById(id);
		return p;
	}
	
	@GetMapping("/GetNom/{nom}")
	public Personne getPersonneByNom(@PathVariable String nom) {
		Personne p =  personneRepo.findByNom(nom);
		if(p == null)
			throw new  CustomerNotFoundException();
		else {
			  return p;
		}
	}
	
//	@GetMapping("/GetNom/{email}")
//	public Personne getPersonneByEmail(@PathVariable String email) {
//		Personne p =  personneRepo.findByEmail(email);
//		return p;
//	}
	
	
//	@PreAuthorize("ADMIN")
	@GetMapping("/FilteredPersonne")
	public List<Personne> getPersonneFiltred() {
		List<Personne> p =  personneRepo.FindPersonnegraterthantree();
		return p;
	}

	@PostMapping("/AddPersonne")
	public void AddPersonne(@RequestBody Personne p) {
		personneRepo.save(p);
	}
	
	@DeleteMapping("/delete1/{nom}")
	public void deletePersonne11(@PathVariable String nom) {
		Personne p =  personneRepo.findByNom(nom);
		System.out.println(p);
		personneService.deletePersonne(p.getIdPersonne());
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePersonne(@PathVariable Long id) {
		Personne p =  personneRepo.findByIdPersonne(id);
		System.out.println(p);
		personneService.deletePersonne(p.getIdPersonne());
	}
	
}
