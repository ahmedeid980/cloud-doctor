package com.team.clouddoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.clouddoctor.entities.User;
import com.team.clouddoctor.security.TokenUtil;
import com.team.clouddoctor.services.UserService;

import io.swagger.annotations.Api;

@Api(value = "userlogin", tags = "userlogin", description = "userlogin Endpoints")
@CrossOrigin
@RestController
@RequestMapping(value= "/userlogin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@GetMapping({"","/"})
	public List<User> getAllUser() {
		return userService.getAll();
	}
	
}
