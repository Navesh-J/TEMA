package com.navesh.TEMA.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VendorCardResponse {

    private Long vendorId;
    private String vendorName;
    private String shopName;
    private String description;
}
