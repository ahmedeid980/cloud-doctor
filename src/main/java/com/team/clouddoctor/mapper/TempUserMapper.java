package com.team.clouddoctor.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.team.clouddoctor.dto.TempUserDto;
import com.team.clouddoctor.entities.TempUser;

@Mapper
public interface TempUserMapper {
  
    
    @Mappings({
        @Mapping(target = "userId", source = "tempUserDto.userId"),
        @Mapping(target = "userName", source = "tempUserDto.userName"),
        @Mapping(target = "email", source = "tempUserDto.email")
	})
	TempUser mapToEntity(TempUserDto tempUserDto);
    
    @Mappings({
        @Mapping(target = "userId", source = "tempUser.userId"),
        @Mapping(target = "userName", source = "tempUser.userName"),
        @Mapping(target = "email", source = "tempUser.email")
	})
    TempUserDto mapToDto(TempUser tempUser);

}