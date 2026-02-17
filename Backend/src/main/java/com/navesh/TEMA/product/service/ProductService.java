package com.navesh.TEMA.product.service;

import com.navesh.TEMA.common.entity.Product;
import com.navesh.TEMA.common.entity.User;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.product.dto.*;
import com.navesh.TEMA.product.repository.ProductRepository;
import com.navesh.TEMA.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Product addProduct(String vendorEmail,
                              AddProductRequest request) {

        User vendor = userRepository.findByEmail(vendorEmail)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found"));

        Product product = new Product();
        product.setVendor(vendor);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setImageUrl(request.getImageUrl());
        product.setCategory(request.getCategory());

        return productRepository.save(product);
    }

    public List<Product> getVendorProducts(String vendorEmail) {

        User vendor = userRepository.findByEmail(vendorEmail)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found"));

        return productRepository.findByVendor(vendor);
    }

    public Product updateProduct(Long id,
                                 UpdateProductRequest request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        if (request.getName() != null)
            product.setName(request.getName());

        if (request.getPrice() != null)
            product.setPrice(request.getPrice());

        if (request.getImageUrl() != null)
            product.setImageUrl(request.getImageUrl());

        if (request.getActive() != null)
            product.setActive(request.getActive());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found"));

        productRepository.delete(product);
    }
}
