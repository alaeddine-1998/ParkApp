package com.example.park.Service;

import java.util.List;

import com.example.park.entities.Role;
import com.example.park.entities.User;

public interface UserService {
	
//	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username , String roleName);
	User getUser(String username);
	List<User> getUsers();
	void deleteAllUser();
	void deleteAllRole();
	public User loadUserByUsername(String username);

}
