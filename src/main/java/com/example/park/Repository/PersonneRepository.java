package com.example.park.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.park.entities.Personne;

public interface PersonneRepository extends  PagingAndSortingRepository<Personne, Long> {
	
	 public Personne findByNom(String nom);
	 
	 
	 @Query("select p from Personne p  where p.nom = :nom" )
	 public List<Personne>  findByListNom(String nom);

	 
//	 public List<Personne> findByNom(String email);
	 
	 public Personne findByIdPersonne(Long nom);
	 
	 public Personne findByEmail(String email);
	 
	 @Query("select p from Personne p  where p.idPersonne >3")
	 public List<Personne> FindPersonnegraterthantree();

}
