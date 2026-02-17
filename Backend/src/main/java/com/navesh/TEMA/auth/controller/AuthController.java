package com.navesh.TEMA.auth.controller;

import com.navesh.TEMA.auth.dto.*;
import com.navesh.TEMA.auth.service.AuthService;
import com.navesh.TEMA.common.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/user/signup")
    public ApiResponse<Void> userSignup(@Valid @RequestBody UserSignupRequest request) {

        authService.userSignup(request);

        return ApiResponse.success("User registered successfully", null);
    }

    @PostMapping("/vendor/signup")
    public ApiResponse<Void> vendorSignup(@Valid @RequestBody VendorSignupRequest request) {

        authService.vendorSignup(request);

        return ApiResponse.success("Vendor registered successfully", null);
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        return ApiResponse.success("Login successful", authService.login(request));
    }
}
