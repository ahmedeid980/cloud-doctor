package com.team.clouddoctor.utils;

import org.springframework.stereotype.Component;

import com.team.clouddoctor.dto.CommonResponseDto;

@Component
public class ResponseUtil {

	public CommonResponseDto buildResponse(int code, String message, boolean success, Object obj) {
		CommonResponseDto commonResponseDto = new CommonResponseDto();
		commonResponseDto.setCode(code);
		commonResponseDto.setMessage(message);
		commonResponseDto.setData(obj);
		commonResponseDto.setSuccess(success);
		return commonResponseDto;
	}
	 public static CommonResponseDto buildSuccessResponse(Object ...params){
		 CommonResponseDto commonResponseDto = new CommonResponseDto();
		 commonResponseDto.setCode(200);
		 commonResponseDto.setSuccess(true);
		 commonResponseDto.setData(params[0]);
		 commonResponseDto.setMessage(params[1].toString());
	        return commonResponseDto;
	    }

}