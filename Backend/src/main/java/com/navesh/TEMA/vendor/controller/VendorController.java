package com.navesh.TEMA.vendor.controller;

import com.navesh.TEMA.common.entity.VendorProfile;
import com.navesh.TEMA.common.response.ApiResponse;
import com.navesh.TEMA.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor")
@CrossOrigin(origins = "*")

public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/profile")
    public ApiResponse<VendorProfile> getProfile(
            Authentication authentication) {

        return ApiResponse.success(
                "Vendor profile fetched",
                vendorService.getVendorProfile(authentication.getName())
        );
    }
}
