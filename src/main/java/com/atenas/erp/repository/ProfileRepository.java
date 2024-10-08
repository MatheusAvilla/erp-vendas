package com.atenas.erp.repository;

import com.atenas.erp.domain.Profile;
import com.atenas.erp.enums.ProfileEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByProfileName(ProfileEnum profileName);

}
