package com.atenas.erp.mapper;

import com.atenas.erp.domain.Profile;
import com.atenas.erp.dto.ProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileDTO toDTO(Profile profile);

    List<ProfileDTO> toDTOList(List<Profile> profiles);

}
