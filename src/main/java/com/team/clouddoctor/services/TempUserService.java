package com.team.clouddoctor.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.clouddoctor.entities.TempUser;
import com.team.clouddoctor.entities.User;

@Service
public class TempUserService {


	public List<User> getAll() {
		List<User> users = null;
		return users;
	}
	public TempUser saveUser(TempUser user) {
		System.out.println("email : " +user.getEmail());
//		user.setPassword(this.passwordEncoder().encode(user.getPassword()));
//		
//		User newUser = userRepository.save(user);
		return user;
	}

}
