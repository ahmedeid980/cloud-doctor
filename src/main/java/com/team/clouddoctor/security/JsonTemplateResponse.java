package com.team.clouddoctor.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.team.clouddoctor.entities.User;

public class JsonTemplateResponse {

	private String token;
	private String message;
	private UserDetails user;

	public JsonTemplateResponse(String token) {
		this.token = token;
	}

	public JsonTemplateResponse(String token, String message, UserDetails user) {
		super();
		this.token = token;
		this.message = message;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

}
