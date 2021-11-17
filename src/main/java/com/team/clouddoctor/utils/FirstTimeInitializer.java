package com.team.clouddoctor.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.team.clouddoctor.entities.User;
import com.team.clouddoctor.services.UserService;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		if(this.userService.getAll().isEmpty()) {
			System.out.println("LOG:  we will create new user now ");
//			User user = new User("ahmed" , "ahmed.radwa@gmail.com" , "123456");
//			this.userService.saveUser(user);
		} 
		
	}

}
