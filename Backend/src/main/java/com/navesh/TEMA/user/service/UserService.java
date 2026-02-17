package com.navesh.TEMA.user.service;

import com.navesh.TEMA.common.entity.Product;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.entity.VendorProfile;
import com.navesh.TEMA.common.enums.Category;
import com.navesh.TEMA.common.enums.Role;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.product.repository.ProductRepository;
import com.navesh.TEMA.user.dto.VendorCardResponse;
import com.navesh.TEMA.user.repository.UserRepository;
import com.navesh.TEMA.vendor.repository.VendorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorProfileRepository vendorProfileRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Vendor listing by category
     */
    public List<VendorCardResponse> getVendorsByCategory(Category category) {

        List<Product> products = productRepository.findByCategory(category);

        Set<User> uniqueVendors = products.stream()
                .map(Product::getVendor)
                .collect(Collectors.toSet());

        return uniqueVendors.stream().map(vendor -> {

            VendorProfile profile = vendorProfileRepository
                    .findByUser(vendor)
                    .orElse(null);

            return new VendorCardResponse(
                    vendor.getId(),
                    vendor.getFullName(),
                    profile != null ? profile.getShopName() : "",
                    profile != null ? profile.getDescription() : ""
            );
        }).toList();
    }

    /**
     * Products of specific vendor (Shop page)
     */
    public List<Product> getVendorProducts(Long vendorId) {

        User vendor = userRepository.findById(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found"));

        if (vendor.getRole() != Role.VENDOR) {
            throw new ResourceNotFoundException("Not a vendor");
        }

        return productRepository.findByVendor(vendor);
    }
}
