package com.navesh.TEMA.common.entity;

import com.navesh.TEMA.common.enums.MembershipStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Membership extends BaseEntity {

    @Column(unique = true)
    private String membershipNumber;

    @ManyToOne
    private User user;

    private LocalDate startDate;
    private LocalDate endDate;

    private int durationMonths;

    @Enumerated(EnumType.STRING)
    private MembershipStatus status;
}
