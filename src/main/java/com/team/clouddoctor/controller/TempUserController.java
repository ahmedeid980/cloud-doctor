package com.team.clouddoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.clouddoctor.dto.CommonResponseDto;
import com.team.clouddoctor.dto.TempUserDto;
import com.team.clouddoctor.facade.TempUserFacade;

import io.swagger.annotations.Api;

@Api(value = "tempUser", tags = "tempUser", description = "tempUser Endpoints")
@CrossOrigin
@RestController
@RequestMapping(value= "/temp")
public class TempUserController {
		
	@Autowired
	private TempUserFacade tempUserFacade;
	
	@PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<CommonResponseDto>saveTempUser(@RequestBody TempUserDto tempUserRequestDto) {
		return ResponseEntity.ok(tempUserFacade.saveTempUser(tempUserRequestDto));
	}
	
}
