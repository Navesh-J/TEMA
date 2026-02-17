package com.navesh.TEMA.cart.service;

import com.navesh.TEMA.cart.dto.*;
import com.navesh.TEMA.cart.repository.*;
import com.navesh.TEMA.common.entity.*;
import com.navesh.TEMA.common.exception.ResourceNotFoundException;
import com.navesh.TEMA.product.repository.ProductRepository;
import com.navesh.TEMA.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired private CartRepository cartRepository;
    @Autowired private CartItemRepository cartItemRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private UserRepository userRepository;

    private Cart getOrCreateCart(User user) {
        return cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUser(user);
                    return cartRepository.save(c);
                });
    }

    public CartItem addToCart(String userEmail, AddToCartRequest request) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Cart cart = getOrCreateCart(user);

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(request.getQuantity());
        item.setPriceAtTime(product.getPrice());

        return cartItemRepository.save(item);
    }

    public List<CartItem> getCartItems(String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Cart cart = getOrCreateCart(user);

        return cartItemRepository.findByCart(cart);
    }

    public CartItem updateQuantity(Long itemId,
                                   UpdateCartItemRequest request) {

        CartItem item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));

        item.setQuantity(request.getQuantity());

        return cartItemRepository.save(item);
    }

    public void removeItem(Long itemId) {
        cartItemRepository.deleteById(itemId);
    }

    public void clearCart(String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Cart cart = getOrCreateCart(user);

        cartItemRepository.deleteByCart(cart);
    }
}
