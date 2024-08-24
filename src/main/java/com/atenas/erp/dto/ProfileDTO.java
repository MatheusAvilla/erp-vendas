package com.atenas.erp.dto;

import com.atenas.erp.enums.ProfileEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO implements Serializable {

    @NotBlank(message = "O preenchimento do perfil é obrigatório")
    @Enumerated(EnumType.STRING)
    private String profileName;

}
