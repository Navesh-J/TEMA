package com.navesh.TEMA.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart extends BaseEntity {

    @ManyToOne
    private User user;
}
