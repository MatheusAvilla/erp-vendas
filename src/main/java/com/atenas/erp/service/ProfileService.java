package com.atenas.erp.service;

import com.atenas.erp.domain.Profile;
import com.atenas.erp.dto.ProfileDTO;
import com.atenas.erp.enums.ProfileEnum;
import com.atenas.erp.exception.AlreadyExistsException;
import com.atenas.erp.mapper.ProfileMapper;
import com.atenas.erp.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public void createProfile(ProfileDTO profileDTO) {
        Optional<Profile> profile = profileRepository.findByProfileName(ProfileEnum.valueOf(profileDTO.getProfileName()));
        profile.ifPresentOrElse(existentProfile -> existentProfile.setProfileName(ProfileEnum.valueOf(profileDTO.getProfileName())),
                () -> profileRepository.save(Profile.builder().profileName(ProfileEnum.valueOf(profileDTO.getProfileName())).build()));
    }

    public List<ProfileDTO> listAllProfiles() {
        return ProfileMapper.INSTANCE.toDTOList(profileRepository.findAll());
    }

}
