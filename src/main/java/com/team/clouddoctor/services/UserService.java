package com.team.clouddoctor.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.clouddoctor.entities.User;
import com.team.clouddoctor.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired UserRepository userRepository;
	
	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			return null;
		}
		return user;
	}

	// get all users Lookup
	public List<User> getAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	// get user by id
	public User getUserById(int id) {
		User userById = userRepository.findById(id).get();

		return userById;
	}

	// save new user
	public User saveUser(User user) {
		System.out.println("password : " +user.getPassword());
		user.setPassword(this.passwordEncoder().encode(user.getPassword()));
		
		User newUser = userRepository.save(user);
		return newUser;
	}

	// delete user
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
