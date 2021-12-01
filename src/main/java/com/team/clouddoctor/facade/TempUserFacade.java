package com.team.clouddoctor.facade;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team.clouddoctor.dto.CommonResponseDto;
import com.team.clouddoctor.dto.TempUserDto;
import com.team.clouddoctor.entities.TempUser;
import com.team.clouddoctor.mapper.TempUserMapper;
import com.team.clouddoctor.services.TempUserService;
import com.team.clouddoctor.utils.ResponseUtil;

@Component
public class TempUserFacade {

	@Autowired
	TempUserService tempUserService;

	private final TempUserMapper tempUserMapper = Mappers.getMapper(TempUserMapper.class);

	public CommonResponseDto saveTempUser(TempUserDto tempUserRequestDto) {

//		if (tempUserDto.getUserId() == null || tempUserDto.getEmail() == null || tempUserDto.getUserName() == null) {
//			throw new MissingOrBadParameterException(ErrorCodes.getErrorMessage(50101), 50101);
//		}

		TempUser tempUser = tempUserMapper.mapToEntity(tempUserRequestDto);
		TempUser user = tempUserService.saveUser(tempUser);
		TempUserDto tempUserResponseDto = tempUserMapper.mapToDto(user);
		

		return ResponseUtil.buildSuccessResponse(tempUserResponseDto, "user  saved");
	}

}
