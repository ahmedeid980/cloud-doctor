package com.team.clouddoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.clouddoctor.entities.User;
import com.team.clouddoctor.security.JsonTemplateResponse;
import com.team.clouddoctor.security.LoginRequest;
import com.team.clouddoctor.security.TokenUtil;
import com.team.clouddoctor.services.UserService;
import com.team.clouddoctor.uibean.UserUIBean;

@CrossOrigin
@RestController
@RequestMapping(value="/CloudDoctor/Authorization")
public class AuthController {

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(value = {"","/"})
	public JsonTemplateResponse Login(@RequestBody LoginRequest loginRequest) {
		final Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
		String token = null;
		JsonTemplateResponse jsonTemplateResponse = null;
		if(userDetails != null) {
			token = tokenUtil.generateToken(userDetails);
			jsonTemplateResponse = new JsonTemplateResponse(token , "you have a new token" , userDetails);
		} else {
			jsonTemplateResponse = new JsonTemplateResponse(null , "username or password invalid, "
					+ "try again later or you can register this login again" ,null);
		}
		
		
		return jsonTemplateResponse;
	}

}
