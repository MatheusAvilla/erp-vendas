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
        Optional<Profile> profile = profileRepository.findByProfileName(profileDTO.getProfileName().name());
        profile.ifPresentOrElse(existentProfile -> {
            throw new AlreadyExistsException(existentProfile.getProfileName() + " already exists.");
        }, () -> profileRepository.save(Profile.builder().profileName(profileDTO.getProfileName()).build()));
    }

    public List<ProfileDTO> listAllProfiles() {
        return ProfileMapper.INSTANCE.toDTOList(profileRepository.findAll());
    }

}
