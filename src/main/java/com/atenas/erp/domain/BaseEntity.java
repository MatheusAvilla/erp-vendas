package com.atenas.erp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "dat_create")
    private LocalDateTime creationDate;

    @Column(name = "dat_update")
    private LocalDateTime updateDate;

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
        updateDate = creationDate;
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDateTime.now();
    }

}
