package com.navesh.TEMA.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VendorProfile extends BaseEntity {

    @OneToOne
    private User user;

    private String shopName;
    private String description;
}
