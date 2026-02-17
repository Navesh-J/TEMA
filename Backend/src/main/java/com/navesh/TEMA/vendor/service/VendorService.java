package com.navesh.TEMA.vendor.service;

import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.entity.VendorProfile;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.user.repository.UserRepository;
import com.navesh.TEMA.vendor.repository.VendorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    private VendorProfileRepository vendorProfileRepository;

    @Autowired
    private UserRepository userRepository;

    public VendorProfile getVendorProfile(String email) {

        User vendor = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found"));

        return vendorProfileRepository.findByUser(vendor)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor profile not found"));
    }
}
