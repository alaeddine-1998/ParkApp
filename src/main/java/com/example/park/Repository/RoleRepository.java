package com.example.park.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.park.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

	Role findByName(String name);
}
