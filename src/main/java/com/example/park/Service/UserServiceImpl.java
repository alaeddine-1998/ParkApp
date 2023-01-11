package com.example.park.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.park.Repository.RoleRepository;
import com.example.park.Repository.UserRepository;
import com.example.park.entities.Role;
import com.example.park.entities.User;


@Service
public class UserServiceImpl implements UserService  {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public User saveUser(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		return userRepository.save(user);
//	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role =  roleRepository.findByName(roleName);
		User user = userRepository.findByUsername(username);
		user.getRoles().add(role);
		userRepository.save(user);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteAllUser() {
		
		userRepository.deleteAll();
	}

	@Override
	public void deleteAllRole() {
		roleRepository.deleteAll();
	}

	@Override
	public User loadUserByUsername(String username) {
//		User user = userRepository.findByUsername(username);
//		if(user == null) {
//			System.out.println("user not found");
//		}
//		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
//		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
	
		return userRepository.findByUsername(username);
	
	}

}
