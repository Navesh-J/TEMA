package com.navesh.TEMA.membership.dto;

import lombok.Data;

@Data
public class UpdateMembershipRequest {

    private String membershipNumber;
    private boolean cancel;
    private int extendMonths; // default 6
}
