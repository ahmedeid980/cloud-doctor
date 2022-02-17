package com.team.clouddoctor.facade;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team.clouddoctor.dto.CommonResponseDto;
import com.team.clouddoctor.dto.TempUserDto;
import com.team.clouddoctor.entities.TempUser;
import com.team.clouddoctor.exception.ErrorCodes;
import com.team.clouddoctor.exception.MissingOrBadParameterException;
import com.team.clouddoctor.mapper.TempUserMapper;
import com.team.clouddoctor.services.TempUserService;
import com.team.clouddoctor.utils.ResponseUtil;

@Component
public class TempUserFacade {

	@Autowired
	TempUserService tempUserService;

	private final TempUserMapper tempUserMapper = Mappers.getMapper(TempUserMapper.class);

	public CommonResponseDto saveTempUser(TempUserDto tempUserRequestDto) {

		if (tempUserRequestDto.getUserId() == null || tempUserRequestDto.getEmail() == null || tempUserRequestDto.getUserName() == null) {
			throw new MissingOrBadParameterException(ErrorCodes.USER_PARAM_REQUIRED.getMessage(),ErrorCodes.USER_PARAM_REQUIRED.getCode());
		}

		TempUser tempUser = tempUserMapper.mapToEntity(tempUserRequestDto);
		TempUser user = tempUserService.saveUser(tempUser);
		TempUserDto tempUserResponseDto = tempUserMapper.mapToDto(user);
		

		return ResponseUtil.buildSuccessResponse(tempUserResponseDto, "user  saved");
	}

}
