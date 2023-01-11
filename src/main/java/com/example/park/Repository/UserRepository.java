package com.example.park.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.park.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	User findByUsername(String username);

}
