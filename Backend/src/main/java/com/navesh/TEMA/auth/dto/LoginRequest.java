package com.navesh.TEMA.auth.dto;

import com.navesh.TEMA.common.enums.Role;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private Role role;
}
