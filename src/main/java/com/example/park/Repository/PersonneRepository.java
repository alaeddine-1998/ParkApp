package com.example.park.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.park.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne,Long>{
	
	 public Personne findByNom(String nom);
	 
	 @Query("select p from Personne p  where p.idPersonne >3")
	 public List<Personne> FindPersonnegraterthantree();

}
