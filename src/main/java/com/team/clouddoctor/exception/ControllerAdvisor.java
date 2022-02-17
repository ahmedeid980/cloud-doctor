package com.team.clouddoctor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.team.clouddoctor.dto.CommonResponseDto;
import com.team.clouddoctor.utils.ResponseUtil;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	ResponseUtil responseUtil = new ResponseUtil();

	@ExceptionHandler(MissingOrBadParameterException.class)
	public ResponseEntity<CommonResponseDto> handleMissingOrBadParameterException(
			MissingOrBadParameterException ex) {

		CommonResponseDto commonResponse = new CommonResponseDto();
		commonResponse.setCode((int) ex.getCode());
		commonResponse.setMessage(ex.getMessage());
		commonResponse.setSuccess(false);
		commonResponse.setData(null);
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
	
	@ExceptionHandler(InsufficientAuthenticationException.class)
	public ResponseEntity<CommonResponseDto> handleInvalidRequestStatusException(
			InsufficientAuthenticationException ex) {

		CommonResponseDto commonResponse = new CommonResponseDto();
		commonResponse.setCode((int) ex.getCode());
		commonResponse.setMessage(ex.getMessage());
		commonResponse.setSuccess(false);
		commonResponse.setData(null);
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {

		CommonResponseDto commonResponse = new CommonResponseDto();
		commonResponse.setCode((int) ex.getCode());
		commonResponse.setMessage(ex.getMessage());
		commonResponse.setSuccess(false);
		commonResponse.setData(null);
		return new ResponseEntity<>(commonResponse, HttpStatus.OK);
	}
}
