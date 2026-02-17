package com.navesh.TEMA.user.controller;

import com.navesh.TEMA.common.entity.Product;
import com.navesh.TEMA.common.enums.Category;
import com.navesh.TEMA.common.response.ApiResponse;
import com.navesh.TEMA.user.dto.VendorCardResponse;
import com.navesh.TEMA.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")

public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Vendor browsing screen
     * Example:
     * /api/user/vendors?category=FLORIST
     */
    @GetMapping("/vendors")
    public ApiResponse<List<VendorCardResponse>> getVendorsByCategory(
            @RequestParam Category category) {

        return ApiResponse.success(
                "Vendors fetched successfully",
                userService.getVendorsByCategory(category)
        );
    }

    /**
     * Vendor products (Shop Items screen)
     */
    @GetMapping("/vendors/{vendorId}/products")
    public ApiResponse<List<Product>> getVendorProducts(
            @PathVariable Long vendorId) {

        return ApiResponse.success(
                "Vendor products fetched",
                userService.getVendorProducts(vendorId)
        );
    }
}
