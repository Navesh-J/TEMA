package com.navesh.TEMA.cart.controller;

import com.navesh.TEMA.cart.dto.*;
import com.navesh.TEMA.cart.service.CartService;
import com.navesh.TEMA.common.entity.CartItem;
import com.navesh.TEMA.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/cart")
@CrossOrigin(origins = "*")

public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/items")
    public ApiResponse<CartItem> addToCart(
            Authentication auth,
            @RequestBody AddToCartRequest request) {

        return ApiResponse.success(
                "Added to cart",
                cartService.addToCart(auth.getName(), request)
        );
    }

    @GetMapping
    public ApiResponse<List<CartItem>> getCart(Authentication auth) {
        return ApiResponse.success(
                "Cart fetched",
                cartService.getCartItems(auth.getName())
        );
    }

    @PutMapping("/items/{id}")
    public ApiResponse<CartItem> updateQuantity(
            @PathVariable Long id,
            @RequestBody UpdateCartItemRequest request) {

        return ApiResponse.success(
                "Quantity updated",
                cartService.updateQuantity(id, request)
        );
    }

    @DeleteMapping("/items/{id}")
    public ApiResponse<String> removeItem(@PathVariable Long id) {
        cartService.removeItem(id);
        return ApiResponse.success("Item removed", null);
    }

    @DeleteMapping("/clear")
    public ApiResponse<String> clearCart(Authentication auth) {
        cartService.clearCart(auth.getName());
        return ApiResponse.success("Cart cleared", null);
    }
}
