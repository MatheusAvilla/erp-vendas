package com.atenas.erp.controller;

import com.atenas.erp.dto.ProfileDTO;
import com.atenas.erp.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/list")
    public List<ProfileDTO> listProfiles() {
        return profileService.listAllProfiles();
    }

    @PostMapping("/create")
    public void createProfile(@RequestBody ProfileDTO profileDTO) {
        profileService.createProfile(profileDTO);
    }

}
