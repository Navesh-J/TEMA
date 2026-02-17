package com.navesh.TEMA.admin.dto;

import com.navesh.TEMA.common.enums.Role;
import lombok.Data;

@Data
public class AddUserRequest {

    private String fullName;
    private String email;
    private String password;
    private Role role; // USER or VENDOR
}
