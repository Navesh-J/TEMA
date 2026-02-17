package com.navesh.TEMA.product.controller;

import com.navesh.TEMA.common.entity.Product;
import com.navesh.TEMA.common.response.ApiResponse;
import com.navesh.TEMA.product.dto.*;
import com.navesh.TEMA.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor/products")
@CrossOrigin(origins = "*")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ApiResponse<Product> addProduct(
            Authentication authentication,
            @RequestBody AddProductRequest request) {

        return ApiResponse.success(
                "Product added successfully",
                productService.addProduct(
                        authentication.getName(),
                        request
                )
        );
    }

    @GetMapping
    public ApiResponse<List<Product>> getVendorProducts(
            Authentication authentication) {

        return ApiResponse.success(
                "Products fetched",
                productService.getVendorProducts(
                        authentication.getName()
                )
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody UpdateProductRequest request) {

        return ApiResponse.success(
                "Product updated",
                productService.updateProduct(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ApiResponse.success(
                "Product deleted",
                null
        );
    }
}
