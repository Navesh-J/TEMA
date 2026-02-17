package com.navesh.TEMA.membership.dto;

import lombok.Data;

@Data
public class AddMembershipRequest {

    private Long userId;
    private int durationMonths;
}
