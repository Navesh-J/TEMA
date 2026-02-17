package com.navesh.TEMA.auth.service;

import com.navesh.TEMA.auth.dto.LoginRequest;
import com.navesh.TEMA.auth.dto.LoginResponse;
import com.navesh.TEMA.auth.dto.UserSignupRequest;
import com.navesh.TEMA.auth.dto.VendorSignupRequest;
import com.navesh.TEMA.auth.util.JwtService;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.entity.VendorProfile;
import com.navesh.TEMA.common.enums.Role;
import com.navesh.TEMA.common.exception.BadRequestException;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.user.repository.UserRepository;
import com.navesh.TEMA.vendor.repository.VendorProfileRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final VendorProfileRepository vendorRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, VendorProfileRepository vendorRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.vendorRepo = vendorRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void userSignup(UserSignupRequest request) {

        if (userRepository.findByEmail(request.getEmail())
                .isPresent()) {
            throw new BadRequestException("Email already registered");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    @Transactional
    public void vendorSignup(VendorSignupRequest request) {

        if (userRepository.findByEmail(request.getEmail())
                .isPresent()) {
            throw new BadRequestException("Email already registered");
        }

        User vendor = new User();
        vendor.setFullName(request.getFullName());
        vendor.setEmail(request.getEmail());
        vendor.setPassword(passwordEncoder.encode(request.getPassword()));
        vendor.setRole(Role.VENDOR);

        userRepository.save(vendor);

        VendorProfile profile = new VendorProfile();
        profile.setUser(vendor);
        profile.setShopName(request.getShopName());
        profile.setDescription(request.getDescription());

        vendorRepo.save(profile);
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            throw new BadRequestException("Invalid credentials");
        }

        if (request.getRole() == null || user.getRole() != request.getRole()) {
            throw new BadRequestException("Role mismatch");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}
