package com.atenas.erp.steps;

import com.atenas.erp.ErpApplication;
import com.atenas.erp.domain.Profile;
import com.atenas.erp.dto.ProfileDTO;
import com.atenas.erp.enums.ProfileEnum;
import com.atenas.erp.repository.ProfileRepository;
import com.atenas.erp.service.ProfileService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@CucumberContextConfiguration
@SpringBootTest(classes = ErpApplication.class)
public class ProfileStep {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileRepository profileRepository;

    @Given("Eu tento criar um perfil com o nome {string}")
    public void shouldCreateNewProfile(String profileName) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setProfileName(ProfileEnum.fromName(profileName));
        profileService.createProfile(profileDTO);
    }

    @Then("O perfil {string} deve ser criado com sucesso")
    public void verifyProfileWasCreated(String profileName) {
        Optional<Profile> profile = profileRepository.findByProfileName(ProfileEnum.fromName(profileName));
        Assertions.assertNotNull(profile);
        Assertions.assertTrue(profile.isPresent());
    }

}
