package com.example.park.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.park.Repository.PersonneRepository;

@Service
public class PersonneService {
	
	@Autowired
	private PersonneRepository persoRepo;
	
	public void deletePersonne(Long id) {
		persoRepo.deleteById(id);
	}

}
