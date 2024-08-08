package com.atenas.erp.domain;

import com.atenas.erp.enums.ProfileEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6465797814503710808L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @Column(name = "nam_profile")
    @Enumerated(EnumType.STRING)
    private ProfileEnum profileName;

}
