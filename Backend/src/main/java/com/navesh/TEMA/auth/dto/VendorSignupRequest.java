package com.navesh.TEMA.auth.dto;

import com.navesh.TEMA.common.enums.Category;
import lombok.Data;

@Data
public class VendorSignupRequest {
    private String fullName;
    private String email;
    private String password;
    private String shopName;
    private String description;
    private Category category;
}
