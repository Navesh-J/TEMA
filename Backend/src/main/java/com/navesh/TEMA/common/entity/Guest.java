package com.navesh.TEMA.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Guest extends BaseEntity {

    @ManyToOne
    private User user;

    private String guestName;
    private String contact;
}
