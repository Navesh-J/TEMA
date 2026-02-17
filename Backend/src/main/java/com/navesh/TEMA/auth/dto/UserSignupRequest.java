package com.navesh.TEMA.auth.dto;

import lombok.Data;

@Data
public class UserSignupRequest {
    private String fullName;
    private String email;
    private String password;
}
