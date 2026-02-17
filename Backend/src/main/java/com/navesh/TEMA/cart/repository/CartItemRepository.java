package com.navesh.TEMA.cart.repository;


import com.navesh.TEMA.common.entity.Cart;
import com.navesh.TEMA.common.entity.CartItem;
import com.navesh.TEMA.common.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCart(Cart cart);

    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);

    void deleteByCart(Cart cart);
}
