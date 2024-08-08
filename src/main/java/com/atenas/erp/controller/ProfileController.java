package com.atenas.erp.controller;

import com.atenas.erp.dto.ProfileDTO;
import com.atenas.erp.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileDTO> listProfiles() {
        return profileService.listAllProfiles();
    }

    @PostMapping("/create")

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createProfile(@RequestBody ProfileDTO profileDTO) {
        profileService.createProfile(profileDTO);
    }

}
